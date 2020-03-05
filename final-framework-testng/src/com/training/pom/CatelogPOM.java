package com.training.pom;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CatelogPOM {

private WebDriver driver;
	
	public CatelogPOM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[@class='text-center']/input[@value='664']")
	private WebElement selectproduct;
	
	public void selectProduct(){
		this.selectproduct.click();
	}
	
	@FindBy(xpath="//td[@class='text-center']/input[@value='575']")
	private WebElement selectproductdel;
	
	public void selectProductdel(){
		this.selectproductdel.click();
	}
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement delete;
	
	public void Delete(){
		this.delete.click();
	}
	
	public void acceptingalert()
	{
		Alert alert = driver.switchTo().alert();
		String alertmsg = driver.switchTo().alert().getText();
		System.out.println(alertmsg);
		alert.accept();
	}
	
	
	@FindBy(xpath="//td[text()='Blazer-Boys(123)']/following-sibling::td/a/i")
	private WebElement productEditbutton; 
	
	public void productEdit() {
		
		this.productEditbutton.click();
	}
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	public void clearQuantity()
	{
		this.quantity.clear();
	}
	
	public void editQuantity(String quantity){
		this.quantity.sendKeys(quantity);
			}
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	public void submitProduct(){
		this.submit.click();
	}
	
	@FindBy(xpath="//div[@id='content']/div[@class='container-fluid']/div/i")
    private WebElement successmsg;
	
	public void successMsg(){
	
	String expected ="Success: You have modified products!	";
	String actual =successmsg.getText();
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
	}
	
	
	public void selectingCatelog() throws InterruptedException{
		driver.findElement(By.xpath("//a[@class='parent']/i[@class='fa fa-tags fa-fw']")).click();
	Thread.sleep(5000);

		//driver.findElement(By.xpath("//ul[@class ='collapse in']")).click();
		//Thread.sleep(10000);
		//driver.findElement(By.xpath("//li[@id='customer']/a/following-sibling::ul/li/a[contains(text(), 'Customers')]")).click();
		
		List<WebElement> obj = driver.findElements(By.xpath("//li[@id='catalog']/ul/li"));
		
		String flag;
		for(int i=0;i<obj.size();i++)
		{
		WebElement element = obj.get(i);
		flag=obj.get(i).getText();
		if(flag.equals("Products"))
		{
		element.click();
		Thread.sleep(10000);
		break;
		}
		}
	}
		
		public void selectingData() throws InterruptedException{
		//	driver.findElement(By.xpath("//a[@class='parent']/i[@class='fa fa-tags fa-fw']")).click();
		//Thread.sleep(5000);

			//driver.findElement(By.xpath("//ul[@class ='collapse in']")).click();
			//Thread.sleep(10000);
			//driver.findElement(By.xpath("//li[@id='customer']/a/following-sibling::ul/li/a[contains(text(), 'Customers')]")).click();
			
			List<WebElement> obj = driver.findElements(By.xpath("//ul[@class='nav nav-tabs']/li"));////div[@class='panel-body']/form/ul[@class='nav nav-tabs']/li
			
			
			String flag;
			for(int i=0;i<obj.size();i++)
			{
			WebElement element = obj.get(i);
			flag=obj.get(i).getText();
			if(flag.equals("Data"))
			{
			element.click();
			Thread.sleep(10000);
			break;
			}
			}
			}
			
			
		
		
}

