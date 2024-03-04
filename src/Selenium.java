import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Selenium {

	public static void main(String[] args) {
		
		WebDriver Driver = new ChromeDriver();
		//WebDriver Driver = new FirefoxDriver();
		//WebDriver Driver = new EdgeDriver();
		
//Implicit Wait to wait till element is present
		
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
//Loads a New Web Page
		
		Driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
//Find Element and Enter Information
		
		Driver.findElement(By.id("inputUsername")).sendKeys("Veeresh");
		
		Driver.findElement(By.name("inputPassword")).sendKeys("Veeresh");

//Click on Login Button
		
		Driver.findElement(By.className("submit")).click();
		
//CSS Selector
		
		//Class Name = tagname.classname ( Example = Button.submit )
		//id = tagname#id
		//Generic = Tagname[attribute='value'] (Example = input[placeholder='Username']
		//input[type='text']:nth-child(3)
		
//Validation using Css Element
		
		System.out.println(Driver.findElement(By.cssSelector("p.error")).getText());

// Using LinkText
		
        Driver.findElement(By.linkText("Forgot your password?")).click();
        
// Using Xpath & Css Selectors
        
        Driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Veeresh");
        Driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("abc@gmail.com");
        Driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
        Driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("def@gmail.com");
        Driver.findElement(By.xpath("//form/input[3]")).sendKeys("1233456");
        Driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(Driver.findElement(By.cssSelector("form p")).getText());
        Driver.findElement(By.xpath("//button[normalize-space()='Go to Login']")).click();
        
        
        
		
//Close the Webpage
		
		//Driver.close();
		
// In Console to check CSS 
		
		// $('p.error') > Enter
        
// In Console to check Xpath
        
        //$x('//input[@placeholder="Phone Number"]')
        
        
//Adding Wait
              
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        String name = "Veeresh";
        
        Driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        Driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        Driver.findElement(By.id("chkboxOne")).click();
        Driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        
        
        Driver.close();
      
	}
}

