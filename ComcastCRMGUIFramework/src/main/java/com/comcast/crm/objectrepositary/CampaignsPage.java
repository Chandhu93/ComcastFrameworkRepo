package com.comcast.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	
	WebDriver driver;
	public CampaignsPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy (xpath = "//img[@title='Create Campaign...']")
	private WebElement createNewCampaginBtn;

	public WebElement getCreateNewCampaginBtn() {
		return createNewCampaginBtn;
	}
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchTxtBox;
	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}
	
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement searchBtn;
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	@FindBy(xpath = "//span[@class='genHeaderSmall']")
	private WebElement headerInfo;
	public WebElement getHeaderInfo() {
		return headerInfo;
	}
	
	public String noCampInfo( ) {
		String noCampInfo ="No Campaign Found !";
		return noCampInfo;
	}

}















