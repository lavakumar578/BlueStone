package com.tyss.blueStone.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tyss.blueStone.baseutil.BaseClass;
import com.tyss.blueStone.util.DriverUtility;
@Listeners
public class ListenerImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart"+Thread.currentThread().getId());
		ExtentSparkReporter spark=new ExtentSparkReporter("./src/main/java/com/tyss/blueStone/reports/extentReport.html");
		
		spark.config().setDocumentTitle("DocumentTitle");
		spark.config().setTheme(Theme.STANDARD);
		try {
			spark.loadXMLConfig(new File("extentconfig.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("Reporter Name", "Lava Kumar");
		report.setSystemInfo("platform", "Windows 10");
		report.setSystemInfo("Unit Testing Tool", "TestNG");
		report.setSystemInfo("Build Management Tool", "Maven");
		report.setSystemInfo("Automation Tool", "Selenium");
		
	}
	@Override
	public void onTestStart(ITestResult result) {
	System.out.println("onTestStart");	
	test = report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		test.log(Status.PASS,result.getMethod().getMethodName()+"is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		test.log(Status.FAIL,result.getMethod().getMethodName()+"is failed");
		test.log(Status.FAIL,result.getThrowable());
			
			
					try {
						test.addScreenCaptureFromPath(DriverUtility.takeScreenShot(result.getMethod().getMethodName(), BaseClass.staticdriver));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
							
				
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");	
		test.log(Status.SKIP,result.getMethod().getMethodName()+"is skipped");
		test.log(Status.SKIP,result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
		report.flush();
		
		
	}

	
}
