package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/main/java/cucumber/feature"},
        glue = {"cucumber/stepDef"},
        plugin = {"pretty:target/cucumber-pretty.txt", "html:target/cucumber-html-report"})
public class Runner extends AbstractTestNGCucumberTests {

}
