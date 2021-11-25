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

import com.crm.comcast.generic.ReadDatafromExcel;

public class VtigerDelete 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		FileInputStream fis = new FileInputStream("./data/CommonData2.property");
	    Properties pobj = new Properties();
	    pobj.load(fis);
	    
        String BROWSER = pobj.getProperty("browser");
        String URL = pobj.getProperty("url");
        String USERNAME = pobj.getProperty("username");
        String PASSWORD = pobj.getProperty("password");
        
        String orgName = "HDFC-06gfg43vbcbcb";
        
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
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		
        
       
	    List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
	    for(int i=1; i<list.size();i++)
	    {
	    	String Text = list.get(i).getText();
	    	if(orgName.equals(Text))
	    	{
	    		 driver.findElement(By.xpath("//a[.='"+orgName+"']/../../td[8]/a[2]")).click();
	    		    
	    	}
	    }
	     
	    Thread.sleep(3000);
	    driver.switchTo().alert().accept();


	}

}
