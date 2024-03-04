import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumU {

	public static void main(String[] args) throws InterruptedException {

		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		Thread.sleep(3000);
		
		//To Sort the Table
		
		Driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement> VegetableList = Driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> AllVegetablesList = VegetableList.stream().map(S->S.getText()).collect(Collectors.toList());
		
		System.out.println(AllVegetablesList);
		
		List<String> SortedVegetablesList = AllVegetablesList.stream().sorted().collect(Collectors.toList());
		
		System.out.println(SortedVegetablesList);
		
		Assert.assertTrue(AllVegetablesList.equals(SortedVegetablesList));
		
		
		// Scan the Row & Coloumn and to find the price of particular Vegetable
		
		List<String> VegetablePriceList = VegetableList.stream().filter(S->S.getText().contains("Beans")).map(S->GetPriceOfVegetable(S)).collect(Collectors.toList());

		VegetablePriceList.forEach(V->System.out.println(V));
	}

	private static String GetPriceOfVegetable(WebElement S) {
		
		String Price = S.findElement(By.xpath("following-sibling::td[1]")).getText();
		return Price;
		
		
	}

}
