package com.automation.rest.cart.model;

import java.util.List;
import java.util.Map;

public class GetCartItemsResponse {
    private String _id;
    private int cartId;
    private int storeId;
    private String status;
    private String cartSource;
    private String serviceType;
    private String customerId;
    private int orderId;
    private String createDate;
    private String updateDate;
    private Summary summary;
    private List<Map<String,Object>> cartItemsList;
    private boolean isMFC;
    private boolean isWYSIWYGEnabled;
    private boolean isRolloutWYSIWYGEnabled;
    private boolean isItemAvailablityEnabled;
    private boolean isPricingDown;
    private boolean isSubstitutions2Enabled;
    private boolean isMTOOrder;
    private boolean isSNAP2Eligible;
    private boolean isCallToUCASuccess;
    private boolean isSnapUser;
    private boolean liteCall;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCartSource() {
        return cartSource;
    }

    public void setCartSource(String cartSource) {
        this.cartSource = cartSource;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public List<Map<String,Object>> getCartItemsList() {
        return cartItemsList;
    }

    public void setCartItemsList(List<Map<String,Object>> cartItemsList) {
        this.cartItemsList = cartItemsList;
    }

    public boolean isMFC() {
        return isMFC;
    }

    public void setMFC(boolean MFC) {
        isMFC = MFC;
    }

    public boolean isWYSIWYGEnabled() {
        return isWYSIWYGEnabled;
    }

    public void setWYSIWYGEnabled(boolean WYSIWYGEnabled) {
        isWYSIWYGEnabled = WYSIWYGEnabled;
    }

    public boolean isRolloutWYSIWYGEnabled() {
        return isRolloutWYSIWYGEnabled;
    }

    public void setRolloutWYSIWYGEnabled(boolean rolloutWYSIWYGEnabled) {
        isRolloutWYSIWYGEnabled = rolloutWYSIWYGEnabled;
    }

    public boolean isItemAvailablityEnabled() {
        return isItemAvailablityEnabled;
    }

    public void setItemAvailablityEnabled(boolean itemAvailablityEnabled) {
        isItemAvailablityEnabled = itemAvailablityEnabled;
    }

    public boolean isPricingDown() {
        return isPricingDown;
    }

    public void setPricingDown(boolean pricingDown) {
        isPricingDown = pricingDown;
    }

    public boolean isSubstitutions2Enabled() {
        return isSubstitutions2Enabled;
    }

    public void setSubstitutions2Enabled(boolean substitutions2Enabled) {
        isSubstitutions2Enabled = substitutions2Enabled;
    }

    public boolean isMTOOrder() {
        return isMTOOrder;
    }

    public void setMTOOrder(boolean MTOOrder) {
        isMTOOrder = MTOOrder;
    }

    public boolean isSNAP2Eligible() {
        return isSNAP2Eligible;
    }

    public void setSNAP2Eligible(boolean SNAP2Eligible) {
        isSNAP2Eligible = SNAP2Eligible;
    }

    public boolean isCallToUCASuccess() {
        return isCallToUCASuccess;
    }

    public void setCallToUCASuccess(boolean callToUCASuccess) {
        isCallToUCASuccess = callToUCASuccess;
    }

    public boolean isSnapUser() {
        return isSnapUser;
    }

    public void setSnapUser(boolean snapUser) {
        isSnapUser = snapUser;
    }

    public boolean isLiteCall() {
        return liteCall;
    }

    public void setLiteCall(boolean liteCall) {
        this.liteCall = liteCall;
    }

    @Override
    public String toString() {
        return "GetCartItemsResponse{" +
                "_id='" + _id + '\'' +
                ", cartId=" + cartId +
                ", storeId=" + storeId +
                ", status='" + status + '\'' +
                ", cartSource='" + cartSource + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", customerId='" + customerId + '\'' +
                ", orderId=" + orderId +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", summary=" + summary +
                ", cartItemsList=" + cartItemsList +
                ", isMFC=" + isMFC +
                ", isWYSIWYGEnabled=" + isWYSIWYGEnabled +
                ", isRolloutWYSIWYGEnabled=" + isRolloutWYSIWYGEnabled +
                ", isItemAvailablityEnabled=" + isItemAvailablityEnabled +
                ", isPricingDown=" + isPricingDown +
                ", isSubstitutions2Enabled=" + isSubstitutions2Enabled +
                ", isMTOOrder=" + isMTOOrder +
                ", isSNAP2Eligible=" + isSNAP2Eligible +
                ", isCallToUCASuccess=" + isCallToUCASuccess +
                ", isSnapUser=" + isSnapUser +
                ", liteCall=" + liteCall +
                '}';
    }
}
