package runner;

import org.junit.runner.RunWith;

import org.junit.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/main/resources/features/employeedetails.feature",
		glue="stepdefinitions",
		tags = "@TC_01",
		monochrome=true,
		dryRun=false,
		plugin= {"pretty","json:target/cucumber.json"}
		) 

public class Runner {
	

}
