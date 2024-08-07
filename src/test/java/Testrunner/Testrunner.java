package Testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\eclipse-workspace\\TestNGCucumber\\src\\main\\resources\\Featuresfile\\secondopinion.feature",
glue = "Steps")
public class Testrunner extends AbstractTestNGCucumberTests {

}
