package com.automation.rest.settings;

import com.automation.helpers.StringUtil;
import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.rest.RestApiUtils;
import com.automation.rest.settings.model.EvalAttrsRequestBody;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

public class EvalAttrs {
    Logger logger = LogManager.getLogger(getClass());
    public String url = "https://www-%s.%s.com/abs/acceptancepub/ESFF/api/v1/evalattrs";

    public EvalAttrs(String env, String banner) {
        this.url = String.format(url, env, RestApiUtils.resolveBannerNameForHost(banner));
    }

    public JSONArray getFeatureFlagStatusObject(String requestBody) {
        HttpRequest request = new HttpRequest();
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("Content-type", "application/json");
        request.setUrl(this.url);
        request.setHeaders(headers);
        request.setStringBody(requestBody);
        logger.info("Feature flag status(evalattrs) API request:" + request);
        HttpResponse httpResponse = HttpHandler.post(request);
        logger.info("Feature flag status(evalattrs) API response:" + httpResponse);
        if (httpResponse.getStatusCode() != 200) {
            throw new RuntimeException("Feature flag status(evalattrs) API failed, response received:" + httpResponse);
        }
        return httpResponse.getJsonArrayResponse();
    }

    public static boolean isFeatureEnabledForGivenBanner(String featureFlag, String banner, String env, EvalAttrsRequestBody evalAttrsRequestBody) {
        boolean isEnabled = false;
        EvalAttrs evalAttrs = new EvalAttrs(env, banner);
        JSONArray featureFlagArray = evalAttrs.getFeatureFlagStatusObject(StringUtil.convertObjectToString(evalAttrsRequestBody));
        for (int i = 0; i < featureFlagArray.length(); i++) {
            try {
                JSONObject obj = (JSONObject) featureFlagArray.get(i);
                if (obj.getString("featureFlagName").equalsIgnoreCase(featureFlag)) {
                    isEnabled = obj.getBoolean("featureFlagValue");
                    break;
                }
            } catch (JSONException je) {
                Assert.assertTrue(false, "Exception caught while reading 'featureFlagName' key from feature flag status(evalattrs) API, message from exception: " + je.getMessage());
                break;
            }
        }
        return isEnabled;
    }
}
