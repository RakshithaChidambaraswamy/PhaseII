package com.training.pom;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.training.generics.ScreenShot;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type ='submit']")
	private WebElement loginBtn; 
	
	@FindBy(xpath= "//input[@value = '220']")
	private WebElement returnidcheckbox;
	
	@FindBy(id ="input-return-id")
	private WebElement returnid;
	
	@FindBy(id ="button-filter")
	private WebElement filterbutton;
	
	@FindBy(xpath ="//tbody/tr/td[contains(text(), 'No results!')]")
	private WebElement result;
	
	@FindBy(xpath = "//button[@type='button']")
	private WebElement delete;
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void deleteButton()
	{
		this.delete.click();
	}
	
	
	public void returnIdcheckbox()
	{
		this.returnidcheckbox.click();
	boolean a = this.returnidcheckbox.isSelected();
	
	if(a == true)
	{
		System.out.println("the return id will be deleted now"+returnidcheckbox);
	}
	else 
	{
		System.out.println("select a return id to delete");
	}
			}
	
	
	
	public void acceptingalert()
	{
		Alert alert = driver.switchTo().alert();
		String alertmsg = driver.switchTo().alert().getText();
		System.out.println(alertmsg);
		alert.accept();
		
	}
	
	public void successmsg()
	{
		this.returnid.sendKeys("220");
		this.filterbutton.click();
		String r = this.result.getText();
		if(r =="No results!")
		{
			System.out.println("record is deleted");
		}
		else
		{
			System.out.println("you have done something wrong");
		}
		
	}
	public void selectingReturn() throws InterruptedException{
		driver.findElement(By.xpath("//a[@class='parent']/i[@class='fa fa-shopping-cart fa-fw']")).click();
		Thread.sleep(5000);

		//driver.findElement(By.xpath("//ul[@class ='collapse in']")).click();
		//Thread.sleep(10000);

		List<WebElement> obj = driver.findElements(By.xpath("//li[@id='sale']/ul/li"));
		
		String flag;
		for(int i=0;i<obj.size();i++)
		{
		WebElement element = obj.get(i);
		flag=obj.get(i).getText();
		if(flag.equals("Returns"))
		{
		element.click();
		Thread.sleep(10000);
		break;
		}
		}	
	}
		
		
	
}
