package com.juaracoding.pageobjectfactory.hook;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 23/03/25 02.01
@Last Modified 23/03/25 02.01
Version 1.0
*/


import com.juaracoding.pageobjectfactory.utils.Browser;
import com.juaracoding.pageobjectfactory.utils.DriverSingleton;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Hook {

    @BeforeSuite
    public void setup(){
        DriverSingleton.setDriver(Browser.CHROME);
    }

    @AfterSuite
    public void tearDown(){
        DriverSingleton.exit();
    }

}
