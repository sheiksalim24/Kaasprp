package org.testCases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.launch.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.login.LoginDetails;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class HomePage extends LaunchBrowser {
	
	public HomePage homePage;

	private void verifyElementExists(String xpath, String elementName, SoftAssert softAssert) {

		try {
			List<WebElement> elements = driver.findElements(By.xpath(xpath));
			if (elements.size() > 0) {
				log.info("✅ " + elementName + " found (" + elements.size() + " elements)");
			} else {
				log.info("❌ " + elementName + " not found");
				softAssert.fail(elementName + " not found on page");
			}
		} catch (Exception e) {
			log.info("❌ Error checking " + elementName + ": " + e.getMessage());
			softAssert.fail("Error verifying " + elementName);
		}
	}

	private String getPageStructureSummary() {

		try {
			StringBuilder summary = new StringBuilder();
			summary.append("\n📊 Page Structure Summary:\n");
			summary.append("====\n");

			// Count elements
			int headerCount = driver.findElements(By.xpath("//header")).size();
			int navCount = driver.findElements(By.xpath("//nav")).size();
			int imgCount = driver.findElements(By.xpath("//img")).size();

			summary.append("Headers: ").append(headerCount).append("\n");
			summary.append("Navigation: ").append(navCount).append("\n");
			summary.append("Images: ").append(imgCount).append("\n");
			summary.append("Page Title: ").append(driver.getTitle()).append("\n");
			summary.append("=====\n");

			return summary.toString();
		} catch (Exception e) {
			return "Error generating summary: " + e.getMessage();
		}
	}

	private void savePageTextContent(String pageText) {
		try {
			// Create a timestamp for the filename
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String fileName = "page_text_content_" + timestamp + ".txt";

			// Write to file
			FileWriter writer = new FileWriter(fileName);
			writer.write("Page Text Content:\n");
			writer.write("===================\n");
			writer.write(pageText);
			writer.close();

			System.out.println("📝 Page text content saved to: " + fileName);
		} catch (IOException e) {
			System.err.println("❌ Failed to save page text content: " + e.getMessage());
		}
	}
	
	private static void caseStudiesNav() throws InterruptedException {
		
		getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));
		WebElement scrollCaseStudy = driver.findElement(By.xpath("//h2[text()='Explore Our Solutions']"));
		
		scrollToElement(scrollCaseStudy);
		
		hoverOnElement(pom.getinstanceHomePage().caseStudiesBox);
		waitForElementClickable(pom.getinstanceHomePage().caseStudiesBox, 40);
		pom.getinstanceHomePage().caseStudiesBox.click();
		String expectedCaseStudiesUrl = "https://test.kaaspro.com/case-studies.html";
		String actualCaseStudiesUrl = driver.getCurrentUrl();
		
		if(expectedCaseStudiesUrl.equals(actualCaseStudiesUrl)) {
			log.info("Case Studies Navigation working fine");
			extentTest.log(Status.INFO, "Case Studies Navigation working fine");
			
			//Heading check
			WebElement caseStudyheading = pom.getinstanceHomePage().caseStudyPageHeading;

			if (caseStudyheading.isDisplayed()) {
				getWait().until(ExpectedConditions.visibilityOf(caseStudyheading));
				String caseStudyheadingText = caseStudyheading.getText();
				String expectedHeading = "Success Stories";
				Assert.assertFalse(caseStudyheadingText.isEmpty(), "Case Study Main heading should be displayed");
				log.info("Case Study Main Heading Verified :" + caseStudyheadingText);
				if (caseStudyheadingText.equals(expectedHeading)) {
					extentTest.log(Status.INFO, "Case Study Main Heading is Present");
				}
			}
		}
		else {
			log.info("Case Studies navigation not working");
		}
		
		
		Thread.sleep(3000);
		driver.navigate().back();
		
		
	}

	private static void whitePappersNav() throws InterruptedException {
		
		getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));
		WebElement scrollWhitePappers = driver.findElement(By.xpath("//h2[text()='Explore Our Solutions']"));
		
		scrollToElement(scrollWhitePappers);
		
		hoverOnElement(pom.getinstanceHomePage().whitePappersBox);
		waitForElementClickable(pom.getinstanceHomePage().whitePappersBox, 40);
		pom.getinstanceHomePage().whitePappersBox.click();
		String expectedCaseStudiesUrl = "https://test.kaaspro.com/whitepapers.html";
		String actualCaseStudiesUrl = driver.getCurrentUrl();
		
		if(expectedCaseStudiesUrl.equals(actualCaseStudiesUrl)) {
			log.info("White Pappers Navigation working fine");
		}
		else {
			log.info("White Pappers navigation not working");
		}
		
		Thread.sleep(3000);
		driver.navigate().back();
	}
	



	@Test(priority = 0, description = "Verify home page loads successfully", enabled = true)
	public void homePageLoad() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		log.info("Starting Home Page Load");
		System.out.println(driver.getTitle());

		Assert.assertTrue(homePage.isPageLoaded(), "Home page should load successfully");
		Assert.assertFalse(driver.getTitle().isEmpty(), "Page title should not be empty");
		log.info("Home page loaded successfully with title: " + driver.getTitle());
		extentTest.log(Status.INFO, "Home page loaded successfully with title: " + driver.getTitle());

	}

	@Test(priority = 1, description = "Verify main heading is displayed", enabled = true)
	public void mainHeading() {

		log.info("startig Home page main Heading");
		homePage = new HomePage();

		try {
			
			WebElement heading = pom.getinstanceHomePage().mainHeading;
			waitForElementVisible(heading, 20);

			if (heading.isDisplayed()) {
				String headingText = heading.getText();
				String expectedHeading = "Smart IT Solutions for Future Ready Businesses.";
			//	Assert.assertFalse(headingText.isEmpty(), "Main heading should be displayed");
				log.info("Main Heading Verified :" + headingText);
				if (headingText.equals(expectedHeading)) {
					extentTest.log(Status.INFO, "Home Page Main Heading is Present");
				}
			}
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, description = "Verify all links are accessible", enabled = true)
	public void allLinksAccessibility() {

		log.info("startig Link Accessibility");
		homePage = new HomePage();

		List<WebElement> getAllLinks = pom.getinstanceHomePage().allLinks;
		int linkCount = getAllLinks.size();
		Assert.assertTrue(linkCount > 0, "Page should contain links");
		log.info("Total Links Found :" + linkCount);
		extentTest.log(Status.INFO, "All links on the Home Page are accessible");

		for (WebElement link : getAllLinks) {
			String href = link.getAttribute("href");
			Assert.assertNotNull(href, "Link should have href attribute");
		}
	}

	@Test(priority = 3, description = "Verify Home Page Navigation", enabled = true)
	public static void navigateHomePage() throws InterruptedException {

		getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.id("kaaspro-loader")));

		getWait().until(ExpectedConditions.visibilityOf(pom.getinstanceHomePage().HomepageLink));
		if (pom.getinstanceHomePage().HomepageLink.isDisplayed()) {
			pom.getinstanceHomePage().HomepageLink.click();
		} else {
			System.out.println("Home Page Link is Not Displayed");
		}

		String expectedHomePageUrl = "https://test.kaaspro.com/index.html";
		String actualHomePageUrl = driver.getCurrentUrl();
		System.out.println(actualHomePageUrl);

		if (expectedHomePageUrl.equals(actualHomePageUrl)) {
			System.out.println("Home Page is Present");
			extentTest.log(com.aventstack.extentreports.Status.INFO, "Home Page Navigation Working Fine");
		} else {
			log.info("Home Page Navigation not Working");
		}
		
		caseStudiesNav();
		//whitePappersNav();---pending after chatbot issue fixed

	}

	@Test(priority = 4, description = "Homepage Screenshot Comparison Test", enabled = false)
	public void compareHomePage() throws IOException, InterruptedException {

		String ManualScreenShotPath = "./ManualScreenShot/HomePage.png";
		String AutomatedScreenShotPath = "./AutomatedScreenShot/automatedScreenShot.png";
		String DiffScreenShotPath = "./DiffScreenShot/HomePage_Diff.png";

		Thread.sleep(5000);

		// Take Screenshot
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);

		// Save Actual Screenshot (optional)
		ImageIO.write(screenshot.getImage(), "PNG", new File(AutomatedScreenShotPath));

		// Load Reference Image
		BufferedImage expectedImage = ImageIO.read(new File(ManualScreenShotPath));
		BufferedImage actualImage = screenshot.getImage();

		// Compare Images
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);

		if (diff.hasDiff()) {

			ImageIO.write(diff.getMarkedImage(), "PNG", new File(DiffScreenShotPath));
			log.info("Difference image saved: " + DiffScreenShotPath);
			extentTest.log(Status.INFO, "Home Page ScreenShot Does not match!");

		} else {
			log.info("HomePage Image Match Perfectly");
			extentTest.log(Status.INFO, "HomePage Image Match Perfectly");

		}
	}

	@Test(priority = 5, description = "Verify Page DOM Structure", enabled = false)
	public void verifyPageDOMStructure() {

		try {
			SoftAssert softAssert = new SoftAssert();

			verifyElementExists("//header", "Header Section", softAssert);
			verifyElementExists("//nav", "Navigation menu", softAssert);
			verifyElementExists("//footer", "Footer section", softAssert);
			verifyElementExists("//img", "Images present", softAssert);

			// Get page structure summary
			String pageStructure = getPageStructureSummary();
			System.out.println("📊 Page Structure:\n" + pageStructure);
			extentTest.log(Status.INFO, "Page Structure:\n" + pageStructure);

			softAssert.assertAll();
			System.out.println("✅ DOM Structure verification completed successfully");
			extentTest.log(Status.INFO, "✅ DOM Structure verification completed successfully");
		} catch (Exception e) {
			System.out.println("❌ DOM Structure verification failed: " + e.getMessage());
			Assert.fail("DOM verification failed: " + e.getMessage());
		}

	}

	@Test(priority = 6, description = "Verify Page Text Content", enabled = false)
	public void verifyPageTextContent() {

		try {

			Thread.sleep(5000);
			SoftAssert softAssert = new SoftAssert();

			// Expected text content (customize based on your page)
			String[] expectedTexts = {
					"Power your growth with kaaspro—delivering innovative, secure, and scalable IT services tailored to your needs." };

			String pageText = driver.findElement(By.tagName("body")).getText();
			System.out.println("📄 Page contains " + pageText.length() + " characters of text");

			// Check for expected text content
			for (String expectedText : expectedTexts) {
				if (pageText.toLowerCase().contains(expectedText.toLowerCase())) {
					System.out.println("✅ Found expected text: " + expectedText);
				} else {
					System.out.println("❌ Missing expected text: " + expectedText);
					softAssert.fail("Expected text '" + expectedText + "' not found on page");
				}
			}

			// Save page text content for manual comparison
			savePageTextContent(pageText);

			softAssert.assertAll();
			System.out.println("✅ Text content verification completed successfully");

		} catch (Exception e) {
			System.out.println("❌ Text content verification failed: " + e.getMessage());
			Assert.fail("Text content verification failed: " + e.getMessage());
		}

	}
}
