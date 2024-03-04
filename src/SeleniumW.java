import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumW {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		Thread.sleep(3000);
		
		//To Search and Validate Search Results are Correct
		
		//Search Rice
		Driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		//Collect Rice after you search for Rice
		List<WebElement> VegetableList = Driver.findElements(By.xpath("//tr/td[1]"));
		
		//Collect Rice from the Table
		List<WebElement> FilteredVegetableList = VegetableList.stream().filter(Vegetables->Vegetables.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(FilteredVegetableList.size(), VegetableList.size());
		
	}

}
