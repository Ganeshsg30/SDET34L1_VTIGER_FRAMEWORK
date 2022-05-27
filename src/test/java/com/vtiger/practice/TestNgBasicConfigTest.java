package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNgBasicConfigTest
{
	@BeforeSuite
	public void beforeSuiteTest()
	{
		Reporter.log("before suite",true);
	}
	
	@AfterSuite
	public void afterSuiteTest()
	{
		Reporter.log("after suite",true);
	}
	
	@BeforeTest
	public void beforeTestTest()
	{
		Reporter.log("before test",true);
	}
	
	
	@AfterTest
	public void afterTestTest()
	{
		Reporter.log("after test",true);
	}
	
	@BeforeClass
	public void beforeClassTest()
	{
		Reporter.log("before class",true);
	}
	
	@AfterClass
	public void afterClassTest()
	{
		Reporter.log("after class",true);
	}
	
	@BeforeMethod
	public void beforeMethodTest()
	{
		Reporter.log("before method",true);
	}
	
	@BeforeMethod
	public void beforeMethod2Test()
	{
		Reporter.log("before method 2",true);
	}
	
	@AfterMethod
	public void afterMethodTest()
	{
		Reporter.log("after method",true);
	}
}
