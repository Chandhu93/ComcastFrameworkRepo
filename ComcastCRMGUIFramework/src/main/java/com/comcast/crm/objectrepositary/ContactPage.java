package com.comcast.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {
	
	WebDriver driver;
	public ContactPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactBtn;

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchTxtBox;
	
	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}
	
	@FindBy(xpath = "//select[@id='bas_searchfield']")
	private WebElement contactIdDropdown;

	public void ContactIdDropDown(String lastname) {
		Select s = new Select(contactIdDropdown);
		s.selectByValue(lastname);
	}

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement submitBtn;
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	@FindBy(xpath = "//span[@class='genHeaderSmall']")
	private WebElement deleteHeadermsg;
	public WebElement getDeleteHeadermsg() {
		return deleteHeadermsg;
	}
	
	public String noContactMsg() {
		String noContactMsg= "No Contact Found !";
		return noContactMsg;
	}
	
}

















