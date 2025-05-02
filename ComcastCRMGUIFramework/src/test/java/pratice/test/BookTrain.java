package pratice.test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BookTrain {
@Test
	public void bookTrain()throws InterruptedException, IOException {
		
		String date = "Sun May 11 2025"; //using Dynamic xpath 
		String srcCity= "Hyderabad";
		String destCity="Vijayawada";
		
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		WebElement e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("commonModal__close")));
		e1.click();
		WebElement e2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()= 'Trains']")));
		e2.click();
		
		
		WebElement e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='fromCity']")));
		e3.click();
		
		WebElement e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='From']")));
		e4.sendKeys(srcCity);
		driver.findElement(By.xpath("//span[text()='"+srcCity+"']")).click();
		
		WebElement e5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='To']")));
		e5.click();
		
		WebElement e6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='To']")));
		e6.sendKeys(destCity);
		WebElement e7=driver.findElement(By.xpath("//span[text()='"+destCity+"']"));
		e7.click();
		
		WebElement e8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='travelDate']")));
		e8.click();
			
		WebElement e9= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='DayPicker-Day' and contains(@aria-label, '" + date + "')]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", e9);
		e9.click();
		
		WebElement e10= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Search']")));
		e10.click();
		
		//Thread.sleep(5000);
		
//		String time = new Date().toString().replace(" ", "_").replace(":" , "_");
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File dst = new File("./screenshot/bookFlightTest"+time+".png");
//		FileUtils.copyFile(src, dst);
		
		List<WebElement> trains = driver.findElements(By.xpath("//p[@data-testid='train-name']"));
		
		for (WebElement train : trains) {
			 System.out.println(train.getText());
		}
		driver.quit();
		
	}

	
}


//WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@role='option']//p[contains(text(),'" + srcCity + "')]")));
//firstOption.click();

//WebElement firstOption1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@role='option']//p[contains(text(),'" + destCity + "')]")));
//firstOption1.click();













