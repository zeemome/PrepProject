package org.ZeeshanClasses.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.ZeeshanClasses.base.PrepBases;
import org.ZeeshanClasses.customs.PrepProj;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportListeners implements ITestListener{

    ExtentReports extent;
    ExtentTest test;
    ExtentSparkReporter reporter;

    @Override
    public void onStart(ITestContext context){
        String timeStamp = new SimpleDateFormat("yyyymmddHHmmss").format(new Date());
        File reportDir = new File("output/reports");
        if(!reportDir.exists()){
            reportDir.mkdir();
        }

        reporter = new ExtentSparkReporter(new File(reportDir, "extent-report-" + timeStamp + ".html"));
        reporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(reporter);

    }

    @Override
    public void onTestStart(ITestResult result){
        test = extent.createTest(result.getMethod().getMethodName());
        Method method = result.getMethod().getConstructorOrMethod().getMethod();
        System.out.println("🚀 Starting Test: " + result.getMethod().getMethodName());
        if(method.isAnnotationPresent(PrepProj.class)){
            PrepProj info = method.getAnnotation(PrepProj.class);
            System.out.println("------------------------------------------------");
            System.out.println("Executing Test Case: " + info.id());
            System.out.println("Description       : " + info.description());
            System.out.println("Created By        : " + info.createdBy());
            System.out.println("------------------------------------------------");
        }
    }

    @Override
    public void onTestSuccess(ITestResult result){
        test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result){
        test.fail("Test failed");
    }

    @Override
    public void onFinish(ITestContext context){
        extent.flush();
    }
}
