package com.automation.mobile;

import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.entities.CommandArgument;
import com.automation.mobile.manager.ConfigFileManager;
import com.automation.mobile.util.GlobalVar;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MobileRunner {

	@Test
	public void executeRunner() throws Exception {

	String testType = System.getenv("TEST_TYPE");
//		String testType = "parallel";
		System.out.println(testType);

		Map<String, List<String>> parsedArgument = parseCommandArgument();
		GlobalVar.DEVICE_LIST = generateDeviceList(parsedArgument);
		System.out.println(GlobalVar.DEVICE_LIST);

		int threadCount = GlobalVar.DEVICE_LIST.size();

		TestNGGenerator testng = new TestNGGenerator(testType, threadCount);
		try {
			testng.runTest();
		}catch (Exception e) {

			e.printStackTrace();
		}
	}

	private Map<String, List<String>> parseCommandArgument()  {

		Map<String, List<String>> testParameters = new HashMap<String, List <String>>();
		if(null != System.getProperty(CommandArgument.MOBILE_DEVICES) && !System.getProperty(CommandArgument.MOBILE_DEVICES).isEmpty()) {
			if(System.getProperty(CommandArgument.MOBILE_DEVICES).contains(",")){
				testParameters.put(CommandArgument.BANNERS,
						Arrays.asList(System.getProperty(CommandArgument.BANNERS).split(",")));
				testParameters.put(CommandArgument.MOBILE_DEVICES,
						Arrays.asList(System.getProperty(CommandArgument.MOBILE_DEVICES).split(",")));
				testParameters.put(CommandArgument.APP_SLUG,
						Arrays.asList(System.getenv(CommandArgument.APP_SLUG).split(",")));
				testParameters.put(CommandArgument.BUILD_SLUG,
						Arrays.asList(System.getenv(CommandArgument.BUILD_SLUG).split(",")));
			} else{
				testParameters.put(CommandArgument.BANNERS,
						Arrays.asList(System.getProperty(CommandArgument.BANNERS)));
				testParameters.put(CommandArgument.MOBILE_DEVICES,
						Arrays.asList(System.getProperty(CommandArgument.MOBILE_DEVICES)));
				testParameters.put(CommandArgument.APP_SLUG,
						Arrays.asList(System.getenv(CommandArgument.APP_SLUG)));
				testParameters.put(CommandArgument.BUILD_SLUG,
						Arrays.asList(System.getenv(CommandArgument.BUILD_SLUG)));
			}

			testParameters.put("environment", Arrays.asList(System.getProperty(CommandArgument.MOBILE_ENVIRONMENT)));
		}
		else {
			if(System.getenv(CommandArgument.DEVICES).contains(",")){
				testParameters.put(CommandArgument.BANNERS,
						Arrays.asList(System.getenv(CommandArgument.BANNER).split(",")));
				testParameters.put(CommandArgument.MOBILE_DEVICES,
						Arrays.asList(System.getenv(CommandArgument.DEVICES).split(",")));
				testParameters.put(CommandArgument.APP_SLUG,
						Arrays.asList(System.getenv(CommandArgument.APP_SLUG).split(",")));
				testParameters.put(CommandArgument.BUILD_SLUG,
						Arrays.asList(System.getenv(CommandArgument.BUILD_SLUG).split(",")));
			} else{
				testParameters.put(CommandArgument.BANNERS,
						Arrays.asList(System.getenv(CommandArgument.BANNER)));
				testParameters.put(CommandArgument.MOBILE_DEVICES,
						Arrays.asList(System.getenv(CommandArgument.DEVICES)));
				testParameters.put(CommandArgument.APP_SLUG,
						Arrays.asList(System.getenv(CommandArgument.APP_SLUG)));
				testParameters.put(CommandArgument.BUILD_SLUG,
						Arrays.asList(System.getenv(CommandArgument.BUILD_SLUG)));
			}

			testParameters.put("environment", Arrays.asList(System.getenv(CommandArgument.ENVIRONMENT)));
		}

		testParameters.put("app", Arrays.asList("shop"));

		System.out.println(testParameters);
		return testParameters;
	}

	public Map<String, Map<String, String>> generateDeviceList(Map<String, List<String>> inputParameters) throws IOException {
		Map<String, Map<String, String>> totalParameters = new HashMap<String, Map<String, String>>();
		List<String> banners = inputParameters.get("banner");
		List<String> mobileDevices = inputParameters.get("mobileDevice");
		String app = inputParameters.get("app").get(0);
		String env = inputParameters.get("environment").get(0);

		for (int i = 0; i < mobileDevices.size(); i++) {
			String banner = banners.get(i);
			String mobile = mobileDevices.get(i);
			Map<String, String> deviceParam = new HashMap<>();
			System.out.println(mobile);
			deviceParam.putAll(new ConfigFileManager().getMobilePropertyMap(mobile));
			deviceParam.putAll(new ConfigFileManager().getBannerPropertyMap(banner, env));
			deviceParam.put("banner", banner);
			deviceParam.put("env", env);
			deviceParam.put("app", app);
			deviceParam.put("STATE", "AVAILABLE");
			deviceParam.put("REGISTERUSER", "");
			deviceParam.put("build_slug", inputParameters.get(CommandArgument.BUILD_SLUG).get(i));
			deviceParam.put("app_slug", inputParameters.get(CommandArgument.APP_SLUG).get(i));
			totalParameters.put(mobile, deviceParam);
		}
		return totalParameters;
	}
}


