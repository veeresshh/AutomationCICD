import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumP {

	public static void main(String[] args) throws InterruptedException {	
		
		WebDriver Driver = new ChromeDriver();

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Delete All Cookies
		Driver.manage().deleteAllCookies();
		
		//Delete One Cookies
		Driver.manage().deleteCookieNamed("Veeresh");
		
		Driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
	}

}
