package pageObjects;

import org.openqa.selenium.WebDriver;

public class managerPO {

    public landingPagePO landingPage;
    public offersPagePO offersPage;
    public WebDriver driver;
    public checkoutPO checkOutPO;

    public managerPO(WebDriver driver){
        this.driver = driver;
    };

    public landingPagePO getLandingPage(){
        landingPage = new landingPagePO(driver);
        return landingPage;
    }

    public offersPagePO offersPagePO(){
        offersPage = new offersPagePO (driver);
        return offersPage;
    }

    public checkoutPO getCheckOutPO(){
        checkOutPO = new checkoutPO (driver);
        return checkOutPO;
    }
}
