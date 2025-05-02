package com.comcast.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//td[@id='mouseArea_Organization Name']")
	private WebElement createdOrg;

	public WebElement getCreatedOrg() {
		return createdOrg;
	}
	
	@FindBy (id="dtlview_Phone") 
	private WebElement phoneInfo;
	
	public WebElement getPhoneInfo() {
		return phoneInfo;
	}
	
	@FindBy (id = "mouseArea_Industry")
	private WebElement idustryCreated;
	
	@FindBy(id = "mouseArea_Type")
	private WebElement typeCreated;
	
	public WebElement getIdustryCreated() {
		return idustryCreated;
	}

	public WebElement getTypeCreated() {
		return typeCreated;
	}
	
	@FindBy (linkText="Contacts") 
	private WebElement contactLink;
	
	public WebElement getContactLink() {
		return contactLink;
	}
	
}



















