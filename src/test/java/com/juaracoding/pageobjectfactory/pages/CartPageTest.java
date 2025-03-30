package com.juaracoding.pageobjectfactory.pages;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 24/03/25 00.25
@Last Modified 24/03/25 00.25
Version 1.0
*/


import com.juaracoding.pageobjectfactory.utils.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.AttributedString;
import java.time.Duration;

public class CartPageTest {

    private WebDriver driver;
    private CartPage cartPage;
    private CheckoutInformation checkoutInformation;

    @BeforeClass
    public void init(){
        driver = DriverSingleton.getDriver();

        cartPage = new CartPage(driver);
        checkoutInformation = new CheckoutInformation(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 5)
    public void verifyItemInCart(){
        int actual = cartPage.countItemInCart();
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 6)
    public void clickCheckout(){
        cartPage.checkout();
    }

    @Test(priority = 7)
    public void verifyToCheckoutInformation(){
        String actual = checkoutInformation.getCheckoutInformationHeader();
        String expected = "Checkout: Your Information";
        Assert.assertEquals(actual, expected);
    }

}
