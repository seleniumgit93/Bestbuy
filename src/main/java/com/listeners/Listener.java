package com.listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.project.BaseTest;

public class Listener extends BaseTest implements ITestListener {
	

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Start");
		
	}

	@Override
	public void onTestSuccess(ITestResult obj1) {
		
		try
		{
		File scrfile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrfile, new File (Projectpath+"//success//"+screeshotfilename));
		Reporter.log("<a href='"+Projectpath+"//success//"+screeshotfilename+"'><img src='"+Projectpath+"//success//"+screeshotfilename+"' height='100' width='100'/></a>");
		Reporter.log("Test has success:"+obj1.getMethod().getMethodName());
		
		}

		catch (IOException e)
		{

		e.printStackTrace();

		}
		
		System.out.println("Test case passed " +obj1.getName()+" "+obj1.getTestClass());
		
	
	}

	@Override
	public void onTestFailure(ITestResult result1) {
		
		
		try
		{
		File scrfile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrfile, new File (Projectpath+"//failure//"+screeshotfilename));
		Reporter.log("<a href='"+Projectpath+"//failure//"+screeshotfilename+"'><img src='"+Projectpath+"//failure//"+screeshotfilename+"' height='100' width='100'/></a>");
		Reporter.log("Test has success:"+result1.getMethod().getMethodName());
		}

		catch (IOException e)
		{

		e.printStackTrace();

		}
		
		
		System.out.println("Test case failed " +result1.getName()+" "+result1.getTestClass());
		System.out.println("Error message is "+result1.getThrowable());
		
		
	}
	
	
}
