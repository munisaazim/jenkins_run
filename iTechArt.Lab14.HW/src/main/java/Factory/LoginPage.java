package Factory;

import Page_Object_Model_And_Project_Factory.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private BaseClass baseClass;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        baseClass = new BaseClass();
    }
    @FindBy(xpath = "//*[@placeholder = \"Username\"]")
    private WebElement username;
    @FindBy(xpath = "//*[@placeholder = \"Password\"]")
    private WebElement password;
    @FindBy(xpath = "//*[@type = \"submit\"]")
    private WebElement login;
    public void login(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        login.click();
    }
}
