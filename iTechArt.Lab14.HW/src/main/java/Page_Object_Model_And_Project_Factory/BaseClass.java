package Page_Object_Model_And_Project_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    private WebDriver driver;
    private String browserName = "chrome";
    private String urlName = "https://www.saucedemo.com/";
    private WebDriverWait wait;
    public WebDriver initDriver(){
        switch (browserName){
            case "chrome":
                driver = new ChromeDriver();
                return driver;
            case "safari":
                driver = new SafariDriver();
                return driver;
            case "edge":
                driver = new EdgeDriver();
                return driver;
            default: throw new WebDriverException(browserName + "is not valid");
        }
    }
    public void setUpPage(){
        driver.manage().window().maximize();
        driver.get(urlName);
    }
    public void waitElement(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Exception e){
            throw new WebDriverException(element + "is unreachable");
        }
    }
}
