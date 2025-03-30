package com.juaracoding.pageobjectfactory.pages;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 30/03/25 10.44
@Last Modified 30/03/25 10.44
Version 1.0
*/


import com.juaracoding.pageobjectfactory.utils.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckOutCompleteTest {
    private WebDriver driver;
    private CheckOutComplete checkOutComplete;

    @BeforeClass
    public void init(){
        driver = DriverSingleton.getDriver();

        checkOutComplete = new CheckOutComplete(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 18)
    public void verifySuccessOrder(){
        String actual = checkOutComplete.getMessageSuccess();
        String expected = "Thank you for your order!";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 19)
    public void navigateToHome(){
        checkOutComplete.clickBackToHome();
    }

}
