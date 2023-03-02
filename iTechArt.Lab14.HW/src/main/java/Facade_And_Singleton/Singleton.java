package Facade_And_Singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Singleton {
    public static WebDriver driver = null;
    private static String url = "https://www.saucedemo.com/";
    public static String browserName = "chrome";

    public static void setUpDriver(){
        if(driver==null){
            if(browserName.equalsIgnoreCase("chrome"))
                driver = new ChromeDriver();
            else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
            else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }
        }
    }
    public static WebDriver getDriver(){
        return  driver;
    }
    public static void setUp(){
        driver.manage().window().maximize();
        driver.get(url);
    }
    public static void quit(){
        driver.quit();
    }
}
