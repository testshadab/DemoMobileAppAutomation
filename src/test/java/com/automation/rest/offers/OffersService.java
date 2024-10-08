package com.automation.rest.offers;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.ApiResponse;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.models.Result;
import com.automation.rest.RestService;
import com.automation.rest.cache.CommonCache;
import com.automation.rest.config.RestApiConfig;
import com.google.gson.Gson;
import io.appium.java_client.AppiumDriver;
import org.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//<<<<<<< HEAD
//public class OffersService extends RestService{
//
//	public OffersService(AppiumDriver driver) {
//
//		super(driver);
//	}
//
//	public Result getAllOffers() {
//
//		Result result = new Result();
//
//		HttpRequest request = new HttpRequest();
//
//		String url = this.hostUrl + "abs/qa1pub/mobile/j4u/api/ecomgallery?storeId=<2574>&offerPgm=PD-CC";
//
//		Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();
//
//		headers.put("Authorization", "Bearer " + CommonCache.tokenCache.get("accessToken"));
//
//		headers.put("Content-Type", "application/json");
//
//		headers.put("x-swy-application-type", "native-mobile");
//
//		headers.put("x-swy_api_key", "emmd");
//
//		headers.put("x-swy_banner", "safeway");
//
//		headers.put("x-swy_version", "1.2");
//
//		request.setUrl(url);
//
//		request.setHeaders(headers);
//
//		try {
//			HttpResponse response = HttpHandler.get(request);
//
//			System.out.print(response.getStatusCode());
//
//			if(response.getStatusCode() == 200) {
//
//				JSONArray allOffers = response.getJsonResponse().getJSONArray("cc");
//=======

public class OffersService extends RestService {

    public OffersService(AppiumDriver driver) {

        super(driver);
    }

    public Result getAllOffers(String storeID) {
        Result result = new Result();
        HttpRequest request = new HttpRequest();
        String url = this.hostUrl + "abs/qa1pub/mobile/j4u/api/ecomgallery?storeId=" + storeID + "&offerPgm=PD-CC";
        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();
        headers.put("Authorization", "Bearer " + CommonCache.tokenCache.get("accessToken"));
        headers.put("Content-Type", "application/json");
        headers.put("x-swy-application-type", "native-mobile");
        headers.put("x-swy_api_key", "emmd");
        headers.put("x-swy_banner", "safeway");
        headers.put("x-swy_version", "1.2");
        request.setUrl(url);
        request.setHeaders(headers);
        try {
            HttpResponse response = HttpHandler.get(request);
            System.out.print(response.getStatusCode());
            if (response.getStatusCode() == 200) {
                JSONArray allOffers = response.getJsonResponse().getJSONArray("cc");
//                if(response.getJsonResponse().getJSONArray("pd") != null) {
//                    allOffers.putAll(response.getJsonResponse().getJSONArray("pd"));
//                }
                CommonCache.offerCache.put("ecommOffer", allOffers);
                List<ApiResponse.AllOffers.Offer> allOffersFromAPI =  new Gson().fromJson(response.getContent(), ApiResponse.AllOffers.class).getCc();
                allOffersFromAPI.addAll(new Gson().fromJson(response.getContent(), ApiResponse.AllOffers.class).getPd());
                List<ApiResponse.AllOffers.Offer> allOffersAPI = (List<ApiResponse.AllOffers.Offer>) CommonCache.allDealsInAPI.get("allDeals");
                CommonCache.allDealsInAPI.put("allDeals", allOffersFromAPI);
                result.setStatus(true);
                result.setStatusMsg("Get All Offers Successfull");
            }
        } catch (Exception e) {
            result.setStatus(false);
            result.setStatusMsg("Get All Offers Failed with Exception :: " + e.toString());
        }
        return result;
    }


    public Result getCategory() {

        Result result = new Result();


        HttpRequest request = new HttpRequest();

        String url = this.nimbusUrl + "/emmd/service/misc/categorysort";


        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();


        headers.put("ADRUM_1", "isMobile:true");

        headers.put("CLIENT_APP_VERSION", "9.5.0");

        //headers.put("Authorization", "Bearer " + CommonCache.tokenCache.get("accessToken"));

        headers.put("REQUEST_TIME", "1603903260514");

        headers.put("Accept", "*/*");

        headers.put("User-Agent", "Safeway/6965 CFNetwork/1197 Darwin/20.0.0");

        headers.put("Accept-Language", "en-us");

        headers.put("Content-Type", "application/json");

        headers.put("X-SWY_API_KEY", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("X-SWY_BANNER", "safeway");

        headers.put("CLIENT_ID", " ");

        headers.put("ADRUM", "isAjax:true");

        headers.put("X-SWY_VERSION", "9.5.0");

        headers.put("SWY_SIGNATURE", "l7chnrkPifgLTNjch+bJ3Q96Oh8=");

        headers.put("Cookie", "swyConsumerDirectoryPro=eyJraWQiOiJxYkpsN1lDa2NiYW5nNzlUWURYNk5HOER4Y2hhY2tPdG9tenVPVURqaFA4IiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULnpiMUZBb2dNRmdJYUZkdUhReG9QdXJvT3FGUnV2RHB5ajAtYjBWWWtJN3Mub2FyZ2M2dTJ1UGZFUnl2TDUycDYiLCJpc3MiOiJodHRwczovL2FsYmVydHNvbnMub2t0YS5jb20vb2F1dGgyL2F1c3A2c294ckl5UHJtOHJTMnA2IiwiYXVkIjoiQWxiZXJ0c29ucyIsImlhdCI6MTYwMzkwMTk1NywiZXhwIjoxNjAzOTA0NjU3LCJjaWQiOiIwb2FwNmtrcDdTZWZnMjRyQjJwNiIsInVpZCI6IjAwdWp4bWk0c2gwanpxY0N2MnA2Iiwic2NwIjpbIm9mZmxpbmVfYWNjZXNzIiwicHJvZmlsZSIsIm9wZW5pZCJdLCJ6aXAiOiI4NTcxOSIsInN1YiI6ImdyZWRkaWFyQGdtYWlsLmNvbSIsImhpZCI6IjI1MDA0MTMzMzc0NiIsImRubSI6IkdhbmVzaCIsImFsbiI6IjQxMDMzODU1NDIwIiwiZ2lkIjoiMzAwLTM2OC0xMDAzOTkxMDIxIiwiZWNjIjoiNDEwMzM4NTU0MjAiLCJmbm0iOiJHYW5lc2giLCJsbm0iOiJSZWRkaWFyIiwidXVpZCI6ImJjNTU4ZjBjLWU1OTgtNDcxNy1iNTU3LTU2NmRlNzcwODk1NCIsImpwciI6IiIsImJhbiI6InNhZmV3YXkiLCJzdHIiOiIxNjg0IiwicGhuIjoiNDA4ODM0NjY3MiIsImJpZCI6Ijc1YWM4ZDRhLWYxZjctNGM3OS1iZjRiLWJhMDRjYzNkNjBlOSJ9.OKCtz5SqbSWcnBLp1btBq5sv64b8o0SSKHgyHk5UVl5Ryfu1KGJoJqFXUcaodWzc6pYxUMKgaEufPfReCBZszAJAgJj5oLt1M1CVLyoveRH10yT0Nmw-CjvtrTAOdH2nPdbAVsEJoleXJihF0-RTrJmkWnaCc5jHv41SWzEH3T5JomYeuUjpRsp0CxUaSM6iZ8KVSuzOYk5lK11h_vAIWY5XV084yFpDy3VtQkchTxw-dGgIRhaRQ9ZlQtb-EX1SEf7B1BHlMaxlOlIGGStj67NMJ9458bD258lU6lktRI5Wk6QRHvNRuveFXlDVAQa5gGl6t88EC-F19jQyUTgHuA");

        headers.put("SWY_TIMESTAMP", "1603903260514");

        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if (response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get Category Successfull");
            }

        } catch (Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get Category Failed with Exception :: " + e.toString());
        }


        return result;

    }

    public Result getWeeklySpecials() {

        Result result = new Result();


        HttpRequest request = new HttpRequest();

        String url = this.nimbusUrl + "/emmd/service/offer/weeklySpecial/2606?Brand=safeway";


        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();


        headers.put("ADRUM_1", "isMobile:true");

        headers.put("User-Agent", "Safeway/7052 CFNetwork/1197 Darwin/20.0.0");

        headers.put("REQUEST_TIME", "1603913906691");

        headers.put("Accept", "*/*");

        headers.put("Accept-Language", "en-us");

        headers.put("SWY_TIMESTAMP", "1603913907");

        headers.put("X-SWY_API_KEY", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("SWY_CLOUD_API_VER", "2.0");

        headers.put("X-SWY_BANNER", "safeway");

        headers.put("CLIENT_ID", " ");

        headers.put("X-SWY_VERSION", "8.5.0");

        headers.put("ADRUM", "isAjax:true");

        headers.put("SWY_SIGNATURE", "D3qSwpYqIKtQCxC+3rIXB34CdLw=");

        headers.put("Cookie", "swyConsumerDirectoryPro=eyJraWQiOiJxYkpsN1lDa2NiYW5nNzlUWURYNk5HOER4Y2hhY2tPdG9tenVPVURqaFA4IiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULnpiMUZBb2dNRmdJYUZkdUhReG9QdXJvT3FGUnV2RHB5ajAtYjBWWWtJN3Mub2FyZ2M2dTJ1UGZFUnl2TDUycDYiLCJpc3MiOiJodHRwczovL2FsYmVydHNvbnMub2t0YS5jb20vb2F1dGgyL2F1c3A2c294ckl5UHJtOHJTMnA2IiwiYXVkIjoiQWxiZXJ0c29ucyIsImlhdCI6MTYwMzkwMTk1NywiZXhwIjoxNjAzOTA0NjU3LCJjaWQiOiIwb2FwNmtrcDdTZWZnMjRyQjJwNiIsInVpZCI6IjAwdWp4bWk0c2gwanpxY0N2MnA2Iiwic2NwIjpbIm9mZmxpbmVfYWNjZXNzIiwicHJvZmlsZSIsIm9wZW5pZCJdLCJ6aXAiOiI4NTcxOSIsInN1YiI6ImdyZWRkaWFyQGdtYWlsLmNvbSIsImhpZCI6IjI1MDA0MTMzMzc0NiIsImRubSI6IkdhbmVzaCIsImFsbiI6IjQxMDMzODU1NDIwIiwiZ2lkIjoiMzAwLTM2OC0xMDAzOTkxMDIxIiwiZWNjIjoiNDEwMzM4NTU0MjAiLCJmbm0iOiJHYW5lc2giLCJsbm0iOiJSZWRkaWFyIiwidXVpZCI6ImJjNTU4ZjBjLWU1OTgtNDcxNy1iNTU3LTU2NmRlNzcwODk1NCIsImpwciI6IiIsImJhbiI6InNhZmV3YXkiLCJzdHIiOiIxNjg0IiwicGhuIjoiNDA4ODM0NjY3MiIsImJpZCI6Ijc1YWM4ZDRhLWYxZjctNGM3OS1iZjRiLWJhMDRjYzNkNjBlOSJ9.OKCtz5SqbSWcnBLp1btBq5sv64b8o0SSKHgyHk5UVl5Ryfu1KGJoJqFXUcaodWzc6pYxUMKgaEufPfReCBZszAJAgJj5oLt1M1CVLyoveRH10yT0Nmw-CjvtrTAOdH2nPdbAVsEJoleXJihF0-RTrJmkWnaCc5jHv41SWzEH3T5JomYeuUjpRsp0CxUaSM6iZ8KVSuzOYk5lK11h_vAIWY5XV084yFpDy3VtQkchTxw-dGgIRhaRQ9ZlQtb-EX1SEf7B1BHlMaxlOlIGGStj67NMJ9458bD258lU6lktRI5Wk6QRHvNRuveFXlDVAQa5gGl6t88EC-F19jQyUTgHuA");

        headers.put("CLIENT_APP_VERSION", "8.5.0");


        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if (response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get Weekly Specials Successfull");
            }

        } catch (Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get Weekly Specials Failed with Exception :: " + e.toString());
        }

        return result;

    }

    public Result getOfferClip() {

        Result result = new Result();


        HttpRequest request = new HttpRequest();

        String url = this.nimbusUrl + "Clipping1/services/clip/items?storeId=4601";

        Map<String, Object> items = new HashMap<String, Object>();

        items.put("itemType", "SC");

        items.put("clipType", "C");

        items.put("itemId", "1745951809");

        items.put("scope", "openid profile offline_access");

        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();

        headers.put("Authorization", "Bearer " + CommonCache.tokenCache.get("accessToken"));

        /////////////////////////////////////////////////

        headers.put("ADRUM_1", "isMobile:true");

        headers.put("User-Agent", "Safeway/7052 CFNetwork/1197 Darwin/20.0.0");

        headers.put("Accept", "*/*");

        headers.put("Accept-Language", "en-us");

        headers.put("Content-Type", "application/json");

        headers.put("SWY_TIMESTAMP", "1603913907");

        headers.put("X-SWY_API_KEY", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("X-SWY_BANNER", "safeway");

        headers.put("CLIENT_ID", " ");

        headers.put("X-SWY_VERSION", "1.1");

        headers.put("ADRUM", "isAjax:true");

        headers.put("Cookie", "swyConsumerDirectoryPro=eyJraWQiOiJxYkpsN1lDa2NiYW5nNzlUWURYNk5HOER4Y2hhY2tPdG9tenVPVURqaFA4IiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULnpiMUZBb2dNRmdJYUZkdUhReG9QdXJvT3FGUnV2RHB5ajAtYjBWWWtJN3Mub2FyZ2M2dTJ1UGZFUnl2TDUycDYiLCJpc3MiOiJodHRwczovL2FsYmVydHNvbnMub2t0YS5jb20vb2F1dGgyL2F1c3A2c294ckl5UHJtOHJTMnA2IiwiYXVkIjoiQWxiZXJ0c29ucyIsImlhdCI6MTYwMzkwMTk1NywiZXhwIjoxNjAzOTA0NjU3LCJjaWQiOiIwb2FwNmtrcDdTZWZnMjRyQjJwNiIsInVpZCI6IjAwdWp4bWk0c2gwanpxY0N2MnA2Iiwic2NwIjpbIm9mZmxpbmVfYWNjZXNzIiwicHJvZmlsZSIsIm9wZW5pZCJdLCJ6aXAiOiI4NTcxOSIsInN1YiI6ImdyZWRkaWFyQGdtYWlsLmNvbSIsImhpZCI6IjI1MDA0MTMzMzc0NiIsImRubSI6IkdhbmVzaCIsImFsbiI6IjQxMDMzODU1NDIwIiwiZ2lkIjoiMzAwLTM2OC0xMDAzOTkxMDIxIiwiZWNjIjoiNDEwMzM4NTU0MjAiLCJmbm0iOiJHYW5lc2giLCJsbm0iOiJSZWRkaWFyIiwidXVpZCI6ImJjNTU4ZjBjLWU1OTgtNDcxNy1iNTU3LTU2NmRlNzcwODk1NCIsImpwciI6IiIsImJhbiI6InNhZmV3YXkiLCJzdHIiOiIxNjg0IiwicGhuIjoiNDA4ODM0NjY3MiIsImJpZCI6Ijc1YWM4ZDRhLWYxZjctNGM3OS1iZjRiLWJhMDRjYzNkNjBlOSJ9.OKCtz5SqbSWcnBLp1btBq5sv64b8o0SSKHgyHk5UVl5Ryfu1KGJoJqFXUcaodWzc6pYxUMKgaEufPfReCBZszAJAgJj5oLt1M1CVLyoveRH10yT0Nmw-CjvtrTAOdH2nPdbAVsEJoleXJihF0-RTrJmkWnaCc5jHv41SWzEH3T5JomYeuUjpRsp0CxUaSM6iZ8KVSuzOYk5lK11h_vAIWY5XV084yFpDy3VtQkchTxw-dGgIRhaRQ9ZlQtb-EX1SEf7B1BHlMaxlOlIGGStj67NMJ9458bD258lU6lktRI5Wk6QRHvNRuveFXlDVAQa5gGl6t88EC-F19jQyUTgHuA");

        headers.put("CLIENT_APP_VERSION", "8.5.0");


        request.setUrl(url);

        request.setHeaders(headers);

        request.setParams(items);

        try {
            HttpResponse response = HttpHandler.post(request);

            if (response.getStatusCode() == 200) {

                CommonCache.tokenCache.put("OfferClip", response.getJsonResponse().getString("OfferClip"));

                result.setStatus(true);

                result.setStatusMsg("Get Offer Clip Successfull");
            }

        } catch (Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get Offer Clip Failed with Exception :: " + e.toString());
        }


        return result;

    }

    public String getDefaultStoreId(String customerID, String deliveryMode,String zipCode, String bannerName) {
        Result result = new Result();
        HttpRequest request = new HttpRequest();
        String storeId = null;
        // Customer ID needs to be parameterized
        String url = this.hostUrl + "abs/acceptancepub/cnc/ucaservice/api/uca/customers/"+customerID+"/profile?fl=preferences,loyalty,household,address";
        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();
        headers.put("Authorization", "Bearer " + CommonCache.tokenCache.get("accessToken"));
        headers.put("Content-Type", "application/json");
        headers.put("x-swy-application-type", "native-mobile");
        headers.put("x-swy_api_key", "emmd");
        headers.put("x-swy-banner", "tomthumb");
        //These are additional params
        headers.put("x-swy-correlation-id", "dc1ddfce-39ed-11e8-b467-0ed5f89f718b");
        headers.put("x-swy-client-id", "mobile-ios-shop");
        headers.put("banner", "tomthumb");
        //headers.put("x-swy-date", "Mon, 25 May 2021 09:54:28 +0530");
        headers.put("x-swy-date",  ""+new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z").format(new Date()));
        headers.put("Ocp-Apim-Subscription-Key", "d8c6d7783b604f618dd446e7c39c7c08");

        request.setUrl(url);
        request.setHeaders(headers);
        try {
            HttpResponse response = HttpHandler.get(request);
            ApiResponse.StoreInformation storeInformation = new Gson().fromJson(response.getContent(), ApiResponse.StoreInformation.class);
            ApiResponse.StoreInformation.Store desiredStore = storeInformation.getStores().stream().filter(indStore -> indStore.address.zipCode.equalsIgnoreCase(zipCode) && indStore.storePreference.equalsIgnoreCase(deliveryMode)&&indStore.banner.equalsIgnoreCase(bannerName)).collect(Collectors.toList()).get(0);
            storeId=desiredStore.storeId;

        } catch (Exception e) {
            result.setStatus(false);
            result.setStatusMsg("Get All Offers Failed with Exception :: " + e.toString());
        }
        return storeId;
    }

    public ApiResponse.StoreSolver.Store getStoreDetails(String deliveryMode, String zipCode, String bannerName) {
        Result result = new Result();
        HttpRequest request = new HttpRequest();
        ApiResponse.StoreSolver.Store desiredStore = null;
        // Customer ID needs to be parameterized
        String url = this.hostUrl + "abs/acceptancepub/xapi/storeresolver/zipcodetoecom?zipcode=" + zipCode;
        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();
        headers.put("Content-Type", "application/json");
        headers.put("banner", bannerName);
        headers.put("Ocp-Apim-Subscription-Key", "35570fd5f27f4d69948bafbb4dd4f878");
        request.setUrl(url);
        request.setHeaders(headers);
        try {
            HttpResponse response = HttpHandler.get(request);
            ApiResponse.StoreSolver storeInformation = new Gson().fromJson(response.getContent(), ApiResponse.StoreSolver.class);
            if (deliveryMode.contains("Delivery") && storeInformation.getStore().isDeliveryStore) {
                desiredStore = storeInformation.getStore();
            } else if (deliveryMode.contains("DriveUp") && storeInformation.getStore().isPickupStore) {
                desiredStore = storeInformation.getStore();
            }

        } catch (Exception e) {
            result.setStatus(false);
            result.setStatusMsg("Get All Offers Failed with Exception :: " + e.toString());
        }
        return desiredStore;
    }

}
