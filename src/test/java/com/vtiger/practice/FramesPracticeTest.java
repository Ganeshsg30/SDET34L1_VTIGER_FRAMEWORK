package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesPracticeTest 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{		
//			FileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
//			JavaUtility jutil = new JavaUtility();
			FileInputStream fis = new FileInputStream("./src/test/resources/demoautomation.properties");
			Properties pro = new Properties();
			pro.load(fis);
			String url = pro.getProperty("url");
			
//			FileInputStream fis1 = new FileInputStream("./src/test/resources/VtigerCreateOrg.xlsx");
//			Workbook book = WorkbookFactory.create(fis1);
//			Sheet s = book.getSheet("demoautomation");
//			Row r = s.getRow(1);
//			Cell c = r.getCell(2);
//			DataFormatter format = new DataFormatter();
//			String data = format.formatCellValue(c);
			
			
			WebDriverManager.chromedriver().setup();
//			ChromeOptions notification= new ChromeOptions();
//			notification.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			
			driver.findElement(By.id("btn2")).click();
			WebElement switchto = driver.findElement(By.linkText("SwitchTo"));
			Actions act = new Actions(driver);
			act.moveToElement(switchto).perform();
			
			driver.findElement(By.xpath("//a[text()='Frames']")).click();
			driver.switchTo().frame(0);
			
			driver.findElement(By.linkText("Single Iframe ")).click();
			//driver.switchTo().frame(0);
			driver.findElement(By.xpath("//iframe[@id='singleframe']")).sendKeys("hii");
			
			
			
			
			
			
			
	}
}
