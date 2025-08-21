package org.testCases;

import static org.testng.AssertJUnit.assertTrue;
import java.time.Duration;
import java.util.List;

import org.launch.LaunchBrowser;
import com.login.LoginDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class AboutUs extends LaunchBrowser {

	public AboutUs aboutus;
		

	@Test(priority = 0, description = "Verify aboutus page load")
	public void aboutUs() throws InterruptedException {

		log.info("Home Page Load");
		aboutus = new AboutUs();
		Thread.sleep(3000);
		pom.getInstanceAboutUs().aboutus.click();
		Thread.sleep(10000);
		if (aboutus.equals(isPageLoaded())) {
			log.info("aboutus page should load successfully");
		} else {
			log.info("aboutus page not loaded");
		}
		Assert.assertFalse(driver.getTitle().isEmpty(), "Page title should not be empty");
		log.info("aboutus page loaded successfully with title: " + driver.getTitle());
		extentTest.log(Status.INFO, "aboutus page loaded successfully with title: " + driver.getTitle());
	}

	@Test(priority = 1, description = "Verify main heading is displayed")
	public void mainHeading() {
		log.info("startig mainHeading");
		aboutus = new AboutUs();

		WebElement heading = pom.getInstanceAboutUs().aboutusheading;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Building the Future of";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "Aboutus page Main Heading is Present");
			}
		}
	}

	@Test(priority = 2, description = "Verify all links are accessible")
public void allLinksAccessibility() {
		
		log.info("starting link accessibility");
		aboutus = new AboutUs();
		List<WebElement> getAllLinks = pom.getInstanceAboutUs().alllinks;
		int linkCount = getAllLinks.size();
		Assert.assertTrue(linkCount > 0, "page should contain links");
	    log.info("total links found:" + linkCount);
		extentTest.log(Status.INFO, "all links on the aboutus page are accessible");
		extentTest.log(Status.INFO, "Total links" + linkCount);
		for(WebElement link : getAllLinks) {
			String href = link.getAttribute("href");
			Assert.assertNotNull(href,"link should have href attributes");
		}
		
	}
	
	
	@Test(priority = 3, description ="navigating to the our location page from aboutus")
	public void ourLocation() throws InterruptedException {
		WebElement element = pom.getInstanceAboutUs().aol;

		// Scroll and adjust for sticky headers
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); // optional for stability
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");

		// Wait until it's clickable
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

			    //  Use JavaScript to click the LinkedIn link (avoids iframe interception)
			    WebElement click = pom.getInstanceAboutUs().aol;
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);
		
		aboutus = new AboutUs();
        
		Thread.sleep(5000);
		WebElement heading = pom.getInstanceAboutUs().ourlocationtext;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Our Global Presence";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			//System.out.println(""+headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "our location page Main Heading is Present");
			}else {
				extentTest.log(Status.INFO, "our location Page Main Heading is not Present");
			}
		}
	}
	
	@Test(priority = 4, description ="navigating to leadership page from aboutus")
	public void leaderShip() throws InterruptedException {
		driver.navigate().back();
        Thread.sleep(3000);
		WebElement element = pom.getInstanceAboutUs().als;

		// Scroll and adjust for sticky headers
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); // optional for stability
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");

		// Wait until it's clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

	    //  Use JavaScript to click the LinkedIn link (avoids iframe interception)
	    WebElement click = pom.getInstanceAboutUs().als;
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);
		
		aboutus = new AboutUs();

		Thread.sleep(5000);
		WebElement heading = pom.getInstanceAboutUs().leadershiptext;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Meet Our Leadership Team";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			//System.out.println(""+headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "leadership Page Main Heading is Present");
			}else {
				extentTest.log(Status.INFO, "leadership Page Main Heading is not Present");
			}
		}
	}
	
	
	
	
}