package com.vtiger.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNeworganization 
{
	public CreateNeworganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
   @FindBy(name="accountname")   
   private WebElement orgNameEdt;
   
   @FindBy(xpath="//tbody/tr[1]/td[1]/div[1]/input[1]")
   private WebElement saveBtn;
   
   public void createOrg(String orgName)
   {
	   orgNameEdt.sendKeys(orgName);
	   saveBtn.click();
   }
}
