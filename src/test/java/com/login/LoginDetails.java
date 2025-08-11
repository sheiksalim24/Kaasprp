package com.login;

import org.launch.LaunchBrowser;
import org.testng.annotations.Test;

public class LoginDetails  extends LaunchBrowser {
	

		
		@Test
		public static void openUrl() {
			System.out.println("Call hear");
			
			while (true) {
				if(url.equals("https://test.kaaspro.com/")) {
					driver.get(url);

					break;
				}
				else if (url.equals("https://kaaspro.com")) {
					driver.get(url);
					break;
				}		
			}
			
			
			
		}

}
