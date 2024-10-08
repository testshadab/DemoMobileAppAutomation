package com.automation.mobile.helpers;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.entities.ConfigType;
import com.automation.mobile.entities.FileLocations;
import com.automation.mobile.entities.MobileConfType;
import com.automation.mobile.models.ApiResponse;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.services.ahem.AhemEmailService;
import com.automation.mobile.services.bitrise.ArtifactService;
import com.automation.mobile.services.perfecto.RepositoryService;
import com.google.common.base.CharMatcher;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ExecutionHelper {

    public static void downloadBuild(AppiumDevice appiumDevice) throws IOException {

        String artifactSlug = null;

        String appSlug = appiumDevice.getConfigureData("app_slug");

        String buildSlug = appiumDevice.getConfigureData("build_slug");

        String platformName = appiumDevice.getConfigureData(MobileConfType.PLATFORM_NAME);

        String banner = appiumDevice.getConfigureData(ConfigType.BANNER);

        String environment = appiumDevice.getConfigureData(ConfigType.APP_ENVIRONMENT);

        StringBuilder fileName = new StringBuilder(banner + "-" + buildSlug);

        HttpResponse artifactRes = ArtifactService.getArtifactList(appSlug, buildSlug);

        JSONArray artifacts = artifactRes.getJsonResponse().getJSONArray("data");

        for (int i = 0; i < artifacts.length(); i++) {

            JSONObject artifactObj = artifacts.getJSONObject(i);

            if (artifactObj.getString("artifact_type").equalsIgnoreCase("ios-ipa")) {

                artifactSlug = artifactObj.getString("slug");

                fileName.append(".ipa");

                break;
            } else if (artifactObj.getString("artifact_type").equalsIgnoreCase("android-apk")) {

                artifactSlug = artifactObj.getString("slug");

                fileName.append(".apk");

                break;
            }
        }

        HttpResponse response = ArtifactService.getArtifact(appSlug, buildSlug, artifactSlug);

        String result = java.net.URLDecoder.decode(response.getJsonResponse().getJSONObject("data").getString("expiring_download_url"), "UTF-8");

        byte[] fileContents = ArtifactService.downloadArtifact(result);

        Path filePath = Paths.get(FileLocations.MOBILE_APP_LOCATION + platformName + "/" + environment);

        if (Files.notExists(filePath)) {

            Files.createDirectories(filePath);
        }

        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath.toString() + "/" + fileName));

        fileOutputStream.write(fileContents);

        fileOutputStream.close();
    }

    public static boolean getRepositoryList(String platformName, String cloudToken, String appName) {

        HttpResponse response = RepositoryService.getFileList(platformName.toUpperCase(), cloudToken);

        JSONArray artifacts = response.getJsonResponse().getJSONArray("artifacts");

        for (int i = 0; i < artifacts.length(); i++) {

            JSONObject artifactObj = artifacts.getJSONObject(i);

            if (artifactObj.getString("artifactLocator").equalsIgnoreCase(appName)) {

                return true;
            }
        }
        return false;
    }

    /*public static String getOtp(String email) {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ie) {
            // Do nothing
        }

        String otp = null;

        int index = email.indexOf('@');

        String mailBoxName = email.substring(0, index);

        String token = AhemEmailService.getToken().getJsonResponse().getString("token");

        JSONArray emails = AhemEmailService.getEmailList(token, mailBoxName).getJsonArrayResponse();

        String emailId = emails.getJSONObject(0).getString("emailId");

        String content = AhemEmailService.getEmailContent(token, mailBoxName, emailId)
                .getJsonResponse().getString("text");

        Scanner sc = new Scanner(content);

        String line = null;
        while (sc.hasNextLine()) {
            line = sc.nextLine().trim();
            try {
                otp = String.format("%06d", Integer.parseInt(line));
                break;
            } catch (NumberFormatException nfx) {
                //Ignore the exception
            }
        }

        AhemEmailService.deleteEmailContent(token, mailBoxName, emailId);

        return otp;
    }*/


    public static String getOtp(String email, long currentEpochTime) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            // Do nothing
        }

        String mailBoxName = email.split("@")[0];
        String token = AhemEmailService.getToken().getJsonResponse().getString("token");
        String emailId = null;
        String otp = null;
        SCAN_MAILBOX:
        for (int cntVal = 0; cntVal <= 5; cntVal++) {
            List<ApiResponse.AllEmails> allEmails = new Gson().fromJson(AhemEmailService.getEmailList(token, mailBoxName).getContent(), new TypeToken<List<ApiResponse.AllEmails>>() {
            }.getType());
            if (allEmails.stream().filter(indEmail -> indEmail.timestamp >= currentEpochTime).collect(Collectors.toList()).size() != 0) {
                emailId = allEmails.stream().filter(indEmail -> indEmail.timestamp > currentEpochTime).collect(Collectors.toList()).get(0).emailId;
                String content = AhemEmailService.getEmailContent(token, mailBoxName, emailId)
                        .getJsonResponse().getString("text");
                otp = CharMatcher.inRange('0', '9').retainFrom(content);
                break;
            } else {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException ie) {
                    // Do nothing
                }
            }
        }
        AhemEmailService.deleteEmailContent(token, mailBoxName, emailId);
        return otp;
    }

    public static int getCurrentEmailsCount(String email) {
        int emailCount = 0;
        String mailBoxName = email.split("@")[0];
        String token = AhemEmailService.getToken().getJsonResponse().getString("token");
        int statusCode = AhemEmailService.getEmailList(token, mailBoxName).getStatusCode();
        if (statusCode != 404) {
            JSONArray emails = AhemEmailService.getEmailList(token, mailBoxName).getJsonArrayResponse();
            emailCount = emails.length();
        }
        return emailCount;
    }

    public static String getOtp(String email, int emailCount) {
        String otp = null;
        boolean newEmailArrived = false;
        // Loop until a new email has arrived
        for (int i = 0; i < 60; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                // Do nothing
            }

            int currentCount = getCurrentEmailsCount(email);
            if (currentCount > emailCount) {
                newEmailArrived = true;
                break;
            }
        }

        if (newEmailArrived) {
            String mailBoxName = email.split("@")[0];
            String token = AhemEmailService.getToken().getJsonResponse().getString("token");
            String emailId = null;
            JSONArray emails = AhemEmailService.getEmailList(token, mailBoxName).getJsonArrayResponse();
            emailId = emails.getJSONObject(0).getString("emailId");
            String content = AhemEmailService.getEmailContent(token, mailBoxName, emailId).getJsonResponse().getString("text");
            otp = CharMatcher.inRange('0', '9').retainFrom(content);
        }
        return otp;
    }

    public static void clearEmailInbox(String email) {
        String mailBoxName = email.split("@")[0];
        String token = AhemEmailService.getToken().getJsonResponse().getString("token");
        String emailId = null;
        int statusCode = AhemEmailService.getEmailList(token, mailBoxName).getStatusCode();
        if (statusCode != 404) {
            JSONArray emails = AhemEmailService.getEmailList(token, mailBoxName).getJsonArrayResponse();
            for (int i = 0; i < emails.length(); i++) {
                emailId = emails.getJSONObject(i).getString("emailId");
                AhemEmailService.deleteEmailContent(token, mailBoxName, emailId);
            }
        }
    }
}

