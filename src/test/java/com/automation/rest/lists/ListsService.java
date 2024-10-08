package com.automation.rest.lists;

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

import java.util.List;
import java.util.Map;

public class ListsService extends RestService{

    public ListsService(AppiumDriver driver) {
        super(driver);
    }

    public Result getMyList(String storeID) {

        Result result = new Result();
        HttpRequest request = new HttpRequest();
        String url = this.nimbusUrl + "/emmd/service/mylist/default/details?storeId="+storeID;
        String token = CommonCache.tokenCache.get("accessToken");
        Map<String, String> headers = RestApiConfig.getJsonHeaders(token);
        headers.put("Accept", "*/*");
        headers.put("Content-Type", "application/json");
        headers.put("Cookie", "swyConsumerDirectoryPro=eyJraWQiOiJHT1RLUXY2NG40N3ZRVjVuaGNGSVVveVNtaWhtQTM5V0N4TFNxVXY4WFVrIiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULktxSkkyalRENnZlMzZjR3h0U25FZk04bzA2WTl4UUg0WVNGcElCUnJBeGMub2FycnYyaDljcEFvQllXUVYwaDYiLCJpc3MiOiJodHRwczovL2Ficy1xYTEub2t0YXByZXZpZXcuY29tL29hdXRoMi9hdXNkdnV5Y3VsUklZaXRYZzBoNyIsImF1ZCI6IkFsYmVydHNvbnMiLCJpYXQiOjE2MDM5MTM3NjUsImV4cCI6MTYwMzkxNDY2NSwiY2lkIjoiMG9hZDhhaXd0N1pBN3NXY3owaDciLCJ1aWQiOiIwMHV1aWpyazVheFBteU1tYzBoNyIsInNjcCI6WyJwcm9maWxlIiwib2ZmbGluZV9hY2Nlc3MiLCJvcGVuaWQiXSwiemlwIjoiOTQxMTEiLCJzdWIiOiJnb2xkZW5nYXRlQHNhZmV3YXkuY29tIiwiaGlkIjoiODc0MDM1MDI5ODkyIiwiZG5tIjoiR29sZGVuIiwiYWxuIjoiNDkzMTg0MzQxNjYiLCJnaWQiOiI1NTctMTc2LTE2MDI4MTkzNzQ5NzAiLCJmbm0iOiJHb2xkZW4iLCJlY2MiOiIiLCJsbm0iOiJHYXRlIiwianByIjoiIiwidXVpZCI6IjYyZGU5ZWMyLWFlNGUtNGM3My04OTRkLWU1ZDIxZmMyNDJhYSIsImJhbiI6InNhZmV3YXkiLCJzdHIiOiI0NjAxIiwicGhuIjoiMzkzOTM5OTk5OSIsImJpZCI6IiJ9.E8vyXi3NIbchlLNjep52x_glscaD02GWVeQqoyWmoGt7pmO8WD0HueFgmMNZQwlwRm_7By2YCUwQuX5YbRmiUCkYAyAMmG3Ds-3_-IIl39SmyMy4fZuD9JFZr6ZU3PNmAoJF6YpR4WzBUg2puuVChNAv4hB94-CGA5oq1OaGCJKBd7v-hQu7mRW3JqwEtqHHpZY1eq-B7Q0j6kSj7sRA32CMBFUVJG4-Gm5xSTQhn4igOMZziCqagV8FWS0P_UzycKNbdcg38OvBYH2kXf_I7xWpqxRVIL4u8e6zUA1Y3i1EzoHF5G2cZPfdBs-BJaG7pgrSNFlL6Q_7FPLy4KklfQ");
        request.setUrl(url);
        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);
            if(response.getStatusCode() == 200) {
                result.setStatus(true);
                result.setStatusMsg("Get My List Successfull");
                //JSONArray myListDetails = response.getJsonResponse().getJSONArray("shoppingList");
                List<ApiResponse.MyList.ShoppingList> myListFromAPI =  new Gson().fromJson(response.getContent(), ApiResponse.MyList.class).getShoppingList();
                CommonCache.myListInAPI.put("myList", myListFromAPI);
                List<ApiResponse.MyList.ShoppingList> allOffersAPI = (List<ApiResponse.MyList.ShoppingList>) CommonCache.myListInAPI.get("myList");
                result.setStatus(true);
                result.setStatusMsg("Get All Offers Successfull");

            }
        }
        catch(Exception e) {
            result.setStatus(false);
            result.setStatusMsg("Get My List Failed with Exception :: " + e.toString());
        }
        return result;
    }

    public Result postMyListDeleteItem() {


        Result result = new Result();

        HttpRequest request = new HttpRequest();

        String url = this.nimbusUrl + "/Clipping1/services/delete/items";

        String token = CommonCache.tokenCache.get("accessToken");

        Map<String, String> headers = RestApiConfig.getJsonHeaders(token);

        headers.put("ADRUM_1", "isMobile:true");

        headers.put("Accept", "*/*");

        headers.put("Accept-Language", "en-us");

        headers.put("Content-Type", "application/json");

        headers.put("X-SWY_API_KEY", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("X-SWY_BANNER", "safeway");

        headers.put("CLIENT_ID", " ");

        headers.put("ADRUM", "isAjax:true");

        headers.put("X-SWY_VERSION", "1.5");

        headers.put("User-Agent", "Safeway/7052 CFNetwork/1197 Darwin/20.0.0");

        headers.put("Cookie", "swyConsumerDirectoryPro=eyJraWQiOiJHT1RLUXY2NG40N3ZRVjVuaGNGSVVveVNtaWhtQTM5V0N4TFNxVXY4WFVrIiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULktxSkkyalRENnZlMzZjR3h0U25FZk04bzA2WTl4UUg0WVNGcElCUnJBeGMub2FycnYyaDljcEFvQllXUVYwaDYiLCJpc3MiOiJodHRwczovL2Ficy1xYTEub2t0YXByZXZpZXcuY29tL29hdXRoMi9hdXNkdnV5Y3VsUklZaXRYZzBoNyIsImF1ZCI6IkFsYmVydHNvbnMiLCJpYXQiOjE2MDM5MTM3NjUsImV4cCI6MTYwMzkxNDY2NSwiY2lkIjoiMG9hZDhhaXd0N1pBN3NXY3owaDciLCJ1aWQiOiIwMHV1aWpyazVheFBteU1tYzBoNyIsInNjcCI6WyJwcm9maWxlIiwib2ZmbGluZV9hY2Nlc3MiLCJvcGVuaWQiXSwiemlwIjoiOTQxMTEiLCJzdWIiOiJnb2xkZW5nYXRlQHNhZmV3YXkuY29tIiwiaGlkIjoiODc0MDM1MDI5ODkyIiwiZG5tIjoiR29sZGVuIiwiYWxuIjoiNDkzMTg0MzQxNjYiLCJnaWQiOiI1NTctMTc2LTE2MDI4MTkzNzQ5NzAiLCJmbm0iOiJHb2xkZW4iLCJlY2MiOiIiLCJsbm0iOiJHYXRlIiwianByIjoiIiwidXVpZCI6IjYyZGU5ZWMyLWFlNGUtNGM3My04OTRkLWU1ZDIxZmMyNDJhYSIsImJhbiI6InNhZmV3YXkiLCJzdHIiOiI0NjAxIiwicGhuIjoiMzkzOTM5OTk5OSIsImJpZCI6IiJ9.E8vyXi3NIbchlLNjep52x_glscaD02GWVeQqoyWmoGt7pmO8WD0HueFgmMNZQwlwRm_7By2YCUwQuX5YbRmiUCkYAyAMmG3Ds-3_-IIl39SmyMy4fZuD9JFZr6ZU3PNmAoJF6YpR4WzBUg2puuVChNAv4hB94-CGA5oq1OaGCJKBd7v-hQu7mRW3JqwEtqHHpZY1eq-B7Q0j6kSj7sRA32CMBFUVJG4-Gm5xSTQhn4igOMZziCqagV8FWS0P_UzycKNbdcg38OvBYH2kXf_I7xWpqxRVIL4u8e6zUA1Y3i1EzoHF5G2cZPfdBs-BJaG7pgrSNFlL6Q_7FPLy4KklfQ");

        headers.put("CLIENT_APP_VERSION", "8.5.0");


        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.post(request);

            if(response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Post My List Delete Item Successfull");
            }

        }
        catch(Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Post My List Delete Item Failed with Exception :: " + e.toString());
        }

        return result;
    }


    public Result postAisleSort() {


        Result result = new Result();

        HttpRequest request = new HttpRequest();

        String url = this.nimbusUrl + "/nc/emmd/service/sba/aislesort";

        String token = CommonCache.tokenCache.get("accessToken");

        Map<String, String> headers = RestApiConfig.getJsonHeaders(token);

        headers.put("SWY_CLOUD_API_VER", "2.0");

        headers.put("X-SWY_VERSION", "8.5.0");

        headers.put("SWY_SIGNATURE", "7dcItuk6DwLzADgqOa8CoNpYTos=");

        headers.put("X-SWY_API_KEY", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("CLIENT_APP_VERSION", "8.5.0");

        headers.put("REQUEST_TIME", "1603913767770");

        headers.put("Accept-Language", "en-us");

        headers.put("CLIENT_ID", " ");

        headers.put("Accept", "*/*");

        headers.put("SWY_TIMESTAMP", "1603913768");

        headers.put("Content-Type", "application/json");

        headers.put("X-SWY_BANNER", "safeway");


        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.post(request);

            if(response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Post Aisle Sort Item Successfull");
            }

        }
        catch(Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Post Aisle Sort Failed with Exception :: " + e.toString());
        }

        return result;
    }

}
