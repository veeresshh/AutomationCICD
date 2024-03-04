import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumD {

       public static void main(String[] args) throws InterruptedException {

           WebDriver Driver = new ChromeDriver();

           Driver.manage().window().maximize();

           Driver.get("http://google.com");          
           Thread.sleep(3000);

           Driver.navigate().to("https://rahulshettyacademy.com");
           Thread.sleep(3000);
           
           Driver.navigate().back();
           Thread.sleep(3000);
           
           Driver.navigate().forward();
           Thread.sleep(3000);
    }
}