package com.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.browsers.BrowserFactory;
import com.config.PropertyManager;
import com.pages.HomePage;
import com.pages.LoginPage;
import org.testng.annotations.*;

import java.io.IOException;

public class HomePageExtentReport extends BrowserFactory {
    HomePage homePage;
    LoginPage loginPage;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extentReports;

    @BeforeSuite
    public void setUpTrstReport() {
        htmlReporter = new ExtentHtmlReporter("extent.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void TestUsername() throws IOException, InterruptedException {
        initialisingBrowser("chrome", PropertyManager.getProperties("url"));
        loginPage = new LoginPage(driver);
        homePage=loginPage.loginMe(PropertyManager.getProperties("username"), PropertyManager.getProperties("password"));
    }

    @Test()
    public void testSearch() throws IOException, InterruptedException {
        ExtentTest test1 = extentReports.createTest("Search preson on Facebook Search", "This is to validate search person functionality");
        homePage.search();
        test1.pass("Navigate to search page");
        test1.log(Status.INFO,"Starting Test case1");
        test1.info("Test1 Completed");
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    @AfterSuite
    public void tearDown() {
        extentReports.flush();
    }
}

