package com.netbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netbanking.pageObjects.LoginPage;
import com.netbanking.utilities.XLUtility;



public class TC02_LoginDDTTest extends BaseClass {
	
	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String username, String password) throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(5);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();	
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(3);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Thread.sleep(5);
			
		}
		
		
		
	}
	
	public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
		
	}
	
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException 
	{
		String path=System.getProperty("user.dir")+"//TestData//LoginGuruData.xlsx";
		XLUtility xl=new XLUtility(path);
		int rowNum=xl.getRowCount("Sheet1");
		int colCount=xl.getCellCount("Sheet1", 1);
		String testData[][]=new String[rowNum][colCount];
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<colCount;j++) {
				testData[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		return testData;		
		
	}

}
