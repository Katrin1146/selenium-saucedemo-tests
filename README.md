# Selenium SauceDemo Tests

UI automation testing project for the SauceDemo e-commerce website.

## Tech Stack

- Java 17
- Selenium WebDriver
- JUnit 5
- Maven
- Page Object Model (POM)

## Test Coverage

The project contains 21 automated UI tests covering:

- Login
    - Successful login
    - Invalid password
    - Empty username/password
    - Locked out user

- Products
    - Add product to cart
    - Remove product
    - Add multiple products
    - Verify product count
    - Verify product cards

- Cart
    - Verify product name and price
    - Remove product from cart
    - Continue shopping
    - Multiple products in cart
    - Navigate to checkout

- Checkout
    - Successful checkout information
    - Validation of required fields
    - Order overview
    - Item total
    - Complete order

## Test Website

SauceDemo

## Project Structure

- `pages` — Page Object classes
- `tests` — automated test classes
- `BaseTest` — common WebDriver setup and teardown

## Run Tests

Run all tests with Maven:

`mvn test`