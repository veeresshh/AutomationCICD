import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumB {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver Driver = new ChromeDriver();
		
		String Name = "Veeresh";
		
		Driver.get("https://rahulshettyacademy.com/locatorspractice/");		
		Driver.findElement(By.id("inputUsername")).sendKeys(Name);
		Driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
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
 
}
