package com.juaracoding.pageobjectfactory.pages;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 30/03/25 10.57
@Last Modified 30/03/25 10.57
Version 1.0
*/


import com.juaracoding.pageobjectfactory.utils.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SideBarTest {

    private WebDriver driver;
    private SideBar sideBar;

    @BeforeClass
    public void init(){
        driver = DriverSingleton.getDriver();

        sideBar = new SideBar(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 20)
    public void logOut(){
        sideBar.clickBurgerMenu();
        sideBar.clickLogOut();
    }

}
