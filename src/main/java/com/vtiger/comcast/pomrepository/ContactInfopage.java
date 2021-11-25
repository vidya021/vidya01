package com.vtiger.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfopage 
{
	@FindBy(xpath ="//span[contains(text(),;contact Information')]" )
	private WebElement conNameVerify;
	
	public ContactInfopage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getConNameVerify() 
	{
		return conNameVerify;
	}

	public WebElement getOrgHeaderSucFInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
