package gt.org.page;

import gt.org.utils.GeneralMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class ExplorePage extends BasePage{
    public ExplorePage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.storellet:id/view_main_navibar_v4_member")
    WebElement explore;
    public void clicksexplore(){
        explore.click();
    }

    @AndroidFindBy(id = "com.storellet:id/fragment_membership_tab_all_title_tv")
    WebElement explorePage;
    public boolean explorePageDisplayed(){
        return explorePage.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_section_header_header_tv\" and @text=\"最新上架\"]")
    WebElement newArrivals;
    public boolean newArrivalsDisplayed(){
        return newArrivals.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_section_header_header_tv\" and @text=\"全部餐廳\"]")
    WebElement allRestaurants;
    public boolean allRestaurantsDisplayed(){
        return allRestaurants.isDisplayed();
    }

    @AndroidFindBy(id = "com.storellet:id/item_recycler_view_retry_rv")
    WebElement newArrivalsRestaurant;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_large_image_landscape_header\" and @text=\"The Wall Street Bar & Lounge\"]")
    WebElement wallStreetBar;
    public void wallStreetBarDisplayed(){
        while (true){
            try {
                wallStreetBar.isDisplayed();
                break;
            }catch (Exception e){
                waitElement(newArrivalsRestaurant,2);
                GeneralMethods.scrollingElement("left",newArrivalsRestaurant,200);
            }
        }
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_large_image_landscape_header\" and @text=\"PizzaExpress\"]")
    WebElement pizzaExpress;
    public void pizzaExpressDisplayed(){
        while (true){
            try {
                pizzaExpress.isDisplayed();
                break;
            }catch (Exception e){
                waitElement(newArrivalsRestaurant,2);
                GeneralMethods.scrollingElement("left",newArrivalsRestaurant,200);
            }
        }
    }

    public void clicksWallStreetBar(){
        wallStreetBar.click();
    }

    @AndroidFindBy(id = "com.storellet:id/email_verification_title_tv")
    WebElement emailVerification;
    public boolean emailVerificationDisplayed(){

        return emailVerification.isDisplayed();
    }

    @AndroidFindBy(id = "com.storellet:id/item_email_verification_ignore_btn")
    WebElement emailIgnoreButton;
    public void clicksEmailIgnoreButton(){
        try {
            waitElement(emailIgnoreButton,5);
            if (emailIgnoreButton.isDisplayed()){
                emailIgnoreButton.click();
            }
        }catch (Exception e){
            System.out.println("WebElement does not exist");
        }
    }

    @AndroidFindBy(id = "com.storellet:id/item_email_verification_sent_btn")
    WebElement emailSendVerificationButton;
    public void clicksEmailSendVerificationButton(){
        try {
            waitElement(emailSendVerificationButton,5);
            if (emailSendVerificationButton.isDisplayed()){
                emailSendVerificationButton.click();
            }
        }catch (Exception e){
            System.out.println("WebElement does not exist");
        }
    }

    @AndroidFindBy(id = "com.storellet:id/item_email_verification_change_btn")
    WebElement emailChangeVerificationButton;
    public void clicksEmailChangeVerificationButton(){
        try {
            waitElement(emailChangeVerificationButton,5);
            if (emailChangeVerificationButton.isDisplayed()){
                emailChangeVerificationButton.click();
            }
        }catch (Exception e){
            System.out.println("WebElement does not exist");
        }
    }
    @AndroidFindBy(id = "com.storellet:id/email_verification_sent_title_tv")
    WebElement emailSentPromptBox;
    public boolean emailSentPromptBoxDisplayed(){
        waitElement(emailSentPromptBox,20);
        return emailSentPromptBox.isDisplayed();
    }

    @AndroidFindBy(id = "com.storellet:id/item_email_verification_sent_success_btn")
    WebElement doneButton;
    public void clicksDoneButton(){
        doneButton.click();
    }

    @AndroidFindBy(id = "com.storellet:id/email_verification_renew_title_tv")
    WebElement emailChangePage;
    public boolean emailChangePageDisplayed(){
        waitElement(emailChangePage,10);
        return emailChangePage.isDisplayed();
    }

    @AndroidFindAll({@AndroidBy(id = "com.storellet:id/email_verification_renew_email_et"),
            @AndroidBy(className = "android.widget.EditText"),
            @AndroidBy(xpath = "//android.widget.EditText[@resource-id=\"com.storellet:id/email_verification_renew_email_et\"]")
    })
    WebElement emailField;
    public void typeEmailField(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }

    @AndroidFindAll({@AndroidBy(id = "com.storellet:id/item_email_verification_renew_btn"),
            @AndroidBy(className = "android.widget.Button"),
            @AndroidBy(xpath = "//android.widget.Button[@resource-id=\"com.storellet:id/item_email_verification_renew_btn\"]")
    })
    WebElement updateButton;
    public boolean getUpdateButtonStatus(){
        return updateButton.isEnabled();
    }
    public void clicksUpdateButton(){
        updateButton.click();
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_merchant_row_title_tv\" and @text=\"Plato Cafe Bistro\"]")
    WebElement platoCafeBistro;
    public void platoCafeBistroDisplayed(){
        while (true){
            try {
                platoCafeBistro.isDisplayed();
                break;
            }catch (Exception e){
                GeneralMethods.scrolling("down",200);
            }
        }
    }
    public void clicksPlatoCafeBistro(){
        platoCafeBistro.click();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_merchant_row_title_tv\" and @text=\"The Farmhouse Deli 餅店\"]")
    WebElement farmhouseDeli;
    public void farmhouseDeliDisplayed(){
        while (true){
            try {
                farmhouseDeli.isDisplayed();
                break;
            }catch (Exception e){
                GeneralMethods.scrolling("down",200);
            }
        }
    }
    public void clicksFarmhouseDeli(){
        farmhouseDeli.click();
    }

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.storellet:id/item_merchant_row_title_tv\"])[last()]")
    WebElement lastRestaurant;

     @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/item_merchant_row_title_tv\"]")
     List<WebElement> allRestaurantsName;

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/item_merchant_row_right_button"),
            @AndroidBy(xpath = "//android.widget.Button[@resource-id=\"com.storellet:id/item_merchant_row_right_button\"]")
    })
    WebElement joinMemberButton;
    public void joinMemberButtonDisplayed(){
        String last = "";
        while (true){
            try {
                last = lastRestaurant.getText();
                joinMemberButton.isDisplayed();
                break;
            }catch (Exception e){
                GeneralMethods.scrolling("down",200);
                WebElement restaurants = allRestaurantsName.get(allRestaurantsName.size() - 1);
                if (Objects.equals(last, restaurants.getText())){
                    System.out.println("There are no more restaurants to join as members");
                    break;
                }
            }
        }
    }
    public void clicksJoinMemberButton(){
        joinMemberButton.click();
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/member_header_newjoin_tv"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/member_header_newjoin_tv\"]")
    })
    WebElement restaurantJoinMemberButton;

    public boolean restaurantJoinMemberButtonDisplayed(){
        waitElement(restaurantJoinMemberButton,10);
        return restaurantJoinMemberButton.isDisplayed();
    }
    public void clicksRestaurantJoinMemberButton(){
        restaurantJoinMemberButton.click();
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/dialog_error_dialog_title"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/dialog_error_dialog_title\"]")
    })
    WebElement memberContentTitle;
    public boolean memberContentTitleDisplayed(){
        waitElement(memberContentTitle,10);
        return memberContentTitle.isDisplayed();
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/message_dialog_positive_btn"),
            @AndroidBy(xpath = "//android.widget.Button[@resource-id=\"com.storellet:id/message_dialog_positive_btn\"]")
    })
    WebElement agreeButton;
    public boolean getAgreeButton(){
        return agreeButton.isEnabled();
    }
    public void clicksAgreeButton(){
        agreeButton.click();
    }
    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/message_dialog_negative_btn"),
            @AndroidBy(xpath = "//android.widget.Button[@resource-id=\"com.storellet:id/message_dialog_negative_btn\"]")
    })
    WebElement disagreeButton;
    public void clicksDisagreeButton(){
        disagreeButton.click();
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/dialog_error_dialog_scroll_view"),
            @AndroidBy(className = "android.widget.ScrollView"),
            @AndroidBy(xpath = "//android.widget.ScrollView[@resource-id=\"com.storellet:id/dialog_error_dialog_scroll_view\"]")
    })
//    @AndroidFindBy(id = "com.storellet:id/dialog_error_dialog_scroll_view")
    WebElement memberContent;

    public void scrollMemberContent(){
            waitElement(memberContent,2);
        while (!agreeButton.isEnabled()){
                GeneralMethods.scrollingElement("down",memberContent,200);
        }
    }

}
