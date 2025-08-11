package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
public WebDriver driver;
	
	public HomePage() {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	

}
