import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class SeleniumX {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(3000);
		
		// Relative Locators [Above]
		
		WebElement NameTextBox = Driver.findElement(By.cssSelector("[name='name']"));
		String NameText = Driver.findElement(with(By.tagName("label")).above(NameTextBox)).getText();
		System.out.println(NameText);
		
		//Relative Locators [Below]
		
		WebElement EmailText = Driver.findElement(By.xpath("//label[normalize-space()='Email']"));
		Thread.sleep(1000);
		Driver.findElement(with(By.tagName("input")).below(EmailText)).sendKeys("Veeresh@gmail.com");
		
		//Relative Locators [Left]
		
		WebElement CheckBoxText = Driver.findElement(By.xpath("//label[normalize-space()='Check me out if you Love IceCreams!']"));
		Driver.findElement(with(By.tagName("input")).toLeftOf(CheckBoxText)).click();
		
		//Relative Locators [Right]
		
		WebElement RadioButton = Driver.findElement(By.id("inlineRadio1"));
		String RadioButtonText = Driver.findElement(with(By.tagName("label")).toRightOf(RadioButton)).getText();
		System.out.println(RadioButtonText);
	}

}
