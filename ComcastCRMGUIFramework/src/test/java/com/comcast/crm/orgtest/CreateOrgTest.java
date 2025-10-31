package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositary.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositary.HomePage;
import com.comcast.crm.objectrepositary.OrganizationInfoPage;
import com.comcast.crm.objectrepositary.OrganizationsPage;

//@Listeners(com.comcast.crm.listenerUtility.ListenerImplementation.class)
public class CreateOrgTest extends BaseClass{

	@Test(groups= {"smokeTest", "regressionTest"})
	public void createOrgTest() throws IOException {

		UtilityClassObject.getTest().log(Status.INFO, "read Data from excel");
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Organizations module");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Click on create new Organization");
		OrganizationsPage op =new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "Create new Organization");
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		UtilityClassObject.getTest().log(Status.INFO, "Verify Header msg Expected Result");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName=oip.getCreatedOrg().getText().trim();
		
		Assert.assertEquals(actOrgName, orgName);
//		Assert.fail();
	}

	@Test(groups="regressionTest")
	public void createOrgWithPhoneNumTest() throws IOException {

		String orgName= eLib.getDataFromExcel("org",7,2)+ jLib.getRandomNumber();
		String ExpPhoneNum= eLib.getDataFromExcel("org",7,3);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage og = new OrganizationsPage(driver);
		og.getCreateNewOrgBtn().click();

		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.getOrgNameEdt().sendKeys(orgName);
		cnp.getPhoneTxtBox().sendKeys(ExpPhoneNum);
		cnp.getSaveBtn().click();

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actPhoneNum = oip.getPhoneInfo().getText();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actPhoneNum, ExpPhoneNum);
		sa.assertAll();
	}

	@Test(groups="regressionTest")
	public void createOrgWithIndustry() throws IOException {
		//Read test data from excel
		String orgName= eLib.getDataFromExcel("org", 4, 2)+ jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String indType = eLib.getDataFromExcel("org", 4, 4);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(orgName);

		cnop.industryDropdown(industry);
		cnop.industryTypeDropdown(indType);
		cnop.getSaveBtn().click();

		//Verify the industry info
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		String actIndustries = oip.getIdustryCreated().getText().trim();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actIndustries, industry);
		
		//Verify the  Type info
		String actType = oip.getTypeCreated().getText();
		sa.assertEquals(actType, indType);
		sa.assertAll();

	}

	@Test(groups="regressionTest")
	public void createOrgAndDelete() throws IOException {

		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

		//Navigate to Organizations module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		//Click on create new Organization
		OrganizationsPage op =new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		//Create new Organization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		
		//Verify Header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName=oip.getCreatedOrg().getText().trim();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actOrgName, orgName);

		hp.getOrgLink().click();

		op.getSearchTextBox().sendKeys(orgName);
		wLib.select(op.getSearchDropDown(), "Organization Name");
		op.getSubmitBtn().click();
		
		//Finding dynamic element using find element jh
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();

		//handling alert pop up
		wLib.switchToAlertAndAccepct(driver);
		sa.assertAll();
	}


}



















