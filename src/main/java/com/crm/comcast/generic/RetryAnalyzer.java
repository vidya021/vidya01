package com.crm.comcast.generic;


  // This class will implement  retry analyzer which can be utilised for failed test scripts

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.util.RetryAnalyzerCount;

public class RetryAnalyzer implements IRetryAnalyzer
{
	int count =0;
	int retrycount=4;
	
	public boolean retry(ITestResult result)
	{
		while(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
	}
	
	

}
