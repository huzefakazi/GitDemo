import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassDemo {
	static WebDriverWait wait;
	public static void main(String[] args) {
		System.out.println("This is develop branch");
		System.setProperty("webdriver.chrome.driver", "Installers/Webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		wait = new WebDriverWait(driver, 15);
		Actions action = new Actions(driver);
				
		WebElement element = driver.findElement(By.id("nav-link-accountList"));
		
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("twotabsearchtextbox"))));
		//action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("nose and ear trimmer").doubleClick().build().perform();
		
		wait.until(ExpectedConditions.visibilityOf(element));
		action.moveToElement(element).moveToElement(driver.findElement(By.xpath("//div[@id='nav-al-your-account']/a[1]/span"))).keyDown(Keys.CONTROL).click().build().perform();
		//action.moveToElement(driver.findElement(By.xpath("//div[@id='nav-al-right-links']/a[1]/span"))).contextClick().sendKeys(Keys.ENTER).sendKeys(Keys.ENTER).build().perform();
		//driver.findElement(By.xpath("//div[@id='nav-al-right-links']/a[1]/span")).sendKeys(Keys.ARROW_DOWN);
		//driver.findElement(By.xpath("//div[@id='nav-al-right-links']/a[1]/span")).sendKeys(Keys.ENTER);
	}

}
