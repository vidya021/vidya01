package db_practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Date;

public class ClearTrip 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException 
	{     
		        Date dateobj =new Date();
		        String date = dateobj.toString();
		        System.out.println(date);
		        String[] today = date.split(" ");
		        String day = today[0];
		        String month = today[1];
		        String dy = today[2];
		        String year = today[5];
		        String xpathDate = day+" "+month+" "+dy+" "+year;
		        System.out.println(xpathDate);
		
		
		
		       //disabling the popup notifications
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable-notifications");
				
				//opening the chrome browser and entering url
				WebDriver driver = new ChromeDriver(option);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get("https://www.cleartrip.com/");
					
				driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("BLR");
				driver.findElement(By.xpath("//p[contains(text(),'Bangalore')]")).click();
				driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("goa");
				driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[2]")).click();
				driver.findElement(By.xpath("//button[@class='flex flex-middle flex-between t-all fs-2 focus:bc-secondary-500 bg-transparent bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 c-neutral-900']")).click();
				driver.findElement(By.xpath("//div[@aria-label='Tue Nov 09 2021']")).click();
				System.out.println("flight booked");
				
				driver.close();
				
				
				
			 /* JavascriptExecutor j = (JavascriptExecutor) driver;
				j.executeScript("window.scrollTo(0,4000)");
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//button)[4]")).click();
				driver.findElement(By.xpath("(//div[text()='30'])[2]")).click();
				driver.findElement(By.xpath("//button[.='Search flights']")).click();
				List<WebElement> allFlightNames = driver.findElements(By.xpath("//img[@class]"));
				List<WebElement> allDeptTime = driver.findElements(By.xpath("//div[@class='ms-grid-column-1 ms-grid-row-1']//p"));
				for(int i = 0; i<allFlightNames.size();i++)
				{
					String flightName = allFlightNames.get(i).getAttribute("alt");
					String deptTime = allDeptTime.get(i).getText();
					System.out.println("Flightname ="+flightName+" deptTime = "+deptTime);
				}
				driver.close();
			*/
				
				
	}

}
