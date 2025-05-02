package com.comcast.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	WebDriver driver;
	public CreateContactPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBys({@FindBy(name = "lastname"), @FindBy(xpath = "//input[@name='lastname']")})
	private WebElement lastNameTxtField;
	
	@FindBy(name = "support_start_date")
	private WebElement supportStartDate;
	
	@FindBy(name = "support_end_date")
	private WebElement supportEndDate;
	
	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getLastNameTxtField() {
		return lastNameTxtField;
	}
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement organizationBtn;
	
	public WebElement getOrganizationBtn() {
		return organizationBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	

}
