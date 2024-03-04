import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumEA {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Driver = new ChromeDriver();

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		Thread.sleep(2000);

		WebElement StaticDropdown = Driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select Dropdown = new Select(StaticDropdown);

		Dropdown.selectByIndex(3);
		System.out.println(Dropdown.getFirstSelectedOption().getText());

		Dropdown.selectByVisibleText("AED");
		System.out.println(Dropdown.getFirstSelectedOption().getText());

		Dropdown.selectByValue("INR");
		System.out.println(Dropdown.getFirstSelectedOption().getText());

		Thread.sleep(2000);

		Driver.close();

	}
}