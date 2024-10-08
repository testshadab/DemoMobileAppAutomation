package com.automation.mobile.manager;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.entities.FileLocations;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class DataFileManager {

    private ThreadLocal<Map<String, String>> testCaseData = new ThreadLocal<>();

    private String fileName;

    private String bannerName;

    private String environment;

    private String platformName;

    public DataFileManager(String fileName, AppiumDevice appiumDevice){

        this.bannerName = appiumDevice.getBanner();

        this.environment = appiumDevice.getEnv();

        this.platformName = appiumDevice.getPlatform();
       this.fileName = fileName+".yml";
//        this.fileName = sign_in+".yml";

    }

    public void read() throws FileNotFoundException {


        InputStream inputStream = new FileInputStream(new File(FileLocations.DATA_DIRECTORY+fileName));

        Yaml yaml = new Yaml();

        Map<String, Object> data = yaml.load(inputStream);

        Map<String, Object> bannerData = (Map<String, Object>) data.get(bannerName);

        Map<String, Object> envData = (Map<String, Object>) bannerData.get(environment);
        System.out.println("envDataTest"+envData);
        setStringData(envData);
    }

    private void setStringData(Map<String, Object> data){

        Map<String, String> testData = new HashMap<>();

        if(data!=null){

                  for (Map.Entry<String, Object> entry : data.entrySet()) {
                if(entry.getValue() instanceof Map) {
                    if (entry.getKey().equalsIgnoreCase(platformName.toLowerCase())) {

                        for (Map.Entry<String, Object> entry1 : ((Map<String, Object>) entry.getValue()).entrySet()) {

                            testData.put(entry1.getKey(), String.valueOf(entry1.getValue()));
                        }
                    }
                }
                else{

                    testData.put(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
        }
    System.out.println("testData"+testData);
        this.testCaseData.set(testData);
    }

    public Map<String, String> getTestCaseData(){
    System.out.println("testCaseData.get("+testCaseData.get());
        return testCaseData.get();
    }
}
