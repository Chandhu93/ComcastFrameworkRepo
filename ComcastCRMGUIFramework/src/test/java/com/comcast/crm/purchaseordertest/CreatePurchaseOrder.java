package com.comcast.crm.purchaseordertest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositary.LoginPage;

public class CreatePurchaseOrder {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		//Read test data from property file
		String browser =  fLib.getDataFromPropertiesFile("browser");
		String url = fLib.getDataFromPropertiesFile("url");
		String username = fLib.getDataFromPropertiesFile("username");
		String password = fLib.getDataFromPropertiesFile("password");

		//Read test data from excel
		String subject = eLib.getDataFromExcel("purchaseOrder", 1, 2) + jLib.getRandomNumber();
		String vendor = eLib.getDataFromExcel("purchaseOrder", 1, 3);
		String billingAddress = eLib.getDataFromExcel("purchaseOrder", 1, 4);
		String shippingAddress = eLib.getDataFromExcel("purchaseOrder", 1, 5);
		String itemName = eLib.getDataFromExcel("purchaseOrder", 1, 6);
		String quty = eLib.getDataFromExcel("purchaseOrder", 1, 7);
		

		WebDriver driver =null;

		if(browser.equals("chrome"))
			driver= new ChromeDriver();
		else if(browser.equals("edge"))
			driver = new EdgeDriver();
		else if(browser.equals("firefox"))
			driver= new FirefoxDriver();
		else
			driver=new ChromeDriver();

		// Login to application
		wLib.maximizeWindow(driver);
		driver.get(url);
		wLib.waitForPageToLoad(driver);

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(url, username, password);
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		driver.findElement(By.name("Purchase Order")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();
		
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(subject);
		
		//vendor
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		String parentWID = driver.getWindowHandle();
		wLib.switchToTabOnTitle(driver, "module=Vendors&action");
		
		//search for vendor
		driver.findElement(By.id("search_txt")).sendKeys(vendor);
		driver.findElement(By.xpath("//input[@type='button']")).click();
		driver.findElement(By.xpath("//a[text()='DJI']")).click();
		
		wLib.switchToTabOnTitle(driver, parentWID);
		driver.findElement(By.name("bill_street")).sendKeys(billingAddress);
		driver.findElement(By.name("ship_street")).sendKeys(shippingAddress);
		
		//product
		driver.findElement(By.id("searchIcon1")).click();
		wLib.switchToTabOnUrl(driver, "module=Products&action");
		driver.findElement(By.id("search_txt")).sendKeys(itemName);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		
		driver.findElement(By.id("popup_product_1499")).click();
		wLib.switchToTabOnTitle(driver, parentWID);
		
		driver.findElement(By.id("qty1")).sendKeys(quty);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actPurchaseOrder = driver.findElement(By.className("lvtHeaderText")).getText();
		if(actPurchaseOrder.contains(subject)) {
			System.out.println(subject+" is created == PASS");
		} else {
			System.out.println(subject+" is not created == FAIL");
		}
		driver.quit();
	}

}




















