package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dbconnection.DBconnector;

public class FacebookLogin  {
	
	@FindBy(id = "email")
	WebElement username;
	
	@FindBy(id = "pass")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\'u_0_b\']")
	WebElement submit;
	
	public FacebookLogin (WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void login() {
		DBconnector connector = new DBconnector();
		User userDetails = connector.getCredentialsFromDB();
		
		username.sendKeys(userDetails.getUserName());
		password.sendKeys(userDetails.getPassword());
		submit.click();
		
	}
	
	
	

}

