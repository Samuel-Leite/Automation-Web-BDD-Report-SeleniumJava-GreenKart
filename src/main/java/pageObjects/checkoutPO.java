package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class checkoutPO {

    public WebDriver driver;

    public checkoutPO(WebDriver driver){
        this.driver = driver;
    }

//  Mapping fields into variables for easier maintenance
    By cartBag = By.cssSelector("[alt='Cart']");
    By checkoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    By promoButton = By.cssSelector(".promoBtn");
    By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
    By country = By.cssSelector("[style='width: 200px;']");
    By termsConditions = By.cssSelector("[type='checkbox']");
    By proceedButton = By.xpath("//button[contains(text(),'Proceed')]");
    By messageOrder = By.cssSelector("[style='color:green;font-size:25px']");

    public void checkoutItems(){
        driver.findElement(cartBag).click();
        driver.findElement(checkoutButton).click();
    }

    public Boolean verifyPromoButton(){
        return driver.findElement(promoButton).isDisplayed();
    }

    public Boolean verifyPlaceOrder(){
        return driver.findElement(placeOrder).isDisplayed();
    }

    public void ordemItem(){
        driver.findElement(placeOrder).click();
    }

    public void chooseCountry(){
        Select product = new Select (driver.findElement(country));
        product.selectByVisibleText("Brazil");
    }

    public void termsAndConditions(){
        driver.findElement(termsConditions).click();
    }

    public void clickProceed(){
        driver.findElement(proceedButton).click();
    }

    public String getMessageOrder(){
        String text = driver.findElement(messageOrder).getText();
        Assert.assertEquals("Thank you, your order has been placed successfully\nYou'll be redirected to Home page shortly!!", text);
        return text;
    }
}
