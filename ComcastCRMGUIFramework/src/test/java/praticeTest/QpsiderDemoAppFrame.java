package praticeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class QpsiderDemoAppFrame {
@Test
	public void switchFrame() {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demoapps.qspiders.com/");
	driver .manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
	
	driver.findElement(By.xpath("//img[contains(@class, 'w-[2.125rem]') and contains(@class, 'mt-2')]")).click();
	WebElement e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[text()='Web Elements']")));
	e1.click();
	driver.findElement(By.xpath("//section[text()='Frames']")).click();
	
	driver.findElement(By.xpath("//section[text()='iframes']")).click();
	driver.findElement(By.xpath("//a[text()='Multiple iframe']")).click();
	
	
	WebElement f1 = driver.findElement(By.xpath("(//iframe[@class='w-full h-96'])[1]"));
	driver.switchTo().frame(f1);
	
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Admin@gmail.com");
	
	
//	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Admin@1234");
//	driver.findElement(By.xpath("//input[@id='confirm-password']")).sendKeys("Admin@1234");
//	driver.findElement(By.xpath("//input[@type='submit']")).click();
//
//	String w= driver.getWindowHandle();
//	driver.switchTo().window(w);
	
	
//	WebElement f2 = driver.findElement(By.xpath("(//iframe[@class='w-full h-96'])[2]"));
//	driver.switchTo().frame(f2);
//	driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Admin@gmail.com");
//	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Admin@1234");
//	driver.findElement(By.xpath("//input[@type='submit']")).click();
//	
	
	
}



}










