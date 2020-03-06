package RockarJaguar.RockarWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CarJourney {
    private WebDriver driver;

    private String homePageURL = "https://jaguar.rockar.com/";
    private By FindNewCarBtn = By.cssSelector("ul.navigation li");
    private By NextStepBtn = By.cssSelector(".button-narrow.next-step");
    private By ContinueBtn = By.cssSelector(".button-narrow.popup-continue");
    private By SkipThisStepBtn = By.cssSelector(".button.skip-button");

    private By SelectAllModels = By.cssSelector(".checkbox-values");
    private By Span = By.cssSelector("label[for=cs0706] span");
    private By Carousel = By.cssSelector("label[for=cs0706]");
    private By ClickOnArrow = By.cssSelector("document.querySelector(\"#model-filter > div > div > div > div > span.slick-next.slick-arrow\")");

    private By ContinueAfterTickbox = By.cssSelector(".button.button-narrow.next-step.continue");
    public String carPriceSelector = ".rockar-price .price";

    public CarJourney (WebDriver driver){
        this.driver = driver;
    }

    public WebDriverWait getDriverWait() {
        return new WebDriverWait(driver, 15);
    }

    public CarJourney waitForPreloader() {
        List<WebElement> preloaders = driver.findElements(By.cssSelector( ".general-preloader"));
        getDriverWait().until(ExpectedConditions.invisibilityOfAllElements(preloaders));

        return this;
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

    /*public CarJourney displayAllCheckboxes(){

        waitForPreloader();
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(Carousel);
        WebElement span = driver.findElement(Span);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        actions.moveToElement(span).click().perform();
        return this;
    }

    public CarJourney clickArrow(){
        driver.findElement(ClickOnArrow).click();
        return this;
    }*/

    public CarJourney selectAllModels(){
        //Sleep for testing purposes
        waitForPreloader();
        List<WebElement> models = driver.findElements(SelectAllModels);
        for (int i = 0; i < models.size(); i++){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", models.get(i));
            getDriverWait().until(ExpectedConditions.elementToBeClickable(models.get(i)));
            models.get(i).click();
        }

        return this;
    }

    public CarJourney continueAfterTickBox(){
        driver.findElement(ContinueAfterTickbox).click();
        return this;
    }

    public CarJourney loadPage(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");

        return this;
    }

    public CarJourney getPrice (){
        //sleep for testing purposes
        waitForPreloader();
        // list all the cars in the page and prints it out
        List<WebElement> carPriceList = driver.findElements(By.cssSelector(carPriceSelector));
        carPriceList.forEach((i) -> System.out.println((i.getText().replaceAll("[£,]", ""))));
        //had to sleep as it was too fast
        waitForPreloader();
        //Calculates the total Price of the cars avaliable
        int totalPriceOfAvailableCars = 0;
        for (WebElement a : carPriceList){
            totalPriceOfAvailableCars += Integer.parseInt(a.getText().replaceAll("[£,]", ""));
        }
        System.out.println("Total Prices of Cars: " + totalPriceOfAvailableCars);
        driver.quit();
        return this;
    }
}
