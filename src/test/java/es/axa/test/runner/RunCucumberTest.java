package es.axa.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"},
        glue = {"es.axa.test", "cucumber.api.spring"},
        features = "src/test/resources/features"
)
public class RunCucumberTest {
}
