package com.sdet34l1.genericlibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class is used to get the common data
 * @author Ganesh
 * It is a Baseclass
 */
public class BaseClass
{
	public int randomnumber;
	public String password;
	public String username;
	public long longtimeout;
	public WebDriver driver;
	public WebElement element;
	public LoginPage loginpage;
	public HomePage homepage;
	public JavaUtility javautil;
	public WebDriverUse webDriverUse;
	public static WebDriver staticdriver;
	
	
	/**
	 * This @annotation is used to open excel and open properties
	 * @throws IOException
	 */
	@BeforeSuite(groups = "baseclass")
	public void beforesuiteTest() throws IOException
	{
		//open database if it is required
		PropertiesFile.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		ExcelUse.openExcel(IconstantPath.EXCELFILEPATH);
	}
	
	
	/**
	 * This @annotation is used to Navigate the application,browser setting,read for common data ,instance for common POM class,etc..
	 */
	@Parameters("browser")
	@BeforeClass(groups = "baseclass")
	public void beforeclassTest()
	{
		javautil = new JavaUtility();
		//String url = PropertiesFile.getDataFromPropertyFile("url");
		//username = PropertiesFile.getDataFromPropertyFile("username");
		//password = PropertiesFile.getDataFromPropertyFile("password");
		String timeouts = PropertiesFile.getDataFromPropertyFile("timeouts");
		String browser = PropertiesFile.getDataFromPropertyFile("browser");
		longtimeout = Long.parseLong(timeouts);
		randomnumber = javautil.getRandomNumber(10000);
		
		String url = System.getProperty("URL");
		username = System.getProperty("USERNAME");
		password = System.getProperty("PASSWORD");
		
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
		
		staticdriver = driver;
		webDriverUse=new WebDriverUse(driver);
		webDriverUse.initializeActions(driver);
		WebDriverUse.browserSetting(longtimeout, driver);
		WebDriverUse.explicitlyWait(driver, longtimeout);
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		WebDriverUse.launchApp(url, driver);
	}
		
	
	/**
	 * This Annotation is used to Login the application
	 */
	@BeforeMethod(groups = "baseclass")
	public void beforeMethodTest()
	{
		loginpage.loginAction(username, password);
	}
	
	
	/**
	 * This Annotation is used to Logout the application
	 */
	@AfterMethod(groups = "baseclass")
	public void afterMethodTest()
	{		
		homepage.signOut(driver,webDriverUse);
	}
	
	
	/**
	 * This Annotation is used to Quit the browser
	 */
	@AfterClass(groups = "baseclass")
	public void afterClassTest()
	{
		WebDriverUse.quitBrowser(driver);
	}
	
	
	/**
	 * This Annotation is used to close the excel and save
	 * @throws IOException
	 */
	@AfterSuite(groups = "baseclass")
	public void afterSuiteTest() throws IOException
	{
		ExcelUse.saveDataIntoExcel(IconstantPath.EXCELFILEPATH);
		ExcelUse.closeExcel();
	}
}
