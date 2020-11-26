package excelLibraries;

import org.openqa.selenium.By;

import com.project.BaseTest;

public class FacebookLogin extends BaseTest{

	public static void main(String[] args) throws Exception {

		  ExcelAPI e1=new ExcelAPI("C:\\Users\\user\\Downloads\\test.xlsx");

		  init();
		  launchBrowser("firefox");
		  launchUrl("facebookurl");
		  
		  for(int i=1;i<e1.getRowCount("login");i++)
		  {
		    driver.findElement(By.id("email")).clear();
		    driver.findElement(By.id("email")).sendKeys(e1.getCellData("login","UserName",i));

		    driver.findElement(By.id("pass")).clear();
		    driver.findElement(By.id("pass")).sendKeys(e1.getCellData("login","Password",i));

		    Thread.sleep(3000);
		}

	}

}
