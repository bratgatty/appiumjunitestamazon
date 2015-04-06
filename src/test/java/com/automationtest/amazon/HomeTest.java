package com.automationtest.amazon;


import com.automationtest.amazon.util.AppiumTest;
import static com.automationtest.amazon.util.Helpers.*;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;



public class HomeTest extends AppiumTest{

    @Test
    public void ShopBtnClick() throws Exception{
       home.navigateToAllDepartmentsScreen();
    }


}
