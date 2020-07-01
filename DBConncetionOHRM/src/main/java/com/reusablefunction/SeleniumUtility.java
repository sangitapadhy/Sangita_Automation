package com.reusablefunction;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.Library;


public class SeleniumUtility extends Library {
	
WebDriver driver;
	
	public SeleniumUtility (WebDriver driver) {
		this.driver=driver;
	}    
	//For ScreenShot
	public void to_take_screenshot(String path) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source,new File(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	//Get Title
	public void getTitle() {
		System.out.println(driver.getTitle());
	}
	
	     
	
	//DropDown
	public void selectdropdown(String id, String text) {
		Select dd=new Select(driver.findElement(By.id(id)));
		dd.selectByVisibleText(text);
	}
	
	//To Select Checkbox
		public void Select_The_Checkbox(WebElement element) {
			try {
	            if (element.isSelected()) {
	               System.out.println("Checkbox: " + element + "is already selected");
	            } else {
	            		element.click();
	            		}
	        	} catch (Exception e) {
	        	System.out.println("Unable to select the checkbox: " + element);
	        			}
		}
	
		//To deselect Checkbox
		public void DeSelect_The_Checkbox(WebElement element) {
			try {
	            if (element.isSelected()) {
	            	  element.click();
	            	} else {
	            	System.out.println("Checkbox: "+element+"is already deselected");
	            }
	        } catch (Exception e) {
	        	System.out.println("Unable to deselect checkbox: "+element);
	        }
	    }
		
		//To select multiple checkboxes
		public void Select_The_CheckBox_from_List(WebElement element, String valueToSelect) {
			List<WebElement> allOptions = element.findElements(By.tagName("input"));
			for (WebElement option : allOptions) {
				   System.out.println("Option value "+option.getText());
				        if (valueToSelect.equals(option.getText())) {
				            option.click();
				            break;
				        }
				    }
		}
		
		//DatePicker
		public void datePicker(String xpathPick) {
			driver.findElement(By.xpath(xpathPick)).click();
		}
	
		public void quit() {
			driver.close();
		
		}



}
