package com.automation.pageElements.Analytics_PageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class StepperQtyPageElements {

    //home tab
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"HOME\"]")
    @AndroidFindBy(id = "homeContainerFragment")
    //@AndroidFindBy(id = "bb_menu_home")
    public MobileElement homeTab;

   // @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name=\"btnNext-Welcome tool tip\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnNext-Pick up tool tip\"]")
    @AndroidFindBy(xpath = "//*[@text=\'Next\']")


    public MobileElement ClickNextButton;

    @iOSXCUITFindBy(accessibility="Don’t Allow")
    public MobileElement NoteficationAllow;


   @iOSXCUITFindBy(xpath= "//XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")
   // @iOSXCUITFindBy(accessibility = "btnSearchBarViewButton")
    @AndroidFindBy(xpath = "//*[contains(@text,'Search')]")
    public MobileElement searchProduct;

 //click Search in Home page
 @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")
 @AndroidFindBy(id = "sv_global")
 public MobileElement clickSearch;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Search for Products\"]")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search for Products\"]")
    public MobileElement searchProductEnter;

    @iOSXCUITFindBy(xpath ="//XCUIElementTypeTable/XCUIElementTypeCell[1]")
    @AndroidFindBy(id = "txt")
    public MobileElement autosuggestion;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"closeGray\"]")
    public MobileElement closeGray;

    //close deals toggle
    @iOSXCUITFindBy(xpath = "//*[@label=\"close\"]")
    @AndroidFindBy(id = "//*[@text=\"close\"]")
    public MobileElement closeToggle;

    @iOSXCUITFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"lblDescription\"]")
   // @AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Granny Smith Large Apple\"]")
    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Granny Smith Large Apple\"]")
    public MobileElement selectProduct;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Add to Cart\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"add\"]")
    public MobileElement Addtocart;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Increment quantity\"]")
    @AndroidFindBy(id = "btnPlus")
    public  MobileElement addQuantity;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Decrement quantity\"]")
    @AndroidFindBy(id = "btnMinus")
    public  MobileElement deleteQuantity;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name BEGINSWITH 'Remove'")
    @AndroidFindBy(id = "tvRemove")
    public MobileElement removeIcon;


    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_cart_count') or contains(@resource-id,'tvTotalItemCount')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Cart'")
    public MobileElement myCartCount;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Allow\"]")
    @AndroidFindBy(xpath = "//*[@text=\"CONTINUE\"]")
    public MobileElement ClickCacheText;

    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
    @iOSXCUITFindBy(accessibility = "Continue")
// @AndroidFindBy(xpath = "//*[@text=\"CONTINUE\"]")
    public MobileElement ClickCacheTextMA;

    @iOSXCUITFindBy(xpath ="//XCUIElementTypeCell[2]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
   @AndroidFindBy(xpath= "//android.widget.FrameLayout[1]/android.widget.Button[1]")
   // @AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.Button[1]")
//    @AndroidFindBy(xpath= "//*[@content-desc=\"Blueberries Prepackaged - 6 Oz.\" or @id=\"itemParentLayout\"]")
    public MobileElement firstItemFrame;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Add to Cart\"]")
    @AndroidFindBy(id = "btnPlusView")
//    @AndroidFindBy(id="//*[contains(@resource-id,\"btn_checkout_pay\")]")
    public MobileElement addButton;

    // one product in cart
    @iOSXCUITFindBy(xpath = "//*[@label=\"Quantity\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tvQuantity')]")
    public MobileElement oneincart;

       // one product in cart
    @iOSXCUITFindBy(xpath = "//*[@label=\"Update\"]")
    public MobileElement updateqty;

    //plus Sign at cart
    @iOSXCUITFindBy(xpath = "//*[@label=\"Increment quantity\"]")
    @AndroidFindBy(id = "btnPlus")
    public MobileElement plusSign;

    @AndroidFindBy(id = "txt")
    @iOSXCUITFindBy(id = "lblPopularSearchItem")
   // public List<MobileElement> currentlyTrendingProducts;
    public MobileElement currentlyTrendingProduct;


    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Cancel\"]")
    public MobileElement searchCancel;

   // @AndroidFindBy(xpath = "//*[@text='Currently Trending']//parent::android.widget.LinearLayout//following-sibling::android.widget.LinearLayout")
    @iOSXCUITFindBy(id = "lblRecentSearchItem")
    @AndroidFindBy(xpath ="//*[@text='Recently Searched']//parent::android.widget.LinearLayout//following-sibling::android.widget.LinearLayout")
    //XCUIElementTypeCell[@name="lblRecentSearchItem"]/XCUIElementTypeOther[1]
    public MobileElement recentlySearchedProduct;

    //android back arrow
    @AndroidFindBy(id = "imageBack")
    //@AndroidFindBy(id = "imageBack")
    ////android.widget.ImageView[@content-desc="Back / Navigation Up"]
    public MobileElement androidBackArrow;

}
