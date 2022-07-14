package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class testBase {

    public WebDriver driver;

    public WebDriver webDriverManager() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("QAUrl"); // faz Get da URL
        String browser_properties = prop.getProperty("browser"); // faz Get da informação no arquivo globais enfatizando o browser
        String browser_maven = System.getProperty("browser"); // codigo para executar via Maven em linha de comando

        String browser = browser_maven!=null ? browser_maven : browser_properties;

        if (driver == null){

            if (browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\browsers\\chromedriver.exe");
                driver = new ChromeDriver();
            }
            if (browser.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\browsers\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
        }
        return driver;
    }
}