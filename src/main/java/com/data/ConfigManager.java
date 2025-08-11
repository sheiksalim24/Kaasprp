package com.data;

import java.io.IOException;

public class ConfigManager {
	
	
	public static ConfigReader getConfigReader() throws IOException {
		ConfigReader reader = new ConfigReader();
		return reader;
	}
	
	public static ConfigManager getConfigManager() {
		ConfigManager m = new ConfigManager();
		return m;
	}

}
