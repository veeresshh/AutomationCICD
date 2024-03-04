import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumN {

	public static void main(String[] args) throws InterruptedException {		
		
		// Accept Insecure Certificates
		ChromeOptions Options = new ChromeOptions();
		Options.setAcceptInsecureCerts(true);
		System.out.println(Options.getBrowserName());
		
		// Accept Insecure Certificates add to Driver 
		WebDriver Driver = new ChromeDriver(Options);

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Driver.get("https://expired.badssl.com/");
		System.out.println(Driver.getTitle());
		Thread.sleep(3000);
		
		
		
		
	}

}
