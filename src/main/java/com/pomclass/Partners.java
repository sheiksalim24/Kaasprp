package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Partners {
	
public WebDriver driver;
	
	public Partners(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
//xpath to navigate to the industries page
	@FindBy (xpath = "//div[@id='header']//a[@href='product.html']")
	public WebElement partnersclick;
	
	@FindBy (xpath = "//div[@class='hero-content']//div[text()='Trusted ']")
	public WebElement partnersheading;
	
	@FindBy (xpath = "//div[@class='grid']//a[@href='75health.html']")
	public WebElement healthlink;
	
	@FindBy (xpath = "//div[@class='hero-content']//h1[text()='Transforming Healthcare with ']")
	public WebElement healthheading;
	
	@FindBy (xpath = "//div[@class=\"grid\"]//a[@href=\"kumaran.html\"]")
	public WebElement kumaranlink;
	
	@FindBy (xpath = "//div[@class='hero-content']//h1[text()='Digital Transformation with ']")
	public WebElement kumaranheading;
	
	@FindBy (xpath = "//div[@class=\"grid\"]//a[@href=\"rocketfinance.html\"]")
	public WebElement rocketfinancelink;
	
	@FindBy (xpath = "//div[@class='hero-content']//h1[text()='Financial Innovation with ']")
	public WebElement rocketfinanceheading;
	
	@FindBy (xpath = "(//div[@class='card-arrow'])[1]")
	public WebElement bankingarrow;
	
	@FindBy (xpath = "(//div[@class='card-arrow'])[2]")
	public WebElement healthcarearrow;
	
	@FindBy (css = "a[href]")
	public List<WebElement> alllinks;
	

}
