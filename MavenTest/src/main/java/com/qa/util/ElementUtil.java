package com.qa.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;
	
	public ElementUtil(WebDriver webdriver) {
		this.driver = webdriver;
		
	}
	
	public void DivValue(By dashboardCount) {
		
		List<WebElement> Value= driver.findElements(dashboardCount);
		List<String> Count = new ArrayList<String>();
		int countitems= Value.size();
		System.out.println(countitems);
		for(WebElement e: Value) {
			String V= e.getText();
			Count.add(V);
			System.out.println(Count);
		}
	
		
	}

	public void JavaScriptClick(By locator) {
		
		WebElement Loc= driver.findElement(locator);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", Loc);
		System.out.println("Javascript Click on the Element");
		
	}
	
	public void JavaScriptScrollIntoView(By locator) {
		
		WebElement Loc= driver.findElement(locator);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", Loc);
		System.out.println("Javascript View to the Element");
		
	}
	
	public void doExplicitWait(WebDriver driver, Duration timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		System.out.println("Searching for the Elemnet Started at"+ java.time.LocalTime.now());
				
	}

}
