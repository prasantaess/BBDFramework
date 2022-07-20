package stepdefinations;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;

import com.qa.factory.DriverFactory;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageLayers.LoginPageLayer;

public class LoginStepDefination {
	//Ctrl+shift+o is the shortcut key to import
	
	private LoginPageLayer Login = new LoginPageLayer(DriverFactory.getDriver());
	private static String pageTitle;
	
	@Given("^user is navigate to the login Page$")
	public void user_is_navigate_to_the_login_Page() throws Throwable {
		DriverFactory.getDriver().get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(5000);
		System.out.println("Entered the URL.");
	}

	@When("^user gets title of the page$")
	public void user_gets_title_of_the_page() throws Throwable {
		pageTitle = Login.getLoginpageTitle();
		System.out.println("Title of the page is..."+pageTitle);
	}

	@When("^user print url of the page$")
	public void user_print_url_of_the_page() throws Throwable {
	  String pageUrl= Login.getLoginpageURL();
	   System.out.println("Current Url of the Page.."+pageUrl);
	}

	@Then("^User verify the page name \"([^\"]*)\"$")
	public void user_verify_the_page_name(String arg1) throws Throwable {
	    
		Assert.assertTrue(pageTitle.contains(arg1));

	}

}
