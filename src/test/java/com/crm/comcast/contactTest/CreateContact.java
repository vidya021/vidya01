package com.crm.comcast.contactTest;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.comcast.generic.FileUtility;
import com.crm.comcast.generic.ReadDatafromExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact 
{
	@Test
	public void createcontact() throws Throwable
{
		

	
	//WebDriverManager.iedriver().setup();
	Random ran=new Random();
	int ranWeb = ran.nextInt(100);
	
	
	FileUtility f=new FileUtility();
	String BROWSER = f.getPropertykey("browser");
	System.out.println(BROWSER);
	String URL = f.getPropertykey("url");
	System.out.println(URL);
	String USERNAME = f.getPropertykey("username");
	String PASSWORD = f.getPropertykey("password");
	
	ReadDatafromExcel r = new ReadDatafromExcel();
	String name=r.getExcelData("Sheet1", 1, 2) + "_" + ranWeb;
	
	String contactname =r.getExcelData("contacts", 1, 0) +"_" + ranWeb ;
	
	
	
			
	
	WebDriver driver =null; 
    
    if(BROWSER.equals("chrome"))
    {        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
    }
    else if(BROWSER.equals("firefox")) 
    {WebDriverManager.firefoxdriver().setup();
    	driver = new FirefoxDriver();
    }
    else if(BROWSER.equals("ie")) 
    {
    	driver = new InternetExplorerDriver();
    }
	
    driver.get(URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();	
	
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(name);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
	String act = driver.findElement(By.className("dvHeaderText")).getText();
	 if (act.contains(name))
	 {
		 System.out.println(name + "Organization is created");
	 }
	 else
	 {
		 System.out.println(name+ "Organization is not created");
	 }
	

	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contacts")));
	driver.findElement(By.linkText("Contacts")).click();
	

	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(contactname);
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while(it.hasNext())
	{
		String windowId = it.next();
		driver.switchTo().window(windowId);
		if(driver.getTitle().contains("Accounts&action"))
		{
			
			break;
		}
		driver.getTitle().contains("Contacts&action");
		
	}
	driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();

	
	
	
	
	
}	
}