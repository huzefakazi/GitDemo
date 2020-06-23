import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleMiscExamples {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "Installers/Webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		int linkCount = driver.findElements(By.tagName("a")).size();
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		int footerLinkCount = footerDriver.findElements(By.tagName("a")).size();
		WebElement firstColumnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/ul"));
		int firstColumnLinksCount = firstColumnDriver.findElements(By.tagName("a")).size();
		System.out.println(linkCount);
		System.out.println(footerLinkCount);
		System.out.println(firstColumnLinksCount);
		
		for(int i=1; i<firstColumnLinksCount; i++) {
			
			wait.until(ExpectedConditions.elementToBeClickable(firstColumnDriver.findElements(By.tagName("a")).get(i)));
			firstColumnDriver.findElements(By.tagName("a")).get(i).sendKeys(Keys.CONTROL,Keys.ENTER);
		
			
		}
	}

}
