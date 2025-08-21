package com.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Selenium imports
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;

	public static WebDriver setup(String name) {

		if (driver == null) {
			switch (name.toLowerCase()) {
			case "chrome":
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setAcceptInsecureCerts(true);
				driver = new ChromeDriver(chromeOptions);
				break;

			case "firefox":
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--start-maximized");
				firefoxOptions.setAcceptInsecureCerts(true);
				driver = new FirefoxDriver(firefoxOptions);
				break;
			case "edge":
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.setAcceptInsecureCerts(true);
				driver = new EdgeDriver(edgeOptions);
				break;

			case "ie":
				driver = new InternetExplorerDriver();
				break;

			case "safari":
				SafariOptions safariOptions = new SafariOptions();
				safariOptions.setAcceptInsecureCerts(true);
				driver = new SafariDriver(safariOptions);
				break;

			default:
				throw new IllegalArgumentException("Invalid browser name: " + name);
			}
			driver.manage().window().maximize();
		}
		return driver;
	}

	// SCREENSHOT

	public static String Screenshot(String Filename) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/" + Filename + ".png");
		String path = destFile.getAbsolutePath();
		System.out.println(destFile);

		FileUtils.copyFile(sourceFile, destFile);

		System.out.println("screen shot captured");
		return path;
	}

	public static WebDriverWait getWait() {
		return wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	// Is page Load
	public static boolean isPageLoaded() {
		try {
			getWait().until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Bottom Scroll

	public static void scrollDown() {
	    try {
	    	
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	        long lastHeight = (Long) js.executeScript("return document.body.scrollHeight");
	        
	        while (true) {
	            // Scroll down
	            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	            Thread.sleep(2000); // Wait for content to load
	            
	            // Check if new content loaded
	            long newHeight = (Long) js.executeScript("return document.body.scrollHeight");
	            if (newHeight == lastHeight) {
	                break; // No more content to load
	            }
	            lastHeight = newHeight;
	        }
	        
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
	}

	// Element Visibility
	public static WebElement waitForElementVisible(WebElement element, int timeoutSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// JavaScript utility to scroll to a WebElement
	public static void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Element to be clickable

	public static WebElement waitForElementClickable(WebElement element, int timeoutSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Mouse Hover Actions
	public static void hoverOnElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public static void invisivilityElement(By locator, int timeoutSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}

	// send keys
	public static void sendKeys(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	// random email
	public static String generateRandomEmail() {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder email = new StringBuilder();
		Random random = new Random();
		int length = 10;
		for (int i = 0; i < length; i++) {
			email.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
		}
		email.append("@test.com");
		return email.toString();
	}

	// random indian phone number
	public static String generateIndianMobileNumber() {
		Random rand = new Random();
		int[] firstDigits = { 6, 7, 8, 9 };
		int firstDigit = firstDigits[rand.nextInt(firstDigits.length)];
		StringBuilder phoneNumber = new StringBuilder();
		phoneNumber.append(firstDigit);
		for (int i = 0; i < 9; i++) {
			phoneNumber.append(rand.nextInt(10));
		}
		return phoneNumber.toString();
	}

}
