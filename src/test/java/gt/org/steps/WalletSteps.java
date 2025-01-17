package gt.org.steps;

import gt.org.page.WalletPage;
import gt.org.utils.DriverManager;
import gt.org.utils.GeneralMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class WalletSteps {
    WalletPage wallet = new WalletPage(DriverManager.getDriver());
    @When("user clicks the show all button on the my wallet page")
    public void userClicksTheShowAllButtonOnTheMyWalletPage() {
        wallet.clicksShowAllButton();
    }

    @And("^user scrolls my wallet page and clicks (.*) restaurant$")
    public void userScrollsMyWalletPageAndClicksSKYBIGGROUPRestaurant(String restaurant) {
        switch (restaurant){
            case "SKY BIG GROUP":
                wallet.clicksSkyBigGroup();
                break;
            case "亞泰":
                wallet.clicksYaTai();
                break;
            default:
                break;
        }

    }

    @When("user clicks the restaurant unredeemed coupons on the 可兌換 selection page")
    public void userClicksTheRestaurantUnredeemedCouponsOnThe可兌換SelectionPage() {
        wallet.clicksRedeemableCoupons();
    }


    @When("^user clicks the (兌換|close) button on the coupons details page$")
    public void userClicksButtonOnTheCouponsDetailsPage(String buttonName) {
        switch (buttonName){
            case "兌換":
                wallet.clicksCouponRedemptionButton();
                break;
            case "close":
                wallet.clicksCouponCloseButton();
            default:
                break;
        }
    }
    @Then("users should see a \"你沒有足夠的積分兌換此項目\" prompt box on the coupon details page")
    public void usersShouldSeeAPromptBoxOnTheCouponDetailsPage() {
        assert wallet.unableToRedeemPromptBoxDisplayed();
    }

    @When("user clicks the confirm button on the prompt box")
    public void userClicksTheConfirmButtonOnThePromptBox() {
        wallet.clicksPromptBoxConfirmButton();
    }

    @When("^the user scrolls the my wallet page to display the (.*) restaurant coupon$")
    public void theUserScrollsTheMyWalletPageToDisplayTheRestaurantCoupon(String restaurant) {
        switch (restaurant){
            case "牛牛日式火鍋放題":
                wallet.beefHotpotDisplayed();
                break;
            case "翠華餐廳":
                wallet.tsuiWahDisplayed();
                break;
            default:
                break;
        }
    }


    @When("^the user clicks the coupon in the (.*) restaurant section to view the coupons$")
    public void theUserClicksTheAllButtonInTheRestaurantSectionToViewTheCoupons(String restaurant) {
        switch (restaurant){
            case "牛牛日式火鍋放題":
                wallet.clicksBeefHotpotCoupon();
                break;
            case "翠華餐廳":
                wallet.clicksTsuiWahCoupon();
                break;
            default:
                break;
        }
    }

    @And("user should see the coupon validity period on the coupon details page")
    public void userShouldSeeTheCouponValidityPeriodOnTheCouponDetailsPage() {
        assert wallet.couponValidityPeriodDisplayed();
    }

    @And("the number of days in the coupon expiry date should be the same as the number of days in the my wallet page coupon expiry date")
    public void theNumberOfDaysInTheCouponExpiryDateShouldBeTheSameAsTheNumberOfDaysINTheMyWalletPageCouponExpiresDate() {
        String expirationDate = GeneralMethods.getTextContent("target/couponExpirationDate.txt");
        String validityPeriod = wallet.getCouponValidityPeriod();
        String regexValidityPeriod = GeneralMethods.regexMethod(validityPeriod,"(\\d{4}年\\d{2}月\\d{2}日)\\s*-\\s*(\\d{4}年\\d{2}月\\d{2}日)",2);
        long daysBetween = GeneralMethods.calculationTimeDays(regexValidityPeriod,"yyyy年MM月dd日");
        long expirationTime = Long.parseLong(GeneralMethods.regexMethod(expirationDate,"(\\d+)天後到期",1));
        assert daysBetween == expirationTime;
    }

    @When("user clicks the close button on the coupon detail page")
    public void userClicksTheCloseButtonOnTheCouponDetailPage() {
        wallet.clicksCouponCloseButton();
    }

    @When("^user clicks the (.*) restaurant on the my wallet page$")
    public void userClicksTheRestaurantOnTheMyWalletPage(String restaurant) {

        switch (restaurant){
            case "牛牛日式火鍋放題":
                wallet.clicksBeefHotpot();
                break;
            case "翠華餐廳":
                wallet.clicksTsuiWah();
                break;
            default:
                break;
        }
    }

//    @And("the coupon expiration date on the restaurant details page should be the same as the coupon expiration date on the my wallet page")
//    public void theCouponExpirationDateOnTheRestaurantDetailsPageShouldBeTheSameAsTheCouponExpirationDateOnTheMyWalletPage() {
//        Assert.assertEquals(wallet.getRestaurantCouponExpirationDate(),GeneralMethods.getTextContent("target/couponExpirationDate.txt"));
//    }


    @Then("^user should back to the my wallet page and display the (.*) restaurant coupon$")
    public void userShouldBackToTheMyWalletPageAndDisplayTheRestaurantCoupon(String restaurant) {
        switch (restaurant){
            case "牛牛日式火鍋放題":
                assert wallet.beefHotpotDisplayed();
                break;
            case "翠華餐廳":
                assert wallet.tsuiWahDisplayed();
                break;
            default:
                break;
        }
    }

    @When("^user views (.*) restaurant images and saves them$")
    public void userViewsRestaurantImagesAndSavesThem(String restaurant) throws IOException {
        wallet.saveImage(wallet.getImage(),restaurant);
    }

    @Then("^(.*) restaurant images are not empty$")
    public void RestaurantImagesAreNotEmpty(String restaurant) throws IOException {
        assert wallet.imageIsNotEmpty(GeneralMethods.getPathImage(restaurant));
    }

    @Then("^the user should see the same image of the (.*) restaurant as the saved image$")
    public void theUserShouldSeeTheSameImageOfTheRestaurantAsTheSavedImage(String restaurant) throws IOException {
        assert GeneralMethods.ImageComparison(GeneralMethods.getPathImage(restaurant),wallet.getImage());
    }

    @And("^the user should see that the image of the Monkey Cafe restaurant is inconsistent with the image of the save (.*) restaurant$")
    public void theUserShouldSeeThatTheImageOfTheMonkeyCafeRestaurantIsInconsistentWithTheImageOfTheSaveRestaurant(String restaurant) throws IOException {
        Assert.assertFalse(GeneralMethods.ImageComparison(GeneralMethods.getPathImage(restaurant),wallet.getImage2()));
    }

    @And("user should see the coupon and coupon expiry date on the 我的錢包 selection page")
    public void userShouldSeeTheCouponAndCouponExpiryDateOnThe我的錢包SelectionPage() {
        assert wallet.restaurantCouponExpirationDateDisplayed();
        GeneralMethods.saveText(wallet.getRestaurantCouponExpirationDate(),"target/couponExpirationDate.txt");
    }

    @When("user clicks the coupon on the 我的錢包 selection page")
    public void userClicksTheCouponOnThe我的錢包SelectionPage() {
        wallet.clicksRestaurantCouponExpirationDate();
    }
}
