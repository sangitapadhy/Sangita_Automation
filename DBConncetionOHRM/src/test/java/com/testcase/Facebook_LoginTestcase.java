package com.testcase;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseclass.Library;
import com.pages.FacebookLogin;
import com.reusablefunction.SeleniumUtility;

public class Facebook_LoginTestcase extends Library{
	FacebookLogin fb;
	SeleniumUtility utility;
	
	@BeforeClass
	public void setup() throws IOException {
		launchApplication();
	}

	@Test
	public void Login() {
	
		fb= new FacebookLogin(driver);
		fb.login();
		
	}
	
	@AfterClass
	public void teardown() {
		SeleniumUtility utility = new SeleniumUtility(driver);
		utility.to_take_screenshot("src/test/resources/ScreenShots/facebooklogin.png");
		utility.getTitle();
		quit();
	}
		
	}

