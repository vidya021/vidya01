package com.crm.comcast.generic;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class javaUtility 
{
	public Timeouts implicitwait(WebDriver driver,int duration)
	{
		Timeouts i = driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
		return i;
	}
	
	public WebElement explicitilyWait(WebDriver driver,WebElement element,int duration) 
	{
		
		WebDriverWait wait = new WebDriverWait(driver, duration);
		WebElement w = wait.until(ExpectedConditions.visibilityOf(element));
		return w;
		
	}
	public int randomWeb(int i)
	{
		Random ran=new Random();
		int ranWeb=ran.nextInt(i);
		return ranWeb;
	}
	
	
	
	

}


