package com.automation.helpers;

import io.cucumber.testng.Pickle;
import io.cucumber.testng.PickleWrapper;

import java.util.Map;

public class ThreadLocalHelper {

    public static ThreadLocal<Pickle> feature = new ThreadLocal<>();

    public static ThreadLocal<String> featureName = new ThreadLocal<>();

    public static ThreadLocal<Map<String, String>> testCaseData = new ThreadLocal<>();
}
