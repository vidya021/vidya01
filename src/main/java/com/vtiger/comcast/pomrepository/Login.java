package com.vtiger.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	public WebDriver driver;
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	 @FindBy(id="submitButton")
	private WebElement loginBtn;
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getUserNameEdt()
	{
	 return userNameEdt;
	}
	
	public WebElement getPasswordEdt()
	{
		return userPasswordEdt;
	}
	
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	public void loginToApp(String uRL)
	{   
		driver.get(uRL);
		userNameEdt.sendKeys("admin");
		userPasswordEdt.sendKeys("admin");
		loginBtn.click();
	}

	
	
	

}
