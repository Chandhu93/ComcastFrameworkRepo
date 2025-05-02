package com.comcast.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	
	WebDriver driver;
	public CampaignInfoPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className  = "dvtCellInfo")
	private WebElement campCreatedInfo;

	public WebElement getCampCreatedInfo() {
		return campCreatedInfo;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Campaign Status']")
	private WebElement campStatus;
	public WebElement getCampStatus() {
		return campStatus;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Campaign Type']")
	private WebElement campType;
	public WebElement getCampType() {
		return campType;
	}
	
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement deleteBtn;
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	
}










