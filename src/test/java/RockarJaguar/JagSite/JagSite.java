package RockarJaguar.JagSite;

import RockarJaguar.RockarWebsite.CarJourney;
import org.openqa.selenium.WebDriver;

public class JagSite {

    private WebDriver driver;
    private CarJourney carJourney;


    public JagSite(WebDriver driver){
        this.driver = driver;
        this.carJourney= new CarJourney(driver);

    }
    public CarJourney getCarJourney(){
        return carJourney;
    }


}
