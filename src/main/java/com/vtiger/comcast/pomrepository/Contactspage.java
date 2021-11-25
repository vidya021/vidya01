package com.vtiger.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactspage 
{
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createcontactButton;
	
	public Contactspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatecontactButton() {
		return createcontactButton;
	}
	

}
