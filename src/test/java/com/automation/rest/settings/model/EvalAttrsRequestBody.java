package com.automation.rest.settings.model;

public class EvalAttrsRequestBody {
    private String appCode;
    private String version;
    private Attributes attributes;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "EvalAttrsRequestBody{" +
                "appCode='" + appCode + '\'' +
                ", version='" + version + '\'' +
                ", attributes=" + attributes +
                '}';
    }

    public class Attributes {
        private String Banner;
        private String AppVersion;
        private String Store;
        private String OSVersion;
        private String ZipCode;
        private String Device;

        public String getBanner() {
            return Banner;
        }

        public void setBanner(String banner) {
            Banner = banner;
        }

        public String getAppVersion() {
            return AppVersion;
        }

        public void setAppVersion(String appVersion) {
            AppVersion = appVersion;
        }

        public String getStored() {
            return Store;
        }

        public void setStoredId(String store) {
            Store = store;
        }

        public String getOSVersion() {
            return OSVersion;
        }

        public void setOSVersion(String OSVersion) {
            this.OSVersion = OSVersion;
        }

        public String getZipCode() {
            return ZipCode;
        }

        public void setZipCode(String zipCode) {
            ZipCode = zipCode;
        }

        public String getDevice() {
            return Device;
        }

        public void setDevice(String device) {
            Device = device;
        }

        @Override
        public String toString() {
            return "Attributes{" +
                    "Banner='" + Banner + '\'' +
                    ", AppVersion='" + AppVersion + '\'' +
                    ", Store='" + Store + '\'' +
                    ", OSVersion='" + OSVersion + '\'' +
                    ", ZipCode='" + ZipCode + '\'' +
                    ", Device='" + Device + '\'' +
                    '}';
        }
    }

}
