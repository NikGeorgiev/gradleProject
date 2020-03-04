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
    private By SelectXfModel = By.cssSelector(".slick-center img");
    private By ContinueAfterTickbox = By.cssSelector(".button.button-narrow.next-step.continue");
    public String carPriceSelector = ".rockar-price .price";

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
            Thread.sleep(5000);
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

    public CarJourney getPrice (){
        //sleep for testing purposes
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // list all the cars in the page and prints it out
        List<WebElement> carPriceList = driver.findElements(By.cssSelector(carPriceSelector));
        carPriceList.forEach((i) -> System.out.println((i.getText().replaceAll("[£,]", ""))));
        //had to sleep as it was too fast
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Calculates the total Price of the cars avaliable
        int totalPriceOfAvailableCars = 0;
        for (WebElement a : carPriceList){
            totalPriceOfAvailableCars += Integer.parseInt(a.getText().replaceAll("[£,]", ""));
        }
        System.out.println("Total Prices of Cars: " + totalPriceOfAvailableCars);
        driver.close();
        return this;
    }
}
