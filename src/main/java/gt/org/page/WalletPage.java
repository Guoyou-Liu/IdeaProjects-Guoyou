package gt.org.page;

import gt.org.utils.GeneralMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.WebElement;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class WalletPage extends BasePage{
    public WalletPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/item_section_header_action_btn"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_section_header_action_btn\"]")
    })
    WebElement showAllButton;
    public void clicksShowAllButton(){
        showAllButton.click();
    }

    @AndroidFindBy(xpath = "(//android.widget.FrameLayout[@resource-id=\"com.storellet:id/item_coupon_view_cardview\"])[1]")
    WebElement redeemableCoupons;
    public void clicksRedeemableCoupons(){
        try {
            waitElement(redeemableCoupons,20);
            if (redeemableCoupons.isDisplayed()){
                redeemableCoupons.click();
            }
        }catch (Exception e){
            System.out.println("WebElement does not exist");
        }
    }
    @AndroidFindBy(xpath = "(//android.widget.FrameLayout[@resource-id=\"com.storellet:id/item_coupon_fullscreen_cardview\"])[1]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout")
    WebElement couponsDetails;
    public boolean couponsDetailsDisplayed(){
        waitElement(couponsDetails,20);
        return couponsDetails.isDisplayed();
    }


    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/item_coupon_fullscreen_redeem_tv"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_coupon_fullscreen_redeem_tv\"]")
    })
    WebElement couponRedemptionButton;
    public void clicksCouponRedemptionButton(){
        couponRedemptionButton.click();
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/dialog_error_dialog_content"),
            @AndroidBy(className = "android.widget.TextView"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/dialog_error_dialog_content\"]")
    })
    WebElement unableToRedeemPromptBox;
    public boolean unableToRedeemPromptBoxDisplayed(){
        return unableToRedeemPromptBox.isDisplayed();
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/dialog_error_dialog_negative_btn"),
            @AndroidBy(className = "android.widget.Button"),
            @AndroidBy(xpath = "//android.widget.Button[@resource-id=\"com.storellet:id/dialog_error_dialog_negative_btn\"]")
    })
    WebElement promptBoxConfirmButton;
    public void clicksPromptBoxConfirmButton(){
        promptBoxConfirmButton.click();
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_large_image_portrait_tv\" and @text=\"SKY BIG GROUP\"]")
    WebElement skyBigGroup;
    public void clicksSkyBigGroup(){
        while (true){
            try {
                skyBigGroup.click();
                break;
            }catch (Exception e){
                GeneralMethods.scrolling("down",200);
            }
        }

    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_large_image_portrait_tv\" and @text=\"亞泰\"]")
    WebElement yaTai;
    public void clicksYaTai(){
        while (true){
            try {
                yaTai.click();
                break;
            }catch (Exception e){
                GeneralMethods.scrolling("down",200);
            }
        }
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_brand_coupon_rv_scroll_title_tv\" and @text=\"牛牛日式火鍋放題\"]")
    WebElement beefHotpot;
    public boolean beefHotpotDisplayed(){
        boolean display;
        while (true){
            try {
                display = beefHotpot.isDisplayed();
                break;
            }catch (Exception e){
                GeneralMethods.scrolling("down",200);
            }
        }
        return display;
    }
    public void clicksBeefHotpot(){
        beefHotpot.click();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_coupon_portrait_body_tv\" and @text=\"迎新：堂食$50現金券(消費滿$500以上)\"]")
    WebElement beefHotpotCoupon;
    public void clicksBeefHotpotCoupon(){
        while (true){
            try {
                beefHotpotCoupon.click();
                break;
            }catch (Exception e){
                GeneralMethods.scrolling("down",200);
            }
        }
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/dialog_coupon_list_fill_screen_dialog_close_iv"),
            @AndroidBy(xpath = "//android.widget.ImageView[@resource-id=\"com.storellet:id/dialog_coupon_list_fill_screen_dialog_close_iv\"]")
    })
    WebElement couponCloseButton;
    public void clicksCouponCloseButton(){
        couponCloseButton.click();
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/item_coupon_fullscreen_title_tv"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_coupon_fullscreen_title_tv\"]")
    })
    WebElement couponTitle;
    public boolean couponTitleDisplayed(){
        waitElement(couponTitle,30);
        return couponTitle.isDisplayed();
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/item_coupon_fullscreen_coupon_expire_tv"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_coupon_fullscreen_coupon_expire_tv\"]")
    })
    WebElement couponValidityPeriod;
    public boolean couponValidityPeriodDisplayed(){
        return couponValidityPeriod.isDisplayed();
    }
    public String getCouponValidityPeriod(){
        return couponValidityPeriod.getText();
    }
    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/item_coupon_view_tips_tv"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_coupon_view_tips_tv\"]")
    })
    WebElement restaurantCouponExpirationDate;
    public boolean restaurantCouponExpirationDateDisplayed(){
        return restaurantCouponExpirationDate.isDisplayed();
    }
    public String getRestaurantCouponExpirationDate(){
        return restaurantCouponExpirationDate.getText();
    }
    public void clicksRestaurantCouponExpirationDate(){
        restaurantCouponExpirationDate.click();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_brand_coupon_rv_scroll_title_tv\" and @text=\"翠華餐廳\"]")
    WebElement tsuiWah;
    public boolean tsuiWahDisplayed(){
       boolean display;
        while (true){
            try {
                display = tsuiWah.isDisplayed();
                break;
            }catch (Exception e){
                GeneralMethods.scrolling("down",200);
            }
        }
        return display;
    }
    public void clicksTsuiWah(){
        tsuiWah.click();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_coupon_portrait_body_tv\" and @text=\"免費熱奶茶一杯 (只限正價)\"]")
    WebElement tsuiWahCoupon;
    public void clicksTsuiWahCoupon(){
        while (true){
            try {
                tsuiWahCoupon.click();
                break;
            }catch (Exception e){
                GeneralMethods.scrolling("down",200);
            }
        }
    }

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.storellet:id/item_large_image_portrait_bg_iv\"])[1]")
    WebElement image;

    public BufferedImage getImage() throws IOException {
        return GeneralMethods.getElementImage(image);
    }
    public void saveImage(BufferedImage image,String imageName) throws IOException {
        GeneralMethods.saveElementImage(image,imageName);
    }
    public boolean imageIsNotEmpty(BufferedImage image) throws IOException {
        return GeneralMethods.viewImageIsNotNull(image);
    }

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.storellet:id/item_large_image_portrait_bg_iv\"])[2]")
    WebElement image2;
    public BufferedImage getImage2() throws IOException {
        return GeneralMethods.getElementImage(image2);
    }


}
