package com.sdet34l1.genericlibrary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.openqa.selenium.WebElement;

/**
 * This class contains only java specific reusable methods
 * @author Ganesh
 */
public class JavaUtility 
{
	
	/**
	 * This method is used to convert String value to long datatype
	 * @param value
	 * @return
	 */
	public long StringTolong(String value)
	{
		return Long.parseLong(value);
	}
	
	/**
	 * This method is used to get the random number
	 * @author Ganesh
	 * @param limit
	 * @return 
	 */
	public int getRandomNumber(int limit)
	{
		Random ran = new Random();
		return ran.nextInt(limit);
	}
	
	/**
	 * This method is used to print the message
	 * @param message
	 */
	public void printStatement(String message)
	{
		System.out.println(message);
	}
	
	/**
	 * This method is used to Condition whether it is true or false
	 * @param actualResult
	 * @param expectedResult
	 */
	public void assertionThroughIfCondition(String actualResult,String expectedResult,String testCaseName)
	{
		if(actualResult.equalsIgnoreCase(expectedResult))
		{
			System.out.println(testCaseName+"Created Successfully");
			System.out.println("Test case is passed");
		}
	}
	
	/**
	 * This method is used to customwait until page is loaded
	 * @param element
	 * @param polingTime
	 * @param duration
	 * @throws InterruptedException 
	 */
	public static void customWait(WebElement element , long polingTime , int duration) throws InterruptedException
	{
		int count=0;
		while(count<=duration)
		{
		try 
		{
			element.click();
			break;
		} 
		catch (Exception e)
		{
			Thread.sleep(polingTime);
			count++;
		}
		}
	}
	
	/**
	 * This method is used to get the data and time
	 * @return
	 */
	public String getDateTimeInFormat()
	{
		return new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new Date());
	}
	
}