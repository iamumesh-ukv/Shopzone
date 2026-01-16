package com.shopzone.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static final int IMPLICIT_WAIT_TIME=20;
	public static final int PAGE_LOAD_TIME=8;

	public static String generateEmailWithTimeStamp()
	{
		Date date = new Date();
		String timestamp = date.toString().replace(" ","_").replace(":","_");
		return "umesh"+timestamp+"@gmail.com";
	}
/*
	@DataProvider(name = "CredentialsSupplier")
	public Object[][] dataSupplier() throws IOException {

	    String excelPath = System.getProperty("user.dir") + "\\testdata01.xlsx";

	    try (
	            FileInputStream fis = new FileInputStream(excelPath);
	            XSSFWorkbook workbook = new XSSFWorkbook(fis)
	    ) {

	        XSSFSheet sheet = workbook.getSheet("loginpage");

	        int rowCount = sheet.getLastRowNum();              // Excluding header
	        int colCount = sheet.getRow(0).getLastCellNum();   // Total columns

	        Object[][] data = new Object[rowCount][colCount];
	        DataFormatter formatter = new DataFormatter();

	        for (int r = 0; r < rowCount; r++) {

	            XSSFRow row = sheet.getRow(r + 1); // Skip header row

	            for (int c = 0; c < colCount; c++) {

	                XSSFCell cell = row.getCell(
	                        c,
	                        Row.MissingCellPolicy.CREATE_NULL_AS_BLANK
	                );

	                data[r][c] = formatter.formatCellValue(cell);
	            }
	        }

	        return data;
	    }
	}
	//------------------------------------
	 public static Object[][]getTestDataFromExcel(String sheetName)
	{
		File excelFile =new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\progressional\\qa\\testdata\\ProgressionalTestData.xlsx");
		XSSFWorkbook workbook=null;
		try
		{
			FileInputStream fisExcel = new FileInputStream(excelFile);
			workbook = new  XSSFWorkbook(fisExcel);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		XSSFSheet sheet= workbook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		Object[][]data= new Object[rows][cols];
		for(int i=0;i<rows;i++)
		{
			XSSFRow row = sheet.getRow(i+1); 

			for(int j=0;j<cols;j++)
			{
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();

				switch(cellType) {

				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}

		return data;
	}
	 */
	public static String captureScreenshot(WebDriver driver,String testName)
	{
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try
		{
			FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return destinationScreenshotPath;
	}
}
