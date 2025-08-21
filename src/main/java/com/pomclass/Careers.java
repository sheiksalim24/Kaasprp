package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Careers {
	

	public WebDriver driver;
	
	public Careers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy (xpath = "//a[text()='Careers']")
	public WebElement careersLink;
	

	@FindBy (xpath = "//h1[@class='hero-title']")
	public WebElement careersPageHeading;
	
	@FindBy (css = "a[href")
	public List<WebElement> careersAllLink;
	
	
	
	

}
