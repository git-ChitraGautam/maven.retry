package maven.retry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice_Project {
	File file ;
	FileInputStream fi;
	XSSFWorkbook workbook;
	WebDriver driver ;
	XSSFSheet sheet ;
	
	@BeforeTest
	
	public void beforetest() throws FileNotFoundException
	{
		WebDriverManager.chromedriver().setup();
		
	 driver = new ChromeDriver();
		
 file = new File("C:\\Users\\Acer\\eclipse-workspace\\maven.retry\\Excel\\TestData.xlsx");
		
	 fi = new FileInputStream(file);
		
		try {
			 workbook = new XSSFWorkbook(fi);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
@Test(priority=1)
	
	
	public void default_count()
	{
		List<WebElement> default_quantity = driver.findElements(By.className("quantity"));
		
		int l=1;
		
		
		for(WebElement q : default_quantity )
		{
			Assert.assertEquals("1",q.getAttribute("value"));
			
			System.out.println("Count   " +l+" "+ q.getAttribute("value"));
			l++;
		}
		
		
	}
	
	
	@Test(priority=2)
	
	public void increment()
	{
		
		
		
		System.out.println("Provide veg to increase");
		 sheet = workbook.getSheet("Inc");
		HashMap<String, Integer>  veg_count = new HashMap<String, Integer>();
		int no_of_rows = sheet.getPhysicalNumberOfRows();
		WebElement temp;
		String veg;
		Integer  count=0;
		WebElement parent;
		WebElement inc_element;
		WebElement button;
		WebElement textbox ; //= driver.findElement(By.className("quantity"));
		for(int i =1 ; i < no_of_rows  ; i++)
		{
			
			
 veg =  sheet.getRow(i).getCell(0).getStringCellValue();
			count = (int) sheet.getRow(i).getCell(1).getNumericCellValue();
			veg_count.put(veg,count);
		
		}
		
		
		int inc =0;
		System.out.println(veg_count.keySet());
		
		for(String k: veg_count.keySet())
		{
			
			System.out.println("Value of k is : "+k);
			
			String xp = "//h4[contains(text(),'"+k+"')]";
			System.out.println(xp);
			temp = driver.findElement(By.xpath(xp));
			
			
			 ((RemoteWebDriver) driver).executeScript("arguments[0].style.border='3px solid green'",temp);
			parent = temp.findElement(By.xpath("./.."));
			
			 ((RemoteWebDriver) driver).executeScript("arguments[0].style.border='3px solid red'",parent);
			 
			 inc_element= parent.findElement(By.className("increment"));
			 textbox = parent.findElement(By.className("quantity"));
			 
			 
			 ((RemoteWebDriver) driver).executeScript("arguments[0].style.border='3px solid black'",inc_element);
			 inc = veg_count.get(k);
			 
			 
			 System.out.println("Value of inc : "+inc);
			 int val_of_text;
			 
			 for ( int l=2;l<=inc;l++)
					
					
				{
					
					inc_element.click();
					val_of_text = Integer.parseInt(textbox.getAttribute("value"));
					System.out.println("Clicked   " +val_of_text);
					Assert.assertEquals(l,val_of_text);
					
			}
			 
			//button = parent.findElement(By.cssSelector("button[text()='ADD TO CART']"));
			 
			 button = parent.findElement(By.tagName("button"));
				
			
			((RemoteWebDriver) driver).executeScript("arguments[0].style.border='3px solid yellow'",parent);
			((RemoteWebDriver) driver).executeScript("arguments[0].style.border='3px solid blue'",button);
			button.click();
			
			while(button.getText().contains("ADDED"))
			{
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		//XSSFRow headers = sheet.getRow(0);
		//int no_of_columns = headers.getPhysicalNumberOfCells();
		
		
		

		
		 
		
		
		
	}

	
@Test(priority=3)
	
	public void decrement()
	{
		
		
		
		System.out.println("Provide veg to decrease");
		 sheet = workbook.getSheet("Dec");
		HashMap<String, Integer>  veg_count = new HashMap<String, Integer>();
		int no_of_rows = sheet.getPhysicalNumberOfRows();
		WebElement temp;
		String veg;
		Integer  count=0;
		WebElement parent;
		WebElement dec_element;
		WebElement button;
		WebElement textbox ; //= driver.findElement(By.className("quantity"));
		int val_of_text ;
		int prev_val_of_text ;
		
		 int l;
		for(int i =1 ; i < no_of_rows  ; i++)
		{
			
			
 veg =  sheet.getRow(i).getCell(0).getStringCellValue();
			count = (int) sheet.getRow(i).getCell(1).getNumericCellValue();
			veg_count.put(veg,count);
		
		}
		
		
		int inc =0;
		System.out.println(veg_count.keySet());
		
		for(String k: veg_count.keySet())
		{
			
			System.out.println("Value of k is : "+k);
			
			String xp = "//h4[contains(text(),'"+k+"')]";
			System.out.println(xp);
			temp = driver.findElement(By.xpath(xp));
			
			
			 ((RemoteWebDriver) driver).executeScript("arguments[0].style.border='3px solid pink'",temp);
			parent = temp.findElement(By.xpath("./.."));
			
			 ((RemoteWebDriver) driver).executeScript("arguments[0].style.border='3px solid orange'",parent);
			 
			 dec_element= parent.findElement(By.className("decrement"));
			 textbox = parent.findElement(By.className("quantity"));
			 
			 
			 ((RemoteWebDriver) driver).executeScript("arguments[0].style.border='3px solid blue'",dec_element);
			 inc = veg_count.get(k);
			 
			 
			 System.out.println("Value of inc : "+inc);
		//	 int val_of_text  =Integer.parseInt(textbox.getAttribute("value"));;
			 int start_count =Integer.parseInt(textbox.getAttribute("value"));
			
			 for (  l=1;l<=(start_count-inc);l++)
					
					
				{
				 prev_val_of_text = Integer.parseInt(textbox.getAttribute("value"));
					dec_element.click();
					val_of_text = Integer.parseInt(textbox.getAttribute("value"));
					System.out.println("Clicked   " +val_of_text);
					Assert.assertEquals(prev_val_of_text-1,val_of_text);
					
					
			}
			 
			//button = parent.findElement(By.xpath("//*[text()='ADD TO CART']"));
			 button = parent.findElement(By.tagName("button"));
			
			((RemoteWebDriver) driver).executeScript("arguments[0].style.border='3px solid purple'",parent);
			((RemoteWebDriver) driver).executeScript("arguments[0].style.border='3px solid red'",button);
			//button.click();
			
			while(button.getText().contains("ADDED"))
			{
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		
		
		
		//XSSFRow headers = sheet.getRow(0);
		//int no_of_columns = headers.getPhysicalNumberOfCells();
		
		
		

		
		 
		
		
		
	}


}
