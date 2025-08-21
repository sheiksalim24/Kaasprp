package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact {
	
	WebDriver driver;
	public Contact(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[text()='Contact']")
	public WebElement contactLink;
	
	@FindBy (xpath = "//h2[text()='Have Questions?']")
	public WebElement contactPageHeading;
	
	@FindBy (css = "a[href]")
	public List<WebElement> contactAllLinks;
	
	@FindBy (xpath = "//input[@id='name']")
	public WebElement nameField;
	
	@FindBy (xpath = "//input[@id='email']")
	public WebElement emailField;
	
	@FindBy (xpath = "//select[@id='country-code']")
	public WebElement countryDropdown;
	
	@FindBy (xpath = "//input[@id='phone']")
	public WebElement phoneNumberField;
	
	@FindBy (tagName = "textarea")
	public WebElement messageField;
	
	@FindBy (xpath = "//button[@id='submitBtn']")
	public WebElement submitButton;
	
	@FindBy (xpath = "//div[@class='popup-content']")
	public WebElement succesPopup;
	
	@FindBy (xpath = "//button[@id='closePopup']")
	public WebElement successPopupOkayBtn;
	
	

	
	
	
	
	
	
	
	
	
	
	
	

}
