package com.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    public static Properties properties = new Properties();

    public static  String getProperties(String string) throws IOException {
        FileReader f  = new FileReader("C:\\Users\\shubh\\IdeaProjects\\PageObjectModel\\src\\main\\resources\\config.properties");
        properties.load(f);
        return properties.getProperty(string);
    }
}
