package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void switchToTabOnUrl (WebDriver driver, String partilURL) {
		Set<String> allWId = driver.getWindowHandles();
		for (String wId :  allWId) {
			driver.switchTo().window(wId);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partilURL)) {
				break;
			}
		}
	}

	public void switchToTabOnTitle(WebDriver driver, String partilTile) {
		Set<String> allWId = driver.getWindowHandles();
		for (String wId :  allWId) {
			driver.switchTo().window(wId);
			String title = driver.getTitle();

			if(title.contains(partilTile)) {
				break;
			}
		}
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToAlertAndAccepct (WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndDismiss (WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void switchToAlertAndText (WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void deselect(WebElement element, String text) {
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}

	public void deselect(WebElement element, int index) {
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}

	public void deselect(WebElement element) {
		Select sel = new Select(element);
		sel.deselectAll();
	}

	public void mouseMoveOnElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();;
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement src, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, target).perform();
	}

	public void rightClick(WebDriver driver, WebElement target) {
		Actions a = new Actions(driver);
		a.contextClick(target).perform();
	}

	public void scrollBy(WebDriver driver, int y) {
		Actions a = new Actions(driver);
		a.scrollByAmount(0, y).perform();
	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.scrollToElement(element).perform();
	}

	public void scrollDown(WebDriver driver, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+y+");");
	}

	public void scrollToBottomOfPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void takeScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshot/faiedTest.png"));
	}

	public void jsClick(WebDriver driver, WebElement element) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click()", element); 
	}

}











