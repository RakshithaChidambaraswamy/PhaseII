package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CustomersPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private CustomersPOM customersPOM;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
/*	@Test()
	public void deleteReturnlist() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC19_1");
		loginPOM.selectingReturn();
		screenShot.captureScreenShot("TC19_2");
		Thread.sleep(1000);
		loginPOM.returnIdcheckbox();
		screenShot.captureScreenShot("TC19_3");
		loginPOM.deleteButton();
		//screenShot.captureScreenShot("TC19_4");
		loginPOM.acceptingalert();
		Thread.sleep(3000);
		loginPOM.successmsg();
		Thread.sleep(3000);
		screenShot.captureScreenShot("TC19_5");
	}*/
	
  @Test()
   public void filtercustomerdetails() throws InterruptedException
   {
	  loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC20_1");
		customersPOM.selectingCustomer();
		screenShot.captureScreenShot("TC20_2");
		customersPOM.customerName("Neha B");
		customersPOM.FilterCustomer();
		Thread.sleep(3000);
		screenShot.captureScreenShot("TC20_3");
		customersPOM.Email("neha3@gmail.com");
		customersPOM.FilterCustomer();
		Thread.sleep(3000);
		screenShot.captureScreenShot("TC20_4");
		
   }
  
 /* @Test()
  public void deleteCustomer() throws InterruptedException
  {
	  loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC21_1");
		////click on customer link
		customersPOM.customerName("Neha B");
		customersPOM.Email("neha3@gmail.com");
		customersPOM.FilterCustomer();
		customersPOM.Checkbox();
		screenShot.captureScreenShot("TC21_3");
		customersPOM.Delete();
		screenShot.captureScreenShot("TC21_4");
		customersPOM.alert();
		customersPOM.acceptingalert();
  }*/
	
}
