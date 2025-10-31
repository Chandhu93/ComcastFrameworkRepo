package praticeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EMICalculator {
	@Test
	public void principalLoanAmount() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://emicalculator.net/");
		driver .manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		
		
	}
}













