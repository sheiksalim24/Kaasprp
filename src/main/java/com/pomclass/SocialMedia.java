package com.pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialMedia {

	public WebDriver driver;

	public SocialMedia(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//xpath to navigate to the industries page
	@FindBy(xpath = "//div[@class='social-icons']//a[@href='http://linkedin.com/company/kaaspro-it']")
	public WebElement linkinlink;

	@FindBy(xpath = "//div[@class=\"social-icons\"]//a[@href=\"https://x.com/kaaspro\"]")
	public WebElement xlink;

	@FindBy(xpath = "//div[@class=\"social-icons\"]//a[@href=\"https://www.facebook.com/share/1EHFfCdj73/?mibextid=wwXIfr\"]")
	public WebElement fblink;

	@FindBy(css = "a[href]")
	public List<WebElement> alllinks;

}
