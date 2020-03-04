package RockarJaguar.RockarWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CarJourney {
    private WebDriver driver;
    private String homePageURL = "https://jaguar.rockar.com/";
    private By FindNewCarBtn = By.cssSelector("ul.navigation li");
    private By NextStepBtn = By.cssSelector("#car-finder > div.navigation-buttons-wrapper.col-12 > div.navigation-outer-container > button:nth-child(2)");
    private By ContinueBtn = By.cssSelector("#finance-filter > div.popup.finance-confirmation-popup > div.popup-container > div > div > div > div > div.row.align-right > button.button.button-narrow.popup-continue");
    private By SkipThisStepBtn = By.cssSelector("#car-finder > div.car-finder-filters > div.part-exchange > div.substep-1 > div.row > div > div.part-exchange-right > div > button");
    private By SelectXfModel = By.cssSelector(".slick-center img");
    private By ContinueAfterTickbox = By.cssSelector("#car-finder > div.navigation-buttons-wrapper.col-12 > div.navigation-outer-container > button.button.button-narrow.next-step.continue.desktop-tablet-only");
    public CarJourney (WebDriver driver){

        this.driver = driver;
    }



    public CarJourney goToHomePage(){
        waitForElement();
        driver.navigate().to(homePageURL);
        return this;

    }

    public CarJourney goToFindNewCarBtn(){
        waitForElement();
        driver.findElement(FindNewCarBtn).click();
        return this;

    }

    public CarJourney clickNextStep(){
        waitForElement();
        driver.findElement(NextStepBtn).click();
        return this;
    }
    public CarJourney waitForElement() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }
    public CarJourney pressContinue(){
        driver.findElement(ContinueBtn).click();
        return this;

    }
    public CarJourney skipThisStep(){
        driver.findElement(SkipThisStepBtn).click();
        return this;
    }
    public CarJourney selectXF(){
        //Sleep for testing purposes
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(SelectXfModel).click();
        return this;
    }
    public CarJourney continueAfterTickBox(){
        driver.findElement(ContinueAfterTickbox).click();
        return this;
    }




}
