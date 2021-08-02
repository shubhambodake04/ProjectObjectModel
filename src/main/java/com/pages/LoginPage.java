package com.pages;

import com.config.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage  {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="email")
    WebElement emailId;

    @FindBy(id="pass")
    WebElement password;

    @FindBy(name="login")
    WebElement loginButton;

    @FindBy(xpath = "//img[contains(@class, 'fb_logo _8ilh img')]")
    WebElement facebookLogo;

    @FindBy(xpath = "//a[contains(text(),'Forgotten password?')]")
    WebElement frgtPassButton;

    @FindBy(xpath = "//a[contains(text(),'Create New Account')]")
    WebElement createButton;

    public String loginPageTitle() throws InterruptedException {
        String title = driver.getTitle();
        System.out.println(title);
        return title;
    }

    public boolean getFacebookLogo(){
       return facebookLogo.isDisplayed();
    }

    public HomePage loginMe(String un, String pwd) throws InterruptedException, IOException {
      //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        emailId.sendKeys(un);
        password.sendKeys(pwd);
        loginButton.click();
        Thread.sleep(6000);
        return new HomePage(driver);
    }
}
