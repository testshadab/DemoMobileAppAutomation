package com.automation.mobile.services.testrail;

import com.automation.mobile.services.testrail.constants.TestRailConstants;
import org.json.simple.JSONObject;

import java.io.IOException;

public class TestRunService {

    public JSONObject getRun(String runId) throws IOException, APIException {

        JSONObject result = new JSONObject();

        APIClient client = new APIClient(TestRailConstants.URL);

        client.setUser("saad.khan@ymedialabs.com");

        client.setPassword("dPdtkom4gN");

        result = (JSONObject) client.sendGet("get_run/"+runId);

        return result;
    }
}
