package com.sdet34l1.genericlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

public class GettersAndSettersForListener implements ITestListener
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
	
	
	public int getRandomnumber() {
		return randomnumber;
	}

	public void setRandomnumber(int randomnumber) {
		this.randomnumber = randomnumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getLongtimeout() {
		return longtimeout;
	}

	public void setLongtimeout(long longtimeout) {
		this.longtimeout = longtimeout;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement() {
		return element;
	}

	public void setElement(WebElement element) {
		this.element = element;
	}

	public LoginPage getLoginpage() {
		return loginpage;
	}

	public void setLoginpage(LoginPage loginpage) {
		this.loginpage = loginpage;
	}

	public HomePage getHomepage() {
		return homepage;
	}

	public void setHomepage(HomePage homepage) {
		this.homepage = homepage;
	}

	public JavaUtility getJavautil() {
		return javautil;
	}

	public void setJavautil(JavaUtility javautil) {
		this.javautil = javautil;
	}

	public WebDriverUse getWebDriverUse() {
		return webDriverUse;
	}

	public void setWebDriverUse(WebDriverUse webDriverUse) {
		this.webDriverUse = webDriverUse;
	}

	public static WebDriver getStaticdriver() {
		return staticdriver;
	}

	public static void setStaticdriver(WebDriver staticdriver) {
		GettersAndSettersForListener.staticdriver = staticdriver;
	}

	public static WebDriver staticdriver;
	
	
	private static GettersAndSettersForListener instance;
	private GettersAndSettersForListener() {}
	
	public static GettersAndSettersForListener getInstance()
	{
		if (instance == null)
		{
			instance = new GettersAndSettersForListener();
		}
		return instance;
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
