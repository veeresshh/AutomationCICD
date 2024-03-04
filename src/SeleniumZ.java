import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumZ {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(3000);
		
		WebElement Name =Driver.findElement(By.xpath("(//input[@name='name'])[1]"));
		
		// To Find Height and Width of the Element
		
		System.out.println(Name.getRect().getDimension().getHeight());
		System.out.println(Name.getRect().getDimension().getWidth());
		
	}

}
