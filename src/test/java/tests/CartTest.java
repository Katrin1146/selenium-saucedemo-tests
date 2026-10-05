package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeEach
    void initPages(){
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    void addCartToBack(){
        loginPage.login("standard_user","secret_sauce");
        assertEquals("Products", productsPage.getProductTitle());
        productsPage.clickAdd();
        assertEquals("1",productsPage.getCartCont());
        cartPage.clickCart();
        assertEquals("Your Cart", cartPage.getTitle());
        assertEquals("Sauce Labs Backpack", cartPage.getProductName());
    }

    @Test
    void verifyProductPriceInCart(){
        loginPage.login("standard_user","secret_sauce");
        assertEquals("Products", productsPage.getProductTitle());
        productsPage.clickAdd();
        cartPage.clickCart();

        assertEquals(1, cartPage.getCartItemsCount());
        assertEquals("$29.99", cartPage.getProductPrice());
    }

@Test
void removeProductFromCart(){
    loginPage.login("standard_user","secret_sauce");
    assertEquals("Products", productsPage.getProductTitle());
    productsPage.clickAdd();
    cartPage.clickCart();
    assertEquals(1, cartPage.getCartItemsCount());
    cartPage.removeButtonClick();
    assertEquals(0, cartPage.getCartItemsCount());

}
@Test
void clickContinueButton(){
    loginPage.login("standard_user","secret_sauce");
    assertEquals("Products", productsPage.getProductTitle());
    productsPage.clickAdd();
    cartPage.clickCart();
    assertEquals(1, cartPage.getCartItemsCount());
    cartPage.clickContinueButton();
    assertEquals("Products", productsPage.getProductTitle());

}
@Test
void verifyMultipleProductsInCart(){
    loginPage.login("standard_user","secret_sauce");
    assertEquals("Products", productsPage.getProductTitle());
    productsPage.clickAdd();
    productsPage.addNextButtonCard();
    cartPage.clickCart();
    assertEquals(2, cartPage.getCartItemsCount());
    assertEquals("Sauce Labs Backpack", cartPage.getProductName(0));
    assertEquals("Sauce Labs Bike Light", cartPage.getProductName(1));
}

@Test
void clickCheckoutButton(){
    loginPage.login("standard_user","secret_sauce");
    assertEquals("Products", productsPage.getProductTitle());
    productsPage.clickAdd();
    cartPage.clickCart();
    cartPage.clickCheckoutButton();
    assertEquals("Checkout: Your Information", cartPage.getCheckoutTitle());
}

}
