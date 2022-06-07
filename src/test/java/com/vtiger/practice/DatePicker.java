package com.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker 
{
	@Test
	public void DatePick() 
	{	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();
		String reqDate = "30";
		String reqMonth = "September";
		String reqYear = "2023";
		driver.findElement(By.xpath("//input[@id='datepicker' and @class='hasDatepicker']")).click();
		String[] currentMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText().split(" ");
		String currentMonth = currentMonthYear[0];
		String currentYear = currentMonthYear[1];
		
		while(!(currentMonth.equals(reqMonth) && currentYear.equals(reqYear)))
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			currentMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText().split(" ");
			currentMonth = currentMonthYear[0];
			currentYear = currentMonthYear[1];
		}
		driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='"+reqDate+"']")).click();
		driver.quit();
	}
}
