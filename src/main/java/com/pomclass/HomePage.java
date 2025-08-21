package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='landing-link']")
	public WebElement HomepageLink;

	@FindBy(xpath = "//h4[@id='typing-text']")
	public WebElement mainHeadingText;

	@FindBy(css = "a[href]")
	public List<WebElement> allLinks;

	@FindBy(xpath = "//h4[@id='typing-text']")
	public WebElement mainHeading;

	@FindBy(xpath = "//div[@class='card-grid main-cards']/a[1]/div[1]")
	public WebElement caseStudiesBox;

	@FindBy(xpath = "//div[@class='card-grid main-cards']/a[2]/div[1]")
	public WebElement whitePappersBox;

	@FindBy(xpath = "/html/body/section/div/div")
	public WebElement caseStudyPageHeading;

}
