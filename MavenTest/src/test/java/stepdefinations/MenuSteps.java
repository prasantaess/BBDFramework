package stepdefinations;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.factory.DriverFactory;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageLayers.MenuPage;

public class MenuSteps {
	
	private MenuPage menu= new MenuPage(DriverFactory.getDriver());
	private WebDriver driver;
	
	@When("^User gets The Menu Sections$")
	public void user_gets_The_Menu_Sections(DataTable MenuList) throws Throwable {
		
		System.out.println(MenuList);
		//ArrayList<String> Expected = new ArrayList<String>(MenuList.asLists());
		//System.out.println(Expected);
		List<String> Actual= menu.MenuList();
		System.out.println(Actual);
		
	}
	
	
	@Given("^User landed on the \"([^\"]*)\"$")
	public void user_landed_on_the(String arg1) throws Throwable {
		menu.setdriver(arg1);
	}

	@When("^User click the height value$")
	public void user_click_the_height_value() throws Throwable {
		
		menu.priceList();
		
	}


	
	
	
}
