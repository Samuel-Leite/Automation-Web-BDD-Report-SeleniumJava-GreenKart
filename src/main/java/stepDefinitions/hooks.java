package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.testContextSetup;

import java.io.File;
import java.io.IOException;

public class hooks {

    testContextSetup testContextSetup;

    public hooks(testContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @After
    public void afterScenario() throws IOException, InterruptedException {
        Thread.sleep(2000);
        testContextSetup.TestBase.webDriverManager().quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {

        WebDriver driver = testContextSetup.TestBase.webDriverManager();
        if(scenario.isFailed()){
//            screenshot para o Extent Report Cucumber
            File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte [] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "name");
        }
    }
}