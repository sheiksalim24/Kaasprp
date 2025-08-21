package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUS {
	
public WebDriver driver;
	
	public AboutUS(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy (xpath = "//footer[@class='footer']")
	public WebElement footer;
	
	@FindBy (xpath = "(//div[@id='footer']//div[@class='footer-column'])[1]//a[@href='about.html']")
	public WebElement aboutus;
	
	@FindBy (xpath = "//div[@class='hero-content']//div[text()='Building the Future of ']")
	public WebElement aboutusheading;
	

	@FindBy (xpath = "//section[@class='card-grid-section']")
	public WebElement sol;//scrolling the page to our location place
	
	@FindBy (xpath = "(//section[@class='card-grid-section']//div[@class='containers']//a[@class='card-item no-image'])[1]")
	public WebElement aol; //aboutus_ourlocation
	
	@FindBy (xpath = "//div[@class='hero-content']//div[text()='Our Global ']")
	public WebElement ourlocationtext;
	
	@FindBy (xpath = "(//div[@id=\"footer\"]//footer[@class=\"footer\"]//ul[@class=\"footer-links\"])[1]")
	public WebElement ourlocationfooter;
	
	@FindBy (xpath = "//a[@href='leadership.html']")
	public WebElement al; //aboutus_leadership
	
	@FindBy (xpath = "//div[@class='hero-content']//div[text()='Meet Our ']")
	public WebElement leadershiptext; 
	
	@FindBy (xpath = "(//section[@class='card-grid-section']//div[@class='containers']//a[@class='card-item no-image'])[2]")
	public WebElement als; //aboutus_leadership
	
	@FindBy (css = "a[href]")
	public List<WebElement> alllinks;

}
