import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumR {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver Driver = new ChromeDriver();

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
		
		//UnBroken URL
		String url = Driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		
		HttpURLConnection Connection = (HttpURLConnection) new URL(url).openConnection();
		Connection.setRequestMethod("HEAD");
		
		Connection.connect();
		int ResponseCode = Connection.getResponseCode();
		System.out.println(ResponseCode);

		
		//Broken URL
		
		String uRl = Driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		HttpURLConnection BrokenConnection = (HttpURLConnection) new URL(uRl).openConnection();
		BrokenConnection.setRequestMethod("HEAD");
		BrokenConnection.connect();
		int BrokenResponseCode = BrokenConnection.getResponseCode();
		
		System.out.println(BrokenResponseCode);
		
	}

}
