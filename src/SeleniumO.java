import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SeleniumO {

	public static void main(String[] args) throws InterruptedException {		
		
		//Very Very Important for Interview
		
		// Accept Insecure Certificates
		ChromeOptions Options = new ChromeOptions();
		Options.setAcceptInsecureCerts(true);
		System.out.println(Options.getBrowserName());
		
		//Add Extensions also
		Options.addExtensions(new File("/path/to/extension.crx"));
		
		//Add Proxy
		Proxy Proxyy = new Proxy();
		Proxyy.setHttpProxy("Ip address :4444");
		Options.setCapability("Proxy", "Proxyy");
		
		// Accept Insecure Certificates add to Driver 
		WebDriver Driver = new ChromeDriver(Options);
		
		
		//To Block Popups
		Options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		
		
		//To Set Download Directory		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "‪C:\\Users\\veereshkumar.s\\Downloads");
		
		Options.setExperimentalOption("prefs", prefs);
		
		

		Driver.manage().window().maximize();

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Driver.get("https://expired.badssl.com/");
		System.out.println(Driver.getTitle());
		Thread.sleep(3000);
		
	}

}
