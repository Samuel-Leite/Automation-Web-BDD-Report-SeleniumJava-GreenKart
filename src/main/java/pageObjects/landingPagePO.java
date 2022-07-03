package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class landingPagePO {

    public WebDriver driver;

    public landingPagePO(WebDriver driver){
        this.driver = driver;
    }

//  Mapping fields into variables for easier maintenance
    By search = By.xpath("//input[@type='search']");
    By productName = By.cssSelector("h4.product-name");
    By topDeals = By.linkText("Top Deals");
    By increment = By.cssSelector("a.increment");
    By addToCart = By.cssSelector(".product-action button");
    By quantity = By.xpath("//input[@class='quantity']");

    public void searchItem(String name){
        driver.findElement(search).sendKeys(name);
    }

    public void getSearchText(){
        driver.findElement(search).getText();
    }

    public void incrementQuantity (int quantity){
        int i = quantity-1;
        while (i>0){
            driver.findElement(increment).click();
            i--;
        }
    }

    public void addToCart(){
        driver.findElement(addToCart).click();
    }

    public void cleanSearch(){
        driver.findElement(search).clear();
    }

    public void cleanQuantity(){
        driver.findElement(quantity).clear();
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public void selectTopDealsPage(){
        driver.findElement(topDeals).click();
    }

    public String getTitleLandingPage(){
        return driver.getTitle();
    }
}
