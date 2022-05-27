package com.vtiger.practice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sdet34l1.genericlibrary.JavaUtility;
import com.sdet34l1.genericlibrary.WebDriverUse;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor 
{
	public static void main(String[] args, WebDriver driver) throws IOException {
		JavaUtility javaUtil = new JavaUtility();
		WebDriverUse webDriverUse = new WebDriverUse(driver);
		WebDriverManager.chromedriver().setup();
		WebDriver driver2 = new ChromeDriver();
		WebDriverUse.initializeJs(driver);
		WebDriverUse.launchApplicationThroughJs("http://localhost:8888");
		//jse.executeScript("window.location='http://localhost:8888'");
		driver.manage().window().maximize();
		WebDriverUse.enterDataThroughJs(driver.findElement(By.name("user_name")),"admin");
		WebDriverUse.enterDataThroughJs(driver.findElement(By.name("user_password")),"root");
		WebDriverUse.clickThroughJs(driver.findElement(By.id("submitButton")));
		WebDriverUse.scrollTillElementThroughJs(driver.findElement(By.xpath("//b[contains(.,'Top Trouble Tickets')]")));
		String fileName = new JavaScriptExecutor().getClass().getName();
		webDriverUse.takeScreenShot(fileName,driver);
		WebDriverUse.quitBrowser(driver);
		
	}
}
