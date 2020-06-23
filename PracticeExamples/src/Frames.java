import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "Installers/Webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.findElement(By.id("draggable")).click();
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']/p"));
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		driver.findElements(By.tagName("iframe")).size();
		driver.switchTo().defaultContent();
		System.out.print("Hello World");
	}

}
