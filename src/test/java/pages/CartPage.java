package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    public WebDriver driver;
    private By cart  = By.className("shopping_cart_link");
    private By cartTitle = By.className(("title"));
    private By productName = By.className("inventory_item_name");
    private By cartItem = By.className("cart_item");
    private By productPrice = By.className("inventory_item_price");
    private By removeButton = By.id("remove-sauce-labs-backpack");
    private By continueButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    private By checkoutCart = By.className("title");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickCart(){
        driver.findElement(cart).click();
    }
    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(cartTitle, "Your Cart"));
        return driver.findElement(cartTitle).getText();
    }
    public String getProductName(){
        return driver.findElement(productName).getText();
    }
    public int getCartItemsCount() {
        return driver.findElements(cartItem).size();
    }
    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }
    public void removeButtonClick(){
        driver.findElement(removeButton).click();
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();

    }
    public String getProductName(int index){
        return driver.findElements(productName).get(index).getText();
    }
    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }
    public String getCheckoutTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(checkoutCart, "Checkout: Your Information"));
        return driver.findElement(checkoutCart).getText();
    }

}
