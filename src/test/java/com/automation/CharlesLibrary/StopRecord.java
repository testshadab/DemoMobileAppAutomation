package com.automation.CharlesLibrary;

import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ramesh P
 */
public class StopRecord {
    String getPlatform = System.getProperty("os.name");
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(StopRecord.class);

    public void stopRecord(String ip) {
        if (getPlatform.contains("Mac")) {
            try {
                ProcessBuilder builder = new ProcessBuilder();
                builder.command("/bin/bash", "-c", ">curl /usr/bin/curl -v -x http://" + ip + ":8888 http://control.charles/recording/stop");
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
                log.info("============= Recording button pressed ===================== ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (getPlatform.contains("WINDOWS")) {
            // Need to test code for windows so for now commented the code
//            try {
//                Runtime.getRuntime().exec(path.getProperty("curlPath"));
//                ProcessBuilder builder = new ProcessBuilder(
//                        "cmd.exe", "/c", "curl -v -x http://" + ip + ":8888 http://control.charles/recording/stop \n");
//                builder.redirectErrorStream(true);
//                Process p = builder.start();
//                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//                String line;
//                while (true) {
//                    line = r.readLine();
//                    if (line == null) {
//                        break;
//                    }
//                   log.info(line);
//                }
//                log.info("===========   Recording button pressed ==========");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
}

