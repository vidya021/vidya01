package com.vtiger.comcast.pomrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.generic.WebDriverUtility;

public class CreateContactPage 
{
	@FindBy(name="lastname")
	private WebElement lastnametf;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgNamelookup;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]/div[1]/input[1]")
	private WebElement saveButton;
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnametf() {
		return lastnametf;
	}

	public WebElement getOrgNamelookup() {
		return orgNamelookup;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void CreateContact(WebDriver driver, String lastName)
	{
		lastnametf.sendKeys(lastName);
		saveButton.click();
	}
	
	WebDriverUtility wu=new WebDriverUtility();
	public void createcontact(WebDriver driver, String lastname,String orgName)
	{
		lastnametf.sendKeys(lastname);
		orgNamelookup.click();
		wu.switchToWindow(driver, "Accounts&action");
		organization o= new organization(driver);
		o.getSearchTxtfd().sendKeys(orgName);
		o.getSearchBtn().click();
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		wu.switchToWindow(driver, "Contacts&action");
		saveButton.click();
		
	}
	

}
