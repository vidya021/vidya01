package com.crm.comcast.organizationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.crm.comcast.generic.ReadDatafromExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectMultiple
{


	public  void mainXML(XmlTest xml) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.iedriver().setup();
		Random ran=new Random();
		int ranWeb=ran.nextInt(100);
		
		
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		
		ReadDatafromExcel r = new ReadDatafromExcel();
		String name=r.getExcelData("Sheet1", 1, 2) + "_" + ranWeb;
		
		
        WebDriver driver =null; 
        
        if(BROWSER.equals("chrome"))
        {        
             driver = new ChromeDriver();
        }else if(BROWSER.equals("firefox")) {
        	driver = new FirefoxDriver();
        }else if(BROWSER.equals("ie")) {
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
		WebElement ind = driver.findElement(By.name("industry"));
		Select s=new Select(ind);
		s.selectByIndex(3);
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
		
		driver.close();
	}	

}
