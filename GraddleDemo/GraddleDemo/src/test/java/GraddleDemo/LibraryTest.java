package GraddleDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibraryTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); //no need to update the driver
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.Facebook.com");
		System.out.println("The Title of the page is "+ driver.getTitle());
	}
	}