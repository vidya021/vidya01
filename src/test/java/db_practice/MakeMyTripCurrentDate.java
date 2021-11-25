package db_practice;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTripCurrentDate 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) 
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
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		driver.findElement(By.xpath("//span[@class='lbl_input latoBold  appendBottom5']")).click();     
		driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("BLR");  
		
		driver.findElement(By.xpath("(//span[@class='lbl_input latoBold  appendBottom5'])[2]")).click();
		driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']")).sendKeys("GOI");
		driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Tue Nov 09 2021']")).click();
		System.out.println("flight booked");
		driver.close();
       
	}

}
