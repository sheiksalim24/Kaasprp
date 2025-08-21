package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffAugmentation {

	public WebDriver driver;

	public StaffAugmentation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//xpath to navigate to the industries page
	@FindBy(xpath = "//div[@class='footer-main']//a[@href='staff-augmentation.html']")
	public WebElement staffaugmentationlink;

	@FindBy(xpath = "//div[@class='hero-content']//h1[text()='Staff ']")
	public WebElement staffaugmentationheading;

	@FindBy(xpath = "(//div[@class='card-arrow'])[1]")
	public WebElement qualityassurancearrow;

	@FindBy(xpath = "(//div[@class='card-arrow'])[2]")
	public WebElement generateaiarrow;

	@FindBy(xpath = "//div[@class='hero-content']//h1[text()='Quality Assurance & ']")
	public WebElement qualityassuranceheading;

	@FindBy(xpath = "//div[@class='hero-content']//h1[text()='Generative AI ']")
	public WebElement generateaiheading;

	@FindBy(css = "a[href]")
	public List<WebElement> alllinks;

}
