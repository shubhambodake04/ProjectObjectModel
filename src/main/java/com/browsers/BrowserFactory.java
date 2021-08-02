package com.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Locale;

public class BrowserFactory {
    protected WebDriver driver;
    public void initialisingBrowser(String browser,String url) {
        switch (browser.toLowerCase(Locale.ROOT))
        {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications","start-maximized","incognito");
                System.setProperty("webdriver.chrome.driver","chromedriver.exe");
                driver = new ChromeDriver(options);
                System.out.println("Website opened");
                break;

            case "firefox":
                FirefoxOptions foptions = new FirefoxOptions();
                foptions.addArguments("--disable-notifications","start-maximized","incognito");
                System.setProperty("webdriver.gecko.driver","geckodriver.exe");
                driver = new FirefoxDriver(foptions);
                System.out.println("Website opened");
                break;

            default:
                EdgeOptions eoptions = new EdgeOptions();
                eoptions.addArguments("--disable-notifications","start-maximized","incognito");
                System.setProperty("webdriver.msedge.driver","msedgedriver.exe");
                driver = new EdgeDriver(eoptions);
                System.out.println("Website opened");

        }
        driver.get(url);

    }
}

