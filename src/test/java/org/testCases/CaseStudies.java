package org.testCases;

import java.time.Duration;
import java.util.List;

import org.launch.LaunchBrowser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.login.LoginDetails;

public class CaseStudies extends LaunchBrowser {

	public CaseStudies casestudies;
	public CaseStudies firstnames;
	


	@Test(priority = 0, description = "Verify cases studies load")
	public void casestudiesload() throws InterruptedException {

		log.info("Home Page Load");
		casestudies = new CaseStudies();
		Thread.sleep(3000);

		try {
			
			WebElement footer = pom.getInstanceAboutUs().footer;
			int footerY = footer.getLocation().getY() - 150;
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, arguments[0]);", footerY);
			invisivilityElement(By.id("kaaspro-loader"), 20);
			pom.getInstanceCaseStudies().casestudieslink.click();
			
		} catch (Exception e) {
			e.getMessage();
		}

		Thread.sleep(10000);
		if (casestudies.equals(isPageLoaded())) {
			log.info("case studies page should load successfully");
		} else {
			log.info("cases studies page not loaded");
		}
		Assert.assertFalse(driver.getTitle().isEmpty(), "Page title should not be empty");
		log.info("case studies page loaded successfully with title: " + driver.getTitle());
		extentTest.log(Status.INFO, "cases studies page loaded successfully with title: " + driver.getTitle());
	}

	@Test(priority = 1, description = "Verify main heading is displayed")
	public void mainHeading() {
		log.info("startig mainHeading");
		casestudies = new CaseStudies();

		WebElement heading = pom.getInstanceCaseStudies().casestudiesheading;

		try {
			
			if (heading.isDisplayed()) {
				getWait().until(ExpectedConditions.visibilityOf(heading));
				String headingText = heading.getText();
				String expectedHeading = "Success";
				Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
				log.info("Main Heading Verified :" + headingText);
				if (headingText.equals(expectedHeading)) {
					extentTest.log(Status.INFO, "cases studies Page Main Heading is Present");
				}
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test(priority = 2, description = "Verify all links are accessible")
	public void allLinksAccessibility() {

		log.info("starting link accessibility");
		casestudies = new CaseStudies();
		try {
			
			List<WebElement> getAllLinks = pom.getInstanceCaseStudies().alllinks;
			int linkCount = getAllLinks.size();
			Assert.assertTrue(linkCount > 0, "page should contain links");
			log.info("total links found:" + linkCount);
			extentTest.log(Status.INFO, "all links on the case studies page are accessible");
			extentTest.log(Status.INFO, "Total links" + linkCount);
			for (WebElement link : getAllLinks) {
				String href = link.getAttribute("href");
				Assert.assertNotNull(href, "link should have href attributes");
			}
			
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Test(priority = 3, description = "Downloading healthcare tech case studies")
	public void healthcareCaseStudies() throws InterruptedException {
		
		invisivilityElement(By.id("kaaspro-loader"), 20);
		WebElement element = pom.getInstanceCaseStudies().healthcaretech;

		scrollToElement(element);
		
		// Wait until it's clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement click = pom.getInstanceCaseStudies().healthcaretech;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);

		pom.getInstanceCaseStudies().fn.sendKeys("ra");
		pom.getInstanceCaseStudies().ln.sendKeys("hul");
		pom.getInstanceCaseStudies().mail.sendKeys("test@test.in");
		pom.getInstanceCaseStudies().mobile.sendKeys("9658475147");
		pom.getInstanceCaseStudies().company.sendKeys("test");
		pom.getInstanceCaseStudies().industry.sendKeys("test");
		pom.getInstanceCaseStudies().job.sendKeys("test");
		pom.getInstanceCaseStudies().message.sendKeys("test");
		pom.getInstanceCaseStudies().downloadbutton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());

		// Then handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test(priority = 4, description = "Downloading Migrating VB6 App to .NET Core case studies")
	public void migrationCaseStudies() throws InterruptedException {
		WebElement element = pom.getInstanceCaseStudies().healthcaretech;

		// Scroll and adjust for sticky headers
		scrollToElement(element);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement click = pom.getInstanceCaseStudies().migrating;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);

		pom.getInstanceCaseStudies().fn.sendKeys("ra");
		pom.getInstanceCaseStudies().ln.sendKeys("hul");
		pom.getInstanceCaseStudies().mail.sendKeys("test@test.in");
		pom.getInstanceCaseStudies().mobile.sendKeys("9658475147");
		pom.getInstanceCaseStudies().company.sendKeys("test");
		pom.getInstanceCaseStudies().industry.sendKeys("test");
		pom.getInstanceCaseStudies().job.sendKeys("test");
		pom.getInstanceCaseStudies().message.sendKeys("test");
		pom.getInstanceCaseStudies().downloadbutton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());

		// Then handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	@Test(priority = 5, description = "Downloading Ubuntu Upgrade: 14.04 to 22.04 Transition case studies")
	public void ubuntuUpgrade() throws InterruptedException {
		WebElement element = pom.getInstanceCaseStudies().ubuntuupgrade;

		// Scroll and adjust for sticky headers
		scrollToElement(element);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement click = pom.getInstanceCaseStudies().ubuntuupgrade;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);

		pom.getInstanceCaseStudies().fn.sendKeys("ra");
		pom.getInstanceCaseStudies().ln.sendKeys("hul");
		pom.getInstanceCaseStudies().mail.sendKeys("test@test.in");
		pom.getInstanceCaseStudies().mobile.sendKeys("9658475147");
		pom.getInstanceCaseStudies().company.sendKeys("test");
		pom.getInstanceCaseStudies().industry.sendKeys("test");
		pom.getInstanceCaseStudies().job.sendKeys("test");
		pom.getInstanceCaseStudies().message.sendKeys("test");
		pom.getInstanceCaseStudies().downloadbutton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());

		// Then handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	@Test(priority = 6, description = "Downloading Oracle Forms Migration to Java case studies")
	public void oracleForms() throws InterruptedException {
		WebElement element = pom.getInstanceCaseStudies().oracleform;

		// Scroll and adjust for sticky headers
		scrollToElement(element);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement click = pom.getInstanceCaseStudies().oracleform;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);

		pom.getInstanceCaseStudies().fn.sendKeys("ra");
		pom.getInstanceCaseStudies().ln.sendKeys("hul");
		pom.getInstanceCaseStudies().mail.sendKeys("test@test.in");
		pom.getInstanceCaseStudies().mobile.sendKeys("9658475147");
		pom.getInstanceCaseStudies().company.sendKeys("test");
		pom.getInstanceCaseStudies().industry.sendKeys("test");
		pom.getInstanceCaseStudies().job.sendKeys("test");
		pom.getInstanceCaseStudies().message.sendKeys("test");
		pom.getInstanceCaseStudies().downloadbutton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());

		// Then handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	@Test(priority = 7, description = "Downloading Scalable & Secure Lending App case studies")
	public void scalableAndSecure() throws InterruptedException {
		WebElement element = pom.getInstanceCaseStudies().scalable;

		// Scroll and adjust for sticky headers
		scrollToElement(element);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement click = pom.getInstanceCaseStudies().scalable;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);

		pom.getInstanceCaseStudies().fn.sendKeys("ra");
		pom.getInstanceCaseStudies().ln.sendKeys("hul");
		pom.getInstanceCaseStudies().mail.sendKeys("test@test.in");
		pom.getInstanceCaseStudies().mobile.sendKeys("9658475147");
		pom.getInstanceCaseStudies().company.sendKeys("test");
		pom.getInstanceCaseStudies().industry.sendKeys("test");
		pom.getInstanceCaseStudies().job.sendKeys("test");
		pom.getInstanceCaseStudies().message.sendKeys("test");
		pom.getInstanceCaseStudies().downloadbutton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());

		// Then handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	@Test(priority = 8, description = "Downloading Modernizing Sales Insights via Reverse Engineering case studies")
	public void modernizingSales() throws InterruptedException {
		WebElement element = pom.getInstanceCaseStudies().modernizingscales;

		// Scroll and adjust for sticky headers
		scrollToElement(element);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement click = pom.getInstanceCaseStudies().modernizingscales;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);

		pom.getInstanceCaseStudies().fn.sendKeys("ra");
		pom.getInstanceCaseStudies().ln.sendKeys("hul");
		pom.getInstanceCaseStudies().mail.sendKeys("test@test.in");
		pom.getInstanceCaseStudies().mobile.sendKeys("9658475147");
		pom.getInstanceCaseStudies().company.sendKeys("test");
		pom.getInstanceCaseStudies().industry.sendKeys("test");
		pom.getInstanceCaseStudies().job.sendKeys("test");
		pom.getInstanceCaseStudies().message.sendKeys("test");
		pom.getInstanceCaseStudies().downloadbutton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());

		// Then handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	@Test(priority = 9, description = "Downloading Legacy to Central: Student Info System Upgrade case studies")
	public void legacy() throws InterruptedException {
		WebElement element = pom.getInstanceCaseStudies().legacytocentral;

		// Scroll and adjust for sticky headers
		scrollToElement(element);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement click = pom.getInstanceCaseStudies().legacytocentral;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);

		pom.getInstanceCaseStudies().fn.sendKeys("ra");
		pom.getInstanceCaseStudies().ln.sendKeys("hul");
		pom.getInstanceCaseStudies().mail.sendKeys("test@test.in");
		pom.getInstanceCaseStudies().mobile.sendKeys("9658475147");
		pom.getInstanceCaseStudies().company.sendKeys("test");
		pom.getInstanceCaseStudies().industry.sendKeys("test");
		pom.getInstanceCaseStudies().job.sendKeys("test");
		pom.getInstanceCaseStudies().message.sendKeys("test");
		pom.getInstanceCaseStudies().downloadbutton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());

		// Then handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	@Test(priority = 10, description = "Downloading Oracle Forms Transformed for the Future case studies")
	public void oracleForm() throws InterruptedException {
		WebElement element = pom.getInstanceCaseStudies().oracleformtransformed;

		// Scroll and adjust for sticky headers
		scrollToElement(element);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement click = pom.getInstanceCaseStudies().oracleformtransformed;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);

		pom.getInstanceCaseStudies().fn.sendKeys("ra");
		pom.getInstanceCaseStudies().ln.sendKeys("hul");
		pom.getInstanceCaseStudies().mail.sendKeys("test@test.in");
		pom.getInstanceCaseStudies().mobile.sendKeys("9658475147");
		pom.getInstanceCaseStudies().company.sendKeys("test");
		pom.getInstanceCaseStudies().industry.sendKeys("test");
		pom.getInstanceCaseStudies().job.sendKeys("test");
		pom.getInstanceCaseStudies().message.sendKeys("test");
		pom.getInstanceCaseStudies().downloadbutton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());

		// Then handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	@Test(priority = 11, description = "Downloading Enhancing Operations with Manufacturing Data System case studies")
	public void enhancingOperations() throws InterruptedException {
		WebElement element = pom.getInstanceCaseStudies().enhancing;

		// Scroll and adjust for sticky headers
		scrollToElement(element);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement click = pom.getInstanceCaseStudies().enhancing;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);

		pom.getInstanceCaseStudies().fn.sendKeys("ra");
		pom.getInstanceCaseStudies().ln.sendKeys("hul");
		pom.getInstanceCaseStudies().mail.sendKeys("test@test.in");
		pom.getInstanceCaseStudies().mobile.sendKeys("9658475147");
		pom.getInstanceCaseStudies().company.sendKeys("test");
		pom.getInstanceCaseStudies().industry.sendKeys("test");
		pom.getInstanceCaseStudies().job.sendKeys("test");
		pom.getInstanceCaseStudies().message.sendKeys("test");
		pom.getInstanceCaseStudies().downloadbutton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());

		// Then handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	@Test(priority = 12, description = "Downloading Modernizing Workforce Ops via System Integration case studies")
	public void modernizingWorkForce() throws InterruptedException {
		WebElement element = pom.getInstanceCaseStudies().modernizing;

		// Scroll and adjust for sticky headers
		scrollToElement(element);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement click = pom.getInstanceCaseStudies().modernizing;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);

		pom.getInstanceCaseStudies().fn.sendKeys("ra");
		pom.getInstanceCaseStudies().ln.sendKeys("hul");
		pom.getInstanceCaseStudies().mail.sendKeys("test@test.in");
		pom.getInstanceCaseStudies().mobile.sendKeys("9658475147");
		pom.getInstanceCaseStudies().company.sendKeys("test");
		pom.getInstanceCaseStudies().industry.sendKeys("test");
		pom.getInstanceCaseStudies().job.sendKeys("test");
		pom.getInstanceCaseStudies().message.sendKeys("test");
		pom.getInstanceCaseStudies().downloadbutton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());

		// Then handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	@Test(priority = 13, description = "Downloading Runway Analysis App Upgraded for Web Access case studies")
	public void runwayAnalysis() throws InterruptedException {
		WebElement element = pom.getInstanceCaseStudies().runway;

		// Scroll and adjust for sticky headers
		scrollToElement(element);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement click = pom.getInstanceCaseStudies().runway;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);

		pom.getInstanceCaseStudies().fn.sendKeys("ra");
		pom.getInstanceCaseStudies().ln.sendKeys("hul");
		pom.getInstanceCaseStudies().mail.sendKeys("test@test.in");
		pom.getInstanceCaseStudies().mobile.sendKeys("9658475147");
		pom.getInstanceCaseStudies().company.sendKeys("test");
		pom.getInstanceCaseStudies().industry.sendKeys("test");
		pom.getInstanceCaseStudies().job.sendKeys("test");
		pom.getInstanceCaseStudies().message.sendKeys("test");
		pom.getInstanceCaseStudies().downloadbutton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());

		// Then handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}
