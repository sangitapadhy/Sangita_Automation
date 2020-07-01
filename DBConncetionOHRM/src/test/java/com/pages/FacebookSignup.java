package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.baseclass.Library;

public class FacebookSignup extends Library{
	
	WebDriver driver;

	@FindBy(id = "u_0_m")
	WebElement FirstName;

	@FindBy(id = "u_0_o")
	WebElement Lastname;

	@FindBy(id = "u_0_r")
	WebElement Mobilenumber;

	@FindBy(id = "u_0_w")
	WebElement password;

	@FindBy(id = "month")
	WebElement we_month;

	@FindBy(id = "day")
	WebElement we_day;

	@FindBy(id = "year")
	WebElement we_year;
	
	@FindBy(id="u_0_6")
	WebElement submit;
	
	@FindBy(id="u_0_13")
	WebElement click;


	public void submit() {
		click.click();
	}
	
	public void clickfemale() {
		submit.click();
	}

	public void selectmonth(String month) {

		Select mm = new Select(we_month);
		mm.selectByVisibleText(month);

	}

	public void selectday(String day) {

		Select mm = new Select(we_day);
		mm.selectByVisibleText(day);

	}


	public void selectyear(String year) {

		Select mm = new Select(we_year);
		mm.selectByVisibleText(year);

	}

	public FacebookSignup(WebDriver driver)  {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void EnterFirstName(String FName) {
		FirstName.sendKeys(FName);

	}

	public void Enterlastname(String pass) {
		Lastname.sendKeys(pass);

	}

	public void Entermobilenumber(String pass) {
		Mobilenumber.sendKeys(pass);

	}

	public void Enterpassword(String pass) {
		password.sendKeys(pass);

	}
}

