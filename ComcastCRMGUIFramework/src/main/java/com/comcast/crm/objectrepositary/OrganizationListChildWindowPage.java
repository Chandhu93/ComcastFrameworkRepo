package com.comcast.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationListChildWindowPage {
	
	WebDriver driver;
	public OrganizationListChildWindowPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@class='txtBox']")
	private WebElement orgSearchTxtBox;
	
	@FindBy(xpath = "//input[@type='button']")
	private WebElement searchBtn;

	public WebElement getOrgSearchTxtBox() {
		return orgSearchTxtBox;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
		

	
	
}












