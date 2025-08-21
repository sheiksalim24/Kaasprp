package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrivacyPolicy {

	public WebDriver driver;

	public PrivacyPolicy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//xpath to navigate to the industries page
	@FindBy(xpath = "//div[@class='footer-main']//a[@href='privacy-policy.html']")
	public WebElement privacypolicylink;

	@FindBy(xpath = "//div[@class=\"containers\"]//h1[text()='Privacy Policy']")
	public WebElement privacypolicyheading;

	@FindBy(css = "a[href]")
	public List<WebElement> alllinks;

}
