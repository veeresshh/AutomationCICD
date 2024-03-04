import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumEF {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Driver = new ChromeDriver();

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		Assert.assertFalse(Driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
		System.out.println(Driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());

		Driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).click();

		System.out.println(Driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
		Assert.assertTrue(Driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());

		Thread.sleep(2000);

		System.out.println(Driver.findElement(By.id("divpaxinfo")).getText());

		Driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		for (int i = 1; i < 5; i++)

		{
			Driver.findElement(By.id("hrefIncAdt")).click();
			Thread.sleep(2000);
		}

		Driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(Driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(Driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(2000);

		Driver.close();

	}
}