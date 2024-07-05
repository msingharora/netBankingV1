package com.netbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() {
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
			
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	public String getApplicationURL() {
		String getURL=prop.getProperty("baseURL");
		return getURL;
		
	}
	
	public String getUsername() {
		String getuser=prop.getProperty("username");
		return getuser;
		
	}
	
	public String getPassword()
	{
		String getPwd=prop.getProperty("password");
		return getPwd;
	}
	
	
	
	
	
	
	

}
