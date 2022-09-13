package com.tyss.blueStone.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportWithLogo {

	@Test
	public void extentReportWithLogo() {
		ExtentReports extent =new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("src\\main\\java\\com\\tyss\\blueStone\\reports\\extentReport.html");
		try {
			spark.loadXMLConfig(new File("extentconfig.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.attachReporter(spark);
		
		ExtentTest test=extent.createTest("First Test");
		test.pass("test started");
		test.pass("Test finished");
		
		extent.flush();
		try {
			Desktop.getDesktop().browse(new File("src\\main\\java\\com\\tyss\\blueStone\\reports\\extentReport.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
