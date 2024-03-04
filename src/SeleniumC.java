import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumC {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver Driver = new ChromeDriver();
		
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Calling Method
		
		String Password = GetPassword(Driver);
		
		String Name = "Veeresh";
		
		Driver.get("https://rahulshettyacademy.com/locatorspractice/");		
		Driver.findElement(By.id("inputUsername")).sendKeys(Name);
		Driver.findElement(By.name("inputPassword")).sendKeys(Password);
		Driver.findElement(By.className("submit")).click();
		
		Thread.sleep(2000);
		
		System.out.println(Driver.findElement(By.tagName("p")).getText());		
		Assert.assertEquals(Driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
       
		System.out.println(Driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		Assert.assertEquals(Driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+Name+",");
	
		Driver.findElement(By.xpath("//button[normalize-space()='Log Out']")).click();
		
		Thread.sleep(2000);
		
		Driver.close();
	}
	
	public static String GetPassword(WebDriver Driver) throws InterruptedException{
		
		Driver.get("https://rahulshettyacademy.com/locatorspractice/");	
		Driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		
		Driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
        String Password0 = Driver.findElement(By.cssSelector("form p")).getText();
        
        //Please use temporary password 'rahulshettyacademy' to Login.
        
        String[] PasswordArray1 = Password0.split("'");
        String[] PasswordArray2 = PasswordArray1[1].split("'");
        String Password = PasswordArray2[0];
        
        return Password;
		
		
	}
}