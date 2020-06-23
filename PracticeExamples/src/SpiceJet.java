import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SpiceJet {
	static WebDriverWait wait;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Installers/Webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		wait = new WebDriverWait(driver, 5);
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_ddl_originStation1_CTXT")));
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='PNQ']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']"))));
		driver.findElement(By.xpath(("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']"))).click();
		
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		//Assert.assertEquals(driver.findElement(By.id(("ctl00_mainContent_view_date2"))).isEnabled(), false);
		if(driver.findElement(By.id(("Div1"))).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		
		
		Select s;
		s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		s.selectByValue("5");
		s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		s.selectByIndex(3);
		s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
		s.selectByVisibleText("1");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText(), "5 Adult, 3 Child, 1 Infant");
		
		s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		s.selectByVisibleText("USD");
		
		WebElement chkFamilyAndFriends = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
		Assert.assertFalse(chkFamilyAndFriends.isSelected());
		if(!chkFamilyAndFriends.isSelected()) {
			chkFamilyAndFriends.click();
		}
		//Get the count of number of checkboxes
		int chkBoxcount =  driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		Assert.assertEquals(chkBoxcount, 6);
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
