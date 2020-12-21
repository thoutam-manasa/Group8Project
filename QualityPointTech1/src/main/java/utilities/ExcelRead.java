package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

//import base.Logs;

public class ExcelRead {
	static WebDriver driver;
	//static Logs log=new Logs(driver);
	public String[][] testdata= new String[1][2];
	int row,column,i,j;
//method to read data from excel
public String[][] read()
	{
		File f=new File("testdata/qualitytech.xlsx");
		try 
		{
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh=wb.getSheet("Sheet1");
			for(row=1,i=0;row<2;row++,i++)
			{
				XSSFRow Row = sh.getRow(row);
				//XSSFRow Row = sh.getRow(row);
			for(column=0,j=0;column<2;column++,j++)
			{
				XSSFCell cell=Row.getCell(column);
				testdata[i][j]=cell.getStringCellValue();
			}
			}
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("FileNotFound exception occured");
			//log.update("FileNotFound exception occured");
		}
		catch (IOException e1) 
		{
			System.out.println("IO exception occured");
			//log.update("IO exception occured");
		}
		catch(IncompatibleClassChangeError e)
		{
			System.out.println("IncompatibleClassChangeError exception occured");
			//log.update("IncompatibleClassChangeError exception occured");
		}
		return testdata;
	}
}
