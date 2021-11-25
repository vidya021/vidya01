package com.crm.comcast.generic;

import java.io.File;
import java.io.IOException;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	

	public void onTestStart(ITestResult result)
	{
		 test=report.createTest(result.getMethod().getMethodName());
		
		
	}

	public void onTestSuccess(ITestResult result) 
	{
	
	 test.log(Status.PASS,"method pass");
	 
	 
	}

	public void onTestFailure(ITestResult result) 
	{
		String methodName= result.getMethod().getMethodName();
		
		Object obj= result.getInstance();
		WebDriver driver=null;
		
	
			try {
				driver=(WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(obj);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./Screenshot/"+methodName+".PNG");
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		test.log(Status.SKIP,"method skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
		test.log(Status.FAIL,"method failed");
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
		
	}

	public void onStart(ITestContext context) 
	{
		FileUtility flib =new FileUtility();
		
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter("./ExtentReport.html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Vtiger CRM 5");
		htmlReporter.config().setReportName("Automation Execution report");
		
		 report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", System.getProperty("os.name"));
		FileUtility Lib=new FileUtility();
		try
		{
			report.setSystemInfo("Testing Url", flib.getPropertykey("url"));
			report.setSystemInfo("browser",flib.getPropertykey("browser"));
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) 
	{
	report.flush();
		
	}
  
}
