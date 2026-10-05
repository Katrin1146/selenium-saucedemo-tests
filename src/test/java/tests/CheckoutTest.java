package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutTest extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeEach
    void initPages(){

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    void successfulCheckoutInformation(){
        loginPage.login("standard_user","secret_sauce");
        assertEquals("Products", productsPage.getProductTitle());
        productsPage.clickAdd();
        cartPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutPage.enterFirstName("Liliya");
        checkoutPage.enterLastName("Panova");
        checkoutPage.geZipPostalCode("65000");
        checkoutPage.clickContinueButton();
        assertEquals("Checkout: Overview", checkoutPage.getCheckoutTitle());

    }

    @Test
    void checkoutWithoutFirstName(){
        loginPage.login("standard_user","secret_sauce");
        assertEquals("Products", productsPage.getProductTitle());
        productsPage.clickAdd();
        cartPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutPage.enterLastName("Panova");
        checkoutPage.geZipPostalCode("65000");
        checkoutPage.clickContinueButton();
        assertEquals("Error: First Name is required", checkoutPage.getErrorMessage());

    }
    @Test
    void verifyOrderOverview(){
        loginPage.login("standard_user","secret_sauce");
        assertEquals("Products", productsPage.getProductTitle());
        productsPage.clickAdd();
        productsPage.addNextButtonCard();
        cartPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutPage.enterFirstName("Liliya");
        checkoutPage.enterLastName("Panova");
        checkoutPage.geZipPostalCode("65000");
        checkoutPage.clickContinueButton();
        assertEquals("Checkout: Overview", checkoutPage.getCheckoutTitle());
        assertEquals(2, checkoutPage.getCountItemsOverview());


    }
    @Test
    void getPriceOrderOverview() {
        loginPage.login("standard_user", "secret_sauce");
        assertEquals("Products", productsPage.getProductTitle());
        productsPage.clickAdd();
        productsPage.addNextButtonCard();
        cartPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutPage.enterFirstName("Liliya");
        checkoutPage.enterLastName("Panova");
        checkoutPage.geZipPostalCode("65000");
        checkoutPage.clickContinueButton();
        assertEquals("Checkout: Overview", checkoutPage.getCheckoutTitle());
        assertEquals(2, checkoutPage.getCountItemsOverview());
        assertEquals("Item total: $39.98", checkoutPage.getPriceTotal());

    }@Test
    void getOrderFinish() {
        loginPage.login("standard_user", "secret_sauce");
        assertEquals("Products", productsPage.getProductTitle());
        productsPage.clickAdd();
        productsPage.addNextButtonCard();
        cartPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutPage.enterFirstName("Liliya");
        checkoutPage.enterLastName("Panova");
        checkoutPage.geZipPostalCode("65000");
        checkoutPage.clickContinueButton();
        assertEquals("Checkout: Overview", checkoutPage.getCheckoutTitle());
        checkoutPage.clickFinishButton();
        assertEquals("Thank you for your order!", checkoutPage.getFinishText());

    }


}
