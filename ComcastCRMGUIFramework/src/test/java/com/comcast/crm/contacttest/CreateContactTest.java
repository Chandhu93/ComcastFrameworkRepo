package com.comcast.crm.contacttest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositary.ContactInfoPage;
import com.comcast.crm.objectrepositary.ContactPage;
import com.comcast.crm.objectrepositary.CreateContactPage;
import com.comcast.crm.objectrepositary.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositary.HomePage;
import com.comcast.crm.objectrepositary.OrganizationInfoPage;
import com.comcast.crm.objectrepositary.OrganizationListChildWindowPage;
import com.comcast.crm.objectrepositary.OrganizationsPage;

@Listeners(com.comcast.crm.listenerUtility.ListenerImplementation.class)
public class CreateContactTest extends BaseClass{
	@Test(groups="smokeTest")
	public  void createContactTest() throws IOException {
		
		UtilityClassObject.getTest().log(Status.INFO, "read Data from excel");
		String lastName= eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Contact page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactBtn().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		
		UtilityClassObject.getTest().log(Status.INFO, "Creating new Contact");
		ccp.getLastNameTxtField().sendKeys(lastName);
		ccp.getSaveBtn().click();

		ContactInfoPage cip = new ContactInfoPage(driver);
		String actLastName = cip.getLastName().getText().trim();
		
		UtilityClassObject.getTest().log(Status.INFO, "Verifying the created contact");
		Assert.assertEquals(actLastName, lastName);
	}	

	@Test(groups="regressionTest")
	public void createContactWithSupportDateTest() throws IOException {

		String lastName = eLib.getDataFromExcel("contact",1,2) + jLib.getRandomNumber();
		String startDate = jLib.getSystemDateyyyMMdd();
		String endDate = jLib.getRequriesDate(30);

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactBtn().click();
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastNameTxtField().sendKeys(lastName);
		ccp.getSupportStartDate().clear();
		ccp.getSupportStartDate().sendKeys(startDate);
		ccp.getSupportEndDate().clear();
		ccp.getSupportEndDate().sendKeys(endDate);
		ccp.getSaveBtn().click();

		//Verify start date and end date
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actStartDate = cip.getStartDate().getText().trim();
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actStartDate, startDate);

		String actEndtDate = cip.getEndDate().getText().trim();
		sa.assertEquals(actEndtDate, endDate);
		sa.assertAll();
	}

	@Test(groups="regressionTest")
	public void createContactWithOrgTest() throws IOException {
		
		String orgName= eLib.getDataFromExcel("contact",7,2)  + jLib.getRandomNumber();
		String contactlastName= eLib.getDataFromExcel("contact",7,3) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op =new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		
		SoftAssert sa = new SoftAssert();
		// Verify header msg
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrg = oip.getCreatedOrg().getText().trim();
		sa.assertEquals(actOrg, orgName);

		oip.getContactLink().click();

		ContactPage cp= new ContactPage(driver);
		cp.getCreateContactBtn().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastNameTxtField().sendKeys(contactlastName);
		ccp.getOrganizationBtn().click();

		//switch to child window
		wLib.switchToTabOnUrl(driver, "module=Accounts");

		OrganizationListChildWindowPage olcp = new OrganizationListChildWindowPage(driver);
		olcp.getOrgSearchTxtBox().sendKeys(orgName);
		olcp.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();

		//switch to parent window
		wLib.switchToTabOnUrl(driver, "Contacts&action");
		ccp.getSaveBtn().click();

		ContactInfoPage cip = new ContactInfoPage(driver);
		String actContact= cip.getCreatedConatct().getText().trim();
		
		sa.assertEquals(actContact, contactlastName);
		
		String actOrgName= cip.getOrgCreated().getText().trim();
		sa.assertEquals(actOrgName, orgName);
		sa.assertAll();
	}

	@Test(groups="regressionTest")
	public void createContactAndDelete() throws IOException {
		String lastName= eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactBtn().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastNameTxtField().sendKeys(lastName);
		ccp.getSaveBtn().click();

		ContactInfoPage cip = new ContactInfoPage(driver);
		String actLastName = cip.getLastName().getText();

		if(lastName.equals(actLastName)) {
			System.out.println(lastName +" Contact is Created == PASS");
		}

		cip.getDeleteBtn().click();
		wLib.switchToAlertAndAccepct(driver);

		cp.getSearchTxtBox().sendKeys(lastName);
		cp.ContactIdDropDown("lastname");
		cp.getSubmitBtn().click();

		String msg = cp.getDeleteHeadermsg().getText();
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(msg, cp.noContactMsg());
		sa.assertAll();
	}


}












