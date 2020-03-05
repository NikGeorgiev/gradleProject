package RockarJaguar.RockarWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarJourney {
    private WebDriver driver;
    private String homePageURL = "https://jaguar.rockar.com/";
    private By FindNewCarBtn = By.cssSelector("ul.navigation li");
    private By NextStepBtn = By.cssSelector(".button-narrow.next-step");
    private By ContinueBtn = By.cssSelector(".button-narrow.popup-continue");
    private By SkipThisStepBtn = By.cssSelector(".button.skip-button");
    private By SelectAllModels = By.cssSelector(".draggable .checkbox-values");
    private By ContinueAfterTickbox = By.cssSelector(".button.button-narrow.next-step.continue");

    private By SelectAllCarPrices = By.cssSelector("rockar-price");

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
    public CarJourney selectAllModels(){
        //Sleep for testing purposes
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> models = driver.findElements(SelectAllModels);
        for (int i = 0; i < 3; i++){
            models.get(i).click();
        }
        return this;
    }
    public CarJourney continueAfterTickBox(){
        driver.findElement(ContinueAfterTickbox).click();
        return this;
    }





}
