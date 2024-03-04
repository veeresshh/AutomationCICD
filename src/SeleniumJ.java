import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class SeleniumJ {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Driver = new ChromeDriver();

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


		Driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(3000);
				
		//Find Number of Frames
		System.out.println(Driver.findElements(By.tagName("iframe")).size());

		
		//Switch to Frame using Web Element
		Driver.switchTo().frame(Driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		
		//Switch to Frame using Index
		//Driver.switchTo().frame(0);
				
		//create action class
		Actions a = new Actions(Driver);
		
		//Define Source
		WebElement Source = Driver.findElement(By.id("draggable"));
		
		//Define Target
		WebElement Target = Driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(Source, Target).build().perform();
		
		
		//Switch to Parenr Frame
		Driver.switchTo().defaultContent();
		
		
	}
}