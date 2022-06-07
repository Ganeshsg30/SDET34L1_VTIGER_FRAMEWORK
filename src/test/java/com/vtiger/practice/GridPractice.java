package com.vtiger.practice;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridPractice 
{
	@Test
	public void gridPractice() throws MalformedURLException, InterruptedException 
	{
		URL url= new URL("http://192.168.43.41:3333/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver = new RemoteWebDriver(url,cap);
		
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.quit();
	}
}
