package com.automation.rest.stores;

import java.util.Map;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.models.Result;
import com.automation.rest.RestService;
import com.automation.rest.cache.CommonCache;
import com.automation.rest.config.RestApiConfig;

import io.appium.java_client.AppiumDriver;

public class StoresService extends RestService{


    public StoresService(AppiumDriver driver) {
        super(driver);
    }


    public Result getListOfStores() {

        Result result = new Result();

        HttpRequest request = new HttpRequest();

        String url = this.hostUrl + "/abs/acceptancepub/xapi/storeresolver/all?zipcode=94111&radius=50&size=1";

        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();

        headers.put("ADRUM_1", "isMobile:true");

        headers.put("Accept", "application/json");

        headers.put("appversion", "8.5.0");

        headers.put("Accept-Language", "en-us");

        headers.put("platform", "ios");

        headers.put("banner", "safeway");

        headers.put("Content-Type", "application/json");

        headers.put("User-Agent", "Safeway/7052 CFNetwork/1197 Darwin/20.0.0");

        headers.put("Ocp-Apim-Subscription-Key", "35570fd5f27f4d69948bafbb4dd4f878");

        headers.put("ADRUM", "isAjax:true");

        headers.put("Cookie", "incap_ses_124_1778155=YHsLQ2olWFfog/35pom4ASbImV8AAAAAtxUTtj6PSNTUoV2ZP9G/VQ==; nlbi_1778155=S7F4AlWSdgd///MAAZv1QQAAAADZlQ7m3QXxjXgY089G/k9z; visid_incap_1778155=SYbHvBk3QrCQYTpn1GEULMW1mV8AAAAAQkIPAAAAAADgcB4SzjaZ9vnJWAe3MKzD");



        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if(response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get List Of Stores Successfull");
            }

        }
        catch(Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get List Of Stores Failed with Exception :: " + e.toString());
        }

        return result;
    }



    public Result getStoreDetail() {

        Result result = new Result();


        HttpRequest request = new HttpRequest();

        String url = this.hostUrl + "/api/services/locator/entity/store/4601";


        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();

        headers.put("Accept", "application/json");

        headers.put("Content-Type", "application/json");

        headers.put("Content-Type", "application/json");

        headers.put("Cookie", "incap_ses_124_1778155=Gt57KLuUD32Do/L5pom4AcS1mV8AAAAAoKJZanBSYsIqjbt/IzykYg==; nlbi_1778155=1vrCTbr/L32cx1izAZv1QQAAAAAgycmIsiX3iSdxp9M0eSJw; visid_incap_1778155=lbPW+YnaRD+dL0ZE8eUWc8S1mV8AAAAAQUIPAAAAAADse1aGifws3ZiqNIMr0AeV; incap_ses_124_1409564=+9F7PjQ2z1R72fH5pom4AZm0mV8AAAAAyk9ZYBzXJYM6VjDpv5Majg==; nlbi_1409564=AGo4a8GOVV6tTYHCW9qUkQAAAACCW8KCe0ZNiFH3I+OWwue0; s_vi=[CS]v1|2FCCD9A08515C3DF-40000BC0E2B20B43[CE]; _ga=GA1.2.789514575.1603908413; _gid=GA1.2.1075612307.1603908413; ls_c=0; ls_e=0; s_fid=59ACA034BC0AC9B7-24DFE70257A2F410; s_la=Wed%20Oct%2028%202020%2011%3A06%3A56%20GMT-0700%20%28PDT%29; s_nr=1603908416861-New; visid_incap_1409564=bE/ql/e3TI6dIz1bs1iq1j+zmV8AAAAAQUIPAAAAAADd3RXVce3JnEpRWMNuVjMy; _vwo=ts~nlMp28p(MR0)l~1%7C(2sg)k~*(MR0)u~D2615CBD4AB2F72C79B1FC5225A8C80B5(1p78)m~3%241603908410%3A47.41471146%3A%3A(2cE)n~0%3A4(2; _vwo_sn=0%3A4; _gcl_au=1.1.1448870962.1603908413; _vis_opt_s=1%7C; _vwo_ds=3%241603908410%3A47.41471146%3A%3A; _vwo_uuid=D2615CBD4AB2F72C79B1FC5225A8C80B5; _vwo_uuid_v2=D2615CBD4AB2F72C79B1FC5225A8C80B5|70877859c525ecb358889eaa4c3228c2");

        headers.put("ADRUM", "isAjax:true");

        headers.put("ADRUM_1", "isMobile:true");

        headers.put("Accept-Language", "en-us");

        headers.put("User-Agent", "Safeway/7052 CFNetwork/1197 Darwin/20.0.0");

        headers.put("Ocp-Apim-Subscription-Key", "34a4bf73f22d4782910d7fac910f2a66");


        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if(response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get Store Detail Successfull");
            }

        }
        catch(Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get Store Detail Failed with Exception :: " + e.toString());
        }


        return result;

    }

    public Result getStoreResolverHome() {

        Result result = new Result();


        HttpRequest request = new HttpRequest();

        String url = this.hostUrl + "/abs/acceptancepub/xapi/storeresolver/all?size=1&zipcode=94107&radius=50";


        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();

        headers.put("ADRUM_1", "isMobile:true");

        headers.put("Accept", "application/json");

        headers.put("appversion", "8.5.0");

        headers.put("Accept-Language", "en-us");

        headers.put("platform", "ios");

        headers.put("banner", "safeway");

        headers.put("Content-Type", "application/json");

        headers.put("User-Agent", "Safeway/7052 CFNetwork/1197 Darwin/20.0.0");

        headers.put("Ocp-Apim-Subscription-Key", "35570fd5f27f4d69948bafbb4dd4f878");

        headers.put("ADRUM", "isAjax:true");

        headers.put("Cookie", "incap_ses_124_1778155=YHsLQ2olWFfog/35pom4ASbImV8AAAAAtxUTtj6PSNTUoV2ZP9G/VQ==; nlbi_1778155=S7F4AlWSdgd///MAAZv1QQAAAADZlQ7m3QXxjXgY089G/k9z; visid_incap_1778155=SYbHvBk3QrCQYTpn1GEULMW1mV8AAAAAQkIPAAAAAADgcB4SzjaZ9vnJWAe3MKzD");


        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if(response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get Store Resolver Home Successfull");
            }

        }
        catch(Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get  Store Resolver Home Failed with Exception :: " + e.toString());
        }

        return result;

    }

}
