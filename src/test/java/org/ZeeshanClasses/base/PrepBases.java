package org.ZeeshanClasses.base;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.ZeeshanClasses.browserManager.BrowserFactory;
import org.ZeeshanClasses.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;


public class PrepBases extends PrepCleanUp{
    public WebDriver driver;


    @BeforeClass
    public void launchBrowser(){
        boolean headlessState = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
        driver = BrowserFactory.launchBrowser(ConfigReader.getProperty("browser"), headlessState);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void shutDownBrowser(){
        driver.quit();
    }
}
