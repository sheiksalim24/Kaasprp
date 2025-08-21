package org.testCases;

import java.time.Duration;
import java.util.List;

import org.launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.login.LoginDetails;

public class MigrationAndModernization extends LaunchBrowser {

	public MigrationAndModernization mm;

	@Test(priority = 0, description = "Verify MigrationAndModernization page loads successfully")
	public void migrationAndModernizationPageLoad() {

		mm = new MigrationAndModernization();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		log.info("Starting MigrationAndModernization Page Load");

		try {

			scrollDown();
			invisivilityElement(By.id("kaaspro-loader"), 15);

			pom.getInstanceMigrationAndModernixation().migAndModernLink.click();
			Thread.sleep(3000);
			System.out.println(driver.getTitle());
		} catch (Exception e) {
			log.info(e.getMessage());
		}

		String expctedMigAndModernUrl = "https://test.kaaspro.com/legacy-modernization.html";
		String actualMigAndModernUrl = driver.getCurrentUrl();

		if (expctedMigAndModernUrl.equals(actualMigAndModernUrl)) {
			extentTest.log(com.aventstack.extentreports.Status.INFO,
					"Migration & Modernization Page Navigation Working Fine");
		} else {
			log.info("Migration & Modernization Page Navigation not Working");
		}

		Assert.assertTrue(mm.isPageLoaded(), "MigrationAndModernization page should load successfully");
		Assert.assertFalse(driver.getTitle().isEmpty(), "MigrationAndModernization Page title should not be empty");
		log.info("MigrationAndModernization page loaded successfully with title: " + driver.getTitle());
		extentTest.log(Status.INFO,
				"MigrationAndModernization page loaded successfully with title: " + driver.getTitle());

	}

	@Test(priority = 1, description = "Verify MigrationAndModernization main heading is displayed")
	public void migrationAndModernizationHeading() {

		log.info("startig MigrationAndModernization main Heading");
		mm = new MigrationAndModernization();

		WebElement MigAndModernheading = pom.getInstanceMigrationAndModernixation().migAndModernHeading;

		try {
			if (MigAndModernheading.isDisplayed()) {
				String MigAndModernheadingText = MigAndModernheading.getText();
				String expectedHeading = "Application Migration & Modernization";
				Assert.assertFalse(MigAndModernheadingText.isEmpty(),
						"MigrationAndModernization Main heading should be displayed");
				log.info("MIgration & Modernization Main Heading Verified :" + MigAndModernheadingText);
				if (MigAndModernheadingText.equals(expectedHeading)) {
					extentTest.log(Status.INFO, "MigrationAndModernization Main Heading is Present");
				}
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	@Test(priority = 2, description = "Verify MigrationAndModernization all links are accessible")
	public void migrationModernizationLinksAccessibility() {

		log.info("startig migrationModernization Link Accessibility");
		mm = new MigrationAndModernization();

		List<WebElement> getAllLinks = pom.getInstanceMigrationAndModernixation().migModernPageAllLink;
		int linkCount = getAllLinks.size();
		Assert.assertTrue(linkCount > 0, "MigrationModernizationPage should contain links");
		log.info("MigrationModernization Total Links Found :" + linkCount);
		extentTest.log(Status.INFO, "All links on the MigrationModernization page are accessible");

		for (WebElement link : getAllLinks) {
			String href = link.getAttribute("href");
			Assert.assertNotNull(href, "Link should have href attribute");
		}
	}

}
