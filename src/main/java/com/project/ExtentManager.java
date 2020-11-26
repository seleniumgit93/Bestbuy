package com.project;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager extends BaseTest {
	
	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if(extent==null)
	     {
			Date dt=new Date();
			String filepath= dt.toString().replace(":","_").replace(" ","_")+".html";
		    extent =new ExtentReports(Projectpath+"//HTMLReports//"+filepath);
	        extent.loadConfig(new File(Projectpath+"//extentconfigreport.xml//"));
	        extent.addSystemInfo("selenium", "3.11.0").addSystemInfo("Environment", prop.getProperty("env"));
	}
		return extent;
	}
}
