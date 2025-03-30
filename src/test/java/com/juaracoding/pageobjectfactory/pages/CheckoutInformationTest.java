package com.juaracoding.pageobjectfactory.pages;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 25/03/25 03.49
@Last Modified 25/03/25 03.49
Version 1.0
*/


import com.juaracoding.pageobjectfactory.utils.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutInformationTest {
    private WebDriver driver;
    private CheckoutInformation checkoutInformation;
    private CheckoutOverview checkoutOverview;

    @BeforeClass
    public void init(){
        driver = DriverSingleton.getDriver();

        checkoutInformation = new CheckoutInformation(driver);
        checkoutOverview = new CheckoutOverview(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 8)
    public void checkoutInformationActionTest(){
        checkoutInformation.checkoutInformationAction("Wirawan" , "Rio" , "15810");
    }

    @Test(priority = 9)
    public void verifyNavigateToMenuCheckoutOverview(){
        String actual = checkoutOverview.getHeaderOverview();
        String expected = "Checkout: Overview";
        Assert.assertEquals(actual, expected);
    }

}
