import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumH {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Driver = new ChromeDriver();

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


		Driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		
		WebElement Move = Driver.findElement(By.xpath("(//a[@title='Login'])[1]"));
		
		WebElement EnterCaps =Driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
		
		//Create action Class
		Actions a = new Actions(Driver);
		
		//Moves to Specific Element
		
		
		
		//Enter Caps		
		a.moveToElement(EnterCaps).click().keyDown(Keys.SHIFT).sendKeys("mobile").doubleClick().build().perform();
		
		Thread.sleep(3000);
		
		
		//Double Click	
		a.moveToElement(Move).contextClick().build().perform();
		
		Thread.sleep(3000);
		
	
	}
}