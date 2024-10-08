package com.automation.CharlesLibrary;

import com.automation.mobile.entities.FileLocations;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * @author Ramesh P
 */
public class CharlesVerificationLib {

    PropertyLoader propertyloader = new PropertyLoader();
    CharlesHelper charlesHelper = new CharlesHelper();
    String getPlatform = charlesHelper.getPlatform();
    String os = charlesHelper.getMobileDeviceType();
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CharlesVerificationLib.class);
    String sep = System.getProperty("file.separator");
    String pathOfTagFileToValidate= FileLocations.PATH_TAGFILE;
    public String readFile(String fileName) throws IOException {
        String sessionFile = FileLocations.APPLICATION_DIRECTORY+sep + "Session_Files" + sep + os + sep + fileName + "_session.chlsj";
        log.info((new File(sessionFile).getAbsolutePath()));
        String content = Files.toString(new File(sessionFile), Charset.defaultCharset());
        StringBuilder tempBuffer = new StringBuilder();
        int incrementer = 0;
        int dataLength = content.length();
        while (incrementer < dataLength) {
            char charecterAt = content.charAt(incrementer);
            if (charecterAt == '%') {
                tempBuffer.append("<percentage>");
            } else if (charecterAt == '+') {
                tempBuffer.append("<plus>");
            } else {
                tempBuffer.append(charecterAt);
            }
            incrementer++;
        }
        content = tempBuffer.toString();
        content = URLDecoder.decode(content, "utf-8");
        content = content.replaceAll("<percentage>", "%");
        content = content.replaceAll("<plus>", "+");
        return content;
    }

    public ArrayList<String> splitString(String fileName) throws IOException {
        String actualString = readFile(fileName);
        String matchingCriteriaStart = "\"text\":";
        String matchingCriteriaEnd = "},{";
        String[] listOfStrings = StringUtils.substringsBetween(actualString, matchingCriteriaStart, matchingCriteriaEnd);
        ArrayList<String> filteredText = new ArrayList<>();
        for (String getSubString : listOfStrings) {
            if (os.equalsIgnoreCase("ios")) {
                if (getSubString.contains("&c.&")) {
                    filteredText.add(StringUtils.substring(getSubString, 0, getSubString.indexOf("\"}},")));
                }
            }
            if (os.equalsIgnoreCase("android")) {
                if (getSubString.contains("&c.&a.")) {
                    filteredText.add(StringUtils.substring(getSubString, 0, getSubString.indexOf("\"}},")));
                }

            }
        }
        return filteredText;
    }

    public void extractData(File file, String name) throws IOException {
        SoftAssert softAssert = new SoftAssert();
        ArrayList<String> printEachElement = splitString(name);
        ArrayList<String> configData = new ArrayList<>();
        String[] s;
        FileOutputStream output = new FileOutputStream(file);
        if (os.contains("ios")) {
            for (String element : printEachElement) {
                String[] elementsOfString1 = StringUtils.substringsBetween(element, "&", ".a");
                for (String elementEach : elementsOfString1) {
                    String[] elementsOfString2 = StringUtils.split(elementEach, "&");
                    for (String element1 : elementsOfString2) {
                        try {
                            s = element1.split("=");
                            configData.add(element1);
                            if (s[1].contains("%20")) {
                                s[1] = s[1].replace("%20", " ");
                            }
                            if (s[1].contains("%24")) {
                                s[1] = s[1].replace("%24", " ");
                            }
                            if (s[1].contains("%E2%80%94")) {
                                s[1] = s[1].replace("%E2%80%94", " - ");
                            }
                            if (s[1].contains("%3A")) {
                                s[1] = s[1].replace("%3A", ":");
                            }
                            if (s[1].contains("%28") && s[1].contains("%29")) {
                                s[1] = s[1].replace("%28", "(");
                                s[1] = s[1].replace("%29", ")");
                            }
                            propertyloader.tagProp.setProperty(s[0], s[1]);
                            log.info(element1);
                        } catch (Exception ignored) {

                        }
                    }
                }
                propertyloader.tagProp.store(output, "");

            }
        } else {
            for (String element : printEachElement) {
                String[] elementsOfString2 = StringUtils.split(element, "&");
                for (String element1 : elementsOfString2) {
                    s = element1.split("=");
                    configData.add(element1);
                    try {
                        if (s[1].contains("%20")) {
                            s[1] = s[1].replace("%20", " ");
                        }
                        if (s[1].contains("%3A")) {
                            s[1] = s[1].replace("%3A", ":");
                        }
                        if (s[1].contains("%28") && s[1].contains("%29")) {
                            s[1] = s[1].replace("%28", "(");
                            s[1] = s[1].replace("%29", ")");
                        }
                        propertyloader.tagProp.setProperty(s[0], s[1]);
                    } catch (Exception ignored) {

                    }
                }
                propertyloader.tagProp.store(output, "");
            }
        }
        softAssert.assertAll();

    }

    public File createTagFile(String method) throws IOException {
        File file = null;
        if (getPlatform.contains("Mac")) {
            file = new File(pathOfTagFileToValidate + os + sep + method + "_Tags.properties");

        } else if (getPlatform.contains("WINDOWS")) {
            try {
                file = new File(pathOfTagFileToValidate + os + sep + method + "_Tags.properties");
                log.info("path: " + file.getAbsolutePath());
            } catch (Exception e) {
                file = new File("signin_Tags.properties");
            }
        }
        if (!file.exists()) {
            file.createNewFile();
        }

        return file;
    }
}