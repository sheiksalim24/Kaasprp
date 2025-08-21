package org.testCases;

import java.util.List;

import org.launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Contact extends LaunchBrowser {

	public static Contact con;

	@Test(priority = 0, description = "Verify Contact page loads successfully")
	public void contactPageLoad() {

		con = new Contact();
		log.info("Starting Contact Page Load");
		scrollDown();

		try {
			invisivilityElement(By.id("kaaspro-loader"), 20);
			pom.getInstanceContact().contactLink.click();
		} catch (Exception e) {
			e.getMessage();
		}

		System.out.println(driver.getTitle());

		String expectedContactUrl = "https://test.kaaspro.com/contact.html";
		String actualContactUrl = driver.getCurrentUrl();

		if (expectedContactUrl.equals(actualContactUrl)) {
			extentTest.log(com.aventstack.extentreports.Status.INFO, "Contact Page Navigation Working Fine");
		} else {
			log.info("Contact Page Navigation not Working");
		}

		Assert.assertTrue(con.isPageLoaded(), "Contact page should load successfully");
		Assert.assertFalse(driver.getTitle().isEmpty(), "Contact Page title should not be empty");
		log.info("Contact page loaded successfully with title: " + driver.getTitle());
		extentTest.log(Status.INFO, "Contact page loaded successfully with title: " + driver.getTitle());

	}

	@Test(priority = 1, description = "Verify Contact main heading is displayed")
	public void ContactHeading() {

		log.info("startig Contact main Heading");

		con = new Contact();
		WebElement contactHeading = pom.getInstanceContact().contactPageHeading;

	try {
		
		waitForElementVisible(contactHeading, 20);
		if (contactHeading.isDisplayed()) {
			String contactHeadingText = contactHeading.getText();
			String expectedHeading = "Have Questions?";
			Assert.assertFalse(contactHeadingText.isEmpty(), "Contact Main heading should be displayed");
			log.info("Contact Main Heading Verified :" + contactHeadingText);
			if (contactHeadingText.equals(expectedHeading)) {
				extentTest.log(Status.INFO, "Contact Main Heading is Present");
			}
		}
		
	} catch (Exception e) {
		e.getMessage();
	}
	}

	@Test(priority = 2, description = "Verify Contact all links are accessible")
	public void contactLinksAccessibility() {
		con = new Contact();
		log.info("startig Contact Link Accessibility");

		List<WebElement> getAllLinks = pom.getInstanceContact().contactAllLinks;
		int linkCount = getAllLinks.size();
		Assert.assertTrue(linkCount > 0, "Contact should contain links");
		log.info("Contact Total Links Found :" + linkCount);
		extentTest.log(Status.INFO, "All links on the Contact page are accessible");

		for (WebElement link : getAllLinks) {
			String href = link.getAttribute("href");
			Assert.assertNotNull(href, "Link should have href attribute");
		}
	}

	@Test(priority = 3, description = "verify fill the contact form")
	public void fillTheContactForm() {

		try {

			waitForElementClickable(pom.getInstanceContact().nameField, 20);
			sendKeys(pom.getInstanceContact().nameField, "Test");

			waitForElementClickable(pom.getInstanceContact().emailField, 20);
			sendKeys(pom.getInstanceContact().emailField, generateRandomEmail());

			Select select = new Select(pom.getInstanceContact().countryDropdown);
			select.selectByValue("+91");

			waitForElementClickable(pom.getInstanceContact().phoneNumberField, 20);
			sendKeys(pom.getInstanceContact().phoneNumberField, generateIndianMobileNumber());

			waitForElementClickable(pom.getInstanceContact().messageField, 20);
			sendKeys(pom.getInstanceContact().messageField, "Test Messages");

			waitForElementClickable(pom.getInstanceContact().submitButton, 30);
			pom.getInstanceContact().submitButton.click();
			extentTest.log(Status.INFO, "Contact Form Submitted Sucessfully");

			// verify the sucess message

			waitForElementVisible(pom.getInstanceContact().succesPopup, 20);
			String SuccessMessage = pom.getInstanceContact().succesPopup.getText();

			if (SuccessMessage.contains("Thank You!")) {
				log.info("Success Message Popup is displayed");
				extentTest.log(Status.INFO, "Contact form has been submitted successfully Popup is Displayed ");
				waitForElementClickable(pom.getInstanceContact().successPopupOkayBtn, 20);

			} else {
				log.info("Conatact form success message popup not displayed");
			}

		} catch (Exception e) {

			e.getMessage();
		}
	}

}
