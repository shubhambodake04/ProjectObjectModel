package com.pages;

import com.config.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Registration {
    WebDriver driver;

    public Registration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Create New Account')]")
    WebElement createButton;
    @FindBy(name = "firstname")
    WebElement fName;
    @FindBy(name = "lastname")
    WebElement lName;
    @FindBy(name = "reg_email__")
    WebElement usrName;
    @FindBy(name = "reg_passwd__")
    WebElement pwdName;
    @FindBy(name = "birthday_day")
    WebElement bDay;
    @FindBy(name = "birthday_month")
    WebElement bMonth;
    @FindBy(name = "birthday_year")
    WebElement bYear;
    @FindBy(xpath = "//label[contains(text(),'Male')]")
    WebElement gender;



    public void RegisterMe() throws InterruptedException, IOException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        createButton.click();
        fName.sendKeys("Shubham");
        lName.sendKeys("Bodake");
        usrName.sendKeys("7757929320");
        pwdName.sendKeys("Shubham@123");
        bDay.sendKeys("4");
        bMonth.sendKeys("Aug");
        bYear.sendKeys("1998");
        gender.click();




}}
