package com.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static FileInputStream fis;
	public static Properties p;
	
	public ConfigReader() throws IOException {
		
		File file = new File("./login.properties");
		fis= new FileInputStream(file);
		p = new Properties();
		p.load(fis);
		
	}
	
	public  String getBrowser() {
		String browser = p.getProperty("browser");
		return browser;
	}
	
	public String getUrl() {
		String url = p.getProperty("url");
		return url;
	}

}
