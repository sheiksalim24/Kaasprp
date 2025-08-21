package org.testCases;

import java.time.Duration;

import org.launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class SocialMediaLink extends LaunchBrowser {

	public SocialMediaLink socialmedia;

	@Test(priority = 0, description = "Verify linkin social media platform on the footer")
	public void linkin() throws InterruptedException {

		log.info("Home Page Load");

		socialmedia = new SocialMediaLink();
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String originalWindow = driver.getWindowHandle();

		// Scroll to footer
		WebElement footer = pom.getInstanceAboutUs().footer;
		int footerY = footer.getLocation().getY() - 150;
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, arguments[0]);", footerY);

		// Wait until loader disappears
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement linkedinLink = pom.getInstanceSocialMedia().linkinlink;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", linkedinLink);

		// Wait until a new tab is opened
		wait.until(driver -> driver.getWindowHandles().size() > 1);

		// Switch to the new tab
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		// Verify the URL
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("https://www.linkedin.com/company/kaaspro-it")) {
			System.out.println("LinkedIn page opened successfully in new tab.");
			extentTest.log(Status.INFO, "The linkin page is opended successfully");
		} else {
			System.out.println("Unexpected page: " + currentUrl);
			extentTest.log(Status.INFO, "The linkin page is not opended successfully");
		}

		// Close the new tab and switch back to original
		driver.close();
		driver.switchTo().window(originalWindow);
	}

	@Test(priority = 1, description = "Verify X social media platform on the footer")
	public void x() throws InterruptedException {

		log.info("Home Page Load");

		socialmedia = new SocialMediaLink();
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String originalWindow = driver.getWindowHandle();

		// Scroll to footer
		WebElement footer = pom.getInstanceAboutUs().footer;
		int footerY = footer.getLocation().getY() - 150;
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, arguments[0]);", footerY);

		// Wait until loader disappears
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement xlink = pom.getInstanceSocialMedia().xlink;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", xlink);

		// Wait until a new tab is opened
		wait.until(driver -> driver.getWindowHandles().size() > 1);

		// Switch to the new tab
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		// Verify the URL
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("https://x.com/kaaspro")) {
			System.out.println("X page opened successfully in new tab.");
			extentTest.log(Status.INFO, "The X page is opended successfully");
		} else {
			System.out.println("Unexpected page: " + currentUrl);
			extentTest.log(Status.INFO, "The X page is not opended successfully");
		}

		// Close the new tab and switch back to original
		driver.close();
		driver.switchTo().window(originalWindow);
	}

	@Test(priority = 2, description = "Verify FB social media platform on the footer")
	public void fb() throws InterruptedException {

		log.info("Home Page Load");

		socialmedia = new SocialMediaLink();
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String originalWindow = driver.getWindowHandle();

		// Scroll to footer
		WebElement footer = pom.getInstanceAboutUs().footer;
		int footerY = footer.getLocation().getY() - 150;
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, arguments[0]);", footerY);

		// Wait until loader disappears
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		// Use JavaScript to click the LinkedIn link (avoids iframe interception)
		WebElement fblink = pom.getInstanceSocialMedia().fblink;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", fblink);

		// Wait until a new tab is opened
		wait.until(driver -> driver.getWindowHandles().size() > 1);

		// Switch to the new tab
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		// Verify the URL
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains(
				"https://www.facebook.com/people/Kaaspro/61577990737718/?mibextid=wwXIfr&rdid=2vjkSuqSFdoIImp5&share_url=https%3A%2F%2Fwww.facebook.com%2Fshare%2F1EHFfCdj73%2F%3Fmibextid%3DwwXIfr")) {
			System.out.println("FB page opened successfully in new tab.");
			extentTest.log(Status.INFO, "The FB page is opended successfully");
		} else {
			System.out.println("Unexpected page: " + currentUrl);
			extentTest.log(Status.INFO, "The FB page is not opended successfully");
		}

		// Close the new tab and switch back to original
		driver.close();
		driver.switchTo().window(originalWindow);
	}

}
