package Facade_And_Singleton;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[contains(@data-test, \"sauce-labs-onesie\")]")
    private WebElement removeBtn;
    @FindBy(xpath = "//button[@data-test = \"checkout\"]")
    private WebElement checkOutBtn;

    public void removeFirstProductAndCheckout(){
        removeBtn.click();
        checkOutBtn.click();
        String getUrl = driver.getCurrentUrl();
        Assert.assertTrue(getUrl.contains("checkout-step-one"));
    }

}
