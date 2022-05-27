package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.IconstantPath;
import com.sdet34l1.genericlibrary.JavaUtility;
import com.sdet34l1.genericlibrary.PropertiesFile;
import com.sdet34l1.genericlibrary.WebDriverUse;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithContactTest 
{
	@Test
	public static void createOrganizationWithContactTest(String[] args) throws IOException 
	{
			PropertiesFile.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
			JavaUtility jutil = new JavaUtility();			
			String url = PropertiesFile.getDataFromPropertyFile("url");
			String username = PropertiesFile.getDataFromPropertyFile("username");
			String password = PropertiesFile.getDataFromPropertyFile("password");
			String timeouts = PropertiesFile.getDataFromPropertyFile("timeouts");
			String browser = PropertiesFile.getDataFromPropertyFile("browser");
			
			FileInputStream fis1 = new FileInputStream("./src/test/resources/VtigerCreateOrg.xlsx");
			Workbook book = WorkbookFactory.create(fis1);
			Sheet s=book.getSheet("CreateContact");
			Row r=s.getRow(5);
			Cell c=r.getCell(2);
			int randomnumber = jutil.getRandomNumber(1000);
			String ls = c.getStringCellValue()+randomnumber;
			System.out.println(ls);
			
			Cell c1=r.getCell(1);
			String ls1 = c1.getStringCellValue()+randomnumber;
			System.out.println(ls1);
			book.close();
			
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
				
//			case "edge":
//			
//				WebDriverManager.edgedriver().setup();
//				driver = new EdgeDriver();
//				break;	
			
			
			default:
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			}
			
			WebDriverUse.launchApp(url, driver);
			WebDriverUse.browserSetting(longtimeout, driver);
			WebDriverUse.explicitlyWait(driver, longtimeout);
			driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(username);
			driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			if(driver.getTitle().contains("Home")) 
			{
				book.getSheet("ContactTestScripts").getRow(1).createCell(4).setCellValue("Home Page is Displayed");
				book.getSheet("ContactTestScripts").getRow(1).createCell(5).setCellValue("Pass");
				System.out.println("Login");
			}
			
			//organization
			driver.findElement(By.xpath("//a[text()='Organizations']/../../td[6]")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			//String orgName = "gtiger";
			
			driver.findElement(By.cssSelector("[name='accountname']")).sendKeys(ls1);
			driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
			String org = driver.findElement(By.id("mouseArea_Organization Name")).getText();
			org=org.trim();
			
			if(org.equalsIgnoreCase(ls1)) 
			{
				System.out.println("Organization Created Successfully");
			}
			
			//contacts
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.cssSelector("[title='Create Contact...']")).click();
			driver.findElement(By.cssSelector("[name='lastname']")).sendKeys(ls);
			
			//driver.findElement(By.cssSelector("input.crmButton.small.save")).click();
			//String con = driver.findElement(By.id("mouseArea_Last Name")).getText();
			
			driver.findElement(By.xpath("//img[@title='Select']")).click();
			String mainid = driver.getWindowHandle();
			Set<String> allid = driver.getWindowHandles();
			
			for(String id:allid)
			{
				if(!id.equals(mainid))
				{
					driver.switchTo().window(id);
				}
			}
			driver.findElement(By.id("search_txt")).sendKeys(ls1);
			driver.findElement(By.cssSelector("[name='search']")).click();
			driver.findElement(By.xpath("//a[contains(@onclick,'set_return_contact_address')]")).click();
			
			driver.switchTo().window(mainid);
			driver.findElement(By.cssSelector("[class='crmButton small save']")).click();
			//String org = driver.findElement(By.id("mouseArea_Organization Name")).getText();
			
			String conName=driver.findElement(By.id("mouseArea_Last Name")).getText();
			
			if(org.equals(ls1) && conName.equals(ls))
			{
				System.out.println("Created Successfully");
			}
			else
			{
				System.out.println("Not Created");
			}
			WebElement logout = driver.findElement(By.xpath("//td[@class='small']//td[2]/img"));
			Actions a = new Actions(driver);
			a.moveToElement(logout).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			driver.quit();
	}
}