package com.automation.rest.rewards;

import java.util.Map;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.models.Result;
import com.automation.rest.RestService;
import com.automation.rest.config.RestApiConfig;

import io.appium.java_client.AppiumDriver;

public class RewardsService extends RestService{

    public RewardsService(AppiumDriver driver) {
        super(driver);

    }

    public Result getGroceryRewards() {


        Result result = new Result();

        HttpRequest request = new HttpRequest();

        String url = this.nimbusUrl + "/rewards/service/gallery/offer/gr?storeId=4601";

        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();

        headers.put("ADRUM_1", "isMobile:true");

        headers.put("Accept", "*/*");

        headers.put("Accept-Language", "en-us");

        headers.put("SWY_TIMESTAMP", "1603913766");

        headers.put("X-SWY_API_KEY", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("X-SWY_BANNER", "safeway");

        headers.put("CLIENT_ID", " ");

        headers.put("X-SWY_VERSION", "8.5.0");

        headers.put("ADRUM", "isAjax:true");

        headers.put("User-Agent", "Safeway/7052 CFNetwork/1197 Darwin/20.0.0");

        headers.put("CLIENT_APP_VERSION", "8.5.0");



        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if(response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get Grocery Rewards Successfull");
            }

        }
        catch(Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get Grocery Rewards Failed with Exception :: " + e.toString());
        }

        return result;
    }



    public Result getRewardsSummary() {

        Result result = new Result();


        HttpRequest request = new HttpRequest();

        String url = this.hostUrl + "/abs/acceptancepub/xapi/ocrp/rewards/summary";

        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();

        headers.put("ADRUM_1", "isMobile:true");

        headers.put("SWY_SSO_TOKEN", "{{accessToken}}");

        headers.put("Accept", "*/*");

        headers.put("Accept-Language", "en-us");

        headers.put("Content-Type", "application/json");

        headers.put("User-Agent", "Safeway/7052 CFNetwork/1197 Darwin/20.0.0");

        headers.put("ADRUM", "isAjax:true");

        headers.put("Ocp-apim-Subscription-Key", "bc4d096bef5f47d094f9819640da16aa");



        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if(response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get Rewards Summary Successfull");
            }

        }
        catch(Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get Rewards Summary Failed with Exception :: " + e.toString());
        }


        return result;

    }



}