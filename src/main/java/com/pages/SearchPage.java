package com.pages;

import com.utility.Take;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SearchPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@aria-label='Search Facebook']")
    WebElement searchUser;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void search() throws InterruptedException, IOException {
        searchUser.sendKeys("Shubham Bodake");
        Thread.sleep(3000);
        searchUser.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        Thread.sleep(3000);
        Take.screenshot(driver,"search");

    }
}
