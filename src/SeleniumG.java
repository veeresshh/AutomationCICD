import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumG {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		
		String[] VegetableList = { "Cucumber", "Brocolli", "Beetroot" };
		
		Driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		
		// Define Object in case you dont add static to the method
		// SeleniumG G = new SeleniumG();	
		
		AddItems(Driver,VegetableList);
		
		//Enter Correct Promo
		Driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		Driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		Driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettacademy");
		Driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println(Driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		//Enter InCorrect Promo
		Driver.findElement(By.cssSelector("input.promoCode")).clear();
		Driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		Driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Code applied ..!']")));
		
		System.out.println(Driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	}
	
	public static void AddItems(WebDriver Driver,String[] VegetableList)
	
	{
		int j = 0;
		
		List<WebElement> products = Driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++)

		{

			String[] Items = products.get(i).getText().split("-");
			String Item = Items[0].trim();

			List<String> Vegetables = Arrays.asList(VegetableList);

			if (Vegetables.contains(Item))

			{
				j++;
				Driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == VegetableList.length)
				{
					break;
				}
			}
		}
		
	}
}

