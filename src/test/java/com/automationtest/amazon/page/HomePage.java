package com.automationtest.amazon.page;


import com.automationtest.amazon.util.CommonId;
import org.openqa.selenium.By;

import static com.automationtest.amazon.util.Helpers.*;

public class HomePage {
    public void navigateToAllDepartmentsScreen() throws Exception{

        //final boolean sign_in_btn = isElementPresent(By.name("Skip sign in"));

        Thread.sleep(15000);
        loaded();
        Thread.sleep(15000);
        text(CommonId.SHOPNAVIGATIONBTN).click();
        Thread.sleep(10000);
        text_exact("All Departments");


        }

    private static void loaded() {
        text_exact("Skip sign in").click();
    }
}
