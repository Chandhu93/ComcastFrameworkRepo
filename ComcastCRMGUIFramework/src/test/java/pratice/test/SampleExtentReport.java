package pratice.test;

import java.sql.SQLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleExtentReport {
	public ExtentSparkReporter spark;
	public ExtentReports report;
	@BeforeSuite 
	public void beforeSuite() throws SQLException{
		System.out.println("Database Connection");
		//Spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add Env Info and Test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "Chrome-120");
	}
	
	@AfterSuite (groups= {"smokeTest", "regressionTest"})
	public void afterSuite() throws SQLException {
		report.flush();
	}
	
	@Test
	public void createContactTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nseindia.com/");
		
		TakesScreenshot t = (TakesScreenshot) driver;
		String filePath= t.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("createContactTest");
		
		test.log(Status.INFO, "login to app");
		
		if("NSE".equals("BSE")) {
			test.log(Status.PASS, "Pass");
		} else
			test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
		
		driver.close();
	
	}
}



















