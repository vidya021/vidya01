package com.crm.comcast.organizationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.comcast.generic.ReadDatafromExcel;

public class sampleseleniumTest {
	private static CharSequence name;


	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	

	public static void main(String[] args) throws IOException 
	{
		//FileInputStream fis =new FileInputStream("./data/CommonData2.property");
		//Properties pobj= new Properties();
		//pobj.load(fis);
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("Url");
		String USERNAME = System.getProperty("Username");
		String PASSWORD = System.getProperty("Password");
		
		ReadDatafromExcel r = new ReadDatafromExcel();
		String name=r.getExcelData("Sheet1", 1, 2);
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
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
		
		driver.close();
		

		
	}

}
