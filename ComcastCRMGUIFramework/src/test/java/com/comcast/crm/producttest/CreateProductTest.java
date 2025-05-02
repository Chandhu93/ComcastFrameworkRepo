package com.comcast.crm.producttest;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositary.CreateProductPage;
import com.comcast.crm.objectrepositary.HomePage;
import com.comcast.crm.objectrepositary.ProductInfoPage;
import com.comcast.crm.objectrepositary.ProductsPage;

@Listeners(com.comcast.crm.listenerUtility.ListenerImplementation.class)
public class CreateProductTest extends BaseClass {
	SoftAssert sa = new SoftAssert();
	@Test
	public void createProductTest() throws IOException {

		String productName = eLib.getDataFromExcel("product", 1, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();

		ProductsPage pp = new ProductsPage(driver);
		pp.getNewProductBtn().click();

		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.getProductNameTxtBox().sendKeys(productName);
		cpp.getSaveBtn().click();

		ProductInfoPage pip = new ProductInfoPage(driver);
		String actProduct = pip.getProductCreated().getText().trim();
		sa.assertEquals(actProduct, productName);
		sa.assertAll();
	}

	@Test
	public void createProductAndDelete() throws IOException {
		String productName = eLib.getDataFromExcel("product", 1, 2) + jLib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();

		ProductsPage pp = new ProductsPage(driver);
		pp.getNewProductBtn().click();

		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.getProductNameTxtBox().sendKeys(productName);
		cpp.getSaveBtn().click();

		ProductInfoPage pip = new ProductInfoPage(driver);
		String actProduct = pip.getProductCreated().getText().trim();
		sa.assertEquals(actProduct, productName);

		//Delete the Product
		pip.getDeleteBtn().click();
		wLib.switchToAlertAndAccepct(driver);

		pp.getSearchTxtBox().sendKeys(productName);
		pp.productDropdown("productname");
		pp.getSubmitBtn().click();

		String msg=pp.getHeaderMsg().getText();
		sa.assertEquals(msg, pip.noProductMsg());
		sa.assertAll();
	}

	@Test
	public void createProductWithProductCategoryTest() throws IOException {
		String productName = eLib.getDataFromExcel("product", 4, 2) + jLib.getRandomNumber();
		String productCategory = eLib.getDataFromExcel("product", 4, 3);
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();

		ProductsPage pp = new ProductsPage(driver);
		pp.getNewProductBtn().click();

		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.getProductNameTxtBox().sendKeys(productName);
		cpp.productCategoryDropdown(productCategory);
		cpp.getSaveBtn().click();
		ProductInfoPage pip = new ProductInfoPage(driver);
		String actCat = pip.getProductCat().getText().trim();
		sa.assertEquals(actCat, productCategory);
		sa.assertAll();
	}

	@Test
	public void createProductWithSalesDate() throws IOException {
		String productName = eLib.getDataFromExcel("product", 4, 2) + jLib.getRandomNumber();
		String startDate = jLib.getSystemDateyyyMMdd();
		String endDate = jLib.getRequriesDate(30);
		
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();

		ProductsPage pp = new ProductsPage(driver);
		pp.getNewProductBtn().click();

		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.getProductNameTxtBox().sendKeys(productName);
		cpp.getSalesStartDate().sendKeys(startDate);
		cpp.getSalesEndDate().sendKeys(endDate);
		cpp.getSaveBtn().click();
		
		ProductInfoPage pip = new ProductInfoPage(driver);
		
		String actStartDate = pip.getSalesStartDate().getText().trim();
		sa.assertEquals(actStartDate, startDate);

		String actEndtDate = pip.getSalesEndDate().getText().trim();
		sa.assertEquals(actEndtDate, endDate);
		sa.assertAll();
	}
	
}











