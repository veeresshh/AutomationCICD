import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumF {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Driver = new ChromeDriver();

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String text = "Rahul";

		Driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		Driver.findElement(By.id("name")).sendKeys(text);
		Thread.sleep(2000);

		Driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		Thread.sleep(2000);

		System.out.println(Driver.switchTo().alert().getText());
		Thread.sleep(2000);

		Driver.switchTo().alert().accept();
		Thread.sleep(2000);

		Driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);

		System.out.println(Driver.switchTo().alert().getText());
		Thread.sleep(2000);

		Driver.switchTo().alert().dismiss();
		Thread.sleep(2000);

	}

}