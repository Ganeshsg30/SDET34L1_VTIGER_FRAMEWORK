package com.sdet34l1.genericlibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * 
 * @author Ganesh
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer
{
	int count = 0;
	int maxRetry = 5;
	@Override
	public boolean retry(ITestResult result) 
	{
		while(count<maxRetry)
		{
			count++;
			return true;
		}
		return false;
	}
	
}
