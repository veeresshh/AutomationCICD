import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumEB {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Driver = new ChromeDriver();

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		Thread.sleep(2000);

		System.out.println(Driver.findElement(By.id("divpaxinfo")).getText());

		Driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		// Select Multiple Passenger Using While Loop

//		int i=1;
//		while(i<5)

//		{
//		    Driver.findElement(By.id("hrefIncAdt")).click();
//	        i++;
//		    Thread.sleep(2000);
//		}

		// Same Code in For Loop

		for (int i = 1; i < 5; i++)

		{
			Driver.findElement(By.id("hrefIncAdt")).click();
			Thread.sleep(2000);
		}

		Driver.findElement(By.id("btnclosepaxoption")).click();
		Thread.sleep(2000);

		System.out.println(Driver.findElement(By.id("divpaxinfo")).getText());

		Driver.close();

	}

}