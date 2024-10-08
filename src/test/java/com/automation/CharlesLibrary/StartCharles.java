package com.automation.CharlesLibrary;

import com.automation.mobile.entities.FileLocations;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Ramesh P
 */
public class StartCharles {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(StartCharles.class);
    CharlesHelper charlesHelper = new CharlesHelper();
    public void invokeCharles() throws Exception {
        if (charlesHelper.getPlatform().contains("Mac")) {
            try {
                ProcessBuilder builder = new ProcessBuilder();
                builder.command("/bin/bash", "-c", ">Charles /Applications/Charles.app/Contents/MacOS/Charles -headless -config com.xk72.charles.config &");

                Process p = builder.start();
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while (r.readLine() != null) {
                    line = r.readLine();
                   log.info(line);
                }
                Thread.sleep(10000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (charlesHelper.getPlatform().contains("WINDOWS")) {
            // Need to test code for windows so for now commented the code
//            try {
//                ProcessBuilder builder = new ProcessBuilder(
//                        "cmd.exe", "/c", "cd " + path.getProperty("charlesLibFolderPath") + " && java -jar " + path.getProperty("charlesJarFolderPath") + " -headless -config " + path.getProperty("charlesConfigPath"));
//                System.out.println("cd " + path.getProperty("charlesLibFolderPath") + " && java -jar " + path.getProperty("charlesJarFolderPath") + " -headless -config " + path.getProperty("charlesConfigPath"));
//                builder.redirectErrorStream(true);
//                Process p = builder.start();
//                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//                String line;
//                line = r.readLine();
//                log.info(line);
//                Thread.sleep(10000);
//            } catch (IOException | InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public void startRecording(String ip) {
        if (charlesHelper.getPlatform().contains("Mac")) {
            try {
                ProcessBuilder builder = new ProcessBuilder();
                builder.command("/bin/bash", "-c", ">curl /usr/bin/curl -v -x http://" + ip + ":8888 http://control.charles/recording/start");
                Process p = builder.start();
                builder.redirectErrorStream(true);
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
        } else if (charlesHelper.getPlatform().contains("WINDOWS")) {
            // Need to test code for windows so for now commented the code
//            try {
//                ProcessBuilder builder = new ProcessBuilder(
//                        "cmd.exe", "/c", "cd " + path.getProperty("charlesLibFolderPath") + " && curl -v -x http://" + ipAddress.getIpAddress() + ":8888 http://control.charles/recording/start");
//                System.out.println("cd " + path.getProperty("charlesLibFolderPath") + " && curl -v -x http://" + ipAddress.getIpAddress() + ":8887 http://control.charles/recording/start");
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
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
    }

    public final void OverrideSSLHandshakeException() throws Exception {
        /*
         *  fix for
         *    Exception in thread "main" javax.net.ssl.SSLHandshakeException:
         *       sun.security.validator.ValidatorException:
         *           PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException:
         *               unable to find valid certification path to requested target
         */

        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {  }
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {  }

                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = (hostname, session) -> true;
        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

    }

    public void cleanSessionFilesFolder()  {
        String[] listOfFiles;
        try {
            ArrayList<File> files = new ArrayList<>();
            File androidSessionFile = new File(FileLocations.ANDROID_CHARLES_SESSION_FILE);
            File iosSessionFile = new File(FileLocations.IOS_CHARLES_SESSION_FILE);
            File androidTagFile =  new File(FileLocations.ANDROID_CHARLES_CONVERTED_FILE);
            File iosTagFile =  new File(FileLocations.IOS_CHARLES_CONVERTED_FILE);
            files.add(androidSessionFile);
            files.add(iosSessionFile);
            files.add(androidTagFile);
            files.add(iosTagFile);
            for(File filesList: files) {
                if (filesList.isDirectory()) {
                    listOfFiles = filesList.list();
                    Arrays.stream(listOfFiles).map(x -> new File(filesList, x)).forEach(File::delete);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

