import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumY {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(3000);
		
		Driver.switchTo().newWindow(WindowType.TAB); // Use Windows Type as Window instead of TAB to open in new window
		
		//To Get total Tabs Opened
		Set<String> WindowHandles = Driver.getWindowHandles();
		Iterator<String> Tabs = WindowHandles.iterator();
		String ParentWindow = Tabs.next();
		String ChildWindow = Tabs.next();
		
		//Move Control to Child Window
		Driver.switchTo().window(ChildWindow);
		
		Driver.get("https://rahulshettyacademy.com/");
		Thread.sleep(5000);
		String CourseName =Driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		
		System.out.println(CourseName);
		
		//Move Control to Parent Window
		Driver.switchTo().window(ParentWindow);
		
		WebElement Name =Driver.findElement(By.xpath("(//input[@name='name'])[1]"));
		Name.sendKeys(CourseName);
		
		
		//Very Very Important
		
		//To take a screenshot of webelement
		File ScreenShot = Name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ScreenShot, new File("TextBox.png"));
		
		//To take a screenshot of Entire Web Page
		File SRC =((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SRC, new File("Screenshot.png"));
	}

}
