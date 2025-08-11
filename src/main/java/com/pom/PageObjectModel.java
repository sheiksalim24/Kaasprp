package com.pom;

import org.openqa.selenium.WebDriver;

import com.pomclass.ServicesPage;
import com.pomclass.website;

public class PageObjectModel {
	
	private website web;
	private WebDriver driver;
	private ServicesPage services;
	
	public PageObjectModel(WebDriver driver) {
		this.driver= driver;
		
	}
	
	public ServicesPage getInstanceServicePage() {
		if(services == null) {
			services = new ServicesPage(driver);	
		}
	
		return services;

		
	}
	
	

}
