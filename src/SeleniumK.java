import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumK {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Driver = new ChromeDriver();

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


		Driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
		
		// To Find No of Links in Page
		System.out.println(Driver.findElements(By.tagName("a")).size());
		
		
		// To Find No of Links in Footer [ Limiting web driver Scope]
		WebElement Footer = Driver.findElement(By.id("gf-BIG"));	
		System.out.println(Footer.findElements(By.tagName("a")).size());
		
		// To Find No of Links in Footer Under only one header
		WebElement ColoumnDriver = Footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(ColoumnDriver.findElements(By.tagName("a")).size());
		
		
		//To Open the Links in new tabs and Get Titles
		
		for(int i=1; i<ColoumnDriver.findElements(By.tagName("a")).size(); i++)
			
		{
			//Ctrl+Link Opens in New Tabs
			String ClickLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			ColoumnDriver.findElements(By.tagName("a")).get(i).sendKeys(ClickLink);
			Thread.sleep(3000);
		}
			
			Set<String> Handles = Driver.getWindowHandles();
			Iterator<String> IT = Handles.iterator();
			
			while(IT.hasNext()) // to see wheather it has next tab
			{
				Driver.switchTo().window(IT.next()); // to move to next tab
				System.out.println(Driver.getTitle());
				
			}

		}
		
		
}