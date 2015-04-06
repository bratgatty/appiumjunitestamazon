package com.automationtest.amazon.util;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class Helpers {

    public static AndroidDriver driver;
    public static URL serverAddress;
    public static WebDriverWait driverWait;


    /**
     * Initialize the webdriver. Must be called before using any helper methods. *
     */
    public static void init(AndroidDriver webDriver, URL driverServerAddress) {
        driver = webDriver;
        serverAddress = driverServerAddress;
        int timeoutInSeconds = 60;
        // must wait at least 60 seconds for running on Sauce.
        // waiting for 30 seconds works locally however it fails on Sauce.
        driverWait = new WebDriverWait(webDriver, timeoutInSeconds);
    }


    public static WebElement element(By locator) {
        return driver.findElement(locator);
    }


    public static WebElement text(String text){
        return element(for_text(text));

    }


    public static By for_text(String text){
        //return By.xpath("//android.widget.TextView[contains(@text,'" + text + "')]");
        return By.id(text);

    }


    public static WebElement text_exact(String text) {
        return element(for_text_exact(text));
    }

    public static By for_text_exact(String text){
        //return By.xpath("//android.widget.TextView[@text='" + text + "']");
        return By.name(text);
    }


    public static boolean isElementPresent(final By by) throws InterruptedException{
        boolean isPresent = true;
        //wait(by);
        // search for elements and check if list is empty
        if (driver.findElements(by).isEmpty()) {
            isPresent = false;
        }
        // rise back implicitly wait time
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return isPresent;





    }





}
