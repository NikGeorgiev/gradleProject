package RockarJaguar.SeleniumConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumConfig {

    private WebDriver driver;

    public SeleniumConfig(String browser, String driverPath){
        if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        }

    }

    public WebDriver getDriver() {
        return driver;
    }

}

//public class SeleniumConfig {
//
//    private static WebDriver driver;
//    public static final int implicitWaitTime = 10;
//    //Chrome options... but not yet
//
//    public static void setWebDriver() {
//        driver = new ChromeDriver();  //?
//        setDriverTimeout(implicitWaitTime);
//    }
//
//    public static WebDriver getWebDriver() {
//        return driver;
//    }
//
//    public static void shutDownDriver() {
//        driver.quit();
//    }
//
//    public static void startBrowser() {
//        setWebDriver();
//    }
//
//    public static void setDriverTimeout(int waitTime) {
//        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
//    }
//
//}

//    public SeleniumConfig(String browser, String driverPath) {
//        if (browser.equalsIgnoreCase("chrome")) {
//            System.setProperty("webdriver.chrome.driver", driverPath);
//            driver = new ChromeDriver();
//            drive = driver;
//        }
//    }
//
//    public WebDriver getDriver() {
//        return driver;
//    }
//    public SeleniumConfig(){
//
//    }
//
//    public void waitFor(int index, String path){
//        WebDriverWait wait = new WebDriverWait(drive, 5);
//
//        if(index == 0){ //xpath of element to wait for
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
//        }
//        if(index == 1){ //id of element to wait for
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(path)));
//            wait.until(ExpectedConditions.elementToBeClickable(By.id(path)));
//        }
//        if(index == 2){ //class of element to wait for
//
//        }
//
//    }


