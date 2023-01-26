package Testrunner;

import org.testng.annotations.Test;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features ="Features",
glue = {"Stepdefinitions"}
//tags  = "@cart"

)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	
	
	
 
}
