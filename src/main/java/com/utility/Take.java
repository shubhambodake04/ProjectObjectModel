package com.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Take {
    public static void screenshot(WebDriver driver, String name) throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)driver); //interface
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir" )+"/Screenshot/"+name+".jpeg";
        File destination = new File(path);
        FileUtils.copyFile(SrcFile,destination);
    }
}
