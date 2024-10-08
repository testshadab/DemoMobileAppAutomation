package com.automation.CharlesLibrary;

import com.automation.mobile.appium.AppiumDriverManager;
import io.appium.java_client.AppiumDriver;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ramesh P
 */
public class DownloadLogs {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    CharlesHelper charlesHelper = new CharlesHelper();
    String getPlatform = charlesHelper.getPlatform();
    String os = charlesHelper.getMobileDeviceType();
    String sep = System.getProperty("file.separator");
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DownloadLogs.class);

    public String returnSessionFilePath() {
        return System.getProperty("user.dir") + sep + "Session_Files" + sep + os + sep;
    }

    public void downloadLogs(String ip, String tagName) throws Exception {
        String sPath = returnSessionFilePath();
        if (getPlatform.contains("Mac")) {
            try {
                ProcessBuilder builder = new ProcessBuilder();
                builder.command("/bin/bash", "-c", ">curl /usr/bin/curl -o " + sPath + tagName +
                        "_session.chls -x http://" + ip + ":8888 http://control.charles/session/download");
                builder.redirectErrorStream(true);
                Process p = builder.start();
                Thread.sleep(3000);
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while (true) {
                    line = r.readLine();
                    if (line == null) {
                        break;
                    }
                    log.info(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (getPlatform.contains("WINDOWS")) {
            try {
                ProcessBuilder builder = new ProcessBuilder(
                        "cmd.exe", "/c", "curl -o " + sPath + tagName + "_session.chls -x http://" + ip +
                        ":8888 http://control.charles/session/download");
                builder.redirectErrorStream(true);
                Process p = builder.start();
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while (true) {
                    line = r.readLine();
                    if (line == null) {
                        break;
                    }
                    log.info(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void ConvertLogs(String tagName)   {
        String sPath = returnSessionFilePath();
        if (getPlatform.contains("Mac")) {
            try {
                log.info(">>>>>> Inside convert logs  <<<<<<<<<<<<");
                ProcessBuilder builder = new ProcessBuilder();
                builder.command("/bin/bash", "-c", ">Charles /Applications/Charles.app/Contents/MacOS/Charles convert " + sPath
                        + tagName + "_session.chls " + sPath + tagName + "_session.chlsj");
                builder.redirectErrorStream(true);
                Process p = builder.start();
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while (true) {
                    line = r.readLine();
                    if (line == null) {
                        break;
                    }
                    log.info(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (getPlatform.contains("WINDOWS")) {
            // Need to test code for windows so for now commented the code
//            try {
//                ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "java -jar "
//                        + path.getProperty("charlesJarFolderPath") + "  convert " + sPath + tagName + "_session.chls "
//                        + sPath + tagName + "_session.chlsj");
//                builder.redirectErrorStream(true);
//                Process p = builder.start();
//                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//                String line;
//                while (true) {
//                    line = r.readLine();
//                    if (line == null) {
//                        break;
//                    }
//                    log.info(line);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

}
