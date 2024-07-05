package com.netbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.netbanking.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readConf=new ReadConfig();
	public String baseURL=readConf.getApplicationURL();
	public String username=readConf.getUsername();
	public String password=readConf.getPassword();
	public static WebDriver driver;
	public Logger logger;
	
	@BeforeMethod
	public void setup() {
		driver=new FirefoxDriver();
		driver.get(baseURL);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		logger=LogManager.getLogger(this.getClass());
		logger.info("setup created");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") + "/Screenshots/" + tName +".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot taken");
	}
	

}
