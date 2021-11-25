package com.crm.comcast.contactTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class fail 
{
	@Test(retryAnalyzer = com.crm.comcast.generic.RetryAnalyzer.class)
	public void createorg()
	{
		System.out.println("Creating Organization");
		Assert.fail();
		
	}

}
