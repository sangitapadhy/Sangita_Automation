package com.testcase;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseclass.Library;
import com.pages.FacebookSignup;
import com.reusablefunction.SeleniumUtility;

public class Facebook_SignupTestcase  extends Library {
	FacebookSignup sn;
		SeleniumUtility util;

		@BeforeClass
		public void setup() throws IOException {
			launchApplication();
			
		}

		@Test
		public void Signup() {
			
			
		    sn= new  FacebookSignup(driver);
		    sn.EnterFirstName("raji");
			sn.Enterlastname("babu");
			sn.Entermobilenumber("54639893");
			sn.Enterpassword("starwar");
			sn.selectmonth("Mar");
			sn.selectday("11");
			sn.selectyear("2020");
			sn.clickfemale();
			sn.submit();
			
		}
			
			@AfterClass
			public void teardown() {
			 util=new SeleniumUtility(driver);
			 util.to_take_screenshot("src/test/resources/ScreenShots/facebooksignup.png");
			 util.getTitle();
				//quit();
			}
			
			
			
			

}
