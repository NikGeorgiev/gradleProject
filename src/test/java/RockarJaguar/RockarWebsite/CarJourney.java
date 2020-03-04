package RockarJaguar.RockarWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CarJourney {
    private WebDriver driver;
    private String homePageURL = "https://jaguar.rockar.com/";
    private By FindNewCarBtn = By.cssSelector("ul.navigation li");
    private By NextStepBtn = By.xpath("/html/body/div[5]/div[3]/div/div/div/div[5]/div[1]/button[2]");
    private By ContinueBtn = By.xpath("//*[@id=\"finance-filter\"]/div[4]/div[2]/div/div/div/div/div[2]/button[2]");
    private By SkipThisStepBtn = By.xpath("//*[@id=\"car-finder\"]/div[4]/div[2]/div[3]/div[1]/div/div[3]/div/button");
    private By SelectXfModel = By.cssSelector(".slick-center img");
    private By ContinueAfterTickbox = By.xpath("//*[@id=\"car-finder\"]/div[5]/div[1]/button[3]");
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
