package gt.org.steps;

import gt.org.page.*;
import gt.org.utils.DriverManager;
import gt.org.utils.GeneralMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CommonSteps {
    AppiumDriver driver = DriverManager.getDriver();
    LoginPage login = new LoginPage(driver);
    SettingsPage settings = new SettingsPage(driver);
    BasePage base = new BasePage(driver);
    SplashPage splash = new SplashPage(driver);
    HomePage home = new HomePage(driver);
    ExplorePage explore = new ExplorePage(driver);
    WalletPage wallet = new WalletPage(driver);
    @When("user clicks the close button in the prompt box if exists")
    public void userClicksTheCloseButtonInTheUpdatePromptBoxIfExists() {
        splash.clickUpgradeTipsCloseButton();
    }
    @Given("^user on the Storellet (.*) page$")
    public void userOnThePage(String arg0) {
        switch (arg0){
            case "home":
                base.homeLogoDisplayed();
                break;
            case "setting":
                settings.settingsPageDisplayed();
                break;
            case "introduction":
                splash.introductionPageDisplayed();
                break;
            default:
                break;
        }
    }

    @Then("^user should navigate to the (.*) page$")
    public void userShouldNavigateToThePage(String arg0) {
        switch (arg0){
            case "login":
                assert login.loginPageDisplayed();
                break;
            case "settings":
                assert settings.settingsPageDisplayed();
                break;
            case "home":
                assert base.homeLogoDisplayed();
                break;
            case "introduction":
                assert splash.introductionPageDisplayed();
                break;
            case "Causeway Bay":
                assert home.causewayBayRestaurantsDisplayed();
                break;
            case "explore":
                assert explore.explorePageDisplayed();
                break;
            case "email change":
                assert explore.emailChangePageDisplayed();
                break;
            case "my wallet":
                assert base.myWalletPageDisplayed();
                break;
            case "coupon detail":
                assert wallet.couponTitleDisplayed();
                break;
            case "restaurant details":
                assert explore.restaurantJoinMemberButtonDisplayed();
                break;
            default:
                break;
        }

    }

    @And("^user clicks the (.*) button on the Storellet home page$")
    public void userClicksTheOnTheStorelletHomePage(String agr0) {
       switch (agr0){
           case "wallet":
               login.clicksWalletButton();
               break;
           case "my account":
               settings.clicksMyAccountButton();
               break;
           case "explore":
                explore.clicksexplore();
                break;
           case "search":
               home.clicksSearchButton();
           default:
               break;

       }
    }

    @Then("^user should then navigate to the (.*) restaurant details page$")
    public void userShouldThenNavigateToTheRestaurantDetailsPage(String arg0){
        Assert.assertEquals(home.getRestaurantTitle(),arg0);
    }

    @When("^user clicks the (.*) on the restaurant page$")
    public void userClicksTheOnTheRestaurantPage(String arg0) {
        switch (arg0){
            case "概要":
                home.clicksSummarySelection();
                break;
            case "我的錢包":
                home.clicksMyWalletSelection();
                break;
            case "可兌換":
                home.clicksRedeemableSelection();
                break;
            default:
                break;
        }
    }

    @And("user skips coupons guide on the restaurant details page if exists")
    public void userSkipsCouponsGuideOnTheRestaurantDetailsPageIfExists() {
        home.clicksCouponsGuide();
    }

    @Then("^user should the navigates to the (.*) selection$")
    public void userShouldTheNavigatesToTheSelection(String arg0) {
        boolean status = false;
        switch (arg0){
            case "我的錢包":
                status = home.myWalletSelectionDisplayed();
                break;
            case "可兌換":
                status = home.redeemableSelectionDisplayed();
                break;
            default:
                break;
        }
        assert status;
    }

    @When("^user on the restaurant (.*) selection page$")
    public void userOnTheRestaurantSelectionPage(String arg0) {
        switch (arg0){
            case "我的錢包":
                home.myWalletPageDisplayed();
                break;
            case "可兌換":
                home.redeemablePageDisplayed();
                break;
            default:
                break;
        }
    }

    @And("user {} the app")
    public void userTheApp(String agr0) {
        switch (agr0){
            case "quit":
                DriverManager.quitDriver();
                break;
            case "restart":
                DriverManager.restartApp();
                break;
            default:
                break;
        }
    }
    @When("^user clicks the (發送驗證|更改電郵|暫時不用) button on the Email Verification if exists$")
    public void userClicksTheOnTheEmailVerificationIfExists(String buttonName) {
        switch (buttonName){
            case "發送驗證":
                explore.clicksEmailSendVerificationButton();
                break;
            case "更改電郵":
                explore.clicksEmailChangeVerificationButton();
                break;
            case "暫時不用":
                explore.clicksEmailIgnoreButton();
                break;
            default:
                break;
        }
    }

    @When("^the user scrolls down the restaurant details page to display the (查看所有分店|最新消息) button$")
    public void theUserScrollsDownTheRestaurantDetailsPageToDisplayTheButton(String buttonName) {
        switch (buttonName){
            case "查看所有分店":
                base.viewBranchesButtonDisplayed();
                break;
            case "最新消息":
                base.receiveNewsSwitchDisplayed();
                break;
            default:
                break;
        }
    }
    @And("^user clicks the (.*) button on the restaurant details page$")
    public void userClicksTheButtonOnTheRestaurantDetailsPage(String arg0) {
        switch (arg0){
            case "條款與細則":
                home.clicksMembershipRules();
                break;
            case "查看所有分店":
                home.clicksViewBranchesButton();
                break;
            case "最新消息":
                home.clicksReceiveNewsSwitch();
                break;
            case "back":
                home.clicksBackButton();
                break;
            case "成為會員":
                explore.clicksRestaurantJoinMemberButton();
            default:
                break;
        }
    }
    @Then("^user should see (coupons|membership) details displayed on the restaurant page$")
    public void userShouldSeeDetailsDisplayedOnTheRestaurantPage(String name) {
        switch (name){
            case "coupons":
                assert wallet.couponsDetailsDisplayed();
                break;
            case "membership":
                assert explore.memberContentTitleDisplayed();
                break;
            default:
                break;
        }
    }

    @And("user should see that the membership validity period has not expired")
    public void userShouldSeeThatTheMembershipValidityPeriodHasNotExpired() {
        String membership =home.getMembershipValidity();
        LocalDate currentTime = LocalDate.now();
        String regexData =GeneralMethods.regexMethod(membership,"(\\d{4}年\\d{2}月\\d{2}日)",1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        LocalDate dateTime = LocalDate.parse(regexData,formatter);
        assert GeneralMethods.timeComparison(currentTime,dateTime);
    }
}
