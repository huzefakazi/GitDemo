import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Installers/Webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(500);
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		
		WebElement source = driver.findElement(By.xpath("//input[@placeholder='From']"));
		source.click();
		source.sendKeys("pun");
		Thread.sleep(500);
		source.sendKeys(Keys.ARROW_DOWN);
		source.sendKeys(Keys.ENTER);
		
		WebElement destination = driver.findElement(By.xpath("//input[@placeholder='To']"));
		destination.sendKeys("nag");
		Thread.sleep(500);
		destination.sendKeys(Keys.ARROW_DOWN);
		destination.sendKeys(Keys.ENTER);

	}

}
