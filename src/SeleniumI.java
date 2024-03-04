import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumI {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Driver = new ChromeDriver();

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


		Driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		Thread.sleep(3000);
		
		Driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		Thread.sleep(3000);
		
		
		//Get Active Tabs
		Set<String> Windows = Driver.getWindowHandles();
		Iterator<String> it = Windows.iterator();
		
		//To Get Parent ID
		String ParentId = it.next();
		
		//To Get Child ID
		String ChildId = it.next();
		
		//Switch to Next Tab
		Driver.switchTo().window(ChildId);
		Thread.sleep(3000);
		
		
		System.out.println(Driver.findElement(By.cssSelector(".im-para.red")).getText());
		String Email = Driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(Email);
		
		
	    //Switch to Next Tab
		Driver.switchTo().window(ParentId);
		Driver.findElement(By.id("username")).sendKeys(Email);
		
		
		
	}
}