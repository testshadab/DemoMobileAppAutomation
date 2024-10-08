package com.automation.mobile.services.testrail;

import com.automation.mobile.services.testrail.constants.TestRailConstants;
import org.json.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class CaseService {

    public JSONArray getCases() throws IOException, APIException {

        JSONArray result;

        APIClient client = new APIClient(TestRailConstants.URL);

        client.setUser("saad.khan@ymedialabs.com");

        client.setPassword("dPdtkom4gN");

        result = (JSONArray) client.sendGet("get_cases/"+1+"&suite_id="+1);

        return result;
    }
}
