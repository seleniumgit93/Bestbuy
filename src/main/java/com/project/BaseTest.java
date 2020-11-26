package com.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class BaseTest {
	
	public static WebDriver driver;
	public static String Projectpath=System.getProperty("user.dir");
	public static Properties p;
	public static FileInputStream fis;
	
	public static Properties envprop;
	public static Properties prop;
	public static Properties or;
	public static ExtentReports report;
	public static ExtentTest test;
    public static String screeshotfilename=null;	
    
    static
    {
    Date dt= new Date();
    screeshotfilename=dt.toString().replace(':','_').replace(',','_')+".png";
    }
	
	public static void init() throws IOException
	
	{
		  fis=new FileInputStream(Projectpath+"\\data.properties"); 
		  p=new Properties();
		  p.load(fis);
		  
		  fis=new FileInputStream(Projectpath+"\\or.properties"); 
		  or=new Properties();
		  or.load(fis);
		  
		  
		  fis=new FileInputStream(Projectpath+"\\environment.properties"); 
		  
		  prop=new Properties();
		  prop.load(fis);
		  String e=prop.getProperty("env");
		  
		  System.out.println(e);
		  
		
		
		  fis=new FileInputStream(Projectpath+"\\"+e+".properties"); 
		  envprop=new Properties(); 
		  envprop.load(fis); 
		//  String val=envprop.getProperty("amazonurl");
		 // System.out.println(val);
		  
		  fis=new FileInputStream(Projectpath+"\\log4jconfig.properties");
		  
		  PropertyConfigurator.configure(fis);
		  
		  
		  report=ExtentManager.getInstance();
		  
		 
		  
	}
	
	
	public static void launchBrowser(String browser)
	{
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		 
		 
		 ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		 option.addArguments("user-data-dir=C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
		 
		 driver=new ChromeDriver(option);
		 
		}
		
		else if(browser.equals("firefox"))			 
	
		{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Downloads\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		//WebDriver driver = new FirefoxDriver(capabilities);
			/*
			 * ProfilesIni p = new ProfilesIni(); FirefoxProfile profile =
			 * p.getProfile("chandu"); profile.setPreference("dom.webnotifications.enabled",
			 * false);
			 * 
			 * FirefoxOptions option = new FirefoxOptions(); option.setProfile(profile);
			 * driver=new FirefoxDriver(option);
			 */
		
		 driver=new FirefoxDriver();
		
		 
		}
		
		
		
	}

	
	public static void launchUrl(String url) throws InterruptedException
	
	{    
	 
		driver.get(envprop.getProperty(url));
		//driver.navigate().to(p.getProperty(url));
		driver.manage().window().maximize();
		
		/*
		 * WebElement loc = driver.findElement(By.id("twotabsearchtextbox"));
		 * loc.sendKeys("samsung"); Thread.sleep(3000); loc.clear();
		 * driver.findElement(By.name("field-keywords")).sendKeys("philips");
		 * Thread.sleep(3000); //driver.findElement(By.className("nav-input")).clear();
		 * loc.clear();
		 * driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(
		 * "sony"); Thread.sleep(3000); loc.clear(); Thread.sleep(3000);
		 * driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("lg");
		 */
		
		//driver.findElement(By.linkText("Computers")).click();
		//driver.findElement(By.partialLinkText("Computer")).click();
		
		/*
		 * List<WebElement> links = driver.findElements(By.tagName("a"));
		 * 
		 * for(int i=0;i<links.size();i++)
		 * 
		 * {
		 * 
		 * if(!links.get(i).getText().isEmpty()) {
		 * 
		 * System.out.println(links.get(i).getText()); }
		 * 
		 * }
		 */
		
	}	
	
	
	public static void selectDropItem(String locator, String value) {
		
		getElement(locator).sendKeys(or.getProperty(value));
		
		//driver.findElement(By.id(locator)).sendKeys(value);
		
	}
	
	

	public static void typeValue(String locator, String value) {
		
		getElement(locator).sendKeys(or.getProperty(value));
		
		//driver.findElement(By.id(locator)).sendKeys(value);
		
	}
		
		public static void clickElement(String locator) {
			
			getElement(locator).click();

			//driver.findElement(By.xpath(locator)).click();
			
		}

		
		private static WebElement getElement(String locator) {
			
			WebElement element=null;
			if(locator.endsWith("_id"))
			{
				
				element=driver.findElement(By.id(or.getProperty(locator)));
			}else if(locator.endsWith("_name"))
			{
				
				element=driver.findElement(By.name(or.getProperty(locator)));
			}else if(locator.endsWith("_classname"))
			{
				
				element=driver.findElement(By.className(or.getProperty(locator)));
			}else if(locator.endsWith("_xpath"))
			{
				
				element=driver.findElement(By.xpath(or.getProperty(locator)));
			}else if(locator.endsWith("_css"))
			{
				
				element=driver.findElement(By.cssSelector(or.getProperty(locator)));
			}else if(locator.endsWith("_linktext"))
			{
				
				element=driver.findElement(By.linkText(or.getProperty(locator)));
			}else if(locator.endsWith("_partiallinktext"))
			{
				
				element=driver.findElement(By.partialLinkText(or.getProperty(locator)));
			}
			
			return element;
			
			
		}
		
		//***********verify element
				public static boolean verifyElement(String expectedlink) {
					
					String actualink=driver.findElement(By.xpath("//a[contains(text(),'Mobiles')]")).getAttribute("innerHTML");
					System.out.println("Actual Link :"+actualink );
					System.out.println("Expected Link :"+expectedlink );
					if(actualink.equals(expectedlink))
						return true;
						
					else
						
						return false;
					
					
				}
				
				//***************Reporting*************
				
				public static void reportSuccess(String successMsg) {
					test.log(LogStatus.PASS, successMsg);
					
				}

				public static void reportFailure(String FailureMsg) throws IOException {
					test.log(LogStatus.FAIL, FailureMsg);
					takeScreenshot();
					
				}


				private static void takeScreenshot() throws IOException {
					  Date dt=new Date();
					  SimpleDateFormat dateformat= new SimpleDateFormat("dd_MM_YYYY hh_mm_ss");
					  File scrnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					  FileHandler.copy(scrnshot, new File(Projectpath+"//Failure//"+"img1_"+dateformat.format(dt)+".jpeg"));
					  test.log(LogStatus.INFO, "screenshot-->"+test.addScreenCapture(Projectpath+"\\Failure\\"+"img1_"+dateformat.format(dt)+".jpeg"));
					  System.out.println(Projectpath+"\\Failure\\"+"img1_"+dateformat.format(dt)+".jpeg");

					
				}
				
				public static void closeBrowser() {
					driver.quit();
					
				}
				

		
		

			
		
	}
	
		


