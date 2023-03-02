package Facade_And_Singleton;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
    private WebDriver driver;
    String savedFirstName = "Username";
    String savedSecondName = "Password";
    String savedZipCode = "01111";
    Checkout(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@placeholder = \"First Name\"]")
    private WebElement firstName;
    @FindBy(xpath = "//*[@placeholder = \"Last Name\"]")
    private WebElement secondName;
    @FindBy(xpath = "//*[@placeholder = \"Zip/Postal Code\"]")
    private WebElement zipCode;
    @FindBy(xpath = "//*[@type = \"submit\"]")
    private WebElement continueBtn;
    @FindBy(xpath = "//*[@data-test = \"finish\"]")
    private WebElement finishBtn;
    @FindBy(xpath = "//*[text() = \"Thank you for your order!\"]")
    private WebElement thankYouText;

    public void sendInformationAndFinish(){
        firstName.sendKeys(savedFirstName);
        secondName.sendKeys(savedSecondName);
        zipCode.sendKeys(savedZipCode);
        continueBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"));
        finishBtn.click();
        Assert.assertTrue(thankYouText.isDisplayed());
    }

}
