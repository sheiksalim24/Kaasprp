package org.utility;

import org.launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class ServicesUtility extends LaunchBrowser {

	public static void servicesPageNav() {
		getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		if (pom.getInstanceServicePage().servicesPageHeader.isDisplayed()) {
			pom.getInstanceServicePage().servicesPageHeader.click();
			String expectedServicesPageUrl = "https://test.kaaspro.com/service.html";
			String actualServicesPageUrl = driver.getCurrentUrl();

			if (expectedServicesPageUrl.equals(actualServicesPageUrl)) {
				extentTest.log(Status.INFO, "Services Page Navigation Working Fine");
			} else {
				log.info("Services Page Navigation not working");
			}
		}
	}

	public static void webDevelopmentNav() throws InterruptedException {

		WebElement scrollWebDevelpment = driver.findElement(By.xpath("(//div[text()='Our Services'])[1]"));

		try {
			waitForElementClickable(scrollWebDevelpment, 20);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		
		scrollToElement(scrollWebDevelpment);

		hoverOnElement(pom.getInstanceServicePage().webDevelopmentLink);
		waitForElementClickable(pom.getInstanceServicePage().webDevelopmentLink, 30);
		pom.getInstanceServicePage().webDevelopmentLink.click();

		String expectedWebDevelopmentUrl = "https://test.kaaspro.com/software-development.html";
		String actualWebDevelopmentUrl = driver.getCurrentUrl();

		if (expectedWebDevelopmentUrl.equals(actualWebDevelopmentUrl)) {
			log.info("Web Development Navigation working fine");
			extentTest.log(Status.INFO, "Web Development Navigation working fine");
		} else {
			log.info("Web Development navigation not working");
		}

		// Heading check
		WebElement webDevelopmentheading = pom.getInstanceServicePage().webDevelopmentHeading;

		String webDevelopmentheadingText = webDevelopmentheading.getText();
		String expectedHeading = "Web Development";
	//	Assert.assertTrue(webDevelopmentheadingText.isEmpty(), "Web Development Main heading should be displayed");
		log.info("Web Development Main Heading Verified :" + webDevelopmentheadingText);
		if (webDevelopmentheadingText.equals(expectedHeading)) {
			extentTest.log(Status.INFO, "Web Development Main Heading is Present");
		} else {
			log.info("Web Development Main Heading is not Present");
		}
		
		Thread.sleep(3000);
		driver.navigate().back();
	}
	
	public static void mobileAppDevelopment() throws InterruptedException {

		getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));
		WebElement scrollMobileAppDev = driver.findElement(By.xpath("(//div[text()='Our Services'])[1]"));
		
		scrollToElement(scrollMobileAppDev);

		hoverOnElement(pom.getInstanceServicePage().mobileAppDevelopment);
		waitForElementClickable(pom.getInstanceServicePage().mobileAppDevelopment, 30);
		pom.getInstanceServicePage().mobileAppDevelopment.click();

		String expectedMobileAppDevelopmentUrl = "https://test.kaaspro.com/mobile-app-development.html";
		String actualMobileAppDevelopmentUrl = driver.getCurrentUrl();

		if (expectedMobileAppDevelopmentUrl.equals(actualMobileAppDevelopmentUrl)) {
			log.info("Mobile App Development Navigation working fine");
			extentTest.log(Status.INFO, "Mobile App Development Navigation working fine");
		} else {
			log.info("Mobile App Development navigation not working");
		}

		// Heading check
		WebElement mobileAppDevelopmenttheading = pom.getInstanceServicePage().mobileAppDevelopmentPageHeading;

		String mobileAppDevelopmentheadingText = mobileAppDevelopmenttheading.getText();
		String expectedMobileAppDevHeading = "Mobile App Development";
	//	Assert.assertTrue(expectedMobileAppDevHeading.isEmpty(), "Mobile App Development Main heading should be displayed");
		log.info("Web Development Main Heading Verified :" + mobileAppDevelopmentheadingText);
		if (mobileAppDevelopmentheadingText.equals(expectedMobileAppDevHeading)) {
			extentTest.log(Status.INFO, "Mobile App Development Main Heading is Present");
		} else {
			log.info("Mobile App Development Main Heading is not Present");
		}
		
		Thread.sleep(3000);
		driver.navigate().back();
	}
	

	public static void appMigrationAndModernization() throws InterruptedException {


		WebElement scrollAppMigAndModernization = driver.findElement(By.xpath("(//div[text()='Our Services'])[1]"));
		try {
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		
		scrollToElement(scrollAppMigAndModernization);

		hoverOnElement(pom.getInstanceServicePage().appMigAndModernizationLink);
		invisivilityElement(By.id("kaaspro-loader"), 20);
		
		try {
		    pom.getInstanceServicePage().appMigAndModernizationLink.click();
		} catch (ElementClickInterceptedException e) {
		    log.info("Click intercepted, using JavaScript click");
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", 
		        pom.getInstanceServicePage().appMigAndModernizationLink);
		}
		
		String expectedAppMigrationAndModernizationUrl = "https://test.kaaspro.com/legacy-modernization.html";
		String actualAppMigrationAndModernizationUrl = driver.getCurrentUrl();

		if (expectedAppMigrationAndModernizationUrl.equals(actualAppMigrationAndModernizationUrl)) {
			log.info("App Migration & Modernization Navigation working fine");
			extentTest.log(Status.INFO, "App Migration & Modernization Navigation working fine");
		} else {
			log.info("App Migration & Modernizationnavigation not working");
		}

		// Heading check
		WebElement appMigAndModernHeading= pom.getInstanceServicePage().appMigAndModernizationHeading;

		String appMigAndModernHeadingText = appMigAndModernHeading.getText();
		String expectedappMigAndModernHeading = "Application Migration & Modernization";
	//	Assert.assertTrue(expectedMobileAppDevHeading.isEmpty(), "Mobile App Development Main heading should be displayed");
		log.info("Application Migration & Modernization Main Heading Verified :" + appMigAndModernHeadingText);
		if (appMigAndModernHeadingText.equals(expectedappMigAndModernHeading)) {
			extentTest.log(Status.INFO, "Application Migration & Modernization Main Heading is Present");
		} else {
			log.info("Application Migration & Modernization Main Heading is not Present");
		}
		
		Thread.sleep(3000);
		driver.navigate().back();
	}
	
	
	public static void productEngineering() throws InterruptedException {

		WebElement scrollProductEng = driver.findElement(By.xpath("(//div[text()='Our Services'])[1]"));

		scrollToElement(scrollProductEng);

		hoverOnElement(pom.getInstanceServicePage().productEngLink);
		waitForElementClickable(pom.getInstanceServicePage().productEngLink, 30);
		getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		pom.getInstanceServicePage().productEngLink.click();

		String productEngUrl = "https://test.kaaspro.com/product-engineering.html";
		String actualProductEngUrl = driver.getCurrentUrl();

		if (productEngUrl.equals(actualProductEngUrl)) {
			log.info("Product Engineering Navigation working fine");
			extentTest.log(Status.INFO, "Product Engineering Navigation working fine");
		} else {
			log.info("Product Engineering navigation not working");
		}

		// Heading check
		WebElement productEngHeading= pom.getInstanceServicePage().productEngPageHeading;

		String productEngHeadingText = productEngHeading.getText();
		String expectedProductEngHeading = "Product Engineering";
	//	Assert.assertTrue(expectedMobileAppDevHeading.isEmpty(), "Mobile App Development Main heading should be displayed");
		log.info("Application Migration & Modernization Main Heading Verified :" + productEngHeadingText);
		if (productEngHeadingText.equals(expectedProductEngHeading)) {
			extentTest.log(Status.INFO, "Product Engineering Main Heading is Present");
		} else {
			log.info("Product Engineering Main Heading is not Present");
		}
		
		Thread.sleep(3000);
		driver.navigate().back();
	}

	public static void managedITServices() throws InterruptedException {

		WebElement scrollManagedITServ = driver.findElement(By.xpath("(//div[text()='Our Services'])[1]"));

		isPageLoaded();
		try {
			scrollToElement(scrollManagedITServ);
		} catch (Exception e) {
			log.info(e.getMessage());
		}

		hoverOnElement(pom.getInstanceServicePage().managedITServLink);
		waitForElementClickable(pom.getInstanceServicePage().managedITServLink, 30);
		getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		try {
		    pom.getInstanceServicePage().managedITServLink.click();
		} catch (ElementClickInterceptedException e) {
		    log.info("Click intercepted, using JavaScript click");
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", 
		        pom.getInstanceServicePage().managedITServLink);
		}

		String managedITServUrl = "https://test.kaaspro.com/managed-it-services.html";
		String actualManagedITServUrl = driver.getCurrentUrl();

		if (managedITServUrl.equals(actualManagedITServUrl)) {
			log.info("Managed IT Services Navigation working fine");
			extentTest.log(Status.INFO, "Managed IT Services Navigation working fine");
		} else {
			log.info("Managed IT Services navigation not working");
		}

		// Heading check
		WebElement managedItServHeading= pom.getInstanceServicePage().managedITServPageHeading;

		String managedITServHeadingText = managedItServHeading.getText();
		String expectedManagedITServHeading = "Managed IT Services";
	//	Assert.assertTrue(expectedMobileAppDevHeading.isEmpty(), "Mobile App Development Main heading should be displayed");
		log.info("Managed IT Services Main Heading Verified :" + managedITServHeadingText);
		if (managedITServHeadingText.equals(expectedManagedITServHeading)) {
			extentTest.log(Status.INFO, "Managed IT Services Main Heading is Present");
		} else {
			log.info("Managed IT Services Main Heading is not Present");
		}

		Thread.sleep(3000);
		driver.navigate().back();
	}

	public static void cloudInfrastructureSolution() throws InterruptedException {

		WebElement cloudInfrastructureSol = driver.findElement(By.xpath("(//div[text()='Our Services'])[1]"));

		isPageLoaded();
		try {
			scrollToElement(cloudInfrastructureSol);
		} catch (Exception e) {
			log.info(e.getMessage());
		}

		invisivilityElement(By.id("kaaspro-loader"), 10);
		
		try {
		    pom.getInstanceServicePage().cloudInfrastructureSolLink.click();
		} catch (ElementClickInterceptedException e) {
		    log.info("Click intercepted, using JavaScript click");
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", 
		        pom.getInstanceServicePage().cloudInfrastructureSolLink);
		}
		
		String cloudInfrastructureSolUrl= "https://test.kaaspro.com/cloud-solutions.html";
		String actualcloudInfrastructureSolUrl = driver.getCurrentUrl();

		if (cloudInfrastructureSolUrl.equals(actualcloudInfrastructureSolUrl)) {
			log.info("Cloud & Infrastructure Solution Navigation working fine");
			extentTest.log(Status.INFO, "Cloud & Infrastructure Solution Navigation working fine");
		} else {
			log.info("Cloud & Infrastructure Solution navigation not working");
		}

		// Heading check
		WebElement CloudInfrastructureSolHeading= pom.getInstanceServicePage().cloudInfrastructureSolPageHeading;

		String CloudInfrastructureSolHeadingText = CloudInfrastructureSolHeading.getText();
		String expectedCloudInfrastructureSolHeading = "Cloud & Infrastructure Solutions";
	//	Assert.assertTrue(expectedMobileAppDevHeading.isEmpty(), "Mobile App Development Main heading should be displayed");
		log.info("Cloud & Infrastructure Solution Main Heading Verified :" + CloudInfrastructureSolHeadingText);
		if (CloudInfrastructureSolHeadingText.equals(expectedCloudInfrastructureSolHeading)) {
			extentTest.log(Status.INFO, "Cloud & Infrastructure Solution Main Heading is Present");
		} else {
			log.info("Cloud & Infrastructure Solution Main Heading is not Present");
		}

		Thread.sleep(3000);
		driver.navigate().back();
	}

	public static void generativeAI() throws InterruptedException {

		getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));
		WebElement generativeAI = driver.findElement(By.xpath("(//a[contains(@class,'industry-item animate')])[8]"));

		scrollToElement(generativeAI);

		hoverOnElement(pom.getInstanceServicePage().generativeAILink);
		invisivilityElement(By.id("kaaspro-loader"), 10);
		try {
		    pom.getInstanceServicePage().generativeAILink.click();
		} catch (ElementClickInterceptedException e) {
		    log.info("Click intercepted, using JavaScript click");
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", 
		        pom.getInstanceServicePage().generativeAILink);
		}
		
		String expectedUrl= "https://test.kaaspro.com/generative-ai-solutions.html";
		String actualUrl = driver.getCurrentUrl();

		if (expectedUrl.equals(actualUrl)) {
			log.info("Generative AI Solutions Navigation working fine");
			extentTest.log(Status.INFO, "Generative AI Solutions Navigation working fine");
		} else {
			log.info("Generative AI Solutions navigation not working");
		}

		// Heading check
		WebElement GenHeading= pom.getInstanceServicePage().generativeAIPageHeading;

		String genHeadingText = GenHeading.getText();
		String expectedGenHeading = "Generative AI Solutions";
	//	Assert.assertTrue(expectedMobileAppDevHeading.isEmpty(), "Mobile App Development Main heading should be displayed");
		log.info("Generative AI Solutions Main Heading Verified :" + genHeadingText);
		if (genHeadingText.equals(expectedGenHeading)) {
			extentTest.log(Status.INFO, "Generative AI Solutions Main Heading is Present");
		} else {
			log.info("Generative AI Solutions Main Heading is not Present");
		}

		Thread.sleep(3000);
		driver.navigate().back();
	}
	
	public static void qualityAssurance() throws InterruptedException {

		invisivilityElement(By.id("kaaspro-loader"), 10);
		WebElement qa = driver.findElement(By.xpath("(//a[contains(@class,'industry-item animate')])[7]"));

		scrollToElement(qa);

		hoverOnElement(pom.getInstanceServicePage().qualityAssuranceLink);
		
		try {
		    pom.getInstanceServicePage().qualityAssuranceLink.click();
		} catch (ElementClickInterceptedException e) {
		    log.info("Click intercepted, using JavaScript click");
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", 
		        pom.getInstanceServicePage().qualityAssuranceLink);
		}
		
		String expectedUrl= "https://test.kaaspro.com/quality-assurance.html";
		String actualUrl = driver.getCurrentUrl();

		if (expectedUrl.equals(actualUrl)) {
			log.info("Quality Assurance Navigation working fine");
			extentTest.log(Status.INFO, "Quality Assurance Navigation working fine");
		} else {
			log.info("Quality Assurance navigation not working");
		}

		// Heading check
		WebElement qaHeading= pom.getInstanceServicePage().qualityAssurancePageHeading;


		String qaHeadingText = qaHeading.getText();
		String expectedQaHeading = "Quality Assurance & Testing";
	//	Assert.assertTrue(expectedMobileAppDevHeading.isEmpty(), "Mobile App Development Main heading should be displayed");
		log.info("Quality Assurance Main Heading Verified :" + qaHeadingText);
		if (qaHeadingText.equals(expectedQaHeading)) {
			extentTest.log(Status.INFO, "Quality Assurance Main Heading is Present");
		} else {
			log.info("Quality Assurance Main Heading is not Present");
		}

		Thread.sleep(3000);
		driver.navigate().back();
	}
	
	public static void staffAugmentation() throws InterruptedException {
		
		invisivilityElement(By.id("kaaspro-loader"), 10);
		WebElement staffAug = driver.findElement(By.xpath("(//a[contains(@class,'industry-item animate')])[7]"));

		scrollToElement(staffAug);

		hoverOnElement(pom.getInstanceServicePage().staffAugLink);
		try {
		    pom.getInstanceServicePage().staffAugLink.click();
		} catch (ElementClickInterceptedException e) {
		    log.info("Click intercepted, using JavaScript click");
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", 
		        pom.getInstanceServicePage().staffAugLink);
		}

		String expectedUrl= "https://test.kaaspro.com/staff-augmentation.html";
		String actualUrl = driver.getCurrentUrl();

		if (expectedUrl.equals(actualUrl)) {
			log.info("Staff Augumentation Navigation working fine");
			extentTest.log(Status.INFO, "Staff Augumentation Navigation working fine");
		} else {
			log.info("Staff Augumentation navigation not working");
		}

		// Heading check
		WebElement staffAugHeading= pom.getInstanceServicePage().staffAugPageHeading;

		String staffAugHeadingText = staffAugHeading.getText();
		String expectedstaffAugHeading = "Staff Augmentation";
	//	Assert.assertTrue(expectedMobileAppDevHeading.isEmpty(), "Mobile App Development Main heading should be displayed");
		log.info("Staff Augumentaion Main Heading Verified :" + staffAugHeadingText);
		if (staffAugHeadingText.equals(expectedstaffAugHeading)) {
			extentTest.log(Status.INFO, "Staff Augmentation Main Heading is Present");
		} else {
			log.info("Staff Augmentation Main Heading is not Present");
		}

		Thread.sleep(3000);
		driver.navigate().back();
	}






}
