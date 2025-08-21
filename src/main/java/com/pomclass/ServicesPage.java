package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesPage {

	WebDriver driver;

	public ServicesPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[text()='Services'])[1]")
	public WebElement servicesPageHeader;

	@FindBy(xpath = "//h3[text()='Web Development']")
	public WebElement webDevelopmentLink;
	
	@FindBy(xpath = "(//a[contains(@class,'industry-item animate')])[1]")
	public WebElement webDevelopmentImage;
	
	@FindBy(xpath = "//div[@class='hero-title']")
	public WebElement servicesPageHeading;
	
	@FindBy(css = "a[href]")
	public List<WebElement> servicesAllLinks;
	
	@FindBy(xpath = "//span[text()='Web Development']")
	public WebElement webDevelopmentHeading;
	
	@FindBy(xpath = "//h3[text()='Mobile App Development']")
	public WebElement mobileAppDevelopment;
	
	@FindBy(xpath = "//h1[@class='hero-title']")
	public WebElement mobileAppDevelopmentPageHeading;
	
	@FindBy(xpath = "//h3[text()='Application Migration & Modernization']")
	public WebElement appMigAndModernizationLink;
	
	@FindBy(xpath = "//h1[@class='hero-title']")
	public WebElement appMigAndModernizationHeading;
	
	@FindBy(xpath = "//h3[text()='Product Engineering']")
	public WebElement productEngLink;
	

	@FindBy(xpath = "//h1[@class='hero-title']")
	public WebElement productEngPageHeading;
	
	@FindBy(xpath = "//h3[text()='Managed IT Services']")
	public WebElement managedITServLink;
	
	@FindBy(xpath = "//h1[@class='hero-title']")
	public WebElement managedITServPageHeading;
	
	@FindBy(xpath = "//h3[text()='Cloud & Infrastructure Solutions']")
	public WebElement cloudInfrastructureSolLink;
	
	@FindBy(xpath = "//h1[@class='hero-title']")
	public WebElement cloudInfrastructureSolPageHeading;
	
	@FindBy(xpath = "//h3[text()='Quality Assurance']")
	public WebElement qualityAssuranceLink;
	
	@FindBy(xpath = "//h1[@class='hero-title']")
	public WebElement qualityAssurancePageHeading;
	
	@FindBy(xpath = "//h3[text()='Staff Augmentation']")
	public WebElement staffAugLink;
	
	@FindBy(xpath = "//h1[@class='hero-title']")
	public WebElement staffAugPageHeading;
	
	@FindBy(xpath = "//h3[text()='Generative AI Solutions']")
	public WebElement generativeAILink;
	
	@FindBy(xpath = "//h1[@class='hero-title']")
	public WebElement generativeAIPageHeading;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
