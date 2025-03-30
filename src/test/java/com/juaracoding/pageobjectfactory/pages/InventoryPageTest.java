package com.juaracoding.pageobjectfactory.pages;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 23/03/25 23.15
@Last Modified 23/03/25 23.15
Version 1.0
*/


import com.juaracoding.pageobjectfactory.utils.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class InventoryPageTest {

    private WebDriver driver;
    private InventoryPage inventoryPage;
    private CartPage cartPage;

    @BeforeClass
    public void init(){
        driver = DriverSingleton.getDriver();

        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 2)
    public void addToCartTest(){
        inventoryPage.addToCart(inventoryPage.buttonAddToCartSauceLabsBackpack);
    }

    @Test(priority = 3)
    public void verifyCartCount(){
        String actual = inventoryPage.getCartBadge();
        String expected = "1";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 4)
    public void navigateToCartTest(){
        inventoryPage.navigateToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String actual = cartPage.getHeaderCart();
        String expected = "Your Cart";
        Assert.assertEquals(actual, expected);
    }

}
