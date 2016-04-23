package java112.labs2;

import java.util.*;
import java.io.*;

public class LabThree {

    private Properties properties;
    private String propertiesFilePath;

    public static void main(String[] args) {
        LabThree demo = new LabThree();
        demo.run(args[0]);
    }

    public void loadProperties(String propertiesFilePath)  {
        properties = new Properties();
        
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        }
        catch(IOException ioe) {
            System.out.println("Can't load the properties file");
            ioe.printStackTrace();
        }
        catch(Exception e) {
            System.out.println("Problem: " + e);
            e.printStackTrace();
        }
    }

    public void run(String input) {

        this.propertiesFilePath = input; 

        loadProperties(propertiesFilePath);

        // Get a list of the keys, aka, property names
        Set<String> propertyNames = properties.stringPropertyNames();

        /**
        //Iterate over the set of names, writing out the property name and the value
        for (String property: propertyNames) {
             System.out.println(property + " => " + properties.getProperty(property));
        }
        */

        //Iterate over the set of names, writing out the property name and the value
        for (String key: propertyNames) {
            String value = properties.getProperty(key);
            System.out.println(key + " => " + value);
        }
    }
}
