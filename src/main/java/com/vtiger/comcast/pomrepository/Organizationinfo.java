package com.vtiger.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationinfo 
{
	public Organizationinfo(WebDriver driver)
	{
		
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement successfulMsg;
		
		@FindBy(xpath = "//span[@id='dtlview_Industry']")
		private WebElement indInfo;
		
		@FindBy(xpath = "//span[@id='dtlview_Type']")
		private WebElement typeInfo;
		
		
		public WebElement getIndInfo() {
			return indInfo;
		}


		public WebElement getTypeInfo() {
			return typeInfo;
		}


		public WebElement getSuccessfulMsg() {
			return successfulMsg;
		}


		
	}


