package praticeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BookBusTest {
	
	@Test
	public void bookBusTickect() throws InterruptedException, AWTException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		driver.get("https://ksrtc.in/");
		
		driver.findElement(By.id("fromCity_chosen")).click();
		WebElement e1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search Your City Name']")));
		e1.sendKeys("Bengaluru",Keys.ENTER);
		
		WebElement e2= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toCity_chosen")));
		e2.click();
		
		WebElement e3= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Search Your City Name'])[2]")));
		e3.sendKeys("Chennai",Keys.ENTER);
		

		driver.findElement(By.id("departDate")).click();
		driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='6']")).click();
		driver.findElement(By.id("submitSearch")).click();
	}
	
	
	

}











