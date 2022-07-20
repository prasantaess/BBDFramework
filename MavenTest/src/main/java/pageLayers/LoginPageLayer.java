package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageLayer {
	
	private WebDriver driver;
	
	// By Locators ---> Object Repository 
	
	private By emailid= By.id("email");
	private By password= By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	
	//2 . Create Constractor 
	
	public LoginPageLayer(WebDriver driver) {
		this.driver=driver;
	}
	
	// 3. Page Actions : features(Behavior) of the Page. 
	
	public String getLoginpageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginpageURL() {
		return driver.getCurrentUrl();
	}
	
	
	
	
	

}
