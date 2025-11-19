package org.ZeeshanClasses.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static void loadConfig(){
        try{
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("//u2447 File could not be loaded");
        }
    }

    public static String getProperty(String key){
        if(properties==null){
            loadConfig();
        }
        return properties.getProperty(key);
    }

}
