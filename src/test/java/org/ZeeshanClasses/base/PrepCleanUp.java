package org.ZeeshanClasses.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import lombok.extern.slf4j.Slf4j;
import org.ZeeshanClasses.browserManager.BrowserFactory;
import org.ZeeshanClasses.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.time.Duration;

@Slf4j
public class PrepCleanUp {

    public ExtentReports reports;
    public ExtentTest logger;

    @BeforeSuite
    public void cleanUp(){
        System.out.println("Cleaning previous test data........");
        deleteFolderContents("./screenshots");
    }

    private void deleteFolderContents(String folderPath){
        File folder = new File(folderPath);
        if(folder.exists() && folder.isDirectory()){
            File [] files = folder.listFiles();
        }
    }
}
