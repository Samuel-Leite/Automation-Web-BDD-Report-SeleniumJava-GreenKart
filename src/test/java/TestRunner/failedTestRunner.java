package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Executar apenas os cenários que obtiveram erros para validar se é bug
@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failed_scenarios.txt",
        glue = "stepDefinitions",
        monochrome = true,
//        dryRun = true,
        plugin = {"html:target/cucumber.html", "json:target/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class failedTestRunner {

}