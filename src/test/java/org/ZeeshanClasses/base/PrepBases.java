package org.ZeeshanClasses.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.ZeeshanClasses.browserManager.BrowserFactory;
import org.ZeeshanClasses.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class PrepBases extends PrepCleanUp{
    public ExtentSparkReporter spark;
    public WebDriver driver;

    @BeforeTest
    public void setupReportMechanism(){
        String dateTime = LocalDateTime.now().toString();
        reports = new ExtentReports();
        spark = new ExtentSparkReporter("output");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Test Report");
        reports.attachReporter(spark);
        logger = reports.createTest(dateTime + "see for yourself");
    }

    @AfterTest
    public void cleanUpReportingMechanism(){
        reports.flush();
    }


    @BeforeClass
    public void launchBrowser(){
        boolean headlessState = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
        driver = BrowserFactory.launchBrowser(ConfigReader.getProperty("browser"), headlessState);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void shutDownBrowser(){
       // driver.quit();
    }
}
