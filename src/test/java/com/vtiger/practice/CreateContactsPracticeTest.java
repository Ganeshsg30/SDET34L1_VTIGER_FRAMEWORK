package com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.sdet34l1.genericlibrary.ExcelUse;
import com.sdet34l1.genericlibrary.IconstantPath;
import com.sdet34l1.genericlibrary.JavaUtility;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsPracticeTest extends BaseClass
{
	String contactName;
	ContactPage contactpage;
	CreateNewContactPage createnewcontactpage;
	ContactInformationPage contactinformationpage;
	
	@Test
	public void createContactsPractiveTest() throws IOException
	{
		contactName = ExcelUse.getDataFromExcel("CreateContact", 2, 1)+randomnumber;
		contactpage = new ContactPage(driver);
		createnewcontactpage = new CreateNewContactPage(driver);
		contactinformationpage = new ContactInformationPage(driver);
		
		homepage.clickContact();
		contactpage.clickContactImg(driver);
		createnewcontactpage.contactCreateandSave(contactName);
		javautil.assertionThroughIfCondition(contactinformationpage.getContactName(), contactName,"Contact is ");
	}
}










































/*
 * public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
	{
		JavaUtility jutil = new JavaUtility();
		FileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		ExcelUtility.openExcel(IconstantPath.EXCELFILEPATH);
		
		String url = FileUtility.getDataFromPropertyFile("url");
		String username = FileUtility.getDataFromPropertyFile("username");
		String password = FileUtility.getDataFromPropertyFile("password");
		String timeouts = FileUtility.getDataFromPropertyFile("timeouts");
		String browser = FileUtility.getDataFromPropertyFile("browser");
		
		int randomnumber = jutil.getRandomNumber(1000);
		String contactName = ExcelUtility.getDataFromExcel("CreateContact", 2, 1)+randomnumber;
		
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
		WebDriverUtility.explicitlyWait(driver, longtimeout);
		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(username);
		driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		String title=driver.getTitle();
		
		jutil.assertionThroughIfCondition(title, title, "create contact");
		{
			ExcelUtility.setDataIntoExcel("ContactTestScripts", 1, 4, "Home Page is Displayed");
			ExcelUtility.setDataIntoExcel("ContactTestScripts", 1, 5, "Pass");
			jutil.printStatement("Login");
		}
		
		driver.findElement(By.xpath("//a[text()='Contacts']/../../td[8]")).click();
		jutil.assertionThroughIfCondition(title, title, "contact");
		{
			ExcelUtility.setDataIntoExcel("ContactTestScripts", 2, 4, "Contacts Page is Displayed");
			ExcelUtility.setDataIntoExcel("ContactTestScripts", 2, 5, "Pass");
			jutil.printStatement("Contact");
		}
		
		driver.findElement(By.cssSelector("[title='Create Contact...']")).click();
		jutil.assertionThroughIfCondition(title, title, "create contact");
		{
			ExcelUtility.setDataIntoExcel("ContactTestScripts", 3, 4, "CreateContacts Page is Displayed");
			ExcelUtility.setDataIntoExcel("ContactTestScripts", 3, 5, "Pass");
			jutil.printStatement("create");
		}
		
		driver.findElement(By.cssSelector("[name='lastname']")).sendKeys(contactName);
		driver.findElement(By.cssSelector("input.crmButton.small.save")).click();
		String Actualcn = driver.findElement(By.id("mouseArea_Last Name")).getText();
		Thread.sleep(2000);
		Actualcn=Actualcn.trim();
		
		String title1 = driver.getTitle();
		title1.contains("Commercial Open");
		jutil.assertionThroughIfCondition(title1, title1 , "lastName");
		jutil.assertionThroughIfCondition(Actualcn, contactName, "create contact");
		
		{
			ExcelUtility.setDataIntoExcel("ContactTestScripts", 4, 4, "Last name added");
			ExcelUtility.setDataIntoExcel("ContactTestScripts", 4, 5, "Pass");
			ExcelUtility.setDataIntoExcel("ContactTestScripts", 5, 4, "Last name ais valid");
			ExcelUtility.setDataIntoExcel("ContactTestScripts", 5, 5, "Pass");
		}
		
		WebElement logout = driver.findElement(By.xpath("//td[@class='small']//td[2]/img"));
		WebDriverUtility.mouseHoverOntheElement(logout, driver);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		String logouttitle = driver.getTitle();
		jutil.assertionThroughIfCondition(logouttitle, logouttitle,"Logout");
		{
			ExcelUtility.setDataIntoExcel("ContactTestScripts", 6, 4, "Login Page is Displayed");
			ExcelUtility.setDataIntoExcel("ContactTestScripts", 6, 5, "Pass");
			jutil.printStatement("Logout");
		}
		ExcelUtility.saveDataIntoExcel(IconstantPath.EXCELFILEPATH);
		ExcelUtility.closeExcel();
		WebDriverUtility.quitBrowser(driver);
	}
 * 
 */



