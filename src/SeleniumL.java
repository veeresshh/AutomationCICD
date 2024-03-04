import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SeleniumL {

	public static void main(String[] args) throws InterruptedException {

		
		ChromeOptions Options = new ChromeOptions();
		Options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		
		WebDriver Driver = new ChromeDriver(Options);

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Driver.get("https://www.makemytrip.com/");
		Thread.sleep(8000);
		
		//Driver.switchTo().frame(Driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame")));
		
		//Driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
		
		//Driver.switchTo().defaultContent();
		
		Driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();
		Thread.sleep(3000);
		
		while(!Driver.findElement(By.cssSelector("[class='DayPicker-Caption']")).getText().contains("September 2024"))
		{
		Driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		}
		
		List<WebElement> Dates = Driver.findElements(By.xpath("//div[@class='DayPicker-Day']/div[@class='dateInnerCell']/p[1]"));
		
		int count = Dates.size();
		
		for(int i=0;i<count;i++)
		{
			String Date = Dates.get(i).getText();
			
			if(Date.equalsIgnoreCase("23"))
			{
				Dates.get(i).click();
				break;
			}
		}
		
		
		
	}

}
