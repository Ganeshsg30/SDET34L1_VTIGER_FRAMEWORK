package com.vtiger.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sdet34l1.genericlibrary.BaseClass;

public class TestNGAssertTest extends TestNgBasicConfigTest
{
	@Test
	public void practice1Test()
	{
		Reporter.log("a-practice1",true);
		Reporter.log("b-practice1",true);
		Assert.fail();
		Reporter.log("c-practice1",true);
		Reporter.log("d-practice1",true);
		Reporter.log("e-practice1",true);
		Reporter.log("f-practice1",true);
	}
	
	@Test
	public void practice2Test()
	{
		Reporter.log("g-practice1",true);
		Reporter.log("h-practice1",true);
		Reporter.log("i-practice1",true);
		Reporter.log("j-practice1",true);
		Reporter.log("k-practice1",true);
		Reporter.log("l-practice1",true);
	}
}
