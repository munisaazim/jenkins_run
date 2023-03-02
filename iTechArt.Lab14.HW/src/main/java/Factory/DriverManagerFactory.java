package Factory;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;

import static org.openqa.selenium.remote.Browser.CHROME;
import static org.openqa.selenium.remote.Browser.FIREFOX;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {
        DriverManager driverManager = null;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
            case EDGE:
                driverManager = new EdgeDriverManager();
            default:
                break;
        }
        return driverManager;
    }
}
