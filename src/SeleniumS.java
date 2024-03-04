import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import java.io.IOException;


public class SeleniumS {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

		WebDriver Driver = new ChromeDriver();

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


		Driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
		

		 List<WebElement> Links = Driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		 
		 //Soft Assertions
		 SoftAssert SoftAssert = new SoftAssert();
		
		for (WebElement Link : Links)
		{
			String uRl = Link.getAttribute("href");
			
			HttpURLConnection BrokenConnection = (HttpURLConnection) new URL(uRl).openConnection();
			BrokenConnection.setRequestMethod("HEAD");
			BrokenConnection.connect();
			int BrokenResponseCode = BrokenConnection.getResponseCode();
			
			System.out.println(BrokenResponseCode);
			
			//Adding Soft Assertions			
			SoftAssert.assertTrue(BrokenResponseCode<400, "The Link with the Text "+Link.getText()+" is Broken with the Response Code "+BrokenResponseCode);

		}
		    SoftAssert.assertAll();
		     
		}
		
		
}
