package com.test;

import com.browsers.BrowserFactory;
import com.config.PropertyManager;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utility.ExcelData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelLoginTest extends BrowserFactory {

    LoginPage loginPage;

    @BeforeMethod
    public void browserSetup() throws IOException {
        initialisingBrowser("chrome", PropertyManager.getProperties("url"));
        loginPage=new LoginPage(driver);
    }
    @DataProvider
    public Object[][] getLoginData() throws FileNotFoundException {
        Object data[][]= ExcelData.getTestData("src/main/java/com/utility/LoginData.xlsx","Sheet1");
        return data;
    }
    @Test(dataProvider = "getLoginData")
    public void LoginPageTest(String username, String password) throws IOException, InterruptedException {

        loginPage.loginMe(username,password);
    }
    @AfterMethod
    public void closeup() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
