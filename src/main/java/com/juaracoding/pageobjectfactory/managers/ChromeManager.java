package com.juaracoding.pageobjectfactory.managers;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 23/03/25 01.30
@Last Modified 23/03/25 01.30
Version 1.0
*/


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ChromeManager {

    public static WebDriver buildDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");

        // Path ke temporary Chrome profile
        String tempProfilePath = System.getProperty("user.dir") + "/tempChromeProfile";
        File profileDir = new File(tempProfilePath);
        if (!profileDir.exists()) {
            profileDir.mkdirs();
        }
        options.addArguments("user-data-dir=" + tempProfilePath);

        // Pretend to be a normal user
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        // Turn off password saving service
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // Disable infobars and notifications
        options.addArguments("disable-infobars");
        options.addArguments("--disable-notifications");

        // In case still detect automation
        options.addArguments("--disable-blink-features=AutomationControlled");

        return new ChromeDriver(options);
    }

}
