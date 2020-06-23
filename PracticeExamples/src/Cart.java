import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Cart {
	static WebDriver driver;
	static WebDriverWait wait;
	private static void addItemsToCart(String[] itemToBeAdded) {
		int j=0;		
		List<WebElement> elements = driver.findElements(By.cssSelector(".product-name"));		
		
			for(int i=0;i<elements.size();i++) {
				String item[] = elements.get(i).getText().split("-");
				String name = item[0].trim();
				List<String> itemToBeAddedList = Arrays.asList(itemToBeAdded);
				
				if(itemToBeAddedList.contains(name)) {	
					j++;
					driver.findElements(By.cssSelector(".product-action button")).get(i).click();
					if(itemToBeAddedList.size()==j) break;
				}
				
				
			}
	}

	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "Installers/Webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
		String[] itemToBeAdded = {"Brocolli","Cucumber","Beetroot","Carrot","Brinjal","Tomato","Beans","Capsicum","Mushroom","Walnuts","Cashews","Nuts Mixture","Water Melon","Potato","Corn","Onion","Raspberry","Musk Melon","Banana","Apple"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		addItemsToCart(itemToBeAdded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".promoCode")));
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".promoBtn")));
		driver.findElement(By.cssSelector(".promoBtn")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		Assert.assertEquals(driver.findElement(By.cssSelector(".promoInfo")).getText(), "Code applied ..!");
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		}
		
	
}
