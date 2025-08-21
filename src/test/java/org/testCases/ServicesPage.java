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
import org.utility.ServicesUtility;

import com.aventstack.extentreports.Status;

import com.login.LoginDetails;

public class ServicesPage extends LaunchBrowser {
	
	public static ServicesPage services;
	

	@Test(priority = 0, description = "Verify Services page loads successfully")
	public void servicesPageLoad() {
		services = new ServicesPage();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		log.info("Starting Services Page Load");
		getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));
		pom.getInstanceServicePage().servicesPageHeader.click();
		System.out.println(driver.getTitle());

		Assert.assertTrue(services.isPageLoaded(), "Services page should load successfully");
		Assert.assertFalse(driver.getTitle().isEmpty(), "Page title should not be empty");
		log.info("Home page loaded successfully with title: " + driver.getTitle());
		extentTest.log(Status.INFO, "Services page loaded successfully with title: " + driver.getTitle());

	}

	@Test(priority = 1, description = "Verify services main heading is displayed")
	public void servicesMainHeading() {
		services = new ServicesPage();

		log.info("startig Services main Heading");

		WebElement servicesheading = pom.getInstanceServicePage().servicesPageHeading;

		if (servicesheading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(servicesheading));
			String servicesHeadingText = servicesheading.getText();
			Assert.assertFalse(servicesHeadingText.isEmpty(), "Services Main heading should be displayed");
			log.info("Services Main Heading Verified :" + servicesHeadingText);
			String expectedHeading = "Technology Solutions for Business Growth";
			if (servicesHeadingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "Services Page Main Heading is Present");
			}
		}
	}

	
	@Test(priority = 2, description = "Verify Services all links are accessible")

	public void servicesAllLinksAccessibility() {

		log.info("startig Serices Link Accessibility");
		services = new ServicesPage();

		List<WebElement> getServicesAllLink = pom.getInstanceServicePage().servicesAllLinks;
		int ServiceslinkCount = getServicesAllLink.size();
		Assert.assertTrue(ServiceslinkCount > 0, "Services Page should contain links");
		log.info("Total Links Found :" + ServiceslinkCount);
		extentTest.log(Status.INFO, "All links on the Services Page are accessible");

		for (WebElement link : getServicesAllLink) {
			String href = link.getAttribute("href");
			Assert.assertNotNull(href, "Link should have href attribute");
		}
	}
	
	@Test(priority = 3, description = "Verify Services Page Navgation")
	public void servicesPageNavigation() throws InterruptedException {
		
		ServicesUtility.servicesPageNav();
		ServicesUtility.webDevelopmentNav();
		ServicesUtility.mobileAppDevelopment();
		ServicesUtility.appMigrationAndModernization();
		ServicesUtility.productEngineering();
		ServicesUtility.managedITServices();
		ServicesUtility.cloudInfrastructureSolution();
		ServicesUtility.qualityAssurance();
		ServicesUtility.staffAugmentation();
		ServicesUtility.generativeAI();
		
	}







}

