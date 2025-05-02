package com.comcast.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

// Rule1: Create a separate java class for each page
public class LoginPage extends WebDriverUtility {

	WebDriver driver; //to access in all the methods

	//Rule3: Object initialization using constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Rule2: Object Identification by using @FindBy
	@FindBy(name="user_name")
	private WebElement usernameEdt;

	@FindBy(name="user_password")
	private WebElement passwordEdt;

	@FindBy(id="submitButton")
	private WebElement loginBtn;

	//Rule4: Object Encapsulation using private access modifier

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	//Rule6: Action method (this called as business method, cannot use for any other app)
	public void loginToApp(String url,String username, String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}


}

















