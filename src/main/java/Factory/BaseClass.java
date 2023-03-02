package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    private WebDriver driver;
    private String browserName = "chrome";
    private String urlName = "https://www.saucedemo.com/";
    private WebDriverWait wait;
    public BaseClass(WebDriver driver){
        this.driver = driver;
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
