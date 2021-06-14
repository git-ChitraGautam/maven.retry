package maven.retry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Compare_Data {
	
	File book1 , book2 ,CSV1 ,CSV2 , Text1 , Text2  ;
	FileInputStream fis_book1 , fis_book2;
	XSSFWorkbook work_book1, work_book2 ;
	
	XSSFSheet sheet_book1 , sheet_book2 ;
	
	int row_book1 , row_book2 , column_book1 , column_book2;
	
	XSSFRow row_data_book1 , row_data_book2;
	
	XSSFCell column_data_book1 , column_data_book2;
	
	String data_book1=" ";
	String data_book2 = " ";
	
	@SuppressWarnings("deprecation")
	@Test
	
	public void compare_excel() throws FileNotFoundException , IOException {
		
		
		book1 = new File ("C:\\Users\\Acer\\eclipse-workspace\\maven.retry\\Excel\\Book1.xlsx");
		book2 = new File("C:\\Users\\Acer\\eclipse-workspace\\maven.retry\\Excel\\Book2.xlsx");
		
		fis_book1 = new FileInputStream(book1);
		fis_book2 = new FileInputStream(book2);
		
		work_book1 = new XSSFWorkbook(fis_book1);
		work_book2 = new XSSFWorkbook(fis_book2);
		
		sheet_book1 = work_book1.getSheet("Sheet1");
		sheet_book2 = work_book2.getSheet("Sheet1");
		row_book1 =sheet_book1.getPhysicalNumberOfRows();
		row_book2 =sheet_book2.getPhysicalNumberOfRows();
		
		
		
		System.out.println("Book1 Rows "+row_book1);
		
		
		System.out.println("Book2 Rows "+row_book2);
		
		
		if(row_book1 == row_book2)
		{
			for(int i=0;i<row_book1;i++)
			{
				row_data_book1 =sheet_book1.getRow(i);
				
				row_data_book2 =sheet_book2.getRow(i);
				
				column_book1 =row_data_book1.getPhysicalNumberOfCells();
				column_book2 =row_data_book2.getPhysicalNumberOfCells();
				data_book1=" ";
				data_book2=" ";
				
				
				if(column_book1 ==column_book2)
				{
					
					for(int j=0;j<column_book1;j++)
					{
						row_data_book1.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
						row_data_book2.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
						
						data_book1=data_book1 + row_data_book1.getCell(j).getStringCellValue();
						data_book2= data_book2 + row_data_book2.getCell(j).getStringCellValue();
					}
					if(data_book1.equals(data_book2))
					{
						System.out.println("Test Pass for row "+i+" "+data_book1+" compared to "+data_book2);
					}
					else
					{
						System.out.println("Test Fail for row "+i+" "+data_book1+" compared to "+data_book2);
					}
				}
				
				else
				{
					System.out.println("Columns are not matching ");
				}
				
				
			}
		}
		else
		{
			System.out.println("Rows are not Equal ");
		}
		
	}
	
	
	@Test
	
	public void compare_CSV() throws IOException
	{
		
		CSV1 = new File("C:\\\\Users\\\\Acer\\\\eclipse-workspace\\\\maven.retry\\\\Excel\\\\CSV1.csv");
		CSV2 = new File("C:\\\\Users\\\\Acer\\\\eclipse-workspace\\\\maven.retry\\\\Excel\\\\CSV2.csv");
		
		HashSet<String> csv1_set = new HashSet<String> (FileUtils.readLines(CSV1));
		
		HashSet<String> csv2_set = new HashSet<String> (FileUtils.readLines(CSV2));
		csv1_set.removeAll(csv2_set);
		
		System.out.println("Data Mismatched "+csv1_set.toString());
		
		
		
	}
	
	
@Test
	
	public void compare_Text() throws IOException
	{
		
	Text1 = new File("C:\\\\Users\\\\Acer\\\\eclipse-workspace\\\\maven.retry\\\\Excel\\\\Text1.txt");
		Text2 = new File("C:\\\\Users\\\\Acer\\\\eclipse-workspace\\\\maven.retry\\\\Excel\\\\Text2.txt");
		
	//	HashSet<String> csv1_set = new HashSet<String> (FileUtils.readLines(CSV1));
		
	//	HashSet<String> csv2_set = new HashSet<String> (FileUtils.readLines(CSV2));
	//	csv1_set.removeAll(csv2_set);
		
		System.out.println(FileUtils.readLines(Text1)+" Data Mismatched "+FileUtils.readLines(Text2));
		
		
		
	}

}
