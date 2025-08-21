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

public class ProductEngineering extends LaunchBrowser {

	public ProductEngineering productengineering;
	public ProductEngineering product;
	public ProductEngineering productllink;
	public ProductEngineering migration;
	public ProductEngineering managed;
	
	@Test(priority = 0, description = "Verify partners page load")
	public void productEngineeringLoad() throws InterruptedException {

		log.info("Home Page Load");
		productengineering = new ProductEngineering();
		Thread.sleep(3000);
		
		WebElement footer = pom.getInstanceAboutUs().footer;
	    int footerY = footer.getLocation().getY() - 150;
	    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, arguments[0]);", footerY);
		
	    pom.getInstanceProductEngineering().productengilink.click();
		
		Thread.sleep(10000);
		if (productengineering.equals(isPageLoaded())) {
			log.info("product engineering page should load successfully");
		} else {
			log.info("product engineering page not loaded");
		}
		Assert.assertFalse(driver.getTitle().isEmpty(), "Page title should not be empty");
		log.info("product engineering page loaded successfully with title: " + driver.getTitle());
		extentTest.log(Status.INFO, "Product engineering page loaded successfully with title: " + driver.getTitle());
	}

	@Test(priority = 1, description = "Verify main heading is displayed")
	public void mainHeading() {
		log.info("startig mainHeading");
		product = new ProductEngineering();

		WebElement heading = pom.getInstanceProductEngineering().productengiheading;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Product";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "Product engineering Page Main Heading is Present");
			}
		}
	}

	@Test(priority = 2, description = "Verify all links are accessible")
public void allLinksAccessibility() {
		
		log.info("starting link accessibility");
		productllink = new ProductEngineering();
		List<WebElement> getAllLinks = pom.getInstanceProductEngineering().alllinks;
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
	
	
	@Test(priority = 3, description ="navigating to the application migration page from product engineering page")
	public void health() throws InterruptedException {
		WebElement element = pom.getInstanceProductEngineering().applicationmigrationarrow;

		// Scroll and adjust for sticky headers
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); // optional for stability
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");

		// Wait until it's clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		//pom.getInstanceIndustries().bankingandfinancelink.click();
		Thread.sleep(3000);
		
		migration = new ProductEngineering();
        
		WebElement heading = pom.getInstanceProductEngineering().applicationmigrationheading;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Application Migration &";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			//System.out.println(""+headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "migration Main Heading is Present");
			}else {
				extentTest.log(Status.INFO, "migration Page Main Heading is not Present");
			}
		}
	}
	
	@Test(priority = 4, description ="navigating to the managed IT service page from product engineering")
	public void kumaranSystem() throws InterruptedException {
		driver.navigate().back();
        Thread.sleep(3000);
		WebElement element = pom.getInstanceProductEngineering().managedarrow;

		// Scroll and adjust for sticky headers
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); // optional for stability
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");

		// Wait until it's clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		//pom.getInstanceIndustries().bankingandfinancelink.click();
		Thread.sleep(3000);
		
		managed = new ProductEngineering();

		WebElement heading = pom.getInstanceProductEngineering().managedheading;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Managed IT";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			//System.out.println(""+headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "Managed IT service page Main Heading is Present");
			}else {
				extentTest.log(Status.INFO, "Managed IT service Page Main Heading is not Present");
			}
		}
	}
}
