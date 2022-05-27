package com.rmgyantra.projectTest;

import java.sql.SQLException;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sdet34l1.genericlibrary.DataBaseUse;

import com.sdet34l1.genericlibrary.ExcelUse;
import com.sdet34l1.genericlibrary.IconstantPath;
import com.sdet34l1.genericlibrary.JavaUtility;
import com.sdet34l1.genericlibrary.PropertiesFile;
import com.sdet34l1.genericlibrary.WebDriverUse;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

public class JdbctoGuiTest 
{
	public static void main(String[] args) throws SQLException, IOException 
	{	
		JavaUtility jutil = new JavaUtility();
		WebDriver driver=null;
		PropertiesFile.openPropertyFile(IconstantPath.RMGYANTRA_PROPERTIYFILE_PATH);
		ExcelUse.openExcel(IconstantPath.RMGYANTRA_EXCELFILE_PATH);
		int randomnumber = jutil.getRandomNumber(1000);
		String projectName=ExcelUse.getDataFromExcel("projects", 1, 1)+"_"+randomnumber;
		DataBaseUse.openDBConnection(IconstantPath.DATABASEURL+PropertiesFile.getDataFromPropertyFile("DBName"),PropertiesFile.getDataFromPropertyFile("DBUsername"),PropertiesFile.getDataFromPropertyFile("DBPassword"));
		DataBaseUse.setDataIntoDataBase("insert into project values('TY_PROJ_0100','ganesh','09/04/2022','"+projectName+"','created','3');");
		DataBaseUse.closeDBConnection();
		
		
//		try {
//			driver1= new Driver();
//		String input="insert into project values('TY_PROJ_036','ganesh','27/04/2022','"+projectName+"','created','3')";
//		DriverManager.registerDriver(driver1);
//		connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
//		Statement statement=connection.createStatement();
//		int result=statement.executeUpdate(input);
//		
//		if(result==1)
//		{
//			jutil.printStatement("data insert in database successfully");
//		}
//		}
//		
//		finally {
//				connection.close();
//			}
//		try {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		WebDriverUse.maximizeBrowser(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
		driver.findElement(By.linkText("Projects")).click();
		List<WebElement> listOfProjects=driver.findElements(By.xpath("//tbody//tr//td[2]"));
		
		for(WebElement project:listOfProjects)
		{
		if(project.getText().equalsIgnoreCase(projectName))
		{
			jutil.printStatement("passed");
			jutil.printStatement("Project Name is visible in GUI");
			break;
		}
		}
		WebDriverUse.quitBrowser(driver);	
	}
}
