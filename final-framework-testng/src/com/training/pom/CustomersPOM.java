package com.training.pom;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPOM {

	private WebDriver driver;
	
	public CustomersPOM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-name")
	private WebElement customerName; 
	
	public void customerName(String customerName) {
		this.customerName.clear();
		this.customerName.sendKeys(customerName);
	}
	
	@FindBy(id = "button-filter")
	private WebElement filterCustomer;
	
	public void FilterCustomer()
	{
		this.filterCustomer.click();
	}
	
	@FindBy(id = "input-email")
	private WebElement email;
	
	public void Email(String email)
	{
		this.email.sendKeys(email);
	}
	
	@FindBy(xpath = "//input[@value='754']")
	private WebElement checkbox;
	
	public void Checkbox()
	{
		this.checkbox.click();
	}
	
	
	
 @FindBy(xpath ="//button[@type='button']")
private WebElement delete;

public void Delete()
{
	this.delete.click();
}



public void acceptingalert()
{
	Alert alert = driver.switchTo().alert();
	String alertmsg = driver.switchTo().alert().getText();
	System.out.println(alertmsg);
	alert.accept();
}

public void selectingCustomer() throws InterruptedException{
	driver.findElement(By.xpath("//li[@id='customer']/a/i")).click();
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//a[text()='Customers']")).click();
	Thread.sleep(5000);

	//driver.findElement(By.xpath("//ul[@class ='collapse in']")).click();
	//Thread.sleep(10000);
	//driver.findElement(By.xpath("//li[@id='customer']/a/following-sibling::ul/li/a[contains(text(), 'Customers')]")).click();
	/*
	List<WebElement> obj = driver1.findElements(By.xpath("//li[@id='customer']/ul/li"));
	
	String flag;
	for(int i=0;i<obj.size();i++)
	{
	WebElement element = obj.get(i);
	flag=obj.get(i).getText();
	if(flag.equals("Customers"))
	{
	element.click();
	Thread.sleep(10000);
	break;
	}
	}	
	
	*/
}
}