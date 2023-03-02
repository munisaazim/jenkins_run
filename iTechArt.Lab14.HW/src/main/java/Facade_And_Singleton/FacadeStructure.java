package Facade_And_Singleton;

import org.openqa.selenium.WebDriver;

public class FacadeStructure {
    Singleton singleton;
    private WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    CartPage cartPage;
    Checkout checkout;
    String username = "standard_user";
    String password = "secret_sauce";

    FacadeStructure(){
        singleton = new Singleton();
        singleton.setUpDriver();
        this.driver = singleton.getDriver();
        singleton.setUp();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        checkout = new Checkout(driver);
    }
    public  void FacadeStructureRun(){
        loginPage.login(username, password);
        mainPage.sortItems();
        mainPage.addToCartProducts();
        mainPage.clickOnCartBox();
        cartPage.removeFirstProductAndCheckout();
        checkout.sendInformationAndFinish();
    }


}
