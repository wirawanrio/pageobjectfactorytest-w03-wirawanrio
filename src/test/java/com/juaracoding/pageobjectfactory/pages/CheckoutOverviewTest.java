package com.juaracoding.pageobjectfactory.pages;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 30/03/25 09.54
@Last Modified 30/03/25 09.54
Version 1.0
*/


import com.juaracoding.pageobjectfactory.utils.DriverSingleton;
import com.sun.source.tree.AssertTree;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutOverviewTest {
    private WebDriver driver;
    private CheckoutOverview checkoutOverview;
    private CheckOutComplete checkOutComplete;

    @BeforeClass
    public void init(){
        driver = DriverSingleton.getDriver();

        checkoutOverview = new CheckoutOverview(driver);
        checkOutComplete = new CheckOutComplete(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 10)
    public void verifyItemOverview(){
        String actual = checkoutOverview.getItemOverview();
        String expected = "Sauce Labs Backpack";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 11)
    public void verifyPaymentInformation(){
        String actual = checkoutOverview.getPaymentInformation();
        String expected = "SauceCard #31337";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 12)
    public void verifyShippingInformation(){
        String actual = checkoutOverview.getShippingInformation();
        String expected = "Free Pony Express Delivery!";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 13)
    public void verifyItemTotal(){
        String actual = checkoutOverview.getItemTotal();
        String expceted = "Item total: $29.99";
        Assert.assertEquals(actual, expceted);
    }

    @Test(priority = 14)
    public void verifyTax(){
        String actual = checkoutOverview.getTax();
        String expected = "Tax: $2.40";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 15)
    public void verifyTotal(){
        String actual = checkoutOverview.getTotal();
        String expected = "Total: $32.39";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 16)
    public void finishOverview(){
        checkoutOverview.clickFinish();
    }

    @Test(priority = 17)
    public void verifyNavigateToCheckoutComplete(){
        String actual = checkOutComplete.getCheckoutCompleteHeader();
        String expected = "Checkout: Complete!";
        Assert.assertEquals(actual, expected);
    }


}
