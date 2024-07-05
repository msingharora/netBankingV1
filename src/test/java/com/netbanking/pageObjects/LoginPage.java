package com.netbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver lDriver;
	
	public LoginPage(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	@FindBy(name="uid")
	WebElement textUsername;
	
	@FindBy(name="password")
	WebElement textPassword;
	
	@FindBy(name="btnReset")
	WebElement btnReset;
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement lnkLogout;
	
	public void setUsername(String uname)
	{
		textUsername.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		textPassword.sendKeys(pwd);
	}
	public void clickSubmit()
	{
		btnLogin.click();
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
