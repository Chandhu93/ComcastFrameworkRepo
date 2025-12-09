package com.comcast.crm.campaigntest;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositary.CampaignInfoPage;
import com.comcast.crm.objectrepositary.CampaignsPage;
import com.comcast.crm.objectrepositary.CreateNewCampaignPage;
import com.comcast.crm.objectrepositary.HomePage;

@Listeners(com.comcast.crm.listenerUtility.ListenerImplementation.class)
public class CreateCampaignTest extends BaseClass{

	@Test 
	public void createCampaignTest() throws IOException {

		String campaignName = eLib.getDataFromExcel("campaign", 1, 2) + jLib.getRandomNumber();
		String date=jLib.getRequriesDate(20);

		HomePage hp = new HomePage(driver);
		hp.campaignPage();

		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateNewCampaginBtn().click();

		CreateNewCampaignPage cncp = new CreateNewCampaignPage(driver);
		cncp.getCampaignNameTxtBox().sendKeys(campaignName);
		cncp.getExpectedClosingDate().clear();
		cncp.getExpectedClosingDate().sendKeys(date);
		cncp.getSaveBtn().click();

		CampaignInfoPage cip = new CampaignInfoPage(driver);
		String actCampaign=cip.getCampCreatedInfo().getText().trim();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actCampaign, campaignName);
		sa.assertAll();
	}

	@Test
	public void createCampaignWithTypeAndStatusTest() throws IOException {

		String campaignName = eLib.getDataFromExcel("campaign", 1, 2) + jLib.getRandomNumber();
		String campaignStatus = eLib.getDataFromExcel("campaign", 1, 3);
		String campaignType= eLib.getDataFromExcel("campaign", 1, 4);
		String date=jLib.getRequriesDate(20);

		HomePage hp = new HomePage(driver);
		hp.campaignPage();

		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateNewCampaginBtn().click();

		CreateNewCampaignPage cncp = new CreateNewCampaignPage(driver);
		cncp.getCampaignNameTxtBox().sendKeys(campaignName);
		cncp.campaignStatus(campaignStatus);
		cncp.campaignType(campaignType);
		cncp.getExpectedClosingDate().clear();
		cncp.getExpectedClosingDate().sendKeys(date);
		cncp.getSaveBtn().click();

		CampaignInfoPage cip = new CampaignInfoPage(driver);
		String actCampaign=cip.getCampCreatedInfo().getText().trim();
		
		SoftAssert as = new SoftAssert();
		as.assertEquals(actCampaign, campaignName);

		String actStatus=cip.getCampStatus().getText().trim();
		as.assertEquals(actStatus, campaignStatus);
		
		String actType= cip.getCampType().getText().trim();
		as.assertEquals(actType, campaignType);
		
		as.assertAll();
	}

	@Test
	public void createCampaignAndDeleteTest() throws IOException {
		String campaignName = eLib.getDataFromExcel("campaign", 1, 2) + jLib.getRandomNumber();
		String date=jLib.getRequriesDate(20);

		HomePage hp = new HomePage(driver);
		hp.campaignPage();

		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateNewCampaginBtn().click();

		CreateNewCampaignPage cncp = new CreateNewCampaignPage(driver);
		cncp.getCampaignNameTxtBox().sendKeys(campaignName);
		cncp.getExpectedClosingDate().clear();
		cncp.getExpectedClosingDate().sendKeys(date);
		cncp.getSaveBtn().click();

		CampaignInfoPage cip = new CampaignInfoPage(driver);
		String actCampaign=cip.getCampCreatedInfo().getText().trim();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actCampaign, campaignName);

		cip.getDeleteBtn().click();
		wLib.switchToAlertAndAccepct(driver);

		cp.getSearchTxtBox().sendKeys(campaignName);
		cp.getSearchBtn().click();
		String msg= cp.getHeaderInfo().getText();

		sa.assertEquals(msg, cp.noCampInfo());
		sa.assertAll();
	}



}





















