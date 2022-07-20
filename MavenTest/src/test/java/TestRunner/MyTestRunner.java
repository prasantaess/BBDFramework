package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	
		features= {"src/test/resources/com/features"},
		glue={"stepdefinations","AppHooks"},
		plugin = {"pretty","html:target/cucumber-reports",
		
		},
				tags = {"~@Flipkart"},
				strict = false,
                dryRun = false,
                monochrome = true
		
		
		
		
		)


public class MyTestRunner {

}
