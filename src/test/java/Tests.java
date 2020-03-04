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

    @BeforeClass
    public static void coverJourney() {
        seleniumConfig = new SeleniumConfig("chrome","/Users/anissubba/Documents/gradleProject/chromedriver");
        carJourney = new CarJourney(seleniumConfig.getDriver());
        }

    @Test
    public void PhaseOne(){
        carJourney.goToHomePage()
                .goToFindNewCarBtn()
                .clickNextStep()
                .pressContinue()
                .skipThisStep()
                .selectXF()
                .continueAfterTickBox()
                .getPrice();
    }
}
