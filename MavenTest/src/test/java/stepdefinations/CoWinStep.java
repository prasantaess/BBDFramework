package stepdefinations;

import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageLayers.CoWinPage;

public class CoWinStep {
	
	private CoWinPage CoWin =new CoWinPage(DriverFactory.getDriver());
	
	@Given("^User landed to the Home Page$")
	public void user_landed_to_the_Home_Page() throws Throwable {
		DriverFactory.getDriver().get("https://www.cowin.gov.in/");
		Thread.sleep(2000);
		System.out.println("User navigate to the Cowin Home Page");
		String pageTitle= CoWin.getLoginpageTitle();
		System.out.println(pageTitle);
	}

	@When("^user select state and district$")
	public void user_select_state_and_district() throws Throwable {
		String pageURL=CoWin.getLoginpageURL();
		System.out.println(pageURL);
	}

	@When("^user click on the search button$")
	public void user_click_on_the_search_button() throws Throwable {
		CoWin.SelectState();
		CoWin.SelectDistrict();
		CoWin.ClickSearch();  
	}

	@Then("^verify the dynamic WebTable$")
	public void verify_the_dynamic_WebTable() throws Throwable {
		CoWin.verifyWebTable();
		
	}
/*
 * Cose for Scenario 2	
 */
	@Given("^User landed to the dashboard Page$")
	public void user_landed_to_the_dashboard_Page() throws Throwable {
	 
		DriverFactory.getDriver().get("https://dashboard.cowin.gov.in/");
		Thread.sleep(2000);
		System.out.println("User navigate to the Cowin DashBoard Page");
		String pageTitle= CoWin.getLoginpageTitle();
		System.out.println(pageTitle);
		
	}

	@When("^user print all the corresponding data$")
	public void user_print_all_the_corresponding_data() throws Throwable {
		
		CoWin.printTheCorrespondingData();	
	   
	}

	@When("^user print all the SVG graph value$")
	public void user_print_all_the_SVG_graph_value() throws Throwable {
		CoWin.iterateLast30Days();
		CoWin.googleSvgAutomate();
	}

}
