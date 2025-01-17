package gt.org.steps;

import gt.org.page.HomePage;
import gt.org.utils.DriverManager;
import gt.org.utils.GeneralMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HomeSteps {
    HomePage home = new HomePage(DriverManager.getDriver());

    @When("user scrolls the home page to view Causeway Bay popular recommendations")
    public void userScrollsTheHomePageToViewCausewayBayPopularRecommendations() {
        while (true) {
            try {
                home.causewayBayDisplayed();
                break;
            } catch (Exception e) {
                GeneralMethods.scrolling("down",200);
            }
        }
    }

    @And("^user should see the (.*) displayed in the popular restaurant recommendations in Causeway Bay$")
    public void userShouldSeeTheDisplayedInThePopularRestaurantRecommendationsInCausewayBay(String arg0) {
        switch (arg0) {
            case "迷你泡芙伴海鹽焦糖醬":
                assert home.cafeDisplayed();
                break;
            case "$25 現金券":
                assert home.patisserieTonyWongDisplayed();
                break;
            default:
                break;

        }
    }

    @When("^user clicks on the (.*) in the popular restaurant recommendation in Causeway Bay$")
    public void userClicksOnTheInThePopularRestaurantRecommendationInCausewayBay(String arg0) {
        switch (arg0) {
            case "迷你泡芙伴海鹽焦糖醬":
                home.clicksCafe();
                break;
            case "$25 現金券":
                home.clicksPatisserieTonyWong();
                break;
            default:
                break;
        }

    }

    @And("^user should see the (.*) selection displayed on the restaurant details page$")
    public void userShouldSeeTheSelectionDisplayedOnTheRestaurantDetailsPage(String arg0) {
        boolean status = false;
        switch (arg0) {
            case "概要":
                status = home.summarySelectionDisplayed();
                break;
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

    @And("^user should see the (.*) selection is selected on the restaurant details page$")
    public void userShouldSeeTheSelectionIsSelectedOnTheRestaurantDetailsPage(String arg0) {
        boolean status = false;
        switch (arg0) {
            case "概要":
                status = home.getSummarySelectionStatus();
                break;
            case "我的錢包":
                status = home.getMyWalletSelectionStatus();
                break;
            case "可兌換":
                status = home.getRedeemableSelectionStatus();
                break;
            default:
                break;
        }
        assert status;
    }

    @And("^user should see the (.*) selection is not selected on the restaurant details page$")
    public void userShouldSeeTheSelectionIsNotSelectedOnTheRestaurantDetailsPage(String arg0) {
        boolean status = true;
        switch (arg0) {
            case "概要":
                status = home.getSummarySelectionStatus();
                break;
            case "我的錢包":
                status = home.getMyWalletSelectionStatus();
                break;
            case "可兌換":
                status = home.getRedeemableSelectionStatus();
                break;
            default:
                break;
        }
        Assert.assertFalse(status);
    }

    @Then("user should see the rules details prompt box appear on the restaurant details page")
    public void userShouldSeeTheRulesDetailsPromptBoxAppearOnTheRestaurantDetailsPage() {
        assert home.membershipRulesContentDisplayed();
    }

    @When("user clicks the confirm button on the rules details prompt box")
    public void userClicksTheConfirmButtonOnTheRulesDetailsPromptBox() {
        home.clicksMembershipRulesConfirmButton();
    }


    @Then("^user should see the 最新消息 button is (turned on|off)$")
    public void userShouldSeeThe最新消息ButtonIs(String arg0) {
        switch (arg0){
            case "turned on":
                Assert.assertEquals(home.getReceiveNewsSwitchStatus(),"true");
                break;
            case "off":
                Assert.assertEquals(home.getReceiveNewsSwitchStatus(),"false");
                break;
            default:
                 break;
        }
    }


    @Then("user then navigates to the view all stores page view branches")
    public void userThenNavigatesToTheViewAllStoresPageViewBranches() {
        assert home.viewBranchesTitleDisplayed();
    }

    @When("user clicks the Back button on the view all stores page")
    public void userClicksTheBackButtonOnTheViewAllStoresPage() {
        home.clicksViewBranchesBackButton();
    }

    @Then("^user should then back to the (.*) restaurant details page$")
    public void userShouldThenBackToTheRestaurantDetailsPage(String arg0) {
        switch (arg0){
            case "Cafe Zense":
                Assert.assertEquals(home.getRestaurantTags(),"Cafe Zense");
                break;
            case "Patisserie Tony Wong":
                Assert.assertEquals(home.getRestaurantTags(),"Patisserie Tony Wong - 尖沙咀");
                break;
            default:
                break;

        }
    }


    @Then("user should see the restaurant already redeemed coupons on the 我的錢包 selection page")
    public void userShouldSeeTheRestaurantAlreadyRedeemedCouponsOnThe我的錢包SelectionPage() {
        assert home.myWalletCouponsDisplayed();
    }

    @Then("user should see the restaurant unredeemed coupons on the 可兌換 selection page")
    public void userShouldSeeTheRestaurantUnredeemedCouponsOnThe可兌換SelectionPage() {
        Assert.assertEquals(home.getItemsTitle(),"兌換");
    }


    @When("user scrolls the restaurant page to clicks the back button")
    public void userScrollsTheRestaurantPageToClicksTheBackButton() {
        while (true){
            try {
                home.clicksBackButton();
                break;
            }catch (Exception e){
                GeneralMethods.scrolling("up",200);
            }
        }
    }

    @When("user clicks the close button on the Causeway Bay page")
    public void userClicksTheCloseButtonOnTheCausewayBayPage() {
        home.clicksCausewayBayCloseButton();
    }


    @Then("users should return to the home page Causeway Bay Hot Recommendations section")
    public void usersShouldReturnToTheHomePageCausewayBayHotRecommendationsSection() {
        assert home.causewayBayDisplayed();
    }


    @Then("user should navigate to the search page and search box displayed")
    public void userShouldNavigateToTheSearchPageAndSearchBoxDisplayed() {
        assert home.searchBoxDisplayed();
    }

    @When("user clicks the search box on the search page")
    public void userClicksTheSearchBoxOnThePage() {
        home.clicksSearchBox();
    }

    @And("^user enters (.*) in the search box$")
    public void theUserEntersInTheSearchBox(String searchContent) {
        home.typeSearchBox(searchContent);

    }

    @Then("^user should see the (.*) on the search result$")
    public void userShouldSeeTheOnTheSearchResult(String result) {
            Assert.assertEquals(home.getSearchResult(),result);
    }

    @When("user clicks the search result on the search page")
    public void userClicksTheSearchResultOnThePage() {
        home.clicksSearchResult();
    }

    @And("^the search content (.*) in the search box will still be displayed$")
    public void theSearchContentInTheSearchBoxWillStillBeDisplayed(String result) {
        Assert.assertEquals(home.getSearchBoxContent(),result);
    }


    @When("user clicks clear button on the search box")
    public void userClicksClearButtonOnTheSearchBox() {
        home.clicksSearchBoxClearButton();
    }

    @Then("the search content in the search box will be cleared")
    public void theSearchContentInTheSearchBoxWillBeCleared() {
        Assert.assertEquals(home.getSearchBoxContent(),"搜尋");
    }

    @And("user clicks the Causeway Bay popular recommendations on the Storellet home page")
    public void userClicksTheCausewayBayPopularRecommendationsOnTheStorelletHomePage() {
        home.clicksCausewayBay();
    }
}
