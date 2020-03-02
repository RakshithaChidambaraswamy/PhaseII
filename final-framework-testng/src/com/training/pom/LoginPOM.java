package com.training.pom;

import org.openqa.selenium.Alert;
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
	
	@FindBy(xpath= "//input[@value = '223']")
	private WebElement returnidcheckbox;
	
	@FindBy(id ="input-return-id")
	private WebElement returnid;
	
	@FindBy(id ="button-filter")
	private WebElement filterbutton;
	
	@FindBy(xpath ="//*[contains(text(),'No results!')]")
	private WebElement result;
	
	
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
	public void alert()
	{
		
		String alertmsg = driver.switchTo().alert().getText();
		System.out.println(alertmsg);
			
	}
	public void acceptingalert()
	{
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	
	public void successmsg()
	{
		this.returnid.sendKeys("223");
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
		
		
	
}
