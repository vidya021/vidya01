package com.crm.comcast.generic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverUtility 
{
	public void switchToWindow(WebDriver driver,String id)
	{
     Set<String> set = driver.getWindowHandles();
     Iterator<String> it = set.iterator();
     while(it.hasNext())
     {
    	 String windowid = it.next();
    	 String title = driver.switchTo().window(windowid).getTitle();
    	 if(title.contains(id))
    	 {
    		 break;
    	 }
     }
     
	}

	public void waitForElementVisibility(WebDriver driver, WebElement orgHeaderSucFInfo) 
	{
		
		
	}

}
