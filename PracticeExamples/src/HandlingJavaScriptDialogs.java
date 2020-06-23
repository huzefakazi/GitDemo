import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingJavaScriptDialogs {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Installers/Webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("JavaScript Alert");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(1000);
		String text = driver.switchTo().alert().getText();
		if (text.contains("JavaScript Alert")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		driver.switchTo().alert().accept();
		driver.findElement(By.id("name")).sendKeys("JavaScript Confirm");
		driver.findElement(By.id("confirmbtn")).click();
		text = driver.switchTo().alert().getText();
		if (text.contains("JavaScript Confirm")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		driver.switchTo().alert().accept();
		driver.quit();
	}

}
