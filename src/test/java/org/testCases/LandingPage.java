package org.testCases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.launch.LaunchBrowser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.login.LoginDetails;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class LandingPage extends LaunchBrowser{

	public void LandingPage() {
        
		LoginDetails.openUrl();
       
       
        try {
            // Wait for the page to load completely
            Thread.sleep(5000);
            // Take full page screenshot using AShot
             ru.yandex.qatools.ashot.Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(1000)) // Scroll delay in ms
                    .takeScreenshot(driver);
            // Save the screenshot
            ImageIO.write(screenshot.getImage(), "PNG", new File("actual_landing.png"));
            System.out.println("Full-page screenshot saved!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           // driver.quit();
        }
    }
    

    public void CompareLandingPage() throws InterruptedException, IOException {
    	LoginDetails.openUrl();
    	
 
        Thread.sleep(5000);
        // Take Screenshot
        ru.yandex.qatools.ashot.Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000)) // Scroll delay in ms
                .takeScreenshot(driver);

        // Save Actual Screenshot (optional)
        ImageIO.write(screenshot.getImage(), "PNG", new File("comparing_landing.png"));
     
        // Load Reference Image
        BufferedImage expectedImage = ImageIO.read(new File("actual_landing.png")); // Place in project root
        BufferedImage actualImage = screenshot.getImage();

        // Compare Images
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);

        if (diff.hasDiff()) {
            System.out.println("Images differ — saving diff file.");
            ImageIO.write(diff.getMarkedImage(), "PNG", new File("landingresult.png"));
        } else {
            System.out.println("Images match perfectly.");
        }

      //  driver.quit();
    }
    
	@Test
	public void execute() throws InterruptedException, IOException {
		
		 LandingPage execute = new LandingPage();
	        execute.LandingPage();
	        execute.CompareLandingPage();
	      
		
	}
}
