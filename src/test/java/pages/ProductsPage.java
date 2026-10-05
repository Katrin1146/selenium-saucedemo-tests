package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ProductsPage {
    private WebDriver driver;
    private By buttonCard = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_badge");
    private By productTitle = By.className("title");
    private By removeClick = By.id("remove-sauce-labs-backpack");
    private By nextbuttonCard = By.id(("add-to-cart-sauce-labs-bike-light"));
    private By productCards = By.className("inventory_item");
    private By productName = By.className("inventory_item_name");
    private By productPrice = By.className("inventory_item_price");
    private By productButton = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory");



    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAdd(){
        driver.findElement(buttonCard).click();
    }

    public String getCartCont(){
        return driver.findElement(cartBadge).getText();
    }

    public String getProductTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.textToBe(
                productTitle,
                "Products"
        ));

        return driver.findElement(productTitle).getText();
    }

    public void removeCard(){
        driver.findElement(removeClick).click();
    }
    public boolean isCartBadgeDisplayed(){
        return !driver.findElements(cartBadge).isEmpty();
    }
    public void addNextButtonCard(){
        driver.findElement(nextbuttonCard).click();
    }
    public int cardsCount (){
        return driver.findElements(productCards).size();
    }
    public boolean areAllProductsComplete(){
        List<WebElement> cards = driver.findElements(productCards);
        for (WebElement card: cards) {
            String name = card.findElement(productName).getText();
            String price = card.findElement(productPrice).getText();
            WebElement button = card.findElement(productButton);

            if (name.isEmpty() || price.isEmpty() || !button.isDisplayed()) {
                return false;
            }

        }return true;
    }

}
