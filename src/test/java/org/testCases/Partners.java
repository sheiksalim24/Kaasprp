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

public class Partners extends LaunchBrowser {
	
	public Partners partners;
	public Partners health;
	public Partners kumaran;
	public Partners rocketfinance;
	public Partners banking;
	
	@Test(priority = 0, description = "Verify partners page load")
	public void partnersLoad() throws InterruptedException {

		log.info("Home Page Load");
		partners = new Partners();
		Thread.sleep(3000);
		pom.getInstancePartners().partnersclick.click();
		Thread.sleep(10000);
		if (partners.equals(isPageLoaded())) {
			log.info("partners page should load successfully");
		} else {
			log.info("partners page not loaded");
		}
		Assert.assertFalse(driver.getTitle().isEmpty(), "Page title should not be empty");
		log.info("partners page loaded successfully with title: " + driver.getTitle());
		extentTest.log(Status.INFO, "Partners page loaded successfully with title: " + driver.getTitle());
	}

	@Test(priority = 1, description = "Verify main heading is displayed")
	public void mainHeading() {
		log.info("startig mainHeading");
		partners = new Partners();

		WebElement heading = pom.getInstancePartners().partnersheading;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Trusted";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "Industries Page Main Heading is Present");
			}
		}
	}

	@Test(priority = 2, description = "Verify all links are accessible")
public void allLinksAccessibility() {
		
		log.info("starting link accessibility");
		partners = new Partners();
		List<WebElement> getAllLinks = pom.getInstancePartners().alllinks;
		int linkCount = getAllLinks.size();
		Assert.assertTrue(linkCount > 0, "page should contain links");
	    log.info("total links found:" + linkCount);
		extentTest.log(Status.INFO, "all links on the partners page are accessible");
		extentTest.log(Status.INFO, "Total links" + linkCount);
		for(WebElement link : getAllLinks) {
			String href = link.getAttribute("href");
			Assert.assertNotNull(href,"link should have href attributes");
		}
		
	}
	
	
	@Test(priority = 3, description ="navigating to the 75health page from partners")
	public void health() throws InterruptedException {
		WebElement element = pom.getInstancePartners().healthlink;

		// Scroll and adjust for sticky headers
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); // optional for stability
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");

		// Wait until it's clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		//pom.getInstanceIndustries().bankingandfinancelink.click();
		Thread.sleep(3000);
		
		health = new Partners();
        
		WebElement heading = pom.getInstancePartners().healthheading;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Transforming Healthcare with";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			//System.out.println(""+headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "75health Page Main Heading is Present");
			}else {
				extentTest.log(Status.INFO, "75health Page Main Heading is not Present");
			}
		}
	}
	
	@Test(priority = 4, description ="navigating to the kumaran system page from partners")
	public void kumaranSystem() throws InterruptedException {
		driver.navigate().back();
        Thread.sleep(3000);
		WebElement element = pom.getInstancePartners().kumaranlink;

		// Scroll and adjust for sticky headers
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); // optional for stability
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");

		// Wait until it's clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		//pom.getInstanceIndustries().bankingandfinancelink.click();
		Thread.sleep(3000);
		
		kumaran = new Partners();

		WebElement heading = pom.getInstancePartners().kumaranheading;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Digital Transformation with";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			//System.out.println(""+headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "Kumaran system Page Main Heading is Present");
			}else {
				extentTest.log(Status.INFO, "Kumaran system Page Main Heading is not Present");
			}
		}
	}
	
	@Test(priority = 5, description ="navigating to the rocket finance page from partners")
	public void rocketFinance() throws InterruptedException {
		driver.navigate().back();
        Thread.sleep(3000);
		WebElement element = pom.getInstancePartners().rocketfinancelink;

		// Scroll and adjust for sticky headers
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); // optional for stability
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");

		// Wait until it's clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		//pom.getInstanceIndustries().bankingandfinancelink.click();
		Thread.sleep(3000);
		
		rocketfinance = new Partners();

		WebElement heading = pom.getInstancePartners().rocketfinanceheading;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Financial Innovation with";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			//System.out.println(""+headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "Rocketfinance Page Main Heading is Present");
			}else {
				extentTest.log(Status.INFO, "Rocketfinance Page Main Heading is not Present");
			}
		}
	}
	
	@Test(priority = 6, description ="navigating to the banking page from partners")
	public void banking() throws InterruptedException {
		driver.navigate().back();
        Thread.sleep(3000);
		WebElement element = pom.getInstancePartners().bankingarrow;

		// Scroll and adjust for sticky headers
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); // optional for stability
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");

		// Wait until it's clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		//pom.getInstanceIndustries().bankingandfinancelink.click();
		Thread.sleep(3000);
		
		banking = new Partners();

		WebElement heading = pom.getInstanceIndustries().bankingfinanceheading;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Banking &";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			//System.out.println(""+headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "banking and finance Page Main Heading is Present");
			}else {
				extentTest.log(Status.INFO, "banking and finance Page Main Heading is not Present");
			}
		}
	}
	
	@Test(priority = 7, description ="navigating to the healthcare from partners")
	public void healthCare() throws InterruptedException {
		driver.navigate().back();
        Thread.sleep(3000);
		WebElement element = pom.getInstancePartners().healthcarearrow;

		// Scroll and adjust for sticky headers
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); // optional for stability
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");

		// Wait until it's clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		//pom.getInstanceIndustries().bankingandfinancelink.click();
		Thread.sleep(3000);
		
		health = new Partners();

		WebElement heading = pom.getInstanceIndustries().healthcareheading;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Healthcare";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			//System.out.println(""+headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "Healthcare Page Main Heading is Present");
			}else {
				extentTest.log(Status.INFO, "Healthcare Page Main Heading is not Present");
			}
		}
	}

}
