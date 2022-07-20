package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ApplicationHooks {
	
	private DriverFactory driverfactory;
	private ConfigReader configReader;
	private WebDriver driver;
	Properties prop;
	
	@Before(order = 0)
	/**
	 * This Method Reads the properties file form ConfigReader class
	 */
	public void getPropery() {
		configReader = new ConfigReader();
	    prop= configReader.init_prop();
		
	}
	@Before(order =1)
	/**
	 * This method call the parameter written in the properties file through getProperty().
	 */
	public void launchBrowser() throws InterruptedException {
		driverfactory= new DriverFactory();
		String browser= prop.getProperty("browser");
		driver= driverfactory.int_driver(browser);
	}
	
@After(order=-1)
/**
 * This Method is called to close the all browser instance at the Last
 * In this case the hooks works reverse. order i will execute first then order Zero. 
 */
public void quitBrowser() {
	driver.quit();
}
/**
 * This Method is for taking the screenshot if the test cases are failed 
 * @param scenario
 */
@After(order=1)
public void tearDown(Scenario scenario) {
	if(scenario.isFailed()) {
	String ScreenShotname = scenario.getName().replaceAll("", "");
	byte [] SourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	 scenario.embed(SourcePath, ScreenShotname);
	}
	
}








}
