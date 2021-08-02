package com.test;

import com.browsers.BrowserFactory;
import com.config.PropertyManager;
import com.pages.AccountPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProfilePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProfilePageTest extends BrowserFactory {
    LoginPage loginPage;
    ProfilePage profilePage;
    HomePage homePage;

    @BeforeMethod
    public void Setup() throws IOException, InterruptedException {
        initialisingBrowser("chrome", PropertyManager.getProperties("url"));
        loginPage = new LoginPage(driver);
        homePage=loginPage.loginMe(PropertyManager.getProperties("username"), PropertyManager.getProperties("password"));
        profilePage = homePage.profile();
    }
    @Test
    public void logoutMe() throws IOException, InterruptedException {
        profilePage.addStory();
    }
    @AfterMethod
    public void closeup() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
