package com.training.pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CatelogPOM {

private WebDriver driver;
String Model;
String ProductName;
String Price;
String Quantity;
String Category;
String metaTitle;
String CategoryName;
String Description;
String MetaDescription;

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
	
	
	
	@FindBy(xpath="//td[@class='text-center']/input[@value='620']")
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
	
	public void eQ(){
		this.quantity.sendKeys(String.valueOf(Quantity));
	}
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	public void submitProduct(){
		this.submit.click();
	}
	
	@FindBy(xpath="//*[contains(text(),'Success: You have modified products!')]")
    private WebElement successmsg;
	
	public void successMsg(){
	
	String expected ="Success: You have modified products!×";
	String actual =successmsg.getText();
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
	}
	
	@FindBy(xpath="//div[@class='container-fluid']/div/a")
	private WebElement addButton;
	
	public void Addbutton(){
		this.addButton.click();
	}
	
	public void readExcelTC73() throws IOException{
		FileInputStream f = new FileInputStream("C:\\Rakshitha\\Uniform_project\\UFM_073.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(f);
		XSSFSheet s =w.getSheetAt(0);
		ProductName = s.getRow(1).getCell(0).getStringCellValue();
		metaTitle = s.getRow(1).getCell(1).getStringCellValue();
		Model = s.getRow(1).getCell(2).getStringCellValue();
		Price = s.getRow(1).getCell(3).getStringCellValue();
	    Quantity = s.getRow(1).getCell(4).getStringCellValue();
		Category = s.getRow(1).getCell(5).getStringCellValue();
		w.close();
		
	}

	
	@FindBy(id="input-name1")
	private WebElement p;
	
	public void Productname(){
		this.p.sendKeys(String.valueOf(ProductName));
	}
	
	@FindBy(id="input-meta-title1")
	private WebElement Title;
	
	public void Metatitle(){
		this.Title.sendKeys(String.valueOf(metaTitle));
	}
	
	@FindBy(id="input-model")
	private WebElement m;
	
	public void Model(){
		this.m.sendKeys(String.valueOf(Model));
		
	}
	
	@FindBy(id="input-price")
	private WebElement P;
	
	public void Price(){
		this.P.sendKeys(String.valueOf(Price));
		
	}
	
	
	@FindBy(id="input-category")
	private WebElement c;
	
	public void Category(){
		this.c.sendKeys(String.valueOf(Category));
		
	}
	
	@FindBy(id="input-name1")
	private WebElement cn;
	
	public void CategoryName(){
		this.cn.sendKeys(String.valueOf(CategoryName));
	}
	
	@FindBy(xpath="//button")
	private WebElement savebutton;
	
	public void Savebutton(){
		this.savebutton.click();
	}
	
	@FindBy(xpath="//div[@class ='note-editable panel-body']")
	private WebElement D;
	
	public void Description(){
		this.D.sendKeys(String.valueOf(Description));
	}
	
	@FindBy(id="input-meta-description1")
	private WebElement md;
	
	public void MetaDescription(){
		this.md.sendKeys(String.valueOf(MetaDescription));
	}
	public void readExcelTC66() throws IOException{
		FileInputStream f = new FileInputStream("C:\\Rakshitha\\Uniform_project\\UFM_073.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(f);
		XSSFSheet s =w.getSheetAt(0);
		CategoryName = s.getRow(3).getCell(0).getStringCellValue();
		Description = s.getRow(3).getCell(1).getStringCellValue();
		metaTitle = s.getRow(3).getCell(2).getStringCellValue();
		MetaDescription = s.getRow(3).getCell(3).getStringCellValue();
		w.close();
		
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
			public void selectingLink() throws InterruptedException{
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
					if(flag.equals("Links"))
					{
					element.click();
					Thread.sleep(10000);
					break;
					}
					}
			}
			
			public void selectingCategories() throws InterruptedException{
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
				if(flag.equals("Categories"))
				{
				element.click();
				Thread.sleep(10000);
				break;
				}
				}
			}
}

