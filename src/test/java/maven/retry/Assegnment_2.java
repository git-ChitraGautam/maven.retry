package maven.retry;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assegnment_2 {
	WebDriver driver;
	
	
	
	@BeforeTest()
	public void before_assigment_2_test()
	{
		WebDriverManager.chromedriver().setup();
		
		
		driver = new ChromeDriver();
		
		
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Set<String>   win = driver.getWindowHandles();
		
		String ff = win.iterator().next();
		
		
	
		
		Iterator it = win.iterator();
		while(it.hasNext())
		{
			ff= it.next().toString();
		}
		driver.switchTo().window(ff);
		
		driver.manage().window().maximize();
		System.out.println( driver.getWindowHandles());
		
		
	}
	
	
	
	@Test()
	public void checkbox() throws InterruptedException
	{
		
		List<WebElement> name  = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(WebElement e : name)
		{
			e.click();
			System.out.println(e.isEnabled());
		}
		
		Thread.sleep(5);
		
		
		
	
		
	}
	
	@Test()
	public void radiobutton() throws InterruptedException
	{
		
		
	//	WebDriverWait wait = new WebDriverWait(driver , 10);
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated
		
		
		
		
		List<WebElement> name  = driver.findElements(By.xpath("//input[@type='radio']"));
		
		for(WebElement e : name)
		{
			e.click();
			System.out.println(e.isEnabled());
		}
		
		Thread.sleep(5);
		
		
		
	
		
	}
	
	
	
	@DataProvider(name = "data")
	public Object[][] data()
	{
		return new Object[][] {{"Chitra"}};
	}
	
	
	
	@DataProvider(name = "Accept")
	public Object[][] accept()
	{
		return new Object[][] {{"Accept"}};
	}
	
	
	
	@DataProvider(name = "Cancel")
	public Object[][] cancel()
	{
		return new Object[][] {{"Cancel"}};
	}
	
	public void openWindow()
	{
		
		WebElement element = driver.findElement(By.id("openwindow"));
		element.click();
		
		Set<String> windows = driver.getWindowHandles();
		String  s = windows.iterator().next();
		
		System.out.println(windows);
		Iterator i = windows.iterator();
		while(i.hasNext())
		{
			s= i.next().toString();
		}
		
		driver.switchTo().window(s);
		
		System.out.println(driver.getCurrentUrl());
		
		driver.manage().window().maximize();
		
		
		
	}
	
	@Test()
	public void openTab()
	{
		
		WebElement element = driver.findElement(By.id("opentab"));
		element.click();
		
		Set<String> windows = driver.getWindowHandles();
		String  s = windows.iterator().next();
		
		System.out.println(windows);
		Iterator i = windows.iterator();
		while(i.hasNext())
		{
			s= i.next().toString();
		}
		
		driver.switchTo().window(s);
		
		System.out.println(driver.getCurrentUrl());
		
		driver.manage().window().maximize();
		
		
		
	}
	
	
	@Test(dataProvider = "data")
	public void switchToAlert(String d)
	{
		
		WebElement name  = driver.findElement(By.id("name"));
		
		name.sendKeys(d);
		
		WebElement element  = driver.findElement(By.id("alertbtn"));
		element.click();
		
		
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		alert.accept();
		
		System.out.println(driver.getCurrentUrl());
		
				
		
		
	}
	
	@Test(dataProvider = "Accept")
	public void switchToConfirmAccept(String n)
	{
		
		WebElement name  = driver.findElement(By.id("name"));
		
		name.sendKeys(n);
		
		WebElement element  = driver.findElement(By.id("confirmbtn"));
		element.click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		alert.accept();
		
		
	}
	
	@Test(dataProvider = "Cancel")
	public void switchToConfirmCancel(String c) throws InterruptedException
	{
		
		WebElement name  = driver.findElement(By.id("name"));
		
		name.sendKeys(c);
		
		WebElement element  = driver.findElement(By.id("confirmbtn"));
		element.click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		Thread.sleep(5);
		
		alert.dismiss();
		
	
		
	}
	
	
	@Test()
	public void handleTable() throws InterruptedException
	{
		
		WebElement name  = driver.findElement(By.id("product"));
		
		
		Thread.sleep(5);
		
		System.out.println(name.findElement(By.xpath("//th")).getText());
		
	
		
	}
	
	
	
	
	
	
	
	
	

}
