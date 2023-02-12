package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/appFeatures/login_logout.feature"},
        glue = {"stepDefinitions", "AppHooks"},
        plugin = {"pretty",
                "html:target/Reports/cucumber-reports.html",
                "json:target/Reports/cucumber-reports.json",
                "junit:target/Reports/cucumber-reports.xml" },
        publish = true)




public class CucumberTestRunner {

}


