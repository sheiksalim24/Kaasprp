package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductEngineering {
	
	
	public WebDriver driver;
	
	public ProductEngineering(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
//xpath to navigate to the industries page
	@FindBy (xpath = "//div[@id='footer']//a[@href='product-engineering.html']")
	public WebElement productengilink;
	
	@FindBy (xpath = "//div[@class='hero-content']//h1[text()='Product ']")
	public WebElement productengiheading;
	
	@FindBy (xpath = "(//div[@class='card-arrow'])[1]")
	public WebElement applicationmigrationarrow;
	
	@FindBy (xpath = "//div[@class=\"hero-content\"]//h1[text()='Application Migration & ']")
	public WebElement applicationmigrationheading;
	
	@FindBy (xpath = "(//div[@class='card-arrow'])[2]")
	public WebElement managedarrow;
	
	@FindBy (xpath = "//div[@class=\"hero-content\"]//h1[text()='Managed IT ']")
	public WebElement managedheading;
	
	@FindBy (css = "a[href]")
	public List<WebElement> alllinks;
	

}
