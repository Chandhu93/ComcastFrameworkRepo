package com.comcast.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewCampaignPage {
	
	WebDriver driver;
	public CreateNewCampaignPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement campaignNameTxtBox;

	public WebElement getCampaignNameTxtBox() {
		return campaignNameTxtBox;
	}
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	@FindBy(id = "jscal_field_closingdate")
	private WebElement expectedClosingDate;
	public WebElement getExpectedClosingDate() {
		return expectedClosingDate;
	}
	
	@FindBy(xpath = "//select[@name='campaignstatus']")
	private WebElement campaignStatus;
	
	public void campaignStatus(String status) {
		Select s = new Select(campaignStatus);
		s.selectByValue(status);
	}
	
	@FindBy(xpath = "//select[@name='campaigntype']")
	private WebElement campaignType;
	
	public void campaignType(String type) {
		Select s = new Select(campaignType);
		s.selectByValue(type);
	}

}
















