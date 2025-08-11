package com.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import freemarker.core.ReturnInstruction.Return;

public class Base {

	public static WebDriver driver;

	public static WebDriver setup(String name) {
		
		if(driver == null) {
			switch(name.toLowerCase()) {
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
	
	
	//SCREENSHOT
	
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
}



