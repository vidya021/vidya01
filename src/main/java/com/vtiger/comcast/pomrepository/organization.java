package com.vtiger.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organization 
{ 
	public  organization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateOrgImg;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchTxtfd;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBtn;
	
	public WebElement getCreateOrgImg()
	{
		return CreateOrgImg;
	}

	public WebElement getSearchTxtfd() {
		return searchTxtfd;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
         
}
