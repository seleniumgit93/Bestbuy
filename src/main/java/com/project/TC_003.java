package com.project;

import java.io.IOException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TC_003 extends BaseTest{
	
 
  @BeforeMethod(groups= {"regression"} )
  @Parameters("browser")
  public void startProcess(String btype) throws IOException, InterruptedException {
	  
	  System.out.println("Before Test...");
	  
	  init();
		test=report.startTest("TC_003");
			
		test.log(LogStatus.INFO, "Started initialization of property files: data,or,env...");
			
		
		launchBrowser(btype);
		test.log(LogStatus.INFO, "opened browser: "+p.getProperty("firefoxbrowser"));
		
		launchUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigate to url: "+p.getProperty("amazonurl"));
  }
  
  @Test(groups= {"regression"})
  public void amazon() {
	  System.out.println("amazon test...");
	  
	  selectDropItem("amazondropbox_id","amazondropvalue");
		test.log(LogStatus.PASS, "Selected drop down item: "+or.getProperty("amazondropvalue")+" by using the locator "+or.getProperty("amazondropbox_id"));
		
		
		
		typeValue("amazonsearchtext_id","amazonsearchtext");
		test.log(LogStatus.PASS, "Entered value in searchbox: "+or.getProperty("amazonsearchtext")+" by using the locator "+or.getProperty("amazonsearchtext_id"));
		
		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.PASS, "Clicked on search button: by using the locator "+or.getProperty("amazonsearchbutton_xpath"));
  }

  @AfterMethod(groups= {"regression"})
  public void endProcess() {
	  System.out.println("After test...");
	  closeBrowser();
	  
	  report.endTest(test);
		report.flush();
  }

}
