package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.landingPagePO;
import utils.testContextSetup;

public class landingPageStep {

public WebDriver driver;
public String landingPageProductName;
testContextSetup testContextSetup;
landingPagePO LandingPage;

public landingPageStep(testContextSetup testContextSetup){

    this.testContextSetup = testContextSetup;
    this.LandingPage = testContextSetup.ManagerPO.getLandingPage();
}

    @Given("user is on GreenKart page")
    public void user_is_on_green_kart_page() {
//    Boolean validation if the title contains the name GreenKart
        Assert.assertTrue(LandingPage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("^user searched with shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        LandingPage.searchItem(shortName);
        Thread.sleep(2000);
        testContextSetup.landingPageProductName = LandingPage.getProductName().split("-")[0].trim();
        System.out.println(landingPageProductName + " is extracted from Home Page");
    }

    @And("add {string} items of the selected product to cart")
    public void add_items_of_the_selected_product_to_cart(String quantity) {
        LandingPage.incrementQuantity(Integer.parseInt(quantity));
        LandingPage.addToCart();
    }

    @When("user searches {string} and adds {string} from product to cart")
    public void user_searches_and_adds_from_product_to_cart(String name, String quantity) throws InterruptedException {
        LandingPage.searchItem(name);
        Thread.sleep(2000);
        testContextSetup.landingPageProductName = LandingPage.getProductName().split("-")[0].trim();
        System.out.println(landingPageProductName + " is extracted from Home Page");

        Thread.sleep(2000);
        LandingPage.incrementQuantity(Integer.parseInt(quantity));
        LandingPage.addToCart();

        LandingPage.cleanSearch();
        Thread.sleep(2000);
        LandingPage.cleanQuantity();
    }
}