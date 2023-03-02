package Page_Object_Model_And_Project_Factory;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC1 {
    WebDriver driver;
    LoginPage loginPage;
    BaseClass baseClass;
    MainPage mainPage;
    CartPage cartPage;
    Checkout checkout;
    String username = "standard_user";
    String password = "secret_sauce";

    @BeforeTest
    public void setUp(){
        baseClass = new BaseClass();
        driver = baseClass.initDriver();
        baseClass.setUpPage();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        checkout = new Checkout(driver);
    }
    @Test
    public void loginValidation(){
        loginPage.login(username, password);
        mainPage.sortItems();
        mainPage.addToCartProducts();
        mainPage.clickOnCartBox();
        cartPage.removeFirstProductAndCheckout();
        checkout.sendInformationAndFinish();
    }
    @AfterTest
    public void quit(){
        driver.quit();
    }
}
