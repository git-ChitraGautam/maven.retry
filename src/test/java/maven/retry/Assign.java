package maven.retry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import javafx.scene.web.WebEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Assign {
	
	
	
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
	
	/*   wget https://bitbucket.org/ariya/phantomjs/downloads/phantomjs-2.1.1-linux-x86_64.tar.bz2 && tar xvjf phantomjs-2.1.1-linux-x86_64.tar.bz2 && rm -f *.bz2  */ 
	
	
	
	
	FileInputStream fi  = null ;
	File file;
	XSSFWorkbook workbook;
	XSSFSheet sheet =null;
	

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class anno ");

	}

	@BeforeTest
	public void beforeTest() throws Exception {
		System.out.println("Before Test ");
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", driver_path + "\\ChromeDriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println(driver);
		System.out.println("Before  Test  ");
		sc = new Scanner(System.in);

		i = 0;

		try {
			driver.get("https://rahulshettyacademy.com");
			
			//driver.get("https://rahulshettyacademy.com/seleniumPractise/#/country");
			
			//driver.get("https://demoqa.com/resizable");
			
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		file =new File("C:\\Users\\Acer\\eclipse-workspace\\maven.retry\\Excel\\TestData.xlsx");
		
		fi = new FileInputStream(file);
		
		try {
			workbook = new XSSFWorkbook(fi);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/*
	
	@Parameters({"URL","keyword"})
	@Test 
	
	public void gh(String URL , String keyword)
	{
		driver.get(URL);
		driver.findElement(By.tagName("input")).sendKeys(keyword);
	}
	
	*/
	
	
	
	@Test
	
	public void resize ()
	{
		
			
				
				Actions action=new Actions(driver );
			

		

		
		    WebElement resize =driver.findElement(By.xpath("//*[@id='resizableBoxWithRestriction']/span"));
		     System.out.println("Before "+driver.findElement(By.xpath("//*[@id=\"resizableBoxWithRestriction\"]")).getAttribute("style"));
		    action.clickAndHold(resize).moveByOffset(250,50).release().build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		    System.out.println(driver.findElement(By.xpath("//*[@id=\"resizableBoxWithRestriction\"]")).getAttribute("style"));
		    
		}
		

	
@Parameters({"UserName", "Password"})
	@Test(priority = 1)
	public void login(String UName , String Password) {
		System.out.println("At login");
		WebElement preloader = driver.findElement(By.xpath("//div[@class='preloader']/span"));
		while (driver.findElement(By.xpath("//div[@class='preloader']/span")).isDisplayed()) {
		
		//Assert.assertTrue(preloader.isDisplayed());
		
		//while (valid) {
			webdriverwait = new WebDriverWait(driver, 1);
			System.out.println("Preloading...");
		}
		driver.findElement(By.xpath("//header[@class='main-header']/div[2]/div/div/div[2]/nav/div[2]/ul/li[4]/a"))
				.click();

		try {
			Thread.sleep(6);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			System.out.println("something wrong ");
		}
		driver.findElement(By.cssSelector("input#name")).sendKeys(UName);
		driver.findElement(By.cssSelector("input#email")).sendKeys(Password);
		
		driver.findElement(By.id("agreeTerms")).click();
		
		driver.findElement(By.id("form-submit")).click();
		while (driver.findElement(By.id("form-submit")).getText().equalsIgnoreCase("Submitting...")) {
			webdriverwait = new WebDriverWait(driver, 1);
			System.out.println("Please wait...");
		}
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(dependsOnMethods = "login")
	public void clicklink() throws InterruptedException

	{
		System.out.println("click link");
		try {
			
			Thread.sleep(1);
			driver.findElement(By.xpath("//div[@class='container']/div[1]/a[1]")).click();
		} catch (org.openqa.selenium.ElementNotInteractableException e) {
			System.out.println("Link is not interactable");
try {
	Thread.sleep(2);
} catch (InterruptedException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
			driver.findElement(By.xpath("//div[@class='container']/div[1]/a[1]")).click();
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	
	

	@SuppressWarnings("deprecation")
	@Test(dependsOnMethods = "clicklink",groups ="a" )
	
	
	public void addVeg() throws Exception {
		
		//Get Data from excel sheet 
		
		
			sheet = workbook.getSheet("Add");
	
	
	 System.out.println(sheet.getPhysicalNumberOfRows());
	 System.out.println("Got it ");
	
	

		
		
		
		
		System.out.println("Enter no of products to add on cart");
		int no = sheet.getPhysicalNumberOfRows();
		//sc.nextLine();
		//XSSFRow[] names = new XSSFRow[no];
		String[] names = new String[no]; // array takes less memory
		System.out.println("Enter products and qty for  " + names.length + "items:");
		for (i = 0; i < names.length; i++) {
			
			names[i] = sheet.getRow(i).getCell(0).getStringCellValue();
			//names[i] = sc.nextLine();
			//names[i][0] = sc.nextLine();
		//	names[i][1] = sc.next();
			
		}

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Getting products ");
		}
		List<String> al = Arrays.asList(names);
	//	WebElement inc;
		System.out.println(products.size());
		for (i = 0; i < products.size(); i++) {
			String name = (products.get(i).getText());

			String formatted_name = (name.split("-"))[0].trim();
			// String formatted_name=(name.trim().split("-"))[0];

			if (al.contains(formatted_name)) {

				// now click on add to cart

				System.out.println("found match");
	/*Trial for incremant */	/*		for ( int i =0; i< names.length;i++)
				{
					int k= Integer.parseInt(names[i][1]);
					for ( int j=0 ; j< k ;j++)
					{
						inc = driver.findElement(By.className("increment"));
						 ((RemoteWebDriver) driver).executeScript("arguments[0].style.border='3px solid green'",inc);
					//	inc.click();
						try {
							Thread.sleep(2);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} */
				WebElement item = driver.findElements(By.xpath("//*[text()='ADD TO CART']")).get(i);
				item.click();
				System.out.println("Product text " + products.get(i).getText());
				System.out.println("item text" + item.getText());

				while (item.getText().contains("ADDED")) {
					System.out.println("Please wait...");
					webdriverwait = new WebDriverWait(driver, 1);
					System.out.println("still ---" + item.getText());

				}

				// break;
			}
		}
		System.out.println("outside for loop at i=" + i);
		driver.findElement(By.className("cart-icon")).click();
//WebElement element=driver.findElement(By.xpath("//ul[@class='cart-items']"));
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='cart-items']/li"));
		System.out.println(list.toString());
		System.out.println("Items presented in the cart- " + (list.size() / 2));

		char option = 'N';

		
			System.out.println("Do you want to proceed to check out Y/N ");
			
			sheet = workbook.getSheet("Options");
			
			//option = sc.next().charAt(0);
			option = sheet.getRow(0).getCell(0).getStringCellValue().charAt(0);
			
			if (option == 'Y') {
				driver.findElement(By.xpath("//div[@class='cart-preview active']/div[2]/button")).click();
				disable ='Y'; 
				
				
				//TAKE SCREENSHOT
				
			/*	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(src,new File("C://Users//Acer//Pictures//Selenium SS//order.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  */           

			} 
		}
	

	@Test(dependsOnMethods = "addVeg" ,groups ="a" , enabled = true)
	
	public void delVeg()
	{
		
		char option2 ='Y';
		
		int row=0;
		int r=1;
		WebElement list;
		Boolean empty_cart = false;
		String message = "Unable to find exact text";
		WebElement cart ; 
		
		if(disable == 'Y') {
			System.out.println("Please don't move further");
			throw new SkipException("Delete is not applicable ");
	
			
			
		}
		try
		{
		empty_cart = driver.findElement(By.className("empty-cart")).isDisplayed();
		}
		catch(Exception e )
		{
			empty_cart =false;
		}
		
		
		
		
		while(( option2 == 'Y' || option2 =='y') && (empty_cart == false ) )
		{
			System.out.println("Do you want to delete item Y/N ?     "+empty_cart.toString());
			
			
			
sheet = workbook.getSheet("Options");
			
			//option = sc.next().charAt(0);
			option2 = sheet.getRow(r).getCell(0).getStringCellValue().charAt(0);
			
			
			r++;
			
			// option2 = sc.next().charAt(0);
			// sc.nextLine();
			if(option2 == 'Y' || option2 =='y')
			{
			
				
				sheet = workbook.getSheet("Delete");
			
				System.out.println("Please provide item to delete  ");
				delitem = sheet.getRow(row).getCell(0).getStringCellValue();
				row++;
				
			 list= driver.findElement(By.xpath("//ul[@class='cart-items']"));
			List<WebElement> l= list.findElements(By.className("product-name"));
				
			for(WebElement i :l )
			{
				temp = i.getText().split("-")[0].trim();;
				System.out.println(temp + "  ->  "+delitem );
				
			    if(temp.equalsIgnoreCase(delitem))
			    {
			    	System.out.println("Search parent and delete ");
			    	temp_element= i.findElement(By.xpath("./.."));      // search parent from child 
			    	System.out.println("1");
			    	 ((RemoteWebDriver) driver).executeScript("arguments[0].style.border='3px solid red'",temp_element);
			    	try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	
			    	
			    	temp_element=temp_element.findElement(By.xpath("following-sibling::a"));      //find following sibling by xpath 
			    	//temp_element=temp_element.findElement(By.xpath("./.."));
			    	System.out.println("2");
			    	 ((RemoteWebDriver) driver).executeScript("arguments[0].style.border='3px solid green'",temp_element);
			    		temp_element.click();
			    	
			    	try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	
			    	
			    	try
					{
			    		 cart = driver.findElement(By.className("empty-cart"));
					empty_cart = cart.isDisplayed();
					System.out.println("Executed "+delitem+empty_cart);
					 message = cart.findElement(By.xpath("//h2")).getText();
					 System.out.println(message);
					}
					catch(Exception e )
					{
						empty_cart =false;
					}
			    	
			    	
			    	
					
			    /*	temp_element=temp_element.findElement(By.xpath("//a[@class='product-remove']"));
			    	System.out.println("3");
			    	 ((RemoteWebDriver) driver).executeScript("arguments[0].style.border='3px solid blue'",temp_element);
			    	try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	System.out.println(temp_element);
			    //	temp_element.click();*/
			    	
			    }
			    else
			    {
			    	System.out.println("try another  ");
			    	try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}
				

			System.out.println(list);
			}
			
			
			
			else if(option2 == 'N' || option2 =='n')
				
			{
		System.out.println("Please move further ");
		driver.findElement(By.xpath("//div[@class='cart-preview active']/div[2]/button")).click();
		
		break;
			}
			
			
			
		
		
		
			
		}
		
		if(option2 == 'N' || option2 =='n')
			
		{
	System.out.println("Get out of the loop ");
	//driver.findElement(By.xpath("//div[@class='cart-preview active']/div[2]/button")).click();
		}
			if (empty_cart == true )
			{
				System.out.println(message);
			}
		
			
			
		}
	
	@Test(dependsOnMethods = "delVeg")
	public void ApplyPromo_inValid()
	
	{
		try {
			Thread.sleep(3);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//driver.get("https://rahulshettyacademy.com/seleniumPractise/#");
		
		String Url =driver.getCurrentUrl();
		System.out.println("Parent Url "+driver.getWindowHandle());
		
		
		
		
	Set<String>   windows = driver.getWindowHandles();
	Iterator<String> it = windows.iterator();
	while(it.hasNext())
	{
		driver.switchTo().window(it.next());
	}
	
		
	System.out.println("Child Window "+driver.getWindowHandle());
		
		
		System.out.println("Current URL    is    hhhhhhh s  "+Url);
		System.out.println((Url == "https://rahulshettyacademy.com/seleniumPractise/#/"));
		System.out.println(Url.equals("https://rahulshettyacademy.com/seleniumPractise/#/" ));
		if (!(Url.equals("https://rahulshettyacademy.com/seleniumPractise/#/")))
		{
			System.out.println("Current URL "+Url);
			throw new SkipException("Webpage not displayed  "+Url);
		}
		
		String promo_code = "123";
		
		System.out.println(driver);
		
		
		
		
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src,new File("C://Users//Acer//Pictures//Selenium SS//driver.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	driver.findElement(By.className("promoCode")).sendKeys(promo_code);
	
	
	WebElement apply_button = driver.findElement(By.xpath("//button[@class = 'promoBtn']"));
	apply_button.click();
	
	
	while(apply_button.getText().contains("Applying"))
	{
	try {
		Thread.sleep(3);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		System.out.println("Promo info not dispalyed ");
	}
	}
	String promo_info = driver.findElement(By.className("promoInfo")).getText();
	Assert.assertEquals("Invalid code ..!",promo_info, "Promo info not matches ");
	
	
	WebElement place_order = driver.findElement(By.xpath("//button[contains(text(),'Place Order')]"));
	place_order.click();
		
		
		
	}
	@Parameters({"country"})		
		
	@Test(dependsOnMethods = "delVeg")
	
public void ApplyPromo_Empty(String country)
	
	{
		try {
			Thread.sleep(3);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//driver.get("https://rahulshettyacademy.com/seleniumPractise/#");
		
		String Url =driver.getCurrentUrl();
		System.out.println("Parent Url "+driver.getWindowHandle());
		
		
		
		
	Set<String>   windows = driver.getWindowHandles();
	Iterator<String> it = windows.iterator();
	while(it.hasNext())
	{
		driver.switchTo().window(it.next());
	}
	
		
	System.out.println("Child Window "+driver.getWindowHandle());
		
		
		System.out.println("Current URL    is    hhhhhhh s  "+Url);
		System.out.println((Url == "https://rahulshettyacademy.com/seleniumPractise/#/"));
		System.out.println(Url.equals("https://rahulshettyacademy.com/seleniumPractise/#/" ));
		if (!(Url.equals("https://rahulshettyacademy.com/seleniumPractise/#/")))
		{
			System.out.println("Current URL "+Url);
			throw new SkipException("Webpage not displayed  "+Url);
		}
		
		//String promo_code = " ";
		
		System.out.println(driver);
		
		
		
		
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src,new File("C://Users//Acer//Pictures//Selenium SS//driver.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	//driver.findElement(By.className("promoCode")).sendKeys(promo_code);
	
	
	WebElement apply_button = driver.findElement(By.xpath("//button[@class = 'promoBtn']"));
	apply_button.click();
	
	
	while(apply_button.getText().contains("Applying"))
	{
	try {
		Thread.sleep(3);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		System.out.println("Promo info not dispalyed ");
	}
	}
	String promo_info = driver.findElement(By.className("promoInfo")).getText();
	Assert.assertEquals("Empty code ..!",promo_info, "Promo info not matches ");
	

	WebElement place_order = driver.findElement(By.xpath("//button[contains(text(),'Place Order')]"));
	place_order.click();
	
	
	Select select = new Select(driver.findElement(By.tagName("select")));
	
	select.selectByVisibleText(country);
	
	
	//Assert.assertEquals("https://rahulshettyacademy.com/seleniumPractise/#/country",driver.getCurrentUrl(), "Promo info not matches ");
	
	
		
		
		
		
	}
	
	@Parameters({"country"})
	@Test
	
	public void select_country(String country)
	{
		
		
		
		Select select = new Select(driver.findElement(By.tagName("select")));
		
		select.selectByVisibleText(country);
		
	}
			
		
		
		
		
		
	

	@BeforeMethod
	public void beforeMethod() {

	}

}






