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
import com.training.pom.*;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Medium_tc {

		private WebDriver driver;
		private String baseUrl;
		private LoginPOM loginPOM;
		private static Properties properties;
		private ScreenShot screenShot;
		private CustomersPOM customersPOM;
		private CatelogPOM catelogPOM;

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
			catelogPOM = new CatelogPOM(driver);
			customersPOM = new CustomersPOM(driver);
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
		
		//Uniform project - UFM_043
		@Test()
		public void Searchproduct() throws InterruptedException {
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); 
			screenShot.captureScreenShot("TC43_1");
			Thread.sleep(3000);
			catelogPOM.selectingCatelog();
			screenShot.captureScreenShot("TC43_2");
			catelogPOM.selectProduct();
			screenShot.captureScreenShot("TC43_3");
			catelogPOM.productEdit();
			screenShot.captureScreenShot("TC43_4");
			Thread.sleep(3000);
			catelogPOM.selectingData();
			screenShot.captureScreenShot("TC43_5");
			Thread.sleep(3000);
			catelogPOM.clearQuantity();
			screenShot.captureScreenShot("TC43_6");
			Thread.sleep(3000);
			catelogPOM.editQuantity("100");
			Thread.sleep(3000);
			screenShot.captureScreenShot("TC43_7");
			catelogPOM.submitProduct();
			//catelogPOM.successMsg();
		}
		
		//Uniform project - UFM_044
		@Test()
		public void DeleteProduct() throws InterruptedException {
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); 
			screenShot.captureScreenShot("TC44_1");
			Thread.sleep(3000);
			catelogPOM.selectingCatelog();
			screenShot.captureScreenShot("TC44_2");
			catelogPOM.selectProductdel();
			screenShot.captureScreenShot("TC44_3");
			catelogPOM.Delete();
			customersPOM.acceptingalert();
			
			
}

}
