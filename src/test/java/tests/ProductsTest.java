package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ProductsPage;
import pages.LoginPage;


import static org.junit.jupiter.api.Assertions.*;

public class ProductsTest extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeEach
    void initPages() {

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    void addBackpackToCart(){
        loginPage.login("standard_user","secret_sauce");
        assertEquals("Products", productsPage.getProductTitle());
        productsPage.clickAdd();
        assertEquals("1",productsPage.getCartCont());

    }

    @Test
    void removeToCart(){
        loginPage.login("standard_user","secret_sauce");
        assertEquals("Products", productsPage.getProductTitle());
        productsPage.clickAdd();
        assertEquals("1",productsPage.getCartCont());
        productsPage.removeCard();
        assertFalse(productsPage.isCartBadgeDisplayed());

    }

    @Test
    void addMoreToCart() {
        loginPage.login("standard_user","secret_sauce");
        assertEquals("Products", productsPage.getProductTitle());
        productsPage.clickAdd();
        productsPage.addNextButtonCard();
        assertEquals("2", productsPage.getCartCont());


    }
    @Test
    void countCart() {
        loginPage.login("standard_user","secret_sauce");
        assertEquals("Products", productsPage.getProductTitle());
        assertEquals(6, productsPage.cardsCount());
        assertTrue(productsPage.areAllProductsComplete());

    }

}
