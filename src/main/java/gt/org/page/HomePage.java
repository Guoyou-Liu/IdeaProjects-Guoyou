package gt.org.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_discover_ranking_list_view_header_tv\" and @text=\"銅鑼灣人氣餐廳推介\"]")
    WebElement causewayBay;
    public boolean causewayBayDisplayed(){
        return causewayBay.isDisplayed();
    }
    public void clicksCausewayBay(){
        causewayBay.click();
    }

    @AndroidFindBy(id = "com.storellet:id/item_content_title_tv")
    WebElement causewayBayRestaurants;
    public boolean causewayBayRestaurantsDisplayed(){
        return causewayBayRestaurants.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_payload_action_row_title_tv\" and @text=\"迷你泡芙伴海鹽焦糖醬\"]")
    WebElement cafe;
    public boolean cafeDisplayed() {
        return cafe.isDisplayed();
    }
    public void clicksCafe(){
        cafe.click();
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_payload_action_row_title_tv\" and @text=\"$25 現金券\"]")
    WebElement patisserieTonyWong;
    public boolean patisserieTonyWongDisplayed(){
        return patisserieTonyWong.isDisplayed();
    }
    public void clicksPatisserieTonyWong(){
        patisserieTonyWong.click();
    }


    @AndroidFindBy(id = "com.storellet:id/merchant_header_name_tv")
    WebElement restaurantTitle;
    public String getRestaurantTitle(){
        waitElement(restaurantTitle,20);
        return restaurantTitle.getText();
    }

    @AndroidFindBy(id = "com.storellet:id/view_achievement_progress_lite_progress_tips_right_tv")
    WebElement membershipRules;
    public void clicksMembershipRules(){
        membershipRules.click();
    }

    @AndroidFindBy(id = "com.storellet:id/dialog_error_dialog_content")
    WebElement membershipRulesContent;
    public boolean membershipRulesContentDisplayed(){
        return membershipRulesContent.isDisplayed();
    }
    @AndroidFindBy(id = "com.storellet:id/dialog_error_dialog_negative_btn")
    WebElement membershipRulesConfirmButton;
    public void clicksMembershipRulesConfirmButton(){
        membershipRulesConfirmButton.click();
    }


    @AndroidFindBy(id = "com.storellet:id/shoplocationlist_toolbar")
    WebElement viewBranchesTitle;
    public boolean viewBranchesTitleDisplayed(){
        waitElement(viewBranchesTitle,20);
        return viewBranchesTitle.isDisplayed();
    }

    @AndroidFindBy(className = "android.widget.ImageButton")
    WebElement viewBranchesBackButton;
    public void clicksViewBranchesBackButton(){
        viewBranchesBackButton.click();
    }

    @AndroidFindBy(id = "com.storellet:id/view_merchant_shoploc_map_title_tv")
    WebElement restaurantTags;
    public String getRestaurantTags(){
        return restaurantTags.getText();
    }

    @AndroidFindBy(accessibility = "我的錢包")
    WebElement myWalletSelection;
    public boolean myWalletSelectionDisplayed(){
        return myWalletSelection.isDisplayed();
    }
    public void clicksMyWalletSelection(){
        myWalletSelection.click();
    }
    public boolean getMyWalletSelectionStatus(){
        return myWalletSelection.isSelected();
    }

    @AndroidFindBy(id = "com.storellet:id/fragment_merchant_section_wallet_coupon_catalog_view")
    WebElement myWalletPage;
    public boolean myWalletPageDisplayed(){
        return myWalletPage.isDisplayed();
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/view_merchant_mywallet_items_title_tv\" and @text=\"優惠券\"]")
    WebElement myWalletCoupons;
    public boolean myWalletCouponsDisplayed(){
        return myWalletCoupons.isDisplayed();
    }

    @AndroidFindBy(accessibility = "概要")
    WebElement summarySelection;
    public boolean summarySelectionDisplayed(){
        return summarySelection.isDisplayed();
    }
    public void clicksSummarySelection(){
        summarySelection.click();
    }
    public boolean getSummarySelectionStatus(){
        return summarySelection.isSelected();
    }

    @AndroidFindBy(accessibility = "可兌換")
    WebElement redeemableSelection;
    public boolean redeemableSelectionDisplayed(){
        return redeemableSelection.isDisplayed();
    }
    public void clicksRedeemableSelection(){
        redeemableSelection.click();
    }
    public boolean getRedeemableSelectionStatus(){
        return redeemableSelection.isSelected();
    }
    @AndroidFindBy(id = "com.storellet:id/fragment_merchant_section_redeemable_redeem_catalog_view")
    WebElement redeemablePage;
    public void redeemablePageDisplayed(){
        redeemablePage.isDisplayed();
    }
        @AndroidFindBy(id = "com.storellet:id/view_merchant_mywallet_items_title_tv")
    WebElement itemsTitle;
    public String getItemsTitle(){
        return itemsTitle.getText();
    }



    @AndroidFindBy(id = "com.storellet:id/member_header_back_iv")
    WebElement backButton;
    public void clicksBackButton(){
        backButton.click();
    }

    @AndroidFindBy(id = "com.storellet:id/fragment_article_detail_close_btn")
    WebElement causewayBayCloseButton;
    public void clicksCausewayBayCloseButton(){
        causewayBayCloseButton.click();
    }



}
