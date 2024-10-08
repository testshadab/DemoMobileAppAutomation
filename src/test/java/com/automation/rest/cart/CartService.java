package com.automation.rest.cart;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.rest.auth.AccessToken;
import com.automation.rest.cache.CommonCache;
import com.automation.rest.cart.model.GetCartItemsResponse;
import com.automation.rest.config.RestApiConfig;
import com.google.gson.Gson;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;

public class CartService {
    private static String HOST = "https://www-qa2.%s.com";
    Logger logger = LogManager.getLogger(getClass());
    private static final String OCIP_APIM_SUBSCRIPTION_KEY = "26dfa6ab7afe4a88805ce9f5351b78b4";
    private static final String GET_CART = "/abs/acceptancepub/erums/cartservice/api/v1/cart/customer/%s";
    private static final String DELETE_CART = "/abs/acceptancepub/erums/cartservice/api/v1/cart/%s/items";


    public CartService(String banner) {
        this.HOST = String.format(HOST, resolveBannerNameForHost(banner));
    }

    public <T> T getCartItems(String userName, String password, String customerId, String storeId, String serviceType) {
        GetCartItemsResponse getCartItemsResponse = null;
        String url = HOST + String.format(GET_CART, customerId);
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        AccessToken accessToken = new AccessToken(userName, password);
        String accessTokenString = accessToken.getAccessToken();

        Map<String, String> headers = RestApiConfig.getJsonHeaders(accessTokenString);
        headers.put("Content-Type", "application/json");
        headers.put("Ocp-Apim-Subscription-Key", OCIP_APIM_SUBSCRIPTION_KEY);
        request.setUrl(url);
        request.setHeaders(headers);

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("storeId", storeId);
        if (!serviceType.isEmpty() && serviceType != null) {
            queryParams.put("serviceType", serviceType);
        }
        request.setParams(queryParams);

        try {
            logger.info(String.format("Get cart items request: %s", request));
            HttpResponse response = HttpHandler.get(request);
            logger.info(String.format("Get cart items response: %s", response));
            if (response.getStatusCode() == 200) {
                getCartItemsResponse = new Gson().fromJson(response.getContent(), GetCartItemsResponse.class);
                CommonCache.cartItems.put("cartItems", getCartItemsResponse);
            } else {
                return (T) ("Get Cart API failed, response received: " + response);
            }
        } catch (Exception e) {
            throw new RuntimeException("Get cart items failed, exception message: " + e.getMessage());
        }
        return (T) getCartItemsResponse;
    }


    public GetCartItemsResponse getCartDetails(String userName, String password, String customerId, String storeId, String serviceType) {
        HttpResponse response = fetchCartDetails(userName, password, customerId, storeId, serviceType);
        GetCartItemsResponse getCartItemsResponse = null;
        if (response.getStatusCode() == 200) {
            getCartItemsResponse = new Gson().fromJson(response.getContent(), GetCartItemsResponse.class);
        }
        return getCartItemsResponse;
    }


    private String resolveBannerNameForHost(String banner) {
        String resolvedBanner = banner;
        if (banner.contains("acme")) {
            resolvedBanner = "acmemarkets";
        } else if (banner.contains("carrs")) {
            resolvedBanner = "carrsqc";
        }
        return resolvedBanner;
    }

    private HttpResponse fetchCartDetails(String userName, String password, String customerId, String storeId, String serviceType) {
        GetCartItemsResponse getCartItemsResponse = null;
        String url = HOST + String.format(GET_CART, customerId);
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        AccessToken accessToken = new AccessToken(userName, password);
        String accessTokenString = accessToken.getAccessToken();

        Map<String, String> headers = RestApiConfig.getJsonHeaders(accessTokenString);
        headers.put("Content-Type", "application/json");
        headers.put("Ocp-Apim-Subscription-Key", OCIP_APIM_SUBSCRIPTION_KEY);
        request.setUrl(url);
        request.setHeaders(headers);

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("storeId", storeId);
        if (!serviceType.isEmpty() && serviceType != null) {
            queryParams.put("serviceType", serviceType);
        }
        request.setParams(queryParams);

        logger.info(String.format("Get cart items request: %s", request));
        HttpResponse response = HttpHandler.get(request);
        logger.info(String.format("Get cart items response: %s", response));
        return response;
    }


    public HttpResponse deleteAllItemsFromTheCart(String userName, String password, String storeId, String cartId, List<String> itemId) {
        String url = HOST + String.format(DELETE_CART, cartId);
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        //Access Token
        AccessToken accessToken = new AccessToken(userName, password);
        String accessTokenString = accessToken.getAccessToken();

        Map<String, String> headers = RestApiConfig.getJsonHeaders(accessTokenString);
        headers.put("Content-Type", "application/json");
        headers.put("Ocp-Apim-Subscription-Key", OCIP_APIM_SUBSCRIPTION_KEY);
        request.setUrl(url);
        request.setHeaders(headers);

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("storeId", storeId);
        request.setParams(queryParams);

        Map<String, Object> requestBody = new LinkedHashMap<String, Object>();
        List<LinkedHashMap<String, Object>> itemIdValues = new ArrayList<LinkedHashMap<String, Object>>();
        itemId.forEach(indVal -> itemIdValues.add(new LinkedHashMap<String, Object>() {{
            put("itemId", indVal);
        }}));
        requestBody.put("cartItemsList", itemIdValues);
        request.setServiceBody(requestBody);
        logger.info(String.format("Get cart items request: %s", request));
        HttpResponse response = HttpHandler.deleteWithPayload(request);
        logger.info(String.format("Get cart items response: %s", response));
        return response;
    }



}
