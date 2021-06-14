package maven.test.retry;

import org.testng.annotations.Test;


import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import javafx.scene.web.WebEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {

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

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class anno ");

	}

	@BeforeTest
	public void beforeTest() {
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

	@Test(priority = 1)
	public void login() {
		System.out.println("At login");
		while (driver.findElement(By.xpath("//div[@class='preloader']/span")).isDisplayed()) {
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
		driver.findElement(By.cssSelector("input#name")).sendKeys("chitra");
		driver.findElement(By.cssSelector("input#email")).sendKeys("chitraoct1996@gmail.com");
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
	public void clicklink()

	{
		System.out.println("click link");
		try {
			driver.findElement(By.xpath("//div[@class='container']/div[1]/a[1]")).click();
		} catch (org.openqa.selenium.ElementNotInteractableException e) {
			System.out.println("Link is not interactable");

			driver.findElement(By.xpath("//div[@class='container']/div[1]/a[1]")).click();
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(dependsOnMethods = "clicklink")
	public void addVeg() {
		System.out.println("Enter no of products to add on cart");
		int no = sc.nextInt();
		sc.nextLine();
		String[] names = new String[no];
	//	String[][] names = new String[no][2]; // array takes less memory
		System.out.println("Enter products and qty for  " + names.length + "items:");
		for (i = 0; i < names.length; i++) {
			names[i] = sc.nextLine();
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
			option = sc.next().charAt(0);
			if (option == 'Y') {
				driver.findElement(By.xpath("//div[@class='cart-preview active']/div[2]/button")).click();
				disable ='Y';

			} else {

				delVeg();
			}
		}
	

	@Test(dependsOnMethods = "addVeg" , enabled = true)
	@Parameters("delitem")
	
	public void delVeg()
	{
		
		char option2 ='Y';
		WebElement list;
		Boolean empty_cart = false;
		String message = "Your cart is empty!";
		WebElement cart ; 
		
		if(disable == 'Y') {
		//	.setEnabled(false);
			
			
		}
		try
		{
		empty_cart = driver.findElement(By.className("empty-cart")).isDisplayed();
		}
		catch(Exception e )
		{
			empty_cart =false;
		}
		
		
		{
		
		while(( option2 == 'Y' || option2 =='y') && (empty_cart == false ) )
		{
			System.out.println("Do you want to delete item Y/N ?     "+empty_cart.toString());
			 option2 = sc.next().charAt(0);
			 sc.nextLine();
			if(option2 == 'Y' || option2 =='y') {
			
			
				System.out.println("Please provide item to delete  ");
				delitem = sc.nextLine();
				
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
			try
			{
	    		 cart = driver.findElement(By.className("empty-cart"));
			empty_cart = cart.isDisplayed();
			 message = cart.findElement(By.xpath("\\h2")).getText();
			 System.out.println(message);
			}
			catch(Exception e )
			{
				empty_cart =false;
			}
			
		
		
		
			
		}
		
		
		
			System.out.println("Please move further ");
			if (empty_cart == true )
			{
				System.out.println(message);
			}
			else
			driver.findElement(By.xpath("//div[@class='cart-preview active']/div[2]/button")).click();
			
		}
			
		}
		
		
		
		
	

	@BeforeMethod
	public void beforeMethod() {

	}

}




