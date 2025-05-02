package com.comcast.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {

	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (name="accountname")
	private WebElement orgNameEdt;

	@FindBy(id = "phone")
	private WebElement phoneTxtBox;

	public WebElement getPhoneTxtBox() {
		return phoneTxtBox;
	}

	@FindBy(name = "industry")
	private WebElement industryDropdown;

	@FindBy(xpath  = "//select[@name='accounttype']")
	private WebElement industryTypeDropdown;

	@FindBy (xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}

	public void industryDropdown(String industry) {
		Select s = new Select(industryDropdown);
		s.selectByVisibleText(industry);
	}

	public void industryTypeDropdown(String indType) {
		Select s = new Select(industryTypeDropdown);
		s.selectByValue(indType);
	}


}





