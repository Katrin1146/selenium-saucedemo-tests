package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    public WebDriver driver;
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipPostalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");
    private By checkoutTitle = By.className("title");
    private By errorMessage = By.cssSelector("[data-test='error']");
    private By overviewItems = By.className("cart_item");
    private By priceTotal = By.className("summary_subtotal_label");
    private By finishButton = By.id("finish");
    private By finishText = By.cssSelector("[data-test='complete-header']");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterFirstName(String name){
        driver.findElement(firstName).sendKeys(name);
    }
    public void enterLastName(String lastname){
        driver.findElement(lastName).sendKeys(lastname);
    }
    public void geZipPostalCode(String zipCode){
        driver.findElement(zipPostalCode).sendKeys(zipCode);
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
    public void clickCancelButton(){
        driver.findElement(cancelButton).click();
    }
    public String getCheckoutTitle() {
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     wait.until(ExpectedConditions.textToBe(checkoutTitle, "Checkout: Overview"));
     return driver.findElement(checkoutTitle).getText();}
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
    public int getCountItemsOverview(){
        return driver.findElements(overviewItems).size();
    }
    public String getPriceTotal(){
        return driver.findElement(priceTotal).getText();
    }
    public void clickFinishButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }
    public String getFinishText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishText));
        return driver.findElement(finishText).getText();
    }

};
