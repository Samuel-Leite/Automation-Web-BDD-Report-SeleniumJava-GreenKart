package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.managerPO;

import java.io.IOException;

public class testContextSetup {

    public WebDriver driver;
    public String landingPageProductName;
    public managerPO ManagerPO;
    public testBase TestBase;
    public genericUtils GenericUtils;

    public testContextSetup() throws IOException {
        TestBase = new testBase();
        ManagerPO = new managerPO(TestBase.webDriverManager());
        GenericUtils = new genericUtils(TestBase.webDriverManager());
    }
}
