package co.uk.directlinegroup.tt;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "junit:target/junit_cucumber.xml", "json:target/cucumber.json"},
        format = {"html:target/site/cucumber-pretty"},
        features = {"@target/target/cucumber_reports/regression_results/Rerun.txt"},
        //tags = {"@tag"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class RunCukesSequence {
}
