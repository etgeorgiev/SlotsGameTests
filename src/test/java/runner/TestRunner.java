package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/hereKittyKitty.feature"} ,
        glue = {"steps", "hooks"},
        plugin = {"pretty", "html:target/cucumberReports.html"},
        monochrome = true)
public class  TestRunner {
}






