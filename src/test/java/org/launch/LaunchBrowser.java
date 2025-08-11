package org.launch;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.base.Base;
import com.data.ConfigManager;
import com.pom.PageObjectModel;

public class LaunchBrowser extends Base{
	
	public static WebDriver driver;
	public static PageObjectModel pom;
	public static WebDriverWait webdriverWait;
	public static String url;
	public static ExtentSparkReporter repoter;
	public static ExtentReports reports;
	public static ExtentTest extentTest;
	public static org.apache.log4j.Logger log;
	
	@BeforeSuite(groups = "before")
	public static void openConnection() throws IOException {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		driver = setup(ConfigManager.getConfigManager().getConfigReader().getBrowser());
		
		log= Logger.getLogger(LaunchBrowser.class);
		BasicConfigurator.configure();
		
		pom= new PageObjectModel(driver);
		
		webdriverWait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		url = ConfigManager.getConfigManager().getConfigReader().getUrl();
		System.out.println(url);
		
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		
		reports = new ExtentReports();
		repoter = new ExtentSparkReporter("./ExtentReports/TestResult.html");
		reports.attachReporter(repoter);
		reports.setSystemInfo("OS", System.getProperty("os.name"));
		reports.setSystemInfo("Java version", System.getProperty("java.version"));
		reports.setSystemInfo("Browser", cap.getBrowserName() + cap.getBrowserVersion());
		
	}

	@BeforeTest
	public void getTheTestNmae(ITestContext context) {
		

		extentTest = reports.createTest(context.getName()).assignAuthor("SHEIK SALIM").assignCategory("KAASPRO WEBSITE")
				.assignDevice("WINDOWS");
	}
	
	@BeforeMethod
	public void verifyTheName(Method m) {

		extentTest.info(MarkupHelper.createLabel("<b>" + m.getName() + "</b>", ExtentColor.TEAL));

	}
	
	
	@AfterMethod
	public void checkStatus(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass("<b>TEST PASSED</B>");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
			extentTest.addScreenCaptureFromPath(Screenshot(result.getName()));
			extentTest.fail(result.getThrowable());
		}
	}
	
	@AfterSuite(groups = "before")
	public void tear_Down() {

		reports.flush();

		try {
			Desktop.getDesktop().browse(new File("ExtentReports/TestResult.html").toURI());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}









