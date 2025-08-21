package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Industries {
	
public WebDriver driver;
	
	public Industries(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
//xpath to navigate to the industries page
	@FindBy (xpath = "(//ul[@class=\"nav-links\"]//a[@id=\"service-link\"])[1]")
	public WebElement industriesclick;
	
//xpath to the links on the industries page
	@FindBy (xpath = "//div[text()='Industry Focused ']")
	public WebElement industriestext;
	
	@FindBy (xpath = "(//div[@class=\"industry-content\"])[1]")
	public WebElement bankingandfinancelink;
	
	@FindBy (xpath = "(//div[@class=\"industry-content\"])[2]")
	public WebElement manufacturinglink;
	
	@FindBy (xpath = "(//div[@class=\"industry-content\"])[3]")
	public WebElement transportationandlogisticslink;
	
	@FindBy (xpath = "(//div[@class=\"industry-content\"])[4]")
	public WebElement healthcarelink;
	
	@FindBy (xpath = "(//div[@class=\"industry-content\"])[5]")
	public WebElement insurancelink;
	
	@FindBy (xpath = "(//div[@class=\"industry-content\"])[6]")
	public WebElement retaillink;
	
	@FindBy (xpath = "(//div[@class=\"industry-content\"])[7]")
	public WebElement educationlink;
	
	@FindBy (xpath = "(//div[@class=\"industry-content\"])[8]")
	public WebElement publicsectorlink;
	
	@FindBy (xpath = "(//div[@class='card-arrow'])[1]")
	public WebElement productengiearrow;
	
	@FindBy (xpath = "(//div[@class=\"card-arrow\"])[2]")
	public WebElement applicationmigrationarrow;
	
//banking & finance page xpath
	@FindBy (xpath = "//div[@class='hero-content']//h1[text()='Banking & ']")
	public WebElement bankingfinanceheading;

	@FindBy (xpath = "(//div[@class=\"card-arrow\"])[1]")
	public WebElement publicsector;
	
	@FindBy (xpath = "//div[@class=\"hero-content\"]")
	public WebElement manufacturing;
	

//Manufacturing xpath
	@FindBy (xpath = "//div[@class='hero-content']//h1[text()='Manufacturing ']")
	public WebElement manufacturingheading;
	
	@FindBy (xpath = "//div[@class='card-arrow']//img[@alt='Go to Banking & Finance']")
	public WebElement bankingfinancearrow;
	
	@FindBy (xpath = "//div[@class='card-arrow']//img[@alt='Go to Transportation & Logistics']")
	public WebElement transportationarrow;
	
//transportation & logistics	
	@FindBy (xpath = "//div[@class='hero-content']//h1[text()='Transportation & ']")
	public WebElement transportationheading;
	
	@FindBy (xpath = "//div[@class='card-arrow']//img[@alt='Go to Manufacturing']")
	public WebElement manufacturingarrow;
	
	@FindBy (xpath = "//div[@class='card-arrow']//img[@alt='Go to Healthcare']")
	public WebElement healthcarearrow;
	
//healthcare innovation
	@FindBy (xpath = "//div[@class=\"hero-content\"]//h1[text()='Healthcare ']")
	public WebElement healthcareheading;
	
	@FindBy (xpath = "//div[@class='card-arrow']//img[@alt='Go to Insurance']")
	public WebElement insurancearrow;
	
//insurance
	@FindBy (xpath = "//div[@class=\"hero-content\"]//h1[text()='Insurance ']")
	public WebElement insuranceheading;
	
	@FindBy (xpath = "//div[@class='card-arrow']//img[@alt='Go to Retail']")
	public WebElement retailarrow;
	
//retails
	@FindBy (xpath = "//div[@class='hero-content']//h1[text()='Retail ']")
	public WebElement retailheading;

	@FindBy (xpath = "//div[@class='card-arrow']//img[@alt='Go to Education']")
	public WebElement educationarrow;
	
//education
	@FindBy (xpath = "//div[@class=\"hero-content\"]//h1[text()='Education ']")
	public WebElement educationheading;
	
	@FindBy (xpath = "//div[@class='card-arrow']//img[@alt='Go to Public Sector']")
	public WebElement publicsetorarrow;
	
	
//public sector page xpath 
	@FindBy (xpath = "//div[@class='hero-content']//h1[text()='Public Sector ']")
	public WebElement publicsectorheading;
		
		
	@FindBy (xpath = "//div[@class='card-arrow']//img[@alt='Go to Banking & Finance']")
	public WebElement bankingandfinancearrow;
	
	@FindBy (css = "a[href]")
	public List<WebElement> alllinks;
	
	@FindBy (xpath = "//div[@class=\"hero-content\"]//h1[text()='Product ']")
	public WebElement productheading;

}
