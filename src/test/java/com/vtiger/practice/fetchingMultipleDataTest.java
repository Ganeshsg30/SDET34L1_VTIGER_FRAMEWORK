package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.ExcelUse;
import com.sdet34l1.genericlibrary.IconstantPath;
import com.sdet34l1.genericlibrary.JavaUtility;


import io.github.bonigarcia.wdm.WebDriverManager;

public class fetchingMultipleDataTest 
{
	@Test(dataProvider = "loginData")
	public void fetchingTwoDataTest(String username,String password)
	{	
		Reporter.log(username +"  ----->  "+ password,true);
	}
	
	@DataProvider
	public Object[][] loginData() throws EncryptedDocumentException, IOException
	{
		ExcelUse.openExcel(IconstantPath.EXCELFILEPATH);
		ExcelUse.closeExcel();
		return ExcelUse.getMultipleDataFromExcel("loginData");
	}
}
	
































/*JavaUtility jutil = new JavaUtility();			
		String url = FileUtility.getDataFromPropertyFile("url");
		String username = FileUtility.getDataFromPropertyFile("username");
		String password = FileUtility.getDataFromPropertyFile("password");
		String timeouts = FileUtility.getDataFromPropertyFile("timeouts");
		String browser = FileUtility.getDataFromPropertyFile("browser");	
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/VtigerCreateOrg.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet s=book.getSheet("Login");
		
		Object[][] arr = new Object[s.getLastRowNum()][s.getRow(0).getLastCellNum();
		
		for(int i=1; i<s.getLastRowNum(); i++)
		{
			for(int j=0; j<s.getRow(i).getLastCellNum(); j++)
			{
				arr[i][j] = s.getRow(i).getCell(j).getStringCellValue();
			}
//			String username = (String)arr[i][0];
//			String password = (String)arr[i][1];
		
			long longtimeout = Long.parseLong(timeouts);
			WebDriver driver = null;
			
			switch (browser)
			{
			case "chrome":
			
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
				
			case "firefox":
			
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
				
			case "edge":
			
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;	
			
			
			default:
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			}
			
		WebDriverUtility.launchApp(url, driver);
		WebDriverUtility.browserSetting(longtimeout, driver);
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(username);
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		jutil.printStatement("Login");
		
		if(driver.getTitle().contains("Home")) 
		{
			WebElement logout = driver.findElement(By.xpath("//td[@class='small']//td[2]/img"));
			WebDriverUtility.mouseHoverOntheElement(logout, driver);
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			book.close();
			WebDriverUtility.quitBrowser(driver);
			jutil.printStatement("Login successfully and Signout");
			break;
		}
		
			jutil.printStatement("Login failed");
//			book.getSheet("Createorgindustry").getRow(1).createCell(4).setCellValue("Home Page is Displayed");
//			book.getSheet("Createorgindustry").getRow(1).createCell(5).setCellValue("Pass");
//			System.out.println("Login");
		}
	}
}




























/*
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{	
	FileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
	ExcelUtility.openExcel(IconstantPath.EXCELFILEPATH);
	JavaUtility jutil = new JavaUtility();			
	String url = FileUtility.getDataFromPropertyFile("url");
	String username = FileUtility.getDataFromPropertyFile("username");
	String password = FileUtility.getDataFromPropertyFile("password");
	String timeouts = FileUtility.getDataFromPropertyFile("timeouts");
	String browser = FileUtility.getDataFromPropertyFile("browser");	
	
	FileInputStream fis1 = new FileInputStream("./src/test/resources/VtigerCreateOrg.xlsx");
	Workbook book = WorkbookFactory.create(fis1);
	Sheet s=book.getSheet("Login");
	
	Object[][] arr = new Object[s.getLastRowNum()][s.getRow(0).getLastCellNum()];
	
	for(int i=1; i<s.getLastRowNum(); i++)
	{
		for(int j=0; j<s.getRow(i).getLastCellNum(); j++)
		{
			arr[i][j] = s.getRow(i).getCell(j).getStringCellValue();
		}
//		String username = (String)arr[i][0];
//		String password = (String)arr[i][1];
	
		long longtimeout = Long.parseLong(timeouts);
		WebDriver driver = null;
		
		switch (browser)
		{
		case "chrome":
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox":
		
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case "edge":
		
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;	
		
		
		default:
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		}
		
	WebDriverUtility.launchApp(url, driver);
	WebDriverUtility.browserSetting(longtimeout, driver);
	driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(username);
	driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	jutil.printStatement("Login");
	
	if(driver.getTitle().contains("Home")) 
	{
		WebElement logout = driver.findElement(By.xpath("//td[@class='small']//td[2]/img"));
		WebDriverUtility.mouseHoverOntheElement(logout, driver);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		book.close();
		WebDriverUtility.quitBrowser(driver);
		jutil.printStatement("Login successfully and Signout");
		break;
	}
	
		jutil.printStatement("Login failed");
//		book.getSheet("Createorgindustry").getRow(1).createCell(4).setCellValue("Home Page is Displayed");
//		book.getSheet("Createorgindustry").getRow(1).createCell(5).setCellValue("Pass");
//		System.out.println("Login");
	}
}*/

