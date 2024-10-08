package com.automation.steps;

import com.automation.CharlesLibrary.*;
import com.automation.mobile.appium.AppiumDriverManager;
import io.appium.java_client.AppiumDriver;
import org.slf4j.LoggerFactory;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.Enumeration;
import java.util.Properties;

public class CharlesPageSteps {

    CharlesVerificationLib obj = new CharlesVerificationLib();
    IPAddress ipa = new IPAddress();
    StartCharles startCharles = new StartCharles();
    DownloadLogs dl = new DownloadLogs();
    StopRecord sr = new StopRecord();
    PropertyLoader propertyLoader = new PropertyLoader();
    Properties prop = null;
    String ip;
    SoftAssert softAssert = new SoftAssert();
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    CharlesHelper charlesHelper = new CharlesHelper();
    String os = charlesHelper.getMobileDeviceType();
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CharlesPageSteps.class);

    @Then("^invoke Charles Proxy$")
    public void invokeCharles() throws Exception {
        if(charlesHelper.isCharlesProxyEnabled().contains("true")){
            startCharles.cleanSessionFilesFolder();
            startCharles.OverrideSSLHandshakeException();
            startCharles.invokeCharles();
            log.info(">>>> Invoked Charles Proxy <<<<< ");
        }else{
            log.info(">>>> Charles Proxy is not enabled <<<<< ");
        }

    }

    @Then("^clear session files$")
    public void clearSessionFiles() throws Exception {
        if(charlesHelper.isCharlesProxyEnabled().contains("true")){
            startCharles.cleanSessionFilesFolder();
            log.info(">>>> Cleared session Files <<<<< ");
        }else{
            log.info(">>>> Charles Proxy is not enabled <<<<< ");
        }

    }

    @Then("^start Charles Proxy Recording$")
    public void startCharlesRecording() throws Exception {
        if(charlesHelper.isCharlesProxyEnabled().contains("true")) {
            ip = ipa.getIpAddress();
            startCharles.startRecording(ip);
            log.info(">>>>>>>>>>> Started Charles Proxy Recording  <<<<<<<<<<<");
        }else{
            log.info(">>>> Charles Proxy is not enabled <<<<< ");
        }
    }

    @Then("^download Charles Logs in File \"([^\"]*)\"$")
    public void downloadCharlesLogsInFile(String fileName) throws Exception {
        if(charlesHelper.isCharlesProxyEnabled().contains("true")) {
            Thread.sleep(4000);
            dl.downloadLogs(ip, fileName);
            dl.ConvertLogs(fileName);
            File file = obj.createTagFile(fileName);
            obj.extractData(file, fileName);
            prop = propertyLoader.loadTagProperty(fileName);
            log.info(">>>>>>>>>  Downloaded Charles Proxy Logs  <<<<<<<<<<<<");
            Enumeration<String> enums = (Enumeration<String>) prop.propertyNames();
            log.info(">>>>>>>>    Printing Charles proxy response from server   <<<<<<<<<<,");
            while (enums.hasMoreElements()) {
                String key = enums.nextElement();
                String value = prop.getProperty(key);
                log.info(key + " : " + value);
            }
            log.info(">>>>>>>>    End of Charles proxy response from server   <<<<<<<<<<<<");

        }else{
            log.info(">>>> Charles Proxy is not enabled <<<<< ");
        }
    }

    @Then("^stop Charles Proxy Recording$")
    public void stopCharlesRecording() throws Exception {
        if(charlesHelper.isCharlesProxyEnabled().contains("true")) {
            sr.stopRecord(ip);
            log.info(">>>>>>>>>> Stopped Charles Proxy Recording <<<<<<<<<<<<<<<");
        }else{
            log.info(">>>> Charles Proxy is not enabled <<<<< ");
        }
    }

    @Then("^verify Charles Proxy Logs for all attribute with tag \"([^\"]*)\"$")
    public void verifyCharlesProxyLogsForAllAttributeWithTag(String tag) throws Throwable {
        if(charlesHelper.isCharlesProxyEnabled().contains("true")) {
            log.info(">>>>>>>>>>>> Starting Charles log verification <<<<<<<<<<<<<<<<<<<<<<");
            Properties tagProp = propertyLoader.loadTagsDataProperty();
            String banner = charlesHelper.getBanner();
            String tags = tagProp.getProperty(os + "."+banner+"."+tag);
            log.info("Tags from test data File which need to be verified >>"+tags);
            String[] tagsNameAndValues = tags.split(",");
            for (String keyValue : tagsNameAndValues) {
                boolean assertionValue=false;
                String[] s = keyValue.split("=");
                if (keyValue.contains("=")) {
                    if(s[0].contains("visitorID")){
                        int lengthOfVisitorID=prop.getProperty("visitorID").length();
                        assertionValue= lengthOfVisitorID >= 30;
                    }else {
                        try {
                            assertionValue = prop.getProperty(s[0].trim()).contains(s[1]);
                        } catch (NullPointerException npe) {
                            log.error(s[0] + " attribute is not present ");
                        }
                    }
                }

                if(assertionValue){
                    softAssert.assertTrue(assertionValue,
                            s[0] + " coming in Charles log is: " + prop.getProperty(s[0].trim()));
                    log.info(("The value for >> " + s[0] + " << TAG " + " in Charles log is >> " + prop.getProperty(s[0].trim())));
                }
                else{
                    softAssert.assertTrue(assertionValue,
                            "The value of attribute << "+s[0] + " >> is not matching in actual Charles Log ." + " EXPECTED VALUE: "+s[1]+" ACTUAL VALUE : "+prop.getProperty(s[0].trim()));
                    log.error(("The value for >> " + s[0] + " << TAG " + " in not matching in Charles. The actual value is >> " + prop.getProperty(s[0].trim())));
            }
            }
            try {
            softAssert.assertAll();
            } catch (AssertionError e) {
                throw new AssertionError(e.getMessage());
            }

        }else{
            log.info(">>>> Charles Proxy is not enabled <<<<< ");
        }
    }

}
