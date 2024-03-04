import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class SeleniumEG {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver Driver = new ChromeDriver();
		
		Driver.manage().window().maximize();
		
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		
		Driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Thread.sleep(2000);
		
		Driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		
		List<WebElement> options =Driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement option :options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
		
		//Driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		Thread.sleep(2000);
		System.out.println(Driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(Driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("Its Enabled");
			Assert.assertTrue(true);
		}
		else
		{
			Driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		}
		
		Driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).click();
		Thread.sleep(2000);
		
		Driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("(//a[@value='BLR'])[1]")).click();
		Thread.sleep(2000);
		System.out.println(Driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value"));
		
		
		Driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		Thread.sleep(2000);
		System.out.println(Driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getAttribute("value"));
		
		
		//.ui-state-default.ui-state-highlight.ui-state-active
		
		
		Thread.sleep(2000);	
		Driver.findElement(By.xpath("//a[contains(@class,'highlight')]")).click();
		
		Thread.sleep(2000);
		Driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		Driver.findElement(By.xpath("//td[@data-month='0']//a[@class='ui-state-default' and contains(text(),'18')]")).click(); 

		
		Driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);		   
		
		for(int i=1;i<5;i++)
			
		{
		    Driver.findElement(By.id("hrefIncAdt")).click();
		    Thread.sleep(2000);
		}	
		
		Driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(Driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(Driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(2000);
		
		
		WebElement StaticDropdown = Driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select Dropdown = new Select(StaticDropdown);
				
		Dropdown.selectByValue("INR");
		System.out.println(Dropdown.getFirstSelectedOption().getText());
				
		Thread.sleep(2000);
				
		Driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		Thread.sleep(6000);
						
		Driver.close();
		
		
	}
}