package com.comcast.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText = "Organizations")
		private WebElement orgLink;
	
	@FindBy (linkText="Contacts") 
		private WebElement contactLink;
	
	@FindBy (linkText = "Campaigns")
		private WebElement campaignLink;
	
	public WebElement getCampaignLink() {
		return campaignLink;
	}

	@FindBy (linkText = "More")
	private WebElement moreLink;
	
	public WebElement getMoreLink() {
		return moreLink;
	}

	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy (linkText = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}
	
	public WebElement getContactLink() {
		return contactLink;
	}
	
	public WebElement getadminImg() {
		return adminImg;
	}

	public void campaignPage() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		getCampaignLink().click();
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOutLink.click();
	}
	
}


















