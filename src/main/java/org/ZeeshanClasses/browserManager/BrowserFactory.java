package org.ZeeshanClasses.browserManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static WebDriver launchBrowser(String browserName, boolean headless){
        WebDriver driver;
        browserName = browserName.toLowerCase();

        switch (browserName){
            case "chrome" :
                driver = launchChrome(headless);
                break;

            case "firefox" :
                driver = launchFirefox(headless);
                break;

            case "edge" :
                driver = launchEdge(headless);
                break;

            case "safari" :
                driver = launchSafari(headless);
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        return driver;
    }

    private static WebDriver launchChrome(boolean headless){
        ChromeOptions options = new ChromeOptions();
        if(headless){
            options.addArguments("--headless=new");
        }
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    private static WebDriver launchFirefox(boolean headless){
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("-headless");
        }
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(options);
    }

    private static WebDriver launchEdge(boolean headless){
        EdgeOptions options = new EdgeOptions();
        if (headless) {
            options.addArguments("--headless=new"); // Edge Chromium
        }
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(options);
    }

    private static WebDriver launchSafari(boolean headless){
        if (headless) {
            System.out.println("Safari does not support headless mode. Launching normally.");
        }
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }
}
