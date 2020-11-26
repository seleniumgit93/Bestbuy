package com.POM;

import org.testng.annotations.Test;

import com.project.BaseTest;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class POM_003 extends BaseTest{
	
	Login obj;
 
  @BeforeTest
  public void startProcess() throws Exception {
	  
	  init();
	  launchBrowser("firefox");
	  launchUrl("automationurl");
  }

  @Test
  public void login() {
	  
	 obj=new Login(driver);
	 obj.customerLogin();
	 Assert.assertEquals(obj.validateCustomer(), "Authentication failed.");
  }
  @AfterTest
  public void afterTest() {
  }

}
