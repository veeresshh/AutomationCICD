import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumEC {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Driver = new ChromeDriver();

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		Thread.sleep(2000);

		Driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("(//a[@value='BLR'])[1]")).click();
		//// div[@id="glsctl00_mainContent_ddl_originStation1_CTNR"]//a[@value="BLR"] -
		//// Parent Child Xpath
		Thread.sleep(2000);
		System.out.println(Driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value"));

		Driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		//// div[@id="glsctl00_mainContent_ddl_destinationStation1_CTNR"]//a[@value="MAA"]
		//// - Parent Child Xpath
		Thread.sleep(2000);
		System.out.println(Driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getAttribute("value"));

		Driver.close();
	}
}