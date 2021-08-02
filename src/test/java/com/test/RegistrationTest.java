package com.test;

import com.browsers.BrowserFactory;
import com.config.PropertyManager;
import com.pages.LoginPage;
import com.pages.Registration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTest extends BrowserFactory {

    @BeforeTest
    public void browserSetup() throws IOException {
        initialisingBrowser("chrome", PropertyManager.getProperties("url"));
    }
    @Test
    public void RegisterUser() throws InterruptedException, IOException {
        Registration registration=new Registration(driver);
        registration.RegisterMe();
    }
    @AfterTest
    public void closeup() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
