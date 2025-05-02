package com.comcast.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	
	WebDriver driver;
	public ProductInfoPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Product Name']")
	private WebElement productCreated;

	public WebElement getProductCreated() {
		return productCreated;
	}
	
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement deleteBtn;
	
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Product Category']")
	private WebElement productCat;
	
	public WebElement getProductCat() {
		return productCat;
	}

	@FindBy(xpath = "//td[@id='mouseArea_Sales Start Date']")
	private WebElement salesStartDate;
	
	@FindBy(xpath = "//td[@id='mouseArea_Sales End Date']")
	private WebElement salesEndDate;
	
	public WebElement getSalesStartDate() {
		return salesStartDate;
	}

	public WebElement getSalesEndDate() {
		return salesEndDate;
	}
	
	public String noProductMsg() {
		String noProductMsg= "No Product Found !";
		return noProductMsg;
	}
	
}
