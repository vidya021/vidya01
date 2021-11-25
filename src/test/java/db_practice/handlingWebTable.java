package db_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class handlingWebTable 
{ 
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	

	
	public static void main(String[] args) throws IOException 
	
	{
		
		    FileInputStream fis = new FileInputStream("./data/CommonData2.property");
		    Properties pobj = new Properties();
		    pobj.load(fis);
		    
	        String BROWSER = pobj.getProperty("browser");
	        String URL = pobj.getProperty("url");
	        String USERNAME = pobj.getProperty("username");
	        String PASSWORD = pobj.getProperty("password");
	        
	        WebDriver driver =null; 
	        
	        if(BROWSER.equals("chrome"))
	        {        
	             driver = new ChromeDriver();
	        }
	        else if(BROWSER.equals("firefox")) 
	        {
	        	driver = new FirefoxDriver();
	        }
	        else if(BROWSER.equals("ie")) 
	        {
	        	driver = new InternetExplorerDriver();
	        }
	        
	        driver.get(URL);
	        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	        driver.findElement(By.id("submitButton")).click(); 
	        
	        driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	       /* select checkbox
	       List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
	       
	       
	       for (int i=1;i<list.size();i++)
	       {
	    	   list.get(i).click();
	       }
	       
	       //deselect checkbox
	       for (int i=1;i<list.size()-1;i++)
	       {
	    	   list.get(i).click();
	       }
	       
	       //select 5th checkbox
	       
	      list.get(5).click();
	      */
	       
	      List<WebElement> lst = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
	      for(int i=1;i<lst.size();i++)
	      {
	    	  System.out.println(lst.get(i).getText());
	      }
	       
	       
	       
	        
		}

	}


