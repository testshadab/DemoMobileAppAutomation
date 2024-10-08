package com.automation.pageElements;


import com.perfectomobile.selenium.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_OrderStatusPageElements {

    @AndroidFindBy(id="cl_order_summary")
  //  @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Your order will be processed soon' AND name == 'lblOrderStatus'")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label CONTAINS 'Pickup for'")
    public MobileElement pickupOrderFirstStatus;

    @AndroidFindBy(xpath = "//*[contains(@text,\"You have until\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label CONTAINS 'You have until ' AND name == 'lblOrderStatusDescription'")
    public MobileElement changeOrderLinkText;

    @AndroidFindBy(xpath = "//*[contains(@text,'Edit Order') or contains(@text,'Orders')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Edit Order'")
    public MobileElement editOrderScreenTitle;

    @AndroidFindBy(id = "btn_view_details")
    @iOSXCUITFindBy(accessibility = "btnViewDetails")
    public MobileElement viewDetailsButton;

    @AndroidFindBy(id = "iv_order_placed")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'imgOrderStatus-0'")
    public MobileElement orderPlacedStatusIcon;

    @AndroidFindBy(id = "iv_order_warehouse")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'imgOrderStatus-1'")
    public MobileElement orderPackedStatusIcon;

    @AndroidFindBy(id = "iv_order_delivery")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'imgOrderStatus-2'")
    public MobileElement orderOnTheWayStatusIcon;

    @AndroidFindBy(id = "iv_order_done")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'imgOrderStatus-3'")
    public MobileElement orderDeliveredStatusIcon;

    @AndroidFindBy(id = "searchview_container")
  //  @iOSXCUITFindBy(accessibility = "lblOrderStatus")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label CONTAINS 'Delivery for'")
    public MobileElement deliveyOrderFirstStatus;

    @AndroidFindBy(id = "tv_order_number")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'lblOrderNumber' and visible==1")
    public MobileElement orderNumber;

    @AndroidFindBy(id = "tv_order_number")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'lblOrderNumber' and visible==1")
    public List<MobileElement> orderNumberList;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Counter Pickup confirmed\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label CONTAINS 'Counter Pickup confirmed' AND name == 'lblOrderStatus'")
    public MobileElement pickupOrderSecondStatus;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Locker Pickup confirmed\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label CONTAINS 'Locker Pickup confirmed' AND name == 'lblOrderStatus'")
    public MobileElement pickupOrderThirdStatus;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Kiosk Pickup confirmed\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label CONTAINS 'Kiosk Pickup confirmed' AND name == 'lblOrderStatus'")
    public MobileElement pickupOrderFourthStatus;
}
