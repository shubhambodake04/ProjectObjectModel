package com.test;

import com.browsers.BrowserFactory;
import com.config.PropertyManager;
import com.pages.AccountPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SearchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AccountPageTest extends BrowserFactory {
    LoginPage loginPage;
    AccountPage accountPage;
    HomePage homePage;

    @BeforeMethod
    public void Setup() throws IOException, InterruptedException {
        initialisingBrowser("chrome", PropertyManager.getProperties("url"));
        loginPage = new LoginPage(driver);
        homePage=loginPage.loginMe(PropertyManager.getProperties("username"), PropertyManager.getProperties("password"));
        accountPage = homePage.accountButton();
    }
    @Test
    public void logoutMe() throws IOException, InterruptedException {
        accountPage.logoutMe();
    }
    @AfterMethod
    public void closeup() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
