import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class SeleniumM {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Driver = new ChromeDriver();

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
		
		JavascriptExecutor JS = (JavascriptExecutor) Driver;
		JS.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(4000);
		
		JS.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List <WebElement> Values = Driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int Sum = 0;
				
		for(int i=0; i<Values.size();i++)
		{
			Sum = Sum + Integer.parseInt(Values.get(i).getText());
		}
		
		System.out.println(Sum);
		Thread.sleep(4000);
		
		int Total = Integer.parseInt(Driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		System.out.println(Total);
		Thread.sleep(4000);
		
		
		Assert.assertEquals(Sum, Total);
		
		
	}

}
