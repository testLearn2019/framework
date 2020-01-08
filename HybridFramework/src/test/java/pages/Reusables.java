package pages;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reusables {
	//WebDriver driver;
	Properties prop;
	String data;
	String CellData;

	
	public String readProperties(String property) {		
		File file = new File ("C:\\Users\\user\\Desktop\\HybridFramework\\ObjectRepositories\\ObjRepo.properties");		
		try {
			FileInputStream inputStrm = new FileInputStream(file);
			prop = new Properties();
			prop.load(inputStrm);
			data=prop.getProperty(property);			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
		
	}
	
	
	public String readExcel(int RowNum, int ColNum) {
		XSSFSheet ExcelWSheet;		 
		XSSFWorkbook ExcelWBook;
		XSSFCell Cell;
		//XSSFRow Row;
		
		File file = new File ("C:\\Users\\user\\Desktop\\HybridFramework\\TestData\\Hybrid_Data.xlsx");
		try {
			FileInputStream ExcelFile = new FileInputStream(file);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheetAt(0);
			//ExcelWSheet.getR
			  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	          CellData = Cell.getStringCellValue();
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return CellData;
	}
	
	public void getScreenshot(WebDriver driver, String filename) {
		String folderPath = "C:\\Users\\user\\Desktop\\HybridFramework\\Screenshot\\";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(folderPath+filename+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
