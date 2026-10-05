package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeEach
    void initPages() {
    loginPage = new LoginPage(driver);
    }

    @Test
    void succesfullLogin() {
        assertEquals("Swag Labs",driver.getTitle());
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        WebElement product = driver.findElement(By.className("title"));
        assertEquals("Products", product.getText());

    }

    @Test
    void loginWithWrongPassword(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLoginButton();
        WebElement error = driver.findElement(By.cssSelector("[data-test='error']"));
        assertEquals("Epic sadface: Username and password do not match any user in this service", error.getText());

    }

    @Test
    void loginWithEmptyPassword(){
        loginPage.enterUsername("standard_user");
        loginPage.clickLoginButton();
        WebElement error = driver.findElement(By.cssSelector("[data-test='error']"));
        assertEquals("Epic sadface: Password is required", error.getText());

    }

    @Test
    void loginWithEmptyUsername(){
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        WebElement error = driver.findElement(By.cssSelector("[data-test='error']"));
        assertEquals("Epic sadface: Username is required", error.getText());

    }

    @Test
    void loginWithEmpty(){
        loginPage.clickLoginButton();
        WebElement error = driver.findElement(By.cssSelector("[data-test='error']"));
        assertEquals("Epic sadface: Username is required", error.getText());

    }

    @Test
    void loginWithLockedOutUser(){
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        WebElement error = driver.findElement(By.cssSelector("[data-test='error']"));
        assertEquals("Epic sadface: Sorry, this user has been locked out.", error.getText());

    }


}
