package com.comcast.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	WebDriver driver;
	public ContactInfoPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Last Name']")
	private WebElement lastName;
	
	@FindBy(xpath = "//td[@id='mouseArea_Support Start Date']")
	private WebElement startDate;
	
	@FindBy(xpath = "//td[@id='mouseArea_Support End Date']")
	private WebElement endDate;
	
	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getLastName() {
		return lastName;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Last Name']")
	private WebElement createdContact;
	
	public WebElement getCreatedConatct() {
		return createdContact;
	}

	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']")
	private WebElement orgCreated;
	
	public WebElement getOrgCreated() {
		return orgCreated;
	}
	
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement deleteBtn;
	
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	
}











