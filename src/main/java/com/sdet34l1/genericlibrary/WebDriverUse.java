package com.sdet34l1.genericlibrary;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

/**
 * This class is used to maintain all WebDriver common actions 
 * @author Ganesh
 */
public class WebDriverUse
{
	
	static WebDriverWait wait; 
	public Actions act;
	static Select select;
	static JavascriptExecutor jse;
	static JavaUtility javautil = new JavaUtility();

	public WebDriverUse(WebDriver driver2) 
	{
		
	}

	/**
	 *This method is used to initialize the Actions class 
	 * @param driver
	 */
	public void initializeActions(WebDriver driver)
	{
		act = new Actions(driver);
	}
	
	/**
	 * This method is used to initialize the select class
	 * @param element
	 */
	public static void initializeSelect(WebElement element)
	{
		select= new Select(element);
	}
	
	/**
	 * This method is used to launch to the Application
	 * @param url
	 * @param driver
	 */
	public static void launchApp(String url , WebDriver driver)
	{
		driver.get(url);
	}
	
	/**
	 * This method is used to maximize the browser and implicitly wait also
	 * @param longTimeOut
	 * @param driver
	 */
	public static void browserSetting(long longTimeOut,WebDriver driver)
	{
		maximizeBrowser(driver);
		waitTillpageLoad(longTimeOut,driver);
	}
	
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public static void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to implicitly wait till page load
	 * @param longTimeOut
	 * @param driver
	 */
	public static void waitTillpageLoad(long longTimeOut,WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
	}
		
	/**
	 * This method is used to mouse hover on the element
	 * @param moreLink
	 * @param driver
	 */
	public void mouseHoverOntheElement(WebElement element)
	{
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to double Click Actions On the element
	 * @param driver 
	 * @param moreLink
	 */
	public void doubleClickOnElement(WebElement element)
	{
		act.moveToElement(element).doubleClick(element).perform();
	}
	
	/**
	 * This method is used to double click Actions on the webpage
	 * @param driver 
	 */
	public void doubleClick()
	{
		act.doubleClick().perform();
	}
	
	/**
	 * This method is used to Right click Actions on the webpage
	 * @param driver 
	 */
	public void rightClick()
	{
		act.contextClick().perform();
	}
	
	/**
	 * This method is used to Right click Actions by element
	 * @param element
	 * @param driver 
	 */
	public void rightClick(WebElement element)
	{
		act.moveToElement(element).contextClick(element).perform();
	}
	
	/**
	 * This method is used to close the browser instance
	 * @param driver
	 */
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	/**
	 * This method is used to Wait untill the element to be clickable
	 * @param element
	 */
	public static void waitUntilElementClickable(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to wait the control till the particular element is visible
	 * @param element
	 * @param timeOut
	 * @param driver
	 */
	public static void WaitUntilElementVisible(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to initialize wait instance
	 * @param driver
	 * @param timeOut
	 */
	public static void explicitlyWait(WebDriver driver, long timeOut)
	{
		wait=new WebDriverWait(driver,timeOut);
	}
	
	/**
	 * This method is used to switch the window based on title
	 * @param driver
	 * @param partialText
	 */
	public static void switchToWindowBasedOnTitle(WebDriver driver,String partialText)
	{
		Set<String> sessionIDs = driver.getWindowHandles();
		for(String id:sessionIDs)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText))
			{
				break;
			}
		}
	}
	
	/**
	 * This method is used to handle dropdown by value
	 * @param element
	 * @param value
	 */
	public static void selectDropDown(WebElement element,String value)
	{
		select = new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * This method is used to handle dropdown by index
	 * @param element
	 * @param index
	 */
	public static void selectDropDown(WebElement element,int index)
	{
		select = new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * This method is used to handle dropdown by visibleText
	 * @param visibleText
	 * @param element
	 */
	public static void selectDropDown(String visibleText,WebElement element)
	{
		select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method is used to switch the frame by Index
	 * @param driver
	 * @param index
	 */
	public static void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch the frame by Name Or Id
	 * @param driver
	 * @param nameOrId
	 */
	public static void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method is used to switch the frame by Element
	 * @param driver
	 * @param element
	 */
	public static void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method is used to back to Default WebPage 
	 * @param driver
	 */
	public static void switchBackToHomeWebPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to initialize the javascript
	 * @param driver
	 */
	public static void initializeJs(WebDriver driver)
	{
		jse=(JavascriptExecutor)driver;
	}
	
	/**
	 * This method is used to enter the data through java script
	 * @param driver
	 * @param element
	 * @param data
	 */
	public static void enterDataThroughJs(WebElement element,String data)
	{
		jse.executeScript("arguments[0].value=arguments[1]",element,data);
	}
	
	/**
	 * This method is used to launch application through java script
	 * @param driver
	 * @param url
	 */
	public static void launchApplicationThroughJs(String url)
	{
		jse.executeScript("window.location=arguments[0]",url);
	}
	
	/**
	 * This method is used to scroll the webPage through java script by given number of height
	 * @param height
	 */
	public static void scrollToSpecifiedHeightThroughJs(String height)
	{
		jse.executeScript("window.scrollBy(0,"+height+")");
	}
	
	/**
	 * This method is used to click the element through java script
	 * @param element
	 */
	public static void clickThroughJs(WebElement element)
	{
		jse.executeScript("arguments[0].click()", element);
	}
	
	/**
	 * This method is used to scroll to bottom on the webPage through java script 
	 */
	public static void scrollToBottomThroughJs()
	{
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	/**
	 * This method is used to scroll the webPage through java script by element
	 * @param element
	 */
	public static void scrollTillElementThroughJs(WebElement element)
	{
		jse.executeScript("arguments[0].scrollIntoView()",element);
	}
	
	/**
	 * This method is used to handle alert popup accept
	 * @param driver
	 */
	public static void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to handle alert popup dismiss
	 * @param driver
	 */
	public static void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to handle alert popup send data
	 * @param driver
	 * @param data
	 */
	public static void alertSendData(WebDriver driver,String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	
	/**
	 * This method is used to handle alert popup getText
	 * @param driver
	 * @return
	 */
	public static String alertGetText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method is used to take a screenshot and filesave with data and time 
	 * @param fileName
	 * @param driver
	 * @throws IOException
	 */
	public static String takeScreenShot(String fileName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+fileName+"_"+javautil.getDateTimeInFormat()+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
		//Files.copy(src,dst);
	}
}

