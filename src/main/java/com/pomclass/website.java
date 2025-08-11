package com.pomclass;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class website {
	
	public WebDriver driver;
	
	public website() {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
