package com.automation.CharlesLibrary;

import com.automation.mobile.entities.FileLocations;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Ramesh P
 */
public class PropertyLoader {
    CharlesHelper charlesHelper = new CharlesHelper();
    String os = charlesHelper.getMobileDeviceType();
    public Properties tagProp=new Properties();
    InputStream tagDataExpInput=null;
    String sep = System.getProperty("file.separator");
    String pathOfTagFileToValidate= FileLocations.PATH_TAGFILE;
    String pathOfTagsDataFile =FileLocations.PATH_CHARLES_TEST_DATA_FILE;
    public  Properties loadTagProperty(String method) {
        try {
            try {
                tagDataExpInput = new FileInputStream(pathOfTagFileToValidate + os + sep + method + "_Tags.properties");
                Thread.sleep(2000);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            // load a properties file
            try {
                tagProp.load(tagDataExpInput);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex1) {
            ex1.printStackTrace();
        } finally {
            if (tagDataExpInput != null) {
                try {
                    tagDataExpInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tagProp;
    }
    

    public  Properties loadTagsDataProperty() {
        try {

            try {
                tagDataExpInput = new FileInputStream(pathOfTagsDataFile + charlesHelper.getBanner() + "TagData.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            // load a properties file
            try {
                tagProp.load(tagDataExpInput);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex1) {
            ex1.printStackTrace();
        } finally {
            if (tagDataExpInput != null) {
                try {
                    tagDataExpInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tagProp;
    }
}

