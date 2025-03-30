package com.juaracoding.pageobjectfactory.strategies;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 23/03/25 01.38
@Last Modified 23/03/25 01.38
Version 1.0
*/


import com.juaracoding.pageobjectfactory.managers.ChromeManager;
import com.juaracoding.pageobjectfactory.managers.FirefoxManager;
import com.juaracoding.pageobjectfactory.utils.Browser;
import org.openqa.selenium.WebDriver;

public class DriverStrategies {

    public static WebDriver setStrategy(String browser){
        if (browser.equals(Browser.CHROME)){
            return ChromeManager.buildDriver();
        } else if (browser.equals(Browser.FIREFOX)) {
            return FirefoxManager.buildDriver();
        }else {
            return ChromeManager.buildDriver();
        }
    }

}
