package com.qa.factory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	/**
	 * This method is used to initialize the thread local based on the browser parameter
	 * @param browser
	 * @return this will return WebDriver
	 * @throws InterruptedException 
	 */
	
	public WebDriver int_driver(String browser) throws InterruptedException {
		
		System.out.println("The Browser Option is .." +browser);
		if(browser.contains("chrome")) {
			System.out.println(browser);
			WebDriverManager.chromedriver().setup();			
			//System.setProperty("WebDriver.chrome.driver", "C:\\Users\\paull\\eclipse-workspace\\MavenTest\\chromedriver.exe");
			//WebDriver driver= new ChromeDriver();
			tlDriver.set(new ChromeDriver());
					}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			
		}
		else {
			System.out.println("Please use Correct  Driver...");
		}	
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return getDriver();		
	}
/**
 * This Method is for used for get driver	
 * @return thread
 */
public static synchronized WebDriver getDriver() {
	return tlDriver.get();
}
}
