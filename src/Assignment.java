import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver Driver = new ChromeDriver();
		
		Driver.manage().window().maximize();
		
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			

		Driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		System.out.println(Driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		Assert.assertTrue(Driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		
		if(Driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected())
		{
			Driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		}
		
		Assert.assertFalse(Driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		System.out.println(Driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		
		System.out.println(Driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
	}
}
