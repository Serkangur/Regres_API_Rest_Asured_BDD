package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-reports.html"
        },
        features = "src/main/resources/features",
        glue = "stepdefinations",
        tags = ""
)




public class TestRunner {
}