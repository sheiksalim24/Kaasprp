package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhitePaper {
	
private String firstname = "ra";
	

	private WebDriver driver;
	
	public WhitePaper(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	

	
	public Object firstname() {
        return firstname;
    }
	

	@FindBy (xpath = "//div[@class='footer-main']//a[@href='whitepapers.html']")
	public WebElement whitepaperlink;
	
	@FindBy (xpath = "//div[@class='hero-content']//div[text()='Forward-thinking Ideas Into ']")
	public WebElement whitepaperheading;
	
	@FindBy (xpath = "//div[@class='industries-grid']//h3[text()='AI Driven Software Development']")
	public WebElement aidriven;
	
	@FindBy (xpath = "//div[@class='industries-grid']//h3[text()='Digital Transformation in BFSI']")
	public WebElement digital;
	
	@FindBy (xpath = "//div[@class='industries-grid']//h3[text()='Legacy Modernisation']")
	public WebElement legacy;
	
	
	
	
	@FindBy (xpath = "//form[@id='whitepaperForm']//input[@id='firstName']")
	public WebElement fn;
	
	@FindBy (xpath = "//form[@id='whitepaperForm']//input[@id='lastName']")
	public WebElement ln;
	
	@FindBy (xpath = "//form[@id='whitepaperForm']//input[@id='email']")
	public WebElement mail;
	
	@FindBy (xpath = "//form[@id='whitepaperForm']//input[@id='mobile']")
	public WebElement mobile;
	
	@FindBy (xpath = "//form[@id='whitepaperForm']//input[@id='company']")
	public WebElement company;
	
	@FindBy (xpath = "//form[@id='whitepaperForm']//input[@id='industry']")
	public WebElement industry;
	
	@FindBy (xpath = "//form[@id='whitepaperForm']//input[@id='position']")
	public WebElement job;
	
	@FindBy (xpath = "//form[@id='whitepaperForm']//textarea[@id='purpose']")
	public WebElement message;
	
	@FindBy (xpath = "//button[@id='downloadBtn']")
	public WebElement downloadbutton;
	
	
	@FindBy (css = "a[href]")
	public List<WebElement> alllinks;
	

}
