package com.sam.b3.TrainingAssessement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	//Global variables to set the relevant testcases where we run our tests
	public Properties prop;
	public FileInputStream fis;
	public String vBrowser;
	public WebDriver driver;
	public static int xlRows,xlCols;
	public static String xData[][];
	public static String vPath;
	public static String vfilepath;
	
	//Browser Initialization
	public void BrowserCall() throws IOException
	{
		
		
		prop=new Properties();
		fis=new FileInputStream("C:\\Users\\00003983\\eclipse-workspace\\TrainingAssessement\\data.properties");
		prop.load(fis);
	    vBrowser=prop.getProperty("Browser");
		
		
		if(vBrowser.equalsIgnoreCase("chrome"))
		{
			//Initiate ChromeDriver instance
			System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver_win32\\chromedriver.exe");//first parameter for webdriver for chrome and second one is exe file of chrome
			driver=new ChromeDriver();
		 
		}
		
		else if(vBrowser.equalsIgnoreCase("edge"))
		{
			//Initiate EdgeDriver instance
			System.setProperty("webdriver.edge.driver", "D:\\WebDriver\\edgedriver_win32\\msedgedriver.exe");//first parameter for webdriver for chrome and second one is exe file of chrome
			driver=new EdgeDriver();
		 
		}
		else if(vBrowser.equalsIgnoreCase("Firefox"))
		{
			//Initiate EdgeDriver instance
			System.setProperty("webdriver.firefox.marionette", "D:\\WebDriver\\firefox\\geckodriver-v0.21.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		 
		}
		else 
		{
			System.out.print("Invalid !!!!");
		}
		
	}
	
	
	//Read excel files using Apache POI
	public static void xlRead(String sPath) throws Exception
 	{
 		File myFile=new File(sPath);
 		FileInputStream myStream=new FileInputStream(myFile);
 		HSSFWorkbook myworkbook=new HSSFWorkbook(myStream);
 		HSSFSheet mySheet=myworkbook.getSheetAt(0);
 		xlRows=mySheet.getLastRowNum()+1;
 		xlCols=mySheet.getRow(0).getLastCellNum();
 		xData=new String[xlRows][xlCols];
 		for(int i=0;i<xlRows;i++)
 		{
 			HSSFRow row=mySheet.getRow(i);
 			for(short j=0;j<xlCols;j++)
 			{
 				HSSFCell cell=row.getCell(j);
 				String value=cellToString(cell);
 				xData[i][j]=value;
 			}
 			System.out.println();
 		}
 	}
 		@SuppressWarnings("deprecation")
 		public static String cellToString(HSSFCell cell)
 		{
 			int type=cell.getCellType();
 			Object result;
 			switch(type)
 			{
 			case HSSFCell.CELL_TYPE_NUMERIC:
 			result=cell.getNumericCellValue();
 			break;
 			case HSSFCell.CELL_TYPE_STRING:
 			result=cell.getStringCellValue();
 			break;
 			case HSSFCell.CELL_TYPE_FORMULA:
 			throw new RuntimeException("We cannot evaluate formula");
 			case HSSFCell.CELL_TYPE_BLANK:
 			result="-";
 			case HSSFCell.CELL_TYPE_BOOLEAN:
 			result=cell.getBooleanCellValue();
 			case HSSFCell.CELL_TYPE_ERROR:
 			result="This cell has some error";
 			default:
 			throw new RuntimeException("We do not support this cell type");
 			}
 			return result.toString();
 			
 		}
 		
 		
		

}
