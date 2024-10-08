package com.automation.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

public class StringUtil {

    public static String convertObjectToString(Object obj) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        if (obj != null) {
            if ((obj instanceof String) || (obj instanceof JSONObject)) {
                return obj.toString();
            } else {
                return gson.toJson(obj).replace("\\\\", "\\");
            }
        }

        return "";
    }
}
