package gt.org.page;

import gt.org.utils.GeneralMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }

    @AndroidFindBy(id = "com.storellet:id/fragment_child_discover_feature_toolbar_logo_iv")
    WebElement homeLogo;
    public boolean homeLogoDisplayed(){
        waitElement(homeLogo,10);
        return homeLogo.isDisplayed();
    }


    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/view_main_navibar_v4_me"),
            @AndroidBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.storellet:id/view_main_navibar_v4_me\"]")
    })
    WebElement myAccountButton;
    public void clicksMyAccountButton(){myAccountButton.click();}
    @AndroidFindBy(id = "com.storellet:id/fragment_member_card_title_tv")
    WebElement accountTitle;
    public boolean accountTitleDisplayed(){
        return accountTitle.isDisplayed();
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/view_main_navibar_v4_wallet"),
            @AndroidBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.storellet:id/view_main_navibar_v4_wallet\"]")
    })
    WebElement walletButton;
    public void clicksWalletButton(){
        walletButton.click();
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/fragment_membership_tab_my_title_tv"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/fragment_membership_tab_my_title_tv\"]")
    })
    WebElement myWalletPage;
    public boolean myWalletPageDisplayed(){
        return myWalletPage.isDisplayed();
    }

    @AndroidFindBy(id = "com.storellet:id/redemption_center_btn")
    WebElement redeemButton;
    public String getRedeemText(){
        return redeemButton.getText();
    }

    @AndroidFindBy(id = "com.storellet:id/search_src_text")
    WebElement searchBox;
    public boolean searchBoxDisplayed(){
        return searchBox.isDisplayed();
    }
    public void clicksSearchBox(){
        searchBox.click();
    }
    public void typeSearchBox(String searchContent){
        searchBox.clear();
        searchBox.sendKeys(searchContent);
    }
    public String getSearchBoxContent(){
        return searchBox.getText();
    }

    @AndroidFindBy(id = "com.storellet:id/fragment_child_discover_feature_toolbar_search_iv")
    WebElement searchButton;
    public void clicksSearchButton(){
        searchButton.click();
    }



    @AndroidFindBy(accessibility = "Clear query")
    WebElement searchBoxClearButton;
    public void clicksSearchBoxClearButton(){
        searchBoxClearButton.click();
    }

    @AndroidFindBy(id = "com.storellet:id/item_search_result_header")
    WebElement searchResult;
    public String getSearchResult(){
        return searchResult.getText();
    }
    public void clicksSearchResult(){
        searchResult.click();
    }

    @AndroidFindBy(id = "com.storellet:id/view_merchant_shoploc_map_showall_btn")
    WebElement viewBranchesButton;
    public void viewBranchesButtonDisplayed(){
        while (true) {
            try {
                viewBranchesButton.isDisplayed();
                break;
            } catch (Exception e) {
                GeneralMethods.scrolling("down",200);
            }
        }
    }
    public void clicksViewBranchesButton(){
        viewBranchesButton.click();
    }

    @AndroidFindBy(id = "com.storellet:id/view_merchant_additional_info_receive_news_switch")
    WebElement receiveNewsSwitch;
    public void receiveNewsSwitchDisplayed(){
        while (true){
            try {
                receiveNewsSwitch.isDisplayed();
                break;
            }catch (Exception e){
                GeneralMethods.scrolling("down",200);
            }
        }
    }

    @AndroidFindBy(id = "com.storellet:id/image1")
    WebElement couponsGuide;
    public void clicksCouponsGuide(){
        try {
            waitElement(couponsGuide,5);
            if (couponsGuide.isDisplayed()){
                couponsGuide.click();
            }
        }catch (Exception e){
            System.out.println("WebElement does not exist");
        }
    }
    public String getReceiveNewsSwitchStatus(){
        waitElement(receiveNewsSwitch,20);
        return receiveNewsSwitch.getDomAttribute("checked");
    }
    public void clicksReceiveNewsSwitch(){
        receiveNewsSwitch.click();
    }

    @AndroidFindBy(id = "com.storellet:id/view_achievement_progress_lite_progress_tips_left_tv")
    WebElement membershipValidity;
    public String getMembershipValidity(){
        return membershipValidity.getText();
    }
    public boolean membershipValidityDisplayed(){
        waitElement(membershipValidity,20);
        return membershipValidity.isDisplayed();
    }

    public void waitElement(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
