package com.automation.rest;

public class RestApiUtils {

    public static String resolveBannerNameForHost(String banner) {
        String resolvedBanner = banner;
        if (banner.contains("acme")) {
            resolvedBanner = "acmemarkets";
        } else if (banner.contains("carrs") && (!banner.contains("qc"))) {
            resolvedBanner = "carrsqc";
        }
        return resolvedBanner;
    }
}
