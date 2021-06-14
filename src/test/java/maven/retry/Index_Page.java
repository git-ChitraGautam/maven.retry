package maven.retry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Index_Page {
	
	public WebDriver driver;
	public String driver_path = "C:\\Users\\Acer\\Downloads\\chromedriver_win32";
	public int i;
	public Scanner sc;
	public String input;
	public WebDriverWait webdriverwait;
	public String delitem;
	public String temp;
	public WebElement temp_element;
	public static char disable ='N';
	public String s ="https://www.rahulshettyacademy.com/#/";
	
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test Index_Page ");
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", driver_path + "\\ChromeDriver.exe");
	 driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println(driver);
		System.out.println("Before  Test  Index_Page  ");
		sc = new Scanner(System.in);

		i = 0;

		try {
			driver.get("https://rahulshettyacademy.com");
		} catch (Exception e) {
			e.printStackTrace();

		}
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test(priority =1 )
	public void options()
	{
		@SuppressWarnings("unchecked")
		List<String> required_op = new ArrayList<String>();
		required_op.add("Home");
		required_op.add("Courses");
		required_op.add("All Access Plan");
		required_op.add("Learning Paths");
		
		required_op.add("Mentorship");
		
		required_op.add("Job Support");
		required_op.add("Practice");
		required_op.add("Blog");
		required_op.add("More");
		
		
		List<String> test_op=new ArrayList<String>();
		
		System.out.println("Test method ");
	List<WebElement> op  = driver.findElements(By.xpath("//div[@class='header-upper']/div/div/div[2]/nav/div[2]/ul/li"));
	
	
		
	System.out.println(op);
 for (WebElement k:op)
	{
		System.out.println(k.getText());
		test_op.add(k.getText());
	}
 Assert.assertEquals(test_op,required_op,"Elements are not matching");
	}

@Test(priority =2 )
public void click_Home()
{
	
	driver.findElement(By.linkText("Home")).click();
	try {
		Thread.sleep(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Assert.assertEquals(driver.getCurrentUrl(),"https://rahulshettyacademy.com/#/index","URL Mismatch"+driver.getCurrentUrl());
}
@Test(priority =3 )
public void click_Courses()
{
	
	driver.findElement(By.linkText("Courses")).click();
	try {
		Thread.sleep(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Assert.assertEquals(driver.getCurrentUrl(),"https://courses.rahulshettyacademy.com/courses","URL Mismatch"+driver.getCurrentUrl());
}

@Test(priority =4)

public void click_Mentorship()
{
	
	driver.findElement(By.linkText("Mentorship")).click();
	try {
		Thread.sleep(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Assert.assertEquals(driver.getCurrentUrl(),s+"mentorship","URL Mismatch  "+driver.getCurrentUrl());
}

@Test(priority =5)
public void click_Practice_Projects()
{
	
	driver.findElement(By.linkText("Practice")).click();
	try {
		Thread.sleep(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Assert.assertEquals(driver.getCurrentUrl(),s+"practice-project","URL Mismatch  "+driver.getCurrentUrl());
}


@Test(priority =6)
public void click_Consulting()
{
	
	driver.findElement(By.linkText("Job Support")).click();
	try {
		Thread.sleep(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Assert.assertEquals(driver.getCurrentUrl(),s+"consulting","URL Mismatch"+driver.getCurrentUrl());
}

@Test(priority =7)
public void click_Learning_Path()
{
	
	driver.findElement(By.linkText("Learning Path")).click();
	try {
		Thread.sleep(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Assert.assertEquals(driver.getCurrentUrl(),s+"learning-path","URL Mismatch"+driver.getCurrentUrl());
}

@Test(priority =8)
public void click_LifetimeAccess()
{
	
	driver.findElement(By.linkText("Lifetime Access")).click();
	try {
		Thread.sleep(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Assert.assertEquals(driver.getCurrentUrl(),s+"lifetime-access","URL Mismatch  "+driver.getCurrentUrl());
}

@Test(priority =9 )
public void hover_About()
{
	
	WebElement hover = driver.findElement(By.linkText("About"));
	Actions actions = new Actions(driver);
	actions.moveToElement(hover).perform();
	try {
		Thread.sleep(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

@Test

public void Scroll_Vertical()
{
	Actions act = new Actions(driver);
	act.sendKeys(Keys.PAGE_DOWN).build().perform();
	
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	act.sendKeys(Keys.PAGE_UP).build().perform();
	
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver; 
	
	js.executeScript("window.scrollBy(0,7)");
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	js.executeScript("window.scrollBy(0,7)");
	
	
}




}
