package com.demoaut.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import com.demoaut.base.TestBase;

public class TestUtil extends TestBase{
   public static XSSFWorkbook workbook=null;
   public static XSSFSheet sheet = null;
   public static XSSFCell cell = null;
   public static DataFormatter formatter =null;
   public static String nameShot = null;
	
	
	public static int PAGE_LOAD_TIMEOUT =30;
	public static int IMPLICIT_WAIT = 10;
	public static String EXCEL_DATA_PATH ="./TestData/Data.xlsx";
	
	public static String getCurrentDate() {
		
		DateFormat formatdate = new  SimpleDateFormat("MMM d, yyyy");
		Date date = new Date();
		return formatdate.format(date);		
	}
	
	public static void selectDropDown(WebElement element,String value) {
		
		Select select = new Select(element);
		select.selectByVisibleText(value);	
		
	}
    
	public static Object[][] getData(String SheetName) throws Exception {
		
			FileInputStream fis = new FileInputStream("C:\\Users\\ara\\Desktop\\Data.xlsx");
			workbook = new XSSFWorkbook(fis);
			fis.close();
		    sheet = workbook.getSheet(SheetName);
		    formatter = new DataFormatter();
		    Object[][] data = null;
		     int rowcount = sheet.getLastRowNum();
			 int columcount = sheet.getRow(0).getLastCellNum();
			   
			 data = new Object[rowcount][columcount];
			 
			 for(int i=0;i<rowcount;i++) {
				 for(int j=0;j<columcount;j++) {
					data[i][j]=formatter.formatCellValue(sheet.getRow(i+1).getCell(j));
					 
				 }
			 }return data;
		
	}
	public static String  captureScreenShot() throws Exception {
		
		
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		nameShot = getDate();
		String dest = System.getProperty("user.dir")+"/screenShot/screenShot"+nameShot+".png";
		File destination = new File(dest);
	    FileUtils.copyFile(src, destination);
		//FileHandler.copy(src, new File ("./screenShot/screenshot.png"));
			System.out.println("The Screen shot was successfully taken...");		
			return dest;
		
		
	}
	public static String getDate() {
		DateFormat dateformat = new SimpleDateFormat("MMddyyyyHHmmss");
		Date date = new Date();
	return	dateformat.format(date);
		
	}
	
}
