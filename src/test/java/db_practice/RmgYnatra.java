package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RmgYnatra 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws SQLException
	
	
	{
	    WebDriver driver = new ChromeDriver();
	    
	    driver.get("http://localhost:8084/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	    driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	    driver.findElement(By.xpath("//a [.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.xpath("//input [@name='projectName']")).sendKeys("SecondProject");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Vidya");
		WebElement project = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
		Select s= new Select(project);
		s.selectByIndex(1);
        driver.findElement(By.xpath("//input[@value='Add Project']")).click();
        
        //database
        
        Connection con =null;
        try 
        {
        Driver driverreff=new Driver();
        DriverManager.registerDriver(driverreff);
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Projects","root","root");
        Statement stat=con.createStatement();
        ResultSet result = stat.executeQuery("select * from project");
        while(result.next())
        	{
        	if(result.getString(4).equals("SecondProject"))
        	{
        		System.out.println("Project is created");
        		break;
        	}
        	
   
            }
        
        }
        catch(Exception e)
        {
        	System.out.println("Project is not created");
        }
        finally
        {
        	con.close();
        }
	}
}
