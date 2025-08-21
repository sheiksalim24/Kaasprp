package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaseStudies {
	
private String firstname = "ra";
	

	private WebDriver driver;
	
	public CaseStudies(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	

	
	public Object firstname() {
        return firstname;
    }
	

	@FindBy (xpath = "//div[@class='footer-main']//a[@href='case-studies.html']")
	public WebElement casestudieslink;
		
	@FindBy (xpath = "//div[@class='hero-content']//div[text()='Success ']")
	public WebElement casestudiesheading;
	
	@FindBy (xpath = "(//div[@class='industry-content'])[1]")
	public WebElement healthcaretech;
	
	@FindBy (xpath = "//form[@id='caseStudyForm']//input[@id='firstName']")
	public WebElement fn;
	
	@FindBy (xpath = "//form[@id='caseStudyForm']//input[@id='lastName']")
	public WebElement ln;
	
	@FindBy (xpath = "//form[@id='caseStudyForm']//input[@id='email']")
	public WebElement mail;
	
	@FindBy (xpath = "//form[@id='caseStudyForm']//input[@id='mobile']")
	public WebElement mobile;
	
	@FindBy (xpath = "//form[@id='caseStudyForm']//input[@id='company']")
	public WebElement company;
	
	@FindBy (xpath = "//form[@id='caseStudyForm']//input[@id='industry']")
	public WebElement industry;
	
	@FindBy (xpath = "//form[@id='caseStudyForm']//input[@id='position']")
	public WebElement job;
	
	@FindBy (xpath = "//form[@id='caseStudyForm']//textarea[@id='purpose']")
	public WebElement message;
	
	@FindBy (xpath = "//button[@id='downloadBtn']")
	public WebElement downloadbutton;
	
	@FindBy (xpath = "//div[@class='industries-grid']//h3[text()='Migrating VB6 App to .NET Core']")
	public WebElement migrating;
	
	@FindBy (xpath = "//div[@class='industries-grid']//h3[text()='Ubuntu Upgrade: 14.04 to 22.04 Transition']")
	public WebElement ubuntuupgrade;
	
	@FindBy (xpath = "//div[@class='industries-grid']//h3[text()='Oracle Forms Migration to Java']")
	public WebElement oracleform;
	
	@FindBy (xpath = "//div[@class='industries-grid']//h3[text()='Scalable & Secure Lending App']")
	public WebElement scalable;
	
	@FindBy (xpath = "//div[@class='industries-grid']//h3[text()='Modernizing Sales Insights via Reverse Engineering']")
	public WebElement modernizingscales;
	
	@FindBy (xpath = "//div[@class='industries-grid']//h3[text()='Legacy to Central: Student Info System Upgrade']")
	public WebElement legacytocentral;
	
	@FindBy (xpath = "//div[@class='industries-grid']//h3[text()='Oracle Forms Transformed for the Future']")
	public WebElement oracleformtransformed;
	
	@FindBy (xpath = "//div[@class='industries-grid']//h3[text()='Enhancing Operations with Manufacturing Data System']")
	public WebElement enhancing;
	
	
	@FindBy (xpath = "//div[@class='industries-grid']//h3[text()='Modernizing Workforce Ops via System Integration']")
	public WebElement modernizing;
	
	@FindBy (xpath = "//div[@class='industries-grid']//h3[text()='Runway Analysis App Upgraded for Web Access']")
	public WebElement runway;
	

	@FindBy (css = "a[href]")
	public List<WebElement> alllinks;
	
	

}
