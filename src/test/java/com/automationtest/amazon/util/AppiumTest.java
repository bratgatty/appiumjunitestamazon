package com.automationtest.amazon.util;


import com.automationtest.amazon.page.HomePage;
import com.automationtest.amazon.page.SearchPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;


// import all file operations related libraries
import java.io.File;
import java.net.URL;
import static com.automationtest.amazon.util.Helpers.driver;





public class AppiumTest {

    /** Page object references. Allows using 'home' instead of 'HomePage' **/
    protected HomePage home = new HomePage();


    /** Page object references. Allows using 'search' instead of 'SearchPage' **/
    protected SearchPage search = new SearchPage();




    /** Run before each test **/
    @Before
    public void setUp() throws Exception {

        URL serverAddress;

        File classPathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classPathRoot,"/app/");
        File app = new File(appDir,"Amazon Shopping_5.4.0.300.apk");


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName", "Samsung");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
        capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");


        serverAddress = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(serverAddress, capabilities);
        Helpers.init(driver, serverAddress);

    }


    @After
    public void tearDown() throws Exception{
        if (driver != null)
            driver.quit();
    }

}
