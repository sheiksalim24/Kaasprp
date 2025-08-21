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
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Whitepaper extends LaunchBrowser {

	public Whitepaper whitepaper;

	@Test(priority = 0, description = "Verify whitepaper load")
	public void casestudiesload() throws InterruptedException {

		log.info("Home Page Load");
		whitepaper = new Whitepaper();
		Thread.sleep(3000);

		WebElement footer = pom.getInstanceAboutUs().footer;
		int footerY = footer.getLocation().getY() - 150;
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, arguments[0]);", footerY);

		pom.getInstanceWhitePaper().whitepaperlink.click();

		Thread.sleep(10000);
		if (whitepaper.equals(isPageLoaded())) {
			log.info("whitepaper page should load successfully");
		} else {
			log.info("whitepaper page not loaded");
		}
		Assert.assertFalse(driver.getTitle().isEmpty(), "Page title should not be empty");
		log.info("whitepaper loaded successfully with title: " + driver.getTitle());
		extentTest.log(Status.INFO, "whitepaper page loaded successfully with title: " + driver.getTitle());
	}

	@Test(priority = 1, description = "Verify main heading is displayed")
	public void mainHeading() {
		log.info("startig mainHeading");
		whitepaper = new Whitepaper();

		WebElement heading = pom.getInstanceWhitePaper().whitepaperheading;

		if (heading.isDisplayed()) {
			getWait().until(ExpectedConditions.visibilityOf(heading));
			String headingText = heading.getText();
			String expectedHeading = "Forward-thinking Ideas Into";
			Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
			log.info("Main Heading Verified :" + headingText);
			if (headingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "whitepaper Page Main Heading is Present");
			}
		}
	}

	@Test(priority = 2, description = "Verify all links are accessible")
	public void allLinksAccessibility() {

		log.info("starting link accessibility");
		whitepaper = new Whitepaper();
		List<WebElement> getAllLinks = pom.getInstanceWhitePaper().alllinks;
		int linkCount = getAllLinks.size();
		Assert.assertTrue(linkCount > 0, "page should contain links");
		log.info("total links found:" + linkCount);
		extentTest.log(Status.INFO, "all links on the whitepaper page are accessible");
		extentTest.log(Status.INFO, "Total links" + linkCount);
		for (WebElement link : getAllLinks) {
			String href = link.getAttribute("href");
			Assert.assertNotNull(href, "link should have href attributes");
		}

	}

	@Test(priority = 3, description = "Downloading AI Driven Software Development whitepaper")
	public void aiDriven() throws InterruptedException {
		WebElement element = pom.getInstanceWhitePaper().aidriven;

		// Scroll and adjust for sticky headers
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); // optional for stability
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");

		// Wait until it's clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement click = pom.getInstanceWhitePaper().aidriven;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);

		pom.getInstanceWhitePaper().fn.sendKeys("ra");
		pom.getInstanceWhitePaper().ln.sendKeys("hul");
		pom.getInstanceWhitePaper().mail.sendKeys("test@test.in");
		pom.getInstanceWhitePaper().mobile.sendKeys("9658475147");
		pom.getInstanceWhitePaper().company.sendKeys("test");
		pom.getInstanceWhitePaper().industry.sendKeys("test");
		pom.getInstanceWhitePaper().job.sendKeys("test");
		pom.getInstanceWhitePaper().message.sendKeys("test");
		pom.getInstanceWhitePaper().downloadbutton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());

		// Then handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test(priority = 4, description = "Downloading Digital Transformation in BFSI whitepaper")
	public void digitalTransformation() throws InterruptedException {
		WebElement element = pom.getInstanceWhitePaper().digital;

		// Scroll and adjust for sticky headers
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); // optional for stability
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement click = pom.getInstanceWhitePaper().digital;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);

		pom.getInstanceWhitePaper().fn.sendKeys("ra");
		pom.getInstanceWhitePaper().ln.sendKeys("hul");
		pom.getInstanceWhitePaper().mail.sendKeys("test@test.in");
		pom.getInstanceWhitePaper().mobile.sendKeys("9658475147");
		pom.getInstanceWhitePaper().company.sendKeys("test");
		pom.getInstanceWhitePaper().industry.sendKeys("test");
		pom.getInstanceWhitePaper().job.sendKeys("test");
		pom.getInstanceWhitePaper().message.sendKeys("test");
		pom.getInstanceWhitePaper().downloadbutton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());

		// Then handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	@Test(priority = 5, description = "Downloading Legacy Modernisation whitepaper")
	public void legacyModernisation() throws InterruptedException {
		WebElement element = pom.getInstanceWhitePaper().legacy;
		// Scroll and adjust for sticky headers
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); // optional for stability
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement click = pom.getInstanceWhitePaper().legacy;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);

		pom.getInstanceWhitePaper().fn.sendKeys("ra");
		pom.getInstanceWhitePaper().ln.sendKeys("hul");
		pom.getInstanceWhitePaper().mail.sendKeys("test@test.in");
		pom.getInstanceWhitePaper().mobile.sendKeys("9658475147");
		pom.getInstanceWhitePaper().company.sendKeys("test");
		pom.getInstanceWhitePaper().industry.sendKeys("test");
		pom.getInstanceWhitePaper().job.sendKeys("test");
		pom.getInstanceWhitePaper().message.sendKeys("test");
		pom.getInstanceWhitePaper().downloadbutton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());

		// Then handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}
