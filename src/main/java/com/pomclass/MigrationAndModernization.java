package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MigrationAndModernization {
	
	public WebDriver driver;
	
	public MigrationAndModernization(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath = "//a[text()='Migration & Modernization']")
	public WebElement migAndModernLink;
	
	@FindBy (xpath = "//h1[@class='hero-title']")
	public WebElement migAndModernHeading;
	
	@FindBy(css = "a[href]")
	public List<WebElement> migModernPageAllLink;

}
