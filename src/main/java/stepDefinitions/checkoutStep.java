package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.checkoutPO;
import utils.testContextSetup;

public class checkoutStep {

public WebDriver driver;
public String landingPageProductName;
public checkoutPO checkOutPO;
testContextSetup testContextSetup;

public checkoutStep(testContextSetup testContextSetup){

    this.testContextSetup = testContextSetup;
    this.checkOutPO = testContextSetup.ManagerPO.getCheckOutPO();
}
    @Then("verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
        Assert.assertTrue(checkOutPO.verifyPromoButton());
        Assert.assertTrue(checkOutPO.verifyPlaceOrder());
    }

    @And("^user checkout products (.+) and check if user can enter promo code and order products$")
    public void user_checkout_products_and_check_if_user_can_enter_promo_code_and_order_products(String name) throws InterruptedException {
        checkOutPO.checkoutItems();
        Assert.assertTrue(checkOutPO.verifyPromoButton());
        Assert.assertTrue(checkOutPO.verifyPlaceOrder());
        Thread.sleep(2000);
    }

    @Then("^user proceeds to checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException {
        checkOutPO.checkoutItems();
//  Extract product name and compare with string name
    }

    @Then("order of the products and validate the order message successfully")
    public void order_of_the_products_and_validate_the_order_message_successfully() throws InterruptedException {
        checkOutPO.ordemItem();
        checkOutPO.chooseCountry();
        checkOutPO.termsAndConditions();
        Thread.sleep(2000);
        checkOutPO.clickProceed();

        checkOutPO.getMessageOrder();
    }
}