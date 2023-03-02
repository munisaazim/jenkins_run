package Facade_And_Singleton;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    @FindBy(xpath = "//*[@class = 'product_sort_container']")
    private WebElement sortButton;
    @FindBy(xpath = "//*[@class = 'active_option']")
    private WebElement sortContainer;
    @FindBy(xpath = "//*[@class = 'cart_list']")
    private WebElement cartListOfProducts;
    @FindBy(xpath = "//*[contains(@data-test, 'add-to-cart')]")
    private WebElement addCart;
    @FindBy(xpath = "//*[@class = 'shopping_cart_link']")
    private WebElement shoppingBoxCart;
    MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void sortItems(){
        Select sortItem = new Select(sortButton);
        sortItem.selectByValue("za");
        Assert.assertTrue(sortContainer.isDisplayed());
    }
    public void addToCartProducts(){
        String[] addingItems = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket"};
        List<String> productNames = new ArrayList<>();
        for(int i =0; i<addingItems.length; i++){
            productNames.add(addingItems[i]);
        }
        List<WebElement> productNamesClickButton = new ArrayList<>();
        for (String productName : productNames) {
            WebElement product = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
            WebElement addToCartButton = addCart;
            productNamesClickButton.add(addToCartButton);
        }
        for (WebElement button : productNamesClickButton) {
            try {
                button.click();
            } catch (StaleElementReferenceException e) {
                // Refresh the page and find the element again
                driver.navigate().refresh();
                WebElement newButton = addCart;
                newButton.click();
            }
        }
    }
    public void clickOnCartBox(){
        shoppingBoxCart.click();
        Assert.assertTrue(cartListOfProducts.isDisplayed());
    }
}
