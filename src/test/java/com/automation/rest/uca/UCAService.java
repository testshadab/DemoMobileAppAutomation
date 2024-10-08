package com.automation.rest.uca;

import java.util.Map;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.models.Result;
import com.automation.rest.RestService;
import com.automation.rest.cache.CommonCache;
import com.automation.rest.config.RestApiConfig;

import io.appium.java_client.AppiumDriver;

public class UCAService extends RestService{

    public UCAService(AppiumDriver driver) {
        super(driver);
    }

    public Result getHiddenCategories() {

        Result result = new Result();

        HttpRequest request = new HttpRequest();

        String url = this.hostUrl + "/abs/acceptancepub/cnc/ucaservice/api/uca/customers/557-176-1602819374970/preferences?subCategory=HIDDEN_CATEGORY&category=DISPLAY";

        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();


        headers.put("X-SWY_VERSION", "1.5");

        headers.put("Cookie", "___utmvaDcuvRYyB=ekB; incap_ses_124_1778155=BB7AaLhg9jNJCBX6pom4AeXvmV8AAAAAUTjAgVe1GhBAi+iXghIqrg==; visid_incap_1778155=nO4eMCcnQxi3YWy5I0yriOXvmV8AAAAAQUIPAAAAAAB0QpkOwPfSxzJl3DlEbayq; _gcl_au=1.1.208580040.1603923943; _vis_opt_s=7%7C; _vwo=ts~nlMp28p(MRh)l~7%7C(2sx)u~D2615CBD4AB2F72C79B1FC5225A8C80B5(1p78)m~3%241603908410%3A47.41471146%3A%3A(2cE)k~*(MRh)n~15532%3A3(k; _vwo_ds=3%241603908410%3A47.41471146%3A%3A; _vwo_sn=15532%3A3; _vwo_uuid=D2615CBD4AB2F72C79B1FC5225A8C80B5; _vwo_uuid_v2=D4C1375CFE2F7AB4D1E89323D9B49BB5E|73c0893146e66898d66f0aa8fe2b2d99; nlbi_1778155=jJUPHXIDvXS4ywDkAZv1QQAAAABq+mYhRU9R8wGHgIvi312Q");

        headers.put("x-swy-correlation-id", "9F6CFD99-0D19-4E19-A05A-D8578210E83E");

        headers.put("User-Agent", "iphone");

        headers.put("X-SWY_API_KEY", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("x-swy-date", "Wed, 28 Oct 2020 18:10:11");

        headers.put("ADRUM_1", "isMobile:true");

        headers.put("Date", "Wed, 28 Oct 2020 22:25:55");

        headers.put("CLIENT_APP_VERSION", "8.5.0");

        headers.put("Accept-Language", "en-us");

        headers.put("CLIENT_ID", " ");

        headers.put("ADRUM", "isAjax:true");

        headers.put("Accept", "application/vnd.safeway.v1+json");

        headers.put("Content-Type", "application/vnd.safeway.v1.merge-patch+json");

        headers.put("x-swy_banner", "safeway");

        headers.put("x-swy-client-id", "mobile-ios-portal");

        headers.put("Ocp-Apim-Subscription-Key", "d8c6d7783b604f618dd446e7c39c7c08");


        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if(response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get Hidden Categories Successfull");
            }

        }
        catch(Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get Hidden Categories Failed with Exception :: " + e.toString());
        }

        return result;
    }

    public Result getListOfCategories() {

        Result result = new Result();

        HttpRequest request = new HttpRequest();

        String url = this.nimbusUrl + "/emmd/service/misc/categorysort";

        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();

        headers.put("ADRUM_1", "isMobile:true");

        headers.put("REQUEST_TIME", "1603913763986");

        headers.put("Authorization", "Bearer " + CommonCache.tokenCache.get("accessToken"));

        headers.put("Accept", "*/*");

        headers.put("User-Agent", "Safeway/7052 CFNetwork/1197 Darwin/20.0.0");

        headers.put("Accept-Language", "en-us");

        headers.put("Content-Type", "application/json");

        headers.put("X-SWY_API_KEY", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("X-SWY_BANNER", "safeway");

        headers.put("CLIENT_ID", " ");

        headers.put("ADRUM", "isAjax:true");

        headers.put("X-SWY_VERSION", "9.5.0");

        headers.put("SWY_SIGNATURE", "l7chnrkPifgLTNjch+bJ3Q96Oh8=");

        headers.put("CLIENT_APP_VERSION", "8.5.0");

        headers.put("SWY_TIMESTAMP", "1603913763986");


        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if(response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get List Of Categories Successfull");
            }

        }
        catch(Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get List Of Categories Failed with Exception :: " + e.toString());
        }

        return result;
    }

    public Result getPreferredStore() {

        Result result = new Result();

        HttpRequest request = new HttpRequest();

        String url = this.hostUrl + "abs/acceptancepub/cnc/ucaservice/api/uca/customers/557-022-1615802578200/stores";

        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();

        headers.put("Authorization", "Bearer " + CommonCache.tokenCache.get("accessToken"));

        headers.put("X-SWY_VERSION", "1.5");

        headers.put("x-swy-correlation-id", "9F6CFD99-0D19-4E19-A05A-D8578210E83E");

        headers.put("Cookie", "swyConsumerDirectoryPro=eyJraWQiOiJHT1RLUXY2NG40N3ZRVjVuaGNGSVVveVNtaWhtQTM5V0N4TFNxVXY4WFVrIiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULkpNenFmTEp4R0trSi1jYzJDS3hId0M3U29zeGYxelRQZDFfWk83b1dSSWsub2FycnYyaDljcEFvQllXUVYwaDYiLCJpc3MiOiJodHRwczovL2Ficy1xYTEub2t0YXByZXZpZXcuY29tL29hdXRoMi9hdXNkdnV5Y3VsUklZaXRYZzBoNyIsImF1ZCI6IkFsYmVydHNvbnMiLCJpYXQiOjE2MDM5MDkwNjAsImV4cCI6MTYwMzkwOTk2MCwiY2lkIjoiMG9hZDhhaXd0N1pBN3NXY3owaDciLCJ1aWQiOiIwMHV1aWpyazVheFBteU1tYzBoNyIsInNjcCI6WyJvZmZsaW5lX2FjY2VzcyIsInByb2ZpbGUiLCJvcGVuaWQiXSwiemlwIjoiOTQxMTEiLCJzdWIiOiJnb2xkZW5nYXRlQHNhZmV3YXkuY29tIiwiaGlkIjoiODc0MDM1MDI5ODkyIiwiZG5tIjoiR29sZGVuIiwiYWxuIjoiNDkzMTg0MzQxNjYiLCJnaWQiOiI1NTctMTc2LTE2MDI4MTkzNzQ5NzAiLCJmbm0iOiJHb2xkZW4iLCJlY2MiOiIiLCJsbm0iOiJHYXRlIiwianByIjoiIiwidXVpZCI6IjYyZGU5ZWMyLWFlNGUtNGM3My04OTRkLWU1ZDIxZmMyNDJhYSIsImJhbiI6InNhZmV3YXkiLCJzdHIiOiI0NjAxIiwicGhuIjoiMzkzOTM5OTk5OSIsImJpZCI6IiJ9.GwkSS8jtEW5FlOc8rz9NRWj8K2IL9Ha_r-sqWzW7suy7EmoQVLjOMpmtjnh-dtem6nAK8aOD4e_RCWJKfIp9myBTmMuNeZHzzbS9xkTh-MGcz-_oRHaGaVCKCHs6846m-j_bodvsx6XGGAFxeNYhrEbF64nrXfW108UgEZP0Hq6rkk3e4LJvJ7UMbxJ-6dxbaV3-Di1y2d5slaNPEgJWjUpj6cW1n2kGcB6Q-Vf4qbKE9fsuqCKj558y6SNiKfOuJEbxWnjujBwkUS5dSEBWfaUNR70KtAxJ91ktSCw5zUrkxSnfX5AfSwnu7I64Y1Wy5nGFR1aZvEihG0tb1msPRg");

        headers.put("User-Agent", "iphone");

        headers.put("X-SWY_API_KEY", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("x-swy-date", "Wed, 28 Oct 2020 18:10:11");

        headers.put("CLIENT_APP_VERSION", "8.5.0");

        headers.put("Accept-Language", "en-us");

        headers.put("CLIENT_ID", " ");

        headers.put("ADRUM", "isAjax:true");

        headers.put("Accept", "application/vnd.safeway.v1+json");

        headers.put("Content-Type", "application/vnd.safeway.v1+json;charset=UTF-8");

        headers.put("x-swy-client-id", "safeway");

        headers.put("Ocp-Apim-Subscription-Key", "mod8c6d7783b604f618dd446e7c39c7c08");


        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if(response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get Preferred Store Successfull");
            }

        }
        catch(Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get Preferred Store Failed with Exception :: " + e.toString());
        }

        return result;
    }

    public Result getUCAProfile() {

        Result result = new Result();

        HttpRequest request = new HttpRequest();

        String url = this.hostUrl + "abs/acceptancepub/cnc/ucaservice/api/uca/customers/557-022-1615802578200/profile?full=y";

        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();

        headers.put("Content-Type", "application/vnd.safeway.v2+json");

        headers.put("accept", "application/vnd.safeway.v2+json");

        headers.put("x-app_version", "Wed, 28 Oct 2020 18:10:11");

        headers.put("Authorization", "Bearer " + CommonCache.tokenCache.get("accessToken"));

        headers.put("appversion", "10.3.0");

        headers.put("swy_api_key", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("x-swy-client-name", "mobile-ios-shop");

        headers.put("Accept-Language", "en-us");

        headers.put("cache-control", "no-cache");

        headers.put("platform", "ios");

        headers.put("banner", "safeway");

        headers.put("x-swy-correlation-id", "dc1ddfce-39ed-11e8-b467-0ed5f89f718b");

        headers.put("User-Agent", "iphone");

        headers.put("Ocp-Apim-Subscription-Key", "d8c6d7783b604f618dd446e7c39c7c08");

        headers.put("user-agent", "SafewayDelivery/1 CFNetwork/1197 Darwin/19.6.0");

        headers.put("CLIENT_APP_VERSION", "8.5.0");

        headers.put("x-swy-banner", "safeway");

        headers.put("x-swy-date", "Thu, 15 Oct 2020 20:39:57 -0700");

        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if(response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get UCA Profile Successfull");
            }

        }
        catch(Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get UCA Profile Failed with Exception :: " + e.toString());
        }

        return result;
    }

    public Result patchCommunicationPreferences() {

        Result result = new Result();

        HttpRequest request = new HttpRequest();

        String url = this.hostUrl + "/abs/acceptancepub/cnc/ucaservice/api/uca/customers/557-176-1602819374970/preferences";

        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();

        headers.put("x-swy-correlation-id", "9F6CFD99-0D19-4E19-A05A-D8578210E83E");

        headers.put("X-SWY_VERSION", "1.5");

        headers.put("Cookie", "___utmvaDcuvRYyB=aFq; incap_ses_124_1778155=2y5Tfm8dUkT0yf35pom4AZnImV8AAAAAG6HPXDpqXaXmg7rKEkqlFw==; nlbi_1778155=BwSSMtDnMxPMJv8MAZv1QQAAAAC6Fr2GsYPDHIoW1Rr3wckv; visid_incap_1778155=ccsetMmaS26rcHXelw66IovImV8AAAAAQUIPAAAAAACjOGS8aLqQFgZ0nBemb0rE; ___utmvbDcuvRYyB=qZI    XQHOHala: GtY; ___utmvmDcuvRYyB=NjjPRuFOAsv; s_vi=[CS]v1|2FCCE43E8515F604-4000062662EFF01A[CE]; _ga=GA1.2.332199180.1603913841; _gid=GA1.2.935240331.1603913841; ls_c=0; ls_e=0; s_fid=2FEAD0D8C72179D3-0E3CF45AC75E2D50; s_la=Wed%20Oct%2028%202020%2012%3A37%3A32%20GMT-0700%20%28PDT%29; s_nr=1603913852402-New; _gcl_au=1.1.247824770.1603913839; _vwo=ts~nlMp28p(MR6)l~4%7C(2sm)u~D2615CBD4AB2F72C79B1FC5225A8C80B5(1p78)m~3%241603908410%3A47.41471146%3A%3A(2cE)k~*(MR6)n~5426%3A3(8; _vwo_sn=5426%3A3; _vis_opt_s=4%7C; _vwo_ds=3%241603908410%3A47.41471146%3A%3A; _vwo_uuid=D2615CBD4AB2F72C79B1FC5225A8C80B5; _vwo_uuid_v2=D6AEE227EB088E9FAAA7DFBFA63CBF27B|033cd1aaec3fb8b7113cb5e340fdeb6e; _gat_UA-172784514-1=1; _gat_gtag_UA_59249278_12=1; _gat_gtag_UA_62530145_7=1");

        headers.put("User-Agent", "iphone");

        headers.put("X-SWY_API_KEY", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("x-swy-date", "Wed, 28 Oct 2020 18:10:11");

        headers.put("ADRUM_1", "isMobile:true");

        headers.put("Date", "Wed, 28 Oct 2020 19:38:15");

        headers.put("CLIENT_APP_VERSION", "8.5.0");

        headers.put("Accept-Language", "en-us");

        headers.put("CLIENT_ID", " ");

        headers.put("ADRUM", "isAjax:true");

        headers.put("Accept", "application/vnd.safeway.v1.merge-patch+json");

        headers.put("Content-Type", "application/vnd.safeway.v1.merge-patch+json");

        headers.put("x-swy-client-id", "mobile-ios-portal");

        headers.put("x-swy_banner", "safeway");

        headers.put("Ocp-Apim-Subscription-Key", "safeway");


        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.patch(request);

            if(response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("patch Communication Preferences Successfull");
            }

        }
        catch(Exception e) {

            result.setStatus(false);

            result.setStatusMsg("patch Communication Preferences Failed with Exception :: " + e.toString());
        }

        return result;
    }

    public Result patchUpdateCategoryPreference() {

        Result result = new Result();

        HttpRequest request = new HttpRequest();

        String url = this.hostUrl + "/abs/acceptancepub/cnc/ucaservice/api/uca/customers/557-176-1602819374970/preferences";

        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();


        headers.put("x-swy-correlation-id", "9F6CFD99-0D19-4E19-A05A-D8578210E83E");

        headers.put("X-SWY_VERSION", "1.5");

        headers.put("Cookie", "___utmvaDcuvRYyB=DMx; incap_ses_124_1778155=VTFsJmTLV3aIERX6pom4AfPvmV8AAAAAe9f4yWhtzpjELztS0Yqa5w==; nlbi_1778155=UKdnOnDVihZ+jt4LAZv1QQAAAABVRYvU7dUgqQR2rgxDp9WD; visid_incap_1778155=PCa8nlb6QQuKokFf+IR4N/PvmV8AAAAAQUIPAAAAAAAXgcXBcTDvPINWqjKd8FOC; ___utmvbDcuvRYyB=lZo    XaPOKalT: stq; ___utmvmDcuvRYyB=MJMfRetHLTL; _gcl_au=1.1.208580040.1603923943; _vis_opt_s=7%7C; _vwo=ts~nlMp28p(MRh)l~7%7C(2sx)u~D2615CBD4AB2F72C79B1FC5225A8C80B5(1p78)m~3%241603908410%3A47.41471146%3A%3A(2cE)k~*(MRh)n~15532%3A3(k; _vwo_ds=3%241603908410%3A47.41471146%3A%3A; _vwo_sn=15532%3A3; _vwo_uuid=D2615CBD4AB2F72C79B1FC5225A8C80B5; _vwo_uuid_v2=D4C1375CFE2F7AB4D1E89323D9B49BB5E|73c0893146e66898d66f0aa8fe2b2d99");

        headers.put("User-Agent", "iphone");

        headers.put("X-SWY_API_KEY", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("x-swy-date", "Wed, 28 Oct 2020 18:10:11");

        headers.put("ADRUM_1", "isMobile:true");

        headers.put("Date", "Wed, 28 Oct 2020 22:26:00");

        headers.put("CLIENT_APP_VERSION", "8.5.0");

        headers.put("Authorization", "Bearer " + CommonCache.tokenCache.get("accessToken"));

        headers.put("Accept-Language", "en-us");

        headers.put("CLIENT_ID", " ");

        headers.put("ADRUM", "isAjax:true");

        headers.put("Accept", "application/vnd.safeway.v1.merge-patch+json");

        headers.put("Content-Type", "application/vnd.safeway.v1.merge-patch+json");

        headers.put("x-swy-client-id", "mobile-ios-portal");

        headers.put("x-swy_banner", "safeway");

        headers.put("Ocp-Apim-Subscription-Key", "safeway");


        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.patch(request);

            if(response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("patch Update Category Preference Successfull");
            }

        }
        catch(Exception e) {

            result.setStatus(false);

            result.setStatusMsg("patch Update Category Preference Failed with Exception :: " + e.toString());
        }

        return result;
    }

}
