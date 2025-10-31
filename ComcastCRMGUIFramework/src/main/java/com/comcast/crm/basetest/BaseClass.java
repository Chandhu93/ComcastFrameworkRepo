package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositary.HomePage;
import com.comcast.crm.objectrepositary.LoginPage;


public class BaseClass {
	public DataBaseUtility dbLib = new DataBaseUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	
	public WebDriver driver= null;

	@BeforeSuite (groups= {"smokeTest", "regressionTest"})
	public void beforeSuite() throws SQLException{
		dbLib.getDbConnection();
		System.out.println("Database Connection");
	}

	@BeforeClass (groups= {"smokeTest", "regressionTest"})
	public void beforeClass() throws IOException {
		
		//Reading data from both cmd line and properties
		String browser= System.getProperty("browser", fLib.getDataFromPropertiesFile("browser"));
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}else {
			driver= new ChromeDriver();
		}
		UtilityClassObject.setDriver(driver);
	}
	
	//Cross Browser
	//@Parameters("browser")   //data of Browser from suite is storing in browser variable
//	@BeforeClass (groups= {"smokeTest", "regressionTest"})
//	public void beforeClass(String  Browser) throws IOException {
//		
//		String browser= Browser ;
//		
//		if(browser.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (browser.equals("firefox")) {
//			driver = new FirefoxDriver();
//		}else if (browser.equals("edge")) {
//			driver = new EdgeDriver();
//		}else {
//			driver= new ChromeDriver();
//		}
//		UtilityClassObject.setDriver(driver);
//	}

	@BeforeMethod (groups= {"smokeTest", "regressionTest"})
	public void beforeMethod() throws IOException {
		
		String url= System.getProperty("browser", fLib.getDataFromPropertiesFile("url"));
		String username= System.getProperty("browser", fLib.getDataFromPropertiesFile("username"));
		String password= System.getProperty("browser", fLib.getDataFromPropertiesFile("password"));

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(url, username, password);	
	}

	@AfterMethod (groups= {"smokeTest", "regressionTest"})
	public void afterMethod() {
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass (groups= {"smokeTest", "regressionTest"})
	public void afterClass() {
		driver.quit();
	}

	@AfterSuite (groups= {"smokeTest", "regressionTest"})
	public void afterSuite() throws SQLException {
		dbLib.closeDbConnection();
	}
}
