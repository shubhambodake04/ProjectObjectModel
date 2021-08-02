package com.test;

import com.browsers.BrowserFactory;
import com.config.PropertyManager;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginPageTest extends BrowserFactory {
    LoginPage loginPage;
    HomePage homePage;
    @BeforeMethod
    public void browserSetup() throws IOException {
        initialisingBrowser("chrome", PropertyManager.getProperties("url"));
         loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void loginPageTitleTest() throws InterruptedException {
        String title = loginPage.loginPageTitle();
        Assert.assertEquals(title, "Facebook – log in or sign up");
    }

   /* @Test(priority = 2)
    public void facebookLogoTest(){
       boolean flag = loginPage.getFacebookLogo();
       Assert.assertTrue(flag);
    }*/

    @Test(priority = 3)
    public void loginTest() throws InterruptedException, IOException {
       homePage=loginPage.loginMe(PropertyManager.getProperties("username"), PropertyManager.getProperties("password"));
    }



    @AfterMethod
    public void closeup() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
