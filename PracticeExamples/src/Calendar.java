import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {		
		
		String dayToBeSelected = "30";
		String monthYearToBeSelected = "June 2022";
		System.setProperty("webdriver.chrome.driver", "Installers/Webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 8);
		driver.get("https://www.path2usa.com/travel-companions");
		
		
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='travel_date']"))));
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='travel_date']"))));
		//wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//input[@id='travel_date']"), true));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='travel_date']")));
		Thread.sleep(8000);
		//js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//input[@id='travel_date']")));
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();
		
		String monthYear = driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='datepicker-switch']")).getText().trim();
		System.out.println(monthYear);
		while(!monthYear.equalsIgnoreCase(monthYearToBeSelected)) {
			driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='next']")).click();
			monthYear = driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='datepicker-switch']")).getText().trim();
			System.out.println(monthYear);
		}
		
		/* Grab the common attribute of calender
		 * Put all the elements in a List
		 * Iterate through the List
		 */
		List<WebElement> days = driver.findElements(By.className("day")); 
		int count = days.size();
		for(int i=0;i<count;i++) {
			if(days.get(i).getText().trim().contains(dayToBeSelected)) {
				days.get(i).click();
				break;
			}
		}

	}

}

