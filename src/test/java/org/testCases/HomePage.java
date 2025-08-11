package org.testCases;

import org.launch.LaunchBrowser;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.login.LoginDetails;

public class HomePage extends LaunchBrowser{
	
	
	
	@Test
	public void HomePageVerification() {
		
		LoginDetails.openUrl();
		
		String expectedUrl = "https://test.kaaspro.com/";
		String actualUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(expectedUrl, actualUrl, "Url Does not match");
		log.info("You are here in Home Page");
		extentTest.log(Status.INFO, "HomePage Displayed");
	}
	
	

}
