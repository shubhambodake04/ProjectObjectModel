package com.test;

import com.browsers.BrowserFactory;
import com.config.PropertyManager;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SearchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchPageTest extends BrowserFactory {
    LoginPage loginPage;
    SearchPage searchPage;
    HomePage homePage;

    @BeforeMethod
    public void Setup() throws IOException, InterruptedException {
        initialisingBrowser("chrome", PropertyManager.getProperties("url"));
        loginPage = new LoginPage(driver);
        homePage=loginPage.loginMe(PropertyManager.getProperties("username"), PropertyManager.getProperties("password"));

    }
    @Test
    public void searchPerson() throws IOException, InterruptedException {
        searchPage= homePage.search();
    }
    @AfterMethod
    public void closeup() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
