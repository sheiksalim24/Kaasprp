package org.testCases;

import java.time.Duration;
import java.util.List;

import org.launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.login.LoginDetails;

public class Careers extends LaunchBrowser{
	
	public static Careers car;
	
	
	


	@Test(priority = 0, description = " Careers page loads successfully")
	public void careersPageLoad() {

		car = new Careers();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		log.info("Starting Careers Page Load");
		scrollDown();
		waitForElementVisible(pom.getInstanceCareers().careersLink, 20);
		try {
			invisivilityElement(By.id("kaaspro-loader"), 15);
			pom.getInstanceCareers().careersLink.click();
		} catch (Exception e) {
			e.getMessage();
		};
		System.out.println(driver.getTitle());
		
		String expctedCareersUrl = "https://test.kaaspro.com/career.html";
		String actualActualCareersUrl = driver.getCurrentUrl();

		if (expctedCareersUrl.equals(actualActualCareersUrl)) {
			extentTest.log(com.aventstack.extentreports.Status.INFO, "Careers Page Navigation Working Fine");
		} else {
			log.info("Careers Page Navigation not Working");
		}

		Assert.assertTrue(car.isPageLoaded(), "Careers page should load successfully");
		Assert.assertFalse(driver.getTitle().isEmpty(), "Careers Page title should not be empty");
		log.info("Careers page loaded successfully with title: " + driver.getTitle());
		extentTest.log(Status.INFO, "Careers page loaded successfully with title: " + driver.getTitle());

	}
	
	
	@Test(priority = 1, description = "Verify Careers main heading is displayed")
	public void careersHeading() {

		log.info("startig Careers main Heading");
		
		car = new Careers();
		WebElement careersHeading = pom.getInstanceCareers().careersPageHeading;

		try {
			if (careersHeading.isDisplayed()) {
				String careersHeadingText = careersHeading.getText();
				String expectedHeading = "Join Our Team";
				Assert.assertFalse(careersHeadingText.isEmpty(), "Careers Main heading should be displayed");
				log.info("Careers Main Heading Verified :" + careersHeadingText);
				if (careersHeadingText.equals(expectedHeading)) {
					extentTest.log(Status.INFO, "Careers Main Heading is Present");
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@Test(priority = 2, description = "Verify Careers all links are accessible")
	public void migrationModernizationLinksAccessibility() {
		car = new Careers();
		log.info("startig migrationModernization Link Accessibility");

		List<WebElement> getAllLinks = pom.getInstanceCareers().careersAllLink;
		int linkCount = getAllLinks.size();
		Assert.assertTrue(linkCount > 0, "Careers should contain links");
		log.info("careers Total Links Found :" + linkCount);
		extentTest.log(Status.INFO, "All links on the Careers page are accessible");

		for (WebElement link : getAllLinks) {
			String href = link.getAttribute("href");
			Assert.assertNotNull(href, "Link should have href attribute");
		}
	}
	
	






}
