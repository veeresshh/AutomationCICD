import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumEE {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Driver = new ChromeDriver();

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		System.out.println(Driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		System.out.println(Driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());

		Driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).click();

		System.out.println(Driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());

		Thread.sleep(2000);

		Driver.close();

	}
}