package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.landingPagePO;
import pageObjects.managerPO;
import pageObjects.offersPagePO;
import utils.testContextSetup;

public class offersPageStep {

public WebDriver driver;
public String landingPageProductName;
public String offersPageProductName;
testContextSetup testContextSetup;
managerPO ManagerPO;

public offersPageStep(testContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    public void switchToOffersPage(){
        landingPagePO LandingPage = testContextSetup.ManagerPO.getLandingPage();
        LandingPage.selectTopDealsPage();
        testContextSetup.GenericUtils.switchWindowToChild();
    }

    @Then("^user searched for (.+) shortname in offers page to check if product exist$")
    public void user_searched_for_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {

        switchToOffersPage();
        offersPagePO offersPage = testContextSetup.ManagerPO.offersPagePO();
        offersPage.searchItem(shortName);
        Thread.sleep(2000);
        offersPageProductName = offersPage.getProductName();
    }

    @And("validate product name in offer page matches with landing page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {

        Assert.assertEquals(offersPageProductName, testContextSetup.landingPageProductName);
    }
}
