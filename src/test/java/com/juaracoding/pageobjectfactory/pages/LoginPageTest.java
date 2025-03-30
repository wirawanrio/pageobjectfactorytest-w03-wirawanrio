package com.juaracoding.pageobjectfactory.pages;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 23/03/25 02.37
@Last Modified 23/03/25 02.37
Version 1.0
*/


import com.juaracoding.pageobjectfactory.utils.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeClass
    @Parameters({"url"})
    public void init(String url){
        driver = DriverSingleton.getDriver();

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    @Parameters({"username" , "password" })
    public void loginActionsTest(String username , String password){
        loginPage.loginActions(username , password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String actual = inventoryPage.getProductheader();
        String expected = "Products";
        Assert.assertEquals(actual, expected);
    }

}
