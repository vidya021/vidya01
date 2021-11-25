package com.crm.comcast.generic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.comcast.pomrepository.Home;
import com.vtiger.comcast.pomrepository.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public FileUtility fui=new FileUtility();
	public WebDriver driver=null;
	public DatabaseUtility dbu=new DatabaseUtility();
	public ExcelUtility eu=new ExcelUtility();
	public javaUtility ju=new javaUtility();

	@BeforeSuite (groups ={"smokeTest","RegressionTest"})
	public void ConfigBs()

	{
		System.out.println("  Connect to database ");
		//dbu.connectToDB();		


	}
	
	//@org.testng.annotations.Parameters(value="BROWSER")
	@BeforeClass (groups = {"smokeTest","RegressionTest"})
	public void configBC() throws IOException 
	{
		System.out.println("  launch the browser ");
		String BROWSER = fui.getPropertykey("browser");

		if(BROWSER.equals(("firefox")))
		{
	        
			driver =new FirefoxDriver();
		}
		else if(BROWSER.equals("chrome"))
		{ 		WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod (groups ={"smokeTest","RegressionTest"})
	public void configBM() throws IOException 
	{
		System.out.println(" Login to application ");
		Login  l=new Login(driver);
		l.loginToApp(fui.getPropertykey("url"));


	}

	@AfterMethod (groups ={"smokeTest","RegressionTest"})
	public void configAM()
	{
		System.out.println("Logout of application");	
		Home h = new Home(driver);
		h.logout(driver);
	}

	@AfterClass (groups={"smokeTest","RegressionTest"})
	public void configAC() 
	{

		System.out.println(" Close the browser ");
		driver.quit();
	}

	@AfterSuite (groups={"smokeTest","RegressionTest"})
	public void configAS() throws SQLException
	{
		System.out.println(" close the database connection ");
		//dbu.closeDB();
	}







}
