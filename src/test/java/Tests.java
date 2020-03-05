import RockarJaguar.RockarWebsite.CarJourney;
import RockarJaguar.SeleniumConfig.SeleniumConfig;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.TestInstance;
import static org.junit.Assume.assumeThat;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.*;
//import static org.hamcrest.Matchers.*;
import java.io.CharArrayReader;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Tests {

    private static SeleniumConfig seleniumConfig;
    private static CarJourney carJourney;

    //public WebDriver driver = new ChromeDriver();


    @BeforeClass
    public static void coverJourney() {
        seleniumConfig = new SeleniumConfig("chrome","/Users/nikolaygeorgiev/Desktop/GradleProject1/chromedriver");
        carJourney = new CarJourney(seleniumConfig.getDriver());

        }
//        CarJourney carJourney = new CarJourney();
//    }

    @Test
    public void PhaseOne(){
        carJourney.goToHomePage()
                .goToFindNewCarBtn()
                .clickNextStep()
                .pressContinue()
                .skipThisStep()
                .selectAllModels()
                .continueAfterTickBox()
                .loadPage()
                .getPrice();
    }

//    @Test
//    public void PhaseTwo(){
//        carJourney.goToFindNewCarBtn();
//    }
//    @Test
//    public void PhaseThree(){
//        carJourney.clickNextStep();
//    }

//    @Test
//    public void DemoMitsubishiCarsTotal(){
//        System.setProperty("webdriver.chrome.drive", "chromedriver");
//        driver.get("https://www.mitsubishi-motors.co.uk/cars/eclipse-cross");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        List<WebElement> price = driver.findElements(By.cssSelector("#selector-2-tab-4 > div > a > div > p > span"));
//        price.forEach((i) -> System.out.println(i.getText().replaceAll("[£,]","")));
//        int total = 0;
//        for (WebElement a : price){
//            total += Integer.parseInt(a.getText().replaceAll("[£,]",""));
//        }
//        System.out.println("Total: " + total);
//        driver.close();
//    }

//    @Test
//    public void DemoAutoTradeCarsTotal(){
//        System.setProperty("webdriver.chrome.drive", "chromedriver");
//        driver.get("https://www.autotrader.co.uk/car-search?advertClassification=standard&postcode=HU6%207JH&on" +
//                "esearchad=Used&onesearchad=Nearly%20New&onesearchad=New&advertising-location=at_cars&is-quick-search=TRUE&page=1");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        List<WebElement> price = driver.findElements(By.cssSelector(".search-page__result .vehicle-price"));
//        price.forEach((i) -> System.out.println(i.getText().replaceAll("[£,]","")));
//        int total = 0;
//        for (WebElement b : price){
//            total += Integer.parseInt(b.getText().replaceAll("[£,]", ""));
//        }
//        System.out.println("Total: " + total);
//        driver.close();
//    }




}
