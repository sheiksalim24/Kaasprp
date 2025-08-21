package org.testCases;

import java.time.Duration;
import java.util.List;

import org.launch.LaunchBrowser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class StaffAugmentation extends LaunchBrowser {

	public StaffAugmentation staffaugmentation;
	public StaffAugmentation staff;
	public StaffAugmentation stafflink;
	public StaffAugmentation qualityassurance;
	public StaffAugmentation generateai;

	@Test(priority = 0, description = "Verify staff augmentation load")
	public void staffAugmentationload() throws InterruptedException {

		log.info("Home Page Load");
		staffaugmentation = new StaffAugmentation();
		Thread.sleep(3000);

		WebElement footer = pom.getInstanceAboutUs().footer;
		int footerY = footer.getLocation().getY() - 150;
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, arguments[0]);", footerY);

		pom.getInstanceStaffAugmentation().staffaugmentationlink.click();

		Thread.sleep(10000);
		if (staffaugmentation.equals(isPageLoaded())) {
			log.info("Staff Augmentation page should load successfully");
		} else {
			log.info("Staff Augmentation page not loaded");
		}
		Assert.assertFalse(driver.getTitle().isEmpty(), "Page title should not be empty");
		log.info("staff augmentation page loaded successfully with title: " + driver.getTitle());
		extentTest.log(Status.INFO, "staff augmentation page loaded successfully with title: " + driver.getTitle());
	}

	@Test(priority = 1, description = "Verify main heading is displayed")
	public void mainHeading() {
		log.info("startig mainHeading");
		staff = new StaffAugmentation();

		WebElement heading = pom.getInstanceStaffAugmentation().staffaugmentationheading;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Staff";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "Staff augmentation Page Main Heading is Present");
			}
		}
	}

	@Test(priority = 2, description = "Verify all links are accessible")
	public void allLinksAccessibility() {

		log.info("starting link accessibility");
		stafflink = new StaffAugmentation();
		List<WebElement> getAllLinks = pom.getInstanceStaffAugmentation().alllinks;
		int linkCount = getAllLinks.size();
		Assert.assertTrue(linkCount > 0, "page should contain links");
		log.info("total links found:" + linkCount);
		extentTest.log(Status.INFO, "all links on the staff augmentation page are accessible");
		extentTest.log(Status.INFO, "Total links" + linkCount);
		for (WebElement link : getAllLinks) {
			String href = link.getAttribute("href");
			Assert.assertNotNull(href, "link should have href attributes");
		}

	}

	@Test(priority = 3, description = "navigating to the quality assurance page from staff augmentation page")
	public void qualityAssurance() throws InterruptedException {
		WebElement element = pom.getInstanceStaffAugmentation().qualityassurancearrow;

		// Scroll and adjust for sticky headers
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); // optional for stability
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");

		// Wait until it's clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		// pom.getInstanceIndustries().bankingandfinancelink.click();
		Thread.sleep(3000);

		qualityassurance = new StaffAugmentation();

		WebElement heading = pom.getInstanceStaffAugmentation().qualityassuranceheading;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Quality Assurance &";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			// System.out.println(""+headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "quality assurance Heading is Present");
			} else {
				extentTest.log(Status.INFO, "quality assurance Page Main Heading is not Present");
			}
		}
	}

	@Test(priority = 4, description = "navigating to the generate AI solution page from staff augmentation")
	public void generateAi() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(3000);
		WebElement element = pom.getInstanceStaffAugmentation().generateaiarrow;

		// Scroll and adjust for sticky headers
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); // optional for stability
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");

		// Wait until it's clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		// pom.getInstanceIndustries().bankingandfinancelink.click();
		Thread.sleep(3000);

		generateai = new StaffAugmentation();

		WebElement heading = pom.getInstanceStaffAugmentation().generateaiheading;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Generative AI";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			// System.out.println(""+headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "Generate AI solution page Main Heading is Present");
			} else {
				extentTest.log(Status.INFO, "Generate AI solution Page Main Heading is not Present");
			}
		}
	}

}
