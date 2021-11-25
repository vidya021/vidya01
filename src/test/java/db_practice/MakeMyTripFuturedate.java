package db_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTripFuturedate 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
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
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Fri Jan 21 2022']")).click();
		System.out.println("flight booked");
		
		driver.close();

	}

}
