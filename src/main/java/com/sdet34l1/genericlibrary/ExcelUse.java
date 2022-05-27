package com.sdet34l1.genericlibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to get the data from excel sheet 
 * @author Ganesh
 */
public class ExcelUse
{	
	static Workbook wb;
	
	/**
	 * This method is used to open the excelfile
	 * @param filepath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static void openExcel(String filepath) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(filepath);
		wb = WorkbookFactory.create(fis);
	}
	
	
	/**
	 * This method is used to get the data from excel sheet
	 * @param filepath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOExeception
	 */
	public static String getDataFromExcel(String sheetName, int rowNumber, int cellNumber)
	{
		String data = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return (data);
	}	
	
	/**
	 * This method is used to save the data into Excel
	 * @param savefilepath
	 * @throws IOException
	 */
	public static void saveDataIntoExcel(String savefilepath) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(savefilepath);
		wb.write(fos);
	}
	
	/**
	 * This method is used to set the value into Excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public static void setDataIntoExcel(String sheetName,int rowNumber , int cellNumber, String setValue)
	{
		wb.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(setValue);
	}
	
	
	/**
	 * This method is used to fetcht the multiple data from the excel sheet
	 * @param sheetName
	 * @return
	 */
	public static Object[][] getMultipleDataFromExcel(String sheetName )
	{
		Sheet sh = wb.getSheet(sheetName);
		Object [][] arr  = new Object[sh.getLastRowNum()] [sh.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sh.getLastRowNum(); i++)
		{
			for(int j=0; j<sh.getRow(i).getLastCellNum(); j++)
			{
				arr[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return arr;
	}
	
	
	
	/**
	 * This Method is used to close the Excel
	 * @throws IOException
	 */
	public static void closeExcel() throws IOException 
	{
		wb.close();
	}
}
