package com.techPanda.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {
	
	ExtentSparkReporter sparkReporter;
	ExtentReports extent;
	ExtentTest test;
	
	
	

	public void onStart(ITestContext context) {
		
		String timeStamp=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		
		String path=System.getProperty("user.dir")+".//reports.//"+timeStamp+context.getName()+".html";
		
		sparkReporter=new ExtentSparkReporter(path);
		
		sparkReporter.config().setDocumentTitle("Guru99 Automation Script");
		sparkReporter.config().setReportName("Functional testing");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Guru99 Ecommerce Application");
		extent.setSystemInfo("Module", "Main menu");
		extent.setSystemInfo("Sub Module", "Mobile");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("OS", "Microsoft 11");
		extent.setSystemInfo("User", "Anusha");
		
		
	}
	
	
	
	
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.PASS, result.getName()+"     PASSED");
	}
	
	
	
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, result.getName()+"     FAILED");
	}
	
	
	
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, result.getName()+"     SKIPPED");
	}
	
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
