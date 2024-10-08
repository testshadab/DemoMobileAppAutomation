package com.automation.rest.cache;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CommonCache {
	
	public static Map<String, String> tokenCache = new HashMap<String, String>();

	public static Map<String, String> commonCache = new HashMap<>();


	public static Map<String, JSONArray> offerCache = new HashMap<String, org.json.JSONArray>() ;
//	public static Map<String, List<ApiResponse.miscService.featureFlag>> miscCache = new HashMap<String, java.util.List<com.automation.mobile.models.ApiResponse.miscService.featureFlag>>() ;
//    public static Map<String, JSONArray> miscCache = new HashMap<String, org.json.JSONArray>() ;
     public static Map<String, JSONObject> miscCache = new HashMap<String, org.json.JSONObject>();
	public static Map<String, Object> allDealsInAPI = new HashMap<String, Object>() ;
	public static Map<String, Object> myListInAPI = new HashMap<String, Object>() ;
	public static Map<String, Object> cartItems = new HashMap<String, Object>() ;
}
