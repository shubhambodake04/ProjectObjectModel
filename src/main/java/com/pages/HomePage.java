package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@aria-label='Search Facebook']")
    WebElement searchUser;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]")
    WebElement profileButton;

    @FindBy(xpath = "//body/div[starts-with(@id,'mount')]")
    WebElement friendsButton;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/span[1]/div[1]/div[1]/img[1]")
    WebElement accountButton;


    public ProfilePage profile() throws InterruptedException {
        profileButton.click();
        Thread.sleep(5000);
        return new ProfilePage(driver);
    }

    public void friendsList() throws InterruptedException {
        friendsButton.click();
        Thread.sleep(5000);
    }

    public AccountPage accountButton() throws InterruptedException, IOException {
        accountButton.click();
        Thread.sleep(2000);
        return new AccountPage(driver);
    }

    public SearchPage search() throws InterruptedException, IOException {
        searchUser.sendKeys("Shubham Bodake");
        Thread.sleep(3000);
        searchUser.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        return new SearchPage(driver);
    }



}
