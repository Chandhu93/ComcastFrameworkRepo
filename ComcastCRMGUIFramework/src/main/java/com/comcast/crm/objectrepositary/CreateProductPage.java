package com.comcast.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateProductPage {
	
	WebDriver driver;
	public CreateProductPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "detailedViewTextBox")
	private WebElement productNameTxtBox;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getProductNameTxtBox() {
		return productNameTxtBox;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	@FindBy(xpath = "//select[@name='productcategory']")
	private WebElement productCategoryDropdown;
	
	public void productCategoryDropdown(String cat) {
		Select s = new Select(productCategoryDropdown);
		s.selectByValue(cat);
	}
	
	@FindBy(xpath = "//input[@id='jscal_field_sales_start_date']")
	private WebElement salesStartDate;
	
	@FindBy(xpath = "//input[@id='jscal_field_sales_end_date']")
	private WebElement salesEndDate;
	
	public WebElement getSalesStartDate() {
		return salesStartDate;
	}

	public WebElement getSalesEndDate() {
		return salesEndDate;
	}



}
















