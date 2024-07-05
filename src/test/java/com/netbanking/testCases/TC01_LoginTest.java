package com.netbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbanking.pageObjects.LoginPage;

public class TC01_LoginTest extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		driver.get(baseURL);
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Enter user name");
		lp.setUsername(username);
		logger.info("Enter password");
		lp.setPassword(password);
		
		lp.clickSubmit();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage11")) {
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
		}
		
	}
	

}
