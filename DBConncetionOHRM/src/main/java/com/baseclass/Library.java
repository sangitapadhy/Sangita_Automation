package com.baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Library {
	
	protected WebDriver driver;
	public static Properties prop;
	public void launchApplication() throws IOException {
		
		FileInputStream file=new FileInputStream("src/test/resources/Configuration/config.properties");
	
		prop=new Properties();
		prop.load(file);
		String browser = prop.getProperty("browser");

		String url = prop.getProperty("url");

		try {
			
			if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
				  
			}
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		
		}catch(WebDriverException e) {
		System.out.println("browser could not be launched");
		}
	}

	
	//to open orangeHRM 
	
	public void OHRM_launchApplication() throws IOException {
		FileInputStream file=new FileInputStream("src/test/resources/Configuration/config.properties");
		prop=new Properties();
		prop.load(file);
		String browser = prop.getProperty("browser");
		String OHRM_url = prop.getProperty("OHRM_url");
		System.setProperty("webdriver.chrome.driver","D:\\QA_Agama\\Softwares\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(OHRM_url);
			
	}
	
		
			public void quit() {
			driver.close();
			
		}

		
	}


