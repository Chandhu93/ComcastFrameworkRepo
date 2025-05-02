package com.comcast.crm.listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImplementation implements ITestListener, ISuiteListener{
	public static ExtentReports report;
	public static ExtentTest test;
	String time = new Date().toString().replace(" ", "_").replace(":" , "_");

	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		//add Env Info and Test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "Chrome-120");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"=== STARTED ===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"=== COMPLETED ===");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName =result.getMethod().getMethodName();

		TakesScreenshot ts =  (TakesScreenshot) UtilityClassObject.getDriver() ;
		String filePath=ts.getScreenshotAs(OutputType.BASE64);
		
		test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"=== FAIL ===");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+"=== SKIPPED ===");
	}

}
