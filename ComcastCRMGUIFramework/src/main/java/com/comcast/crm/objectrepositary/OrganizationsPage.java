package com.comcast.crm.objectrepositary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath= "//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	@FindBy(name = "search_text")
	private WebElement searchTextBox;
	
	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	@FindBy(name = "search_field")
	private WebElement searchDropDown;
	
	public WebElement getSearchDropDown() {
		return searchDropDown;
	}
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
}













