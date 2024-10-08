package com.automation.mobile.services.testrail;

import com.automation.mobile.services.testrail.constants.TestRailConstants;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class ResultService {

    public void addResultsForCases(String runId, JSONObject body) throws IOException, APIException {

        JSONArray result = new JSONArray();

        APIClient client = new APIClient(TestRailConstants.URL);

        client.setUser("saad.khan@ymedialabs.com");

        client.setPassword("dPdtkom4gN");

        result = (JSONArray) client.sendPost("add_results_for_cases/"+runId, body);
    }
}
