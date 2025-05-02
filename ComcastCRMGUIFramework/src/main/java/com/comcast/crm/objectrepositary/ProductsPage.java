package com.comcast.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
	
	WebDriver driver;
	public ProductsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img [@title='Create Product...']")
	private WebElement newProductBtn;

	public WebElement getNewProductBtn() {
		return newProductBtn;
	}
	
	@FindBy(name = "search_text")
	private WebElement searchTxtBox;
	
	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}
	
	@FindBy(id = "bas_searchfield")
	private WebElement productDropdown;
	
	public void productDropdown(String productName) {
		Select s = new Select(productDropdown);
		s.selectByValue(productName);
	}
	
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement submitBtn;
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	@FindBy(xpath = "//span[@class='genHeaderSmall']")
	private WebElement headerMsg;
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	

}













