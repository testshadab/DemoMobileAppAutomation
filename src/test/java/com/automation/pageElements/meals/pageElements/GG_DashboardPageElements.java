package com.automation.pageElements.meals.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;

public class GG_DashboardPageElements {
 //test ui
    @AndroidFindBy(id = "btn_tooltip")
    @iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeButton' AND label == 'Next' AND visible==1")
    public MobileElement nextButtonTutorial;

    @AndroidFindBy(xpath  = "//android.widget.Button[@text=\"CONTINUE\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Continue\"")
    public MobileElement cachingContinueBtn;

    @AndroidFindBy(id = "tv_salutation_wish")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'lblGreetingsTitle')]")
    public MobileElement greetingInfo;

    @AndroidFindBy(xpath = "//*[contains(@text,'Dismiss')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Dismiss')]")
    public MobileElement dismiss;

    @AndroidFindBy(className = "android.widget.ProgressBar")
    @iOSXCUITFindBy(accessibility = "In progress")
    public MobileElement loadingSpinner;

    @AndroidFindBy(id = "tv_deal_desc")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalDescritionLabel'")
    public MobileElement dealDescription;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_deal_desc') or contains(@resource-id,'tv_redeemed_reward_desc')]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalDescritionLabel'")
    public List<MobileElement> dealDescriptionList;

    @AndroidFindBy(id = "tv_deal_expiry")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalExpiryLabel'")
    public MobileElement dealExpiry;

    @AndroidFindBy(id = "tv_deal_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalNameLabel'")
    public MobileElement dealName;

    @AndroidFindBy(id = "tv_deal_price")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalPriceLabel'")
    public MobileElement dealPrice;

    @AndroidFindBy(id = "tv_salutation_header")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Rise. Shine. Save.'")
    public MobileElement personalisedSectionTitle;

    @AndroidFindBy(id = "tv_dashboard_store_name")
    @iOSXCUITFindBy(accessibility = "btnStorePickerTitle")
    public MobileElement storeLocationDetail;

    @AndroidFindBy(id = "PENDING")
    @iOSXCUITFindBy(accessibility = "PENDING")
    public MobileElement loader;

    @AndroidFindBy(id = "tv_rewards")
    @iOSXCUITFindBy(id = "lblRewardsTitle")
    public MobileElement rewardInformation;

   // @AndroidFindBy(id = "homeContainerFragment")
//    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"HOME\")")
//    @AndroidFindBy(uiAutomator = "//*[contains(@text,'HOME')]" )
    @AndroidFindBy(xpath = "//*[contains(@content-desc,'HOME')]")
    @iOSXCUITFindBy(accessibility = "HOME")
    public MobileElement homeTab;

    @AndroidFindBy(xpath = "//*[contains(@text,'LATER')]")
    @iOSXCUITFindBy(accessibility = "Maybe Later")
    public MobileElement updateLater;

    @AndroidFindBy(id = "dealsContainerFragment")
    @iOSXCUITFindBy(id = "DEALS")
    public MobileElement dealsTab;


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Nope! Too busy\")")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Nope! Too busy\"]")
    public MobileElement denySurvey;

    @AndroidFindBy(id = "myItemsContainerFragment")
    @iOSXCUITFindBy(accessibility = "MY ITEMS")
    public MobileElement myItemsTab;

    @AndroidFindBy(xpath = "//*[@text=\"MEMBER\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"MEMBER\"]")
    public MobileElement walletTab;

    @AndroidFindBy(accessibility = "deals")
    @iOSXCUITFindBy(xpath = "//*[@label='DEALS']")
    public MobileElement dealSectionHeader;

    @AndroidFindBy(id = "swipe_refresh_myall_list")
    @iOSXCUITFindBy(id = "Status Loading")
    public MobileElement PullScreenRefresh;

    @AndroidFindBy(id = "searchview_container")
    @iOSXCUITFindBy(xpath = "//*[@name='btnSearchBarViewButton']")
    public MobileElement searchBar;

    @AndroidFindBy(id = "sv_global")
    @iOSXCUITFindBy(accessibility = "btnSearchBarViewButton")
    public MobileElement searchTextField;

    @AndroidFindBy(id = "iv_scan")
    @iOSXCUITFindBy(xpath = "//*[@label='Scan barcode']")
    public MobileElement scanIcon;

    @AndroidFindBy(id = "tv_see_all")
    @iOSXCUITFindBy(xpath = "//*[@name='btnSeeAllButtonTitle']//*[@label='See all']")
    public MobileElement seeAll;

    @AndroidFindBy(id = "iv_user_avatar")
    @iOSXCUITFindBy(id = "User profile")
    public MobileElement profileIcon;

    @AndroidFindBy(accessibility = "BOGO")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'BOGO'")
    public MobileElement bogoTab;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[1]/android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
    public MobileElement bogoMenuItems;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.Button[1]/android.widget.ImageView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]")
    public MobileElement bogoProduct;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.widget.TextView[3]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Buy One Get One Free'")
    public MobileElement bogoText;

    @iOSXCUITFindBy(xpath = "//*[@label='Nope! Too busy'']")
    public MobileElement tooBusy;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"btn_tooltip\")]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Pick up tool tip\"]")
    public MobileElement pickUpNext;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"btn_tooltip\")]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Deals tool tip\"]")
    public MobileElement dealsNext;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"btn_tooltip\")]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Wallet tool tip\"]")
    public MobileElement walletNext;

    @AndroidFindBy(xpath = "//*[@resource-id=\"android:id/button1\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[2]/XCUIElementTypeOther[3]")
    public MobileElement dontAllowPopUp;

    @AndroidFindBy(xpath = "//*[@resource-id=\"android:id/button1\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[2]/XCUIElementTypeOther[3]")
    public List<MobileElement> dontAllowPopUpHandle;

    @AndroidFindBy(accessibility = "sv_global")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value == 'More'")
    public MobileElement moreScreenTitle;

    @AndroidFindBy(id = "et_search")
    @iOSXCUITFindBy(accessibility = "Search products or deals")
    public MobileElement detailSearchField;

    @AndroidFindBy(id = "tv_item")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
    public List<MobileElement> searchKeywordFromResult;

    @AndroidFindBy(id = "tv_item")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
    public MobileElement firstSearchResult;

    @iOSXCUITFindBy(accessibility = "closeGray")
    public MobileElement toggleClose;

    @AndroidFindBy(id = "imageExperience")
    @iOSXCUITFindBy(accessibility = "viewAEMBanner")
    public MobileElement aemBanner;

    @AndroidFindBy(id = "home_aem_banner")
    @iOSXCUITFindBy(accessibility = "viewAEMBanner")
    public List<MobileElement> aemBannerList;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Rewards']")
    @iOSXCUITFindBy(accessibility = "View Rewards")
    public MobileElement otherFeaturesRewards;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Order history']")
    @iOSXCUITFindBy(accessibility = "View Order history")
    public MobileElement otherFeaturesOrderHistory;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='My account']")
    @iOSXCUITFindBy(accessibility = "View My account")
    public MobileElement otherFeaturesMyAccount;

    @AndroidFindBy(xpath = "//*[@text='Account']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Account']")
    public MobileElement accountPageTitle;

    @AndroidFindBy(id = "iv_rewards_giftbox")
    @iOSXCUITFindBy(accessibility = "lblRewardsTitle")
    public MobileElement staticImageRewardInfo;

    @AndroidFindBy(id = "tv_rewards")
    @iOSXCUITFindBy(accessibility = "lblRewardsTitle")
    public MobileElement staticMsgRewardInfo;

    @AndroidFindBy(id = "iv_contactless_pay_img")
    @iOSXCUITFindBy(iOSNsPredicate = "label='Your receipts & contactless pay - Access your digital receipts and set up a payment method to pay contactless in-store.'")
    public MobileElement setupContactlessPayBannerDashboard;

    @AndroidFindBy(id = "txtSubtitle")
    @iOSXCUITFindBy(accessibility = "Link your bank account to the wallet and get ready for checkout.")
    public MobileElement setupContactlessPayScreen;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Browse\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Browse\" and name == \"lblTitle\"")
    public MobileElement browsePageTitleHeader;

    @AndroidFindBy(id = "iv_rewards_giftbox")
    @iOSXCUITFindBy(id = "imgvRewardsGiftBox")
    public MobileElement rewardImage;

    @AndroidFindBy(id = "Close")
    @iOSXCUITFindBy(accessibility = "btnTopNavBarLeft")
    public MobileElement closeOrBackArrow;

    @AndroidFindBy(id = "Close")
    @iOSXCUITFindBy(id = "btnClose")
    public MobileElement closeDrawer;

    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Vaccine Scheduler']/XCUIElementTypeButton")
    public MobileElement aemBannerBack;

    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeButton\" and label == \"Cancel\"")
    public MobileElement cancelButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Order history']")
    @iOSXCUITFindBy(accessibility = "View Order history")
    public MobileElement orderHistoryButton;

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(accessibility = "Back")
    public MobileElement orderHistoryBackButton;

    @AndroidFindBy(accessibility = "BROWSE")
    @iOSXCUITFindBy(accessibility = "BROWSE")
    public MobileElement browseTab;

    @AndroidFindBy(id = "root_tv_shopping_mode")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Delivery') or contains(@name,'Pickup') or contains(@name,'In-')]")
    public MobileElement shoppingModeDownArrow;

    @iOSXCUITFindBy(id = "Don’t Allow")
    public MobileElement dontAllowBtn;


    @iOSXCUITFindBy(id="btnNotificationPermissionsAllow")
    public MobileElement allownotificationsBtn;



    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"DISMISS\")")
    @iOSXCUITFindBy(id = "Dismiss")
    public MobileElement dismissCTA;

    @AndroidFindBy(xpath="//*[@content-desc=\'Close\']")
    public MobileElement closeFeedback;

    @AndroidFindBy(id = "imageCancel")
    @iOSXCUITFindBy(accessibility = "Clear text")
    public MobileElement TextClearButtonOnSearchField;

    @AndroidFindBy(id = "noResultParagraph")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'0 Results Found')]")
    public MobileElement noResultErrorMessage;

    @AndroidFindBy(id = "sign_up")
    @iOSXCUITFindBy(iOSNsPredicate = "name=='btnCardMediumVerticalButton' AND label BEGINSWITH 'Clip'")
    public MobileElement clipButton;

    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    public MobileElement addButton;

    @AndroidFindBy(id = "increaseView")
    public MobileElement plusButton;

    @iOSXCUITFindBy(accessibility = "btnSearchBarViewIcon")
    @AndroidFindBy(id = "iv_search")
    public MobileElement searchIcon;

    @AndroidFindBy(accessibility = "Search")
    @iOSXCUITFindBy(iOSNsPredicate = "label=='Search icon'")
    public MobileElement searchIconInHomePage;

    @AndroidFindBy(id = "iv_cart")
    @iOSXCUITFindBy(accessibility = "btnCartWithBadge")
    public MobileElement cartIcon;

    @AndroidFindBy(id = "popular_text")
    @iOSXCUITFindBy(id = "Currently Trending")
    public MobileElement currentlyTrendingLabel;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Recently Searched\")")
    @iOSXCUITFindBy(id = "Recently Searched")
    public MobileElement recentlySearchedLabel;

    @AndroidFindBy(id = "txt")
    @iOSXCUITFindBy(id = "lblPopularSearchItem")
    public List<MobileElement> currentlyTrendingProducts;

    @AndroidFindBy(xpath = "//*[@text='Currently Trending']//parent::android.widget.LinearLayout//following-sibling::android.widget.LinearLayout")
    @iOSXCUITFindBy(id = "lblRecentSearchItem")
    public List<MobileElement> recentlySearchedProducts;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'banner')")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Banner') and @visible='true']")
    public MobileElement bannerAd;

    @AndroidFindBy(id = "bottom_home_navigation")
    @iOSXCUITFindBy(accessibility = "HOME")
    public MobileElement bottomNavigationBar;

    @AndroidFindBy(id = "btn_rewards")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'rewards'")
    public MobileElement rewardModule;

    @AndroidFindBy(id = "PENDING")
    @iOSXCUITFindBy(iOSNsPredicate = "name=='lblOrderStatus' AND visible==1")
    public MobileElement orderStatus;

    @AndroidFindBy(id = "iv_special_event_banner_img")
    @iOSXCUITFindBy(accessibility = "imgvMonopolyBannerImage")
    public MobileElement monopolyBanner;

    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(iOSNsPredicate = "name=='btnTopNavBarLeft' AND type=='XCUIElementTypeButton'")
    public MobileElement backToDashboardButton;

    @AndroidFindBy(id = "webview_tv_title")
    @iOSXCUITFindBy(accessibility = "lblTopNavBarTitle")
    public MobileElement shopPlayWinTitle;

    @AndroidFindBy(id = "btn_tooltip")
    @iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeButton' AND label == 'Next' AND visible==1")
    public MobileElement nextButtonOfTutorialScreen;

    @AndroidFindBy(id = "tv_tooltip_message")
    @iOSXCUITFindBy(accessibility = "lblToolTipDescription-Pick up tool tip")
    public MobileElement shoppingMethodTutorialMsg;

    @AndroidFindBy(accessibility = "Close")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement cancelButtonOnFeedBackForm;

    @AndroidFindBy(xpath = "//*[@text='Tell Us How We Did' or @text='Feedback Wanted']")
    @iOSXCUITFindBy( iOSNsPredicate= "label BEGINSWITH 'Tell Us' OR label ==  'Feedback Wanted'")
    public MobileElement feedBackForm;

    @AndroidFindBy(id = "progress_indicator")
    @iOSXCUITFindBy(accessibility = "In progress")
    public MobileElement loadingSpinnerMonopoly;

    @AndroidFindBy(accessibility = "Search Button")
    @iOSXCUITFindBy(iOSNsPredicate = "label=='Search'")
    public MobileElement searchIconOnProductViewAllSection;

    @AndroidFindBy(id = "tv_tooltip_message")
    @iOSXCUITFindBy(accessibility = "lblToolTipDescription-Welcome tool tip")
    public MobileElement dealsTutorialMsg;

    @AndroidFindBy(id = "tv_tooltip_message")
    @iOSXCUITFindBy(accessibility = "lblToolTipDescription-Welcome tool tip")
    public MobileElement welcomeDealsTutorialMsg;

    @AndroidFindBy(id = "tv_tooltip_message")
    @iOSXCUITFindBy(accessibility = "lblToolTipDescription-Browse tool tip")
    public MobileElement homeBrowseTutorialMsg;

    @AndroidFindBy(id = "tv_tooltip_message")
    @iOSXCUITFindBy(accessibility = "lblToolTipDescription-Wallet tool tip")
    public MobileElement walletTutorialMsg;

    @AndroidFindBy(xpath = "//*[contains(@text,'Love') or contains(@text,'love')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Love' OR label CONTAINS 'love'")
    public MobileElement loveAppPopupLabel;

    @AndroidFindBy(xpath = "//*[contains(@text,'YES')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Yes'")
    public MobileElement loveAppPopupYesBtn;

    @AndroidFindBy(accessibility = "deals")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Deals' AND visible==1")
    public MobileElement dealsTitleHeader;

    @AndroidFindBy(id = "buttonLogin")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Sign In\" AND name == \"Sign In\" AND type == \"XCUIElementTypeButton\" and visible==1")
    public MobileElement signInButton;

    @AndroidFindBy(accessibility = "Sign Out button")
    @iOSXCUITFindBy(accessibility = "Sign Out")
    public MobileElement signOutButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name =='Zip Code'")
    @AndroidFindBy(id = "edit_text")
    //@CacheLookup
    public MobileElement zipCodeEditText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(id = "btn_next")
    public MobileElement registerZipCodeNext;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH 'Delivery'")
    @AndroidFindBy(id = "delivery_zipcode")
    public MobileElement deliverToZipButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Start shopping\"]")
    @AndroidFindBy(id = "start_shopping")
    public MobileElement startShoppingButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    @iOSXCUITFindBy(accessibility = "OK")
    public MobileElement confirmSignOutOkButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Next'")
    @AndroidFindBy(xpath = "(//*[@text='Next'])")
    public MobileElement Delivery_Next;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'User profile'")
    @AndroidFindBy(id = "iv_user_avatar")
    public MobileElement UMA_Home;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Allow'")
    public MobileElement Allow;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement Continue;

    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    @AndroidFindBy(id = "tv_salutation_header")
    public MobileElement buyItAgainModule;

    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    @AndroidFindBy(id = "itemParentLayout")
    public MobileElement buyItAgainCards;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Browse categories'")
    @AndroidFindBy(id = "linearLayout")
    public MobileElement browseCategoriesCards;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeImage' AND name == 'imgvAisleImage'")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Browse categories']")
    public MobileElement browseCategoriesModule;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblName'")
    @AndroidFindBy(id = "text_aisle_name")
    public MobileElement browseCategoriesCardText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblName'")
    @AndroidFindBy(id = "text_aisle_name")
    public List<MobileElement> browseCategoriesCardsList;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Browse deals'")
    @AndroidFindBy(id = "linearLayout")
    public MobileElement browseDealsCards;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblName'")
    @AndroidFindBy(id = "text_aisle_name")
    public MobileElement browseDealsCardText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblName'")
    @AndroidFindBy(id = "text_aisle_name")
    public List<MobileElement> browseDealsCardsList;

    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    @AndroidFindBy(id = "cl_large_card")
    public MobileElement weeklyCouponModule;

    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    @AndroidFindBy(id = "cl_carousel_view")
    public MobileElement aemModule;

    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    @AndroidFindBy(id = "itemParentLayout")
    public MobileElement aemCard;

    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    @AndroidFindBy(id = "addButton")
    public MobileElement aemAddButton;

    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    @AndroidFindBy(id = "tv_dashboard_help_title")
    public MobileElement weCanHelpTitle;

    @iOSXCUITFindBy(accessibility = "btnSeeAllButtonTitle-Browse categories")
    @AndroidFindBy(accessibility = "Browse categories See all")
    public MobileElement seeAllBtnBrowseCategories;

    @iOSXCUITFindBy(accessibility = "btnSeeAllButtonTitle-Browse categories")
    @AndroidFindBy(accessibility = "Browse deals See all")
    public MobileElement seeAllBtnBrowseDeals;

    @iOSXCUITFindBy(accessibility = "browseDeals-1")
    @AndroidFindBy(id = "tvSeeAllDeals")
    public MobileElement seeAllDealsBanner;

    @AndroidFindBy(id = "deals_cardview")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalPriceLabel'")
    public List<MobileElement> dealCardContainer;

    @AndroidFindBy(id = "tv_see_all")
    @iOSXCUITFindBy(accessibility = "btnSeeAll")
    public MobileElement seeAllButtonInDealCard;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Clip your favorites\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Clip your favorites'")
    public MobileElement clipYourFavouriteTitle;

    @AndroidFindBy(accessibility = "Clip your favorites See all")
    @iOSXCUITFindBy(accessibility = "btnSeeAllButtonTitle-Clip your favorites")
    public MobileElement seeAllLinkClipYourFavourite;

    @AndroidFindBy(id = "bottom_sheet_sub_title")
    @iOSXCUITFindBy(accessibility = "lblDealsCount")
    public MobileElement dealsCount;

    @AndroidFindBy(id = "tv_deal_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalNameLabel'")
    public List<MobileElement> dealsName;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'My rewards')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'My rewards'")
    public MobileElement myRewardsDrawer;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Clipped deals')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Clipped deals'")
    public MobileElement clippedDealsDrawer;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Pharmacy')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'View Pharmacy' AND visible==1")
    public MobileElement pharmacyDrawer;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Meals')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'View Meals' AND visible==1")
    public MobileElement mealsDrawer;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Weekly ad')]")
    @iOSXCUITFindBy(accessibility = "View Weekly ad")
    public MobileElement weeklyAdDrawer;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'btn_rewards') and @text='My rewards']//following-sibling::*")
    @iOSXCUITFindBy(iOSNsPredicate = "label ENDSWITH 'My rewards'")
    public MobileElement myRewardModuleCount;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'btn_rewards') and @text='Clipped deals']//following-sibling::*")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Clipped deals'")
    public MobileElement clippedModuleCount;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'progress_bar')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Status Loading'")
    public MobileElement loadingSpinnerOTP;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Browse deals']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeImage' AND name == 'imgvAisleImage'")
    public MobileElement  browseDealsModule;

    @iOSXCUITFindBy(accessibility = "btnNotificationPermissionsAllow")
    public MobileElement allowNotificationsButton;

    @iOSXCUITFindBy(accessibility = "Allow")
    public MobileElement allowNotificationPermissionPopup;

    @AndroidFindBy(accessibility = "MY LIST")
    @iOSXCUITFindBy(accessibility = "MY LIST")
    public MobileElement myListTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"OK\")")
    @iOSXCUITFindBy(xpath = "//*[@label='OK' or @label='Ok']")
    public MobileElement okBtn;


    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"oyalty_qr_code\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Loyalty QR code\"]")
    public MobileElement memberScanCode;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_welcome_card_title\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Items you may like\"]")
    public MobileElement forYou;


    @AndroidFindBy(id = "deals_cardview")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[@name=\"collectionDealsCollectionView\"]/XCUIElementTypeCell")
    public List<MobileElement> dealsCard;
}
