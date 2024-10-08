package com.automation.rest.cart.model;

public class Summary {
    private int itemCount;
    private String totalItemQuantity;
    private Double totalBasePrice;
    private Double totalEstimatedPrice;
    private String estimatedClubCardSavings;
    private String qualifyingDollarValue;
    private String qualifyingDollarValueWYSIWYG;
    private int minCartThresholdValue;
    private boolean hasRestrictedItems;
    private String transactionTotal;
    private String totalCardSavings;

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public String getTotalItemQuantity() {
        return totalItemQuantity;
    }

    public void setTotalItemQuantity(String totalItemQuantity) {
        this.totalItemQuantity = totalItemQuantity;
    }

    public Double getTotalBasePrice() {
        return totalBasePrice;
    }

    public void setTotalBasePrice(Double totalBasePrice) {
        this.totalBasePrice = totalBasePrice;
    }

    public Double getTotalEstimatedPrice() {
        return totalEstimatedPrice;
    }

    public void setTotalEstimatedPrice(Double totalEstimatedPrice) {
        this.totalEstimatedPrice = totalEstimatedPrice;
    }

    public String getEstimatedClubCardSavings() {
        return estimatedClubCardSavings;
    }

    public void setEstimatedClubCardSavings(String estimatedClubCardSavings) {
        this.estimatedClubCardSavings = estimatedClubCardSavings;
    }

    public String getQualifyingDollarValue() {
        return qualifyingDollarValue;
    }

    public void setQualifyingDollarValue(String qualifyingDollarValue) {
        this.qualifyingDollarValue = qualifyingDollarValue;
    }

    public String getQualifyingDollarValueWYSIWYG() {
        return qualifyingDollarValueWYSIWYG;
    }

    public void setQualifyingDollarValueWYSIWYG(String qualifyingDollarValueWYSIWYG) {
        this.qualifyingDollarValueWYSIWYG = qualifyingDollarValueWYSIWYG;
    }

    public int getMinCartThresholdValue() {
        return minCartThresholdValue;
    }

    public void setMinCartThresholdValue(int minCartThresholdValue) {
        this.minCartThresholdValue = minCartThresholdValue;
    }

    public boolean isHasRestrictedItems() {
        return hasRestrictedItems;
    }

    public void setHasRestrictedItems(boolean hasRestrictedItems) {
        this.hasRestrictedItems = hasRestrictedItems;
    }

    public String getTransactionTotal() {
        return transactionTotal;
    }

    public void setTransactionTotal(String transactionTotal) {
        this.transactionTotal = transactionTotal;
    }

    public String getTotalCardSavings() {
        return totalCardSavings;
    }

    public void setTotalCardSavings(String totalCardSavings) {
        this.totalCardSavings = totalCardSavings;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "itemCount=" + itemCount +
                ", totalItemQuantity='" + totalItemQuantity + '\'' +
                ", totalBasePrice='" + totalBasePrice + '\'' +
                ", totalEstimatedPrice='" + totalEstimatedPrice + '\'' +
                ", estimatedClubCardSavings='" + estimatedClubCardSavings + '\'' +
                ", qualifyingDollarValue='" + qualifyingDollarValue + '\'' +
                ", qualifyingDollarValueWYSIWYG='" + qualifyingDollarValueWYSIWYG + '\'' +
                ", minCartThresholdValue=" + minCartThresholdValue +
                ", hasRestrictedItems=" + hasRestrictedItems +
                ", transactionTotal='" + transactionTotal + '\'' +
                ", totalCardSavings='" + totalCardSavings + '\'' +
                '}';
    }
}
