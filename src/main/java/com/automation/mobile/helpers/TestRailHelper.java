//package com.automation.mobile.helpers;
//
//import com.automation.mobile.services.testrail.APIException;
//import com.automation.mobile.services.testrail.ResultService;
//import cucumber.api.Scenario;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//
//import java.io.IOException;
//
//public class TestRailHelper {
//
//    public static void updateResult(String[] caseIds, Scenario scenario, String runId) throws IOException, APIException {
//
//        JSONObject resultObj;
//
//        int status_id = 0;
//
//        String comment = "";
//
//        ResultService resultService = new ResultService();
//
////        TestRunService runService = new TestRunService();
////
////        JSONObject result = runService.getRun(runId);
////
////        CaseService caseService = new CaseService();
////
////        JSONObject caseResult = caseService.getCases();
//
//
//        if(scenario.getStatus() == "failed"){
//
//            status_id = 5;
//        }
//        else if(scenario.getStatus() == "passed"){
//
//            status_id = 1;
//        }
//        else if(scenario.getStatus() == "skipped"){
//
//            status_id = 4;
//        }
//
//        JSONObject body = new JSONObject();
//
//        JSONArray results = new JSONArray();
//
//        for (String caseId : caseIds){
//
//            resultObj = new JSONObject();
//
//            resultObj.put("case_id", Integer.valueOf(caseId.substring(1)));
//
//            resultObj.put("status_id", status_id);
//
//            resultObj.put("comment", comment);
//
//            results.add(resultObj);
//        }
//
//        body.put("results", results);
//
//        resultService.addResultsForCases(runId, body);
//    }
//}
