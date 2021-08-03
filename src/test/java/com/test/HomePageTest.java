package com.test;

import com.browsers.BrowserFactory;
import com.config.PropertyManager;
import com.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BrowserFactory {
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    SearchPage searchPage;
    AccountPage accountPage;


    @BeforeMethod
    public void Setup() throws IOException, InterruptedException {
        initialisingBrowser("chrome", PropertyManager.getProperties("url"));
        loginPage = new LoginPage(driver);
        homePage=loginPage.loginMe(PropertyManager.getProperties("username"), PropertyManager.getProperties("password"));
        //searchPage=loginPage.loginMe();
    }

    @Test(priority = 1)
    public void verifyProfileButton() throws IOException, InterruptedException {
        profilePage = homePage.profile();
    }
    @Test(priority = 2)
    public void verifySearchPerson() throws IOException, InterruptedException {
        searchPage= homePage.search();
    }
    @Test(priority = 3)
    public  void verifyFriendsButton() throws InterruptedException {
         homePage.friendsList();
    }
    @Test(priority = 4)
    public  void verifyAccountButton() throws InterruptedException, IOException {
        accountPage = homePage.accountButton();
    }
    @AfterMethod
    public void closeup() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
