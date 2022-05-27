package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import java.sql.ResultSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import com.mysql.cj.jdbc.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataBaseToVtigerOrganization 
{
	public static void main(String[] args) throws SQLException 
	{
		String url=null,username=null,password=null;
		Driver driver1= new Driver();
		DriverManager.registerDriver(driver1);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from vtigerorganization;");
		
		while(result.next())
		{
			url=result.getString("url");
			username=result.getString("username");
			password=result.getString("password");
		}
		connection.close();
		
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(username);
			driver.findElement(By.cssSelector("[name='user_password']")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.xpath("//a[text()='Organizations']/../../td[6]")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			String orgName = "gtiger";
			
			driver.findElement(By.cssSelector("[name='accountname']")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
			String org = driver.findElement(By.id("mouseArea_Organization Name")).getText();
	
			if(org.equalsIgnoreCase(orgName))
			{
				System.out.println("Organization Created Successfully");
			}
			WebElement logout = driver.findElement(By.xpath("//td[@class='small']//td[2]/img"));
			Actions a = new Actions(driver);
			a.moveToElement(logout).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			driver.quit();
	}
}
