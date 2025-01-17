package gt.org.steps;

import gt.org.page.ExplorePage;
import gt.org.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ExploreSteps {
    AppiumDriver driver = DriverManager.getDriver();
    ExplorePage explore = new ExplorePage(driver);

    @And("^user should see the (.*) displayed on the explore page$")
    public void userShouldSeeTheDisplayedOnTheExplorePage(String arg0) {
        switch (arg0){
            case "search box":
                assert explore.searchBoxDisplayed();
                break;
            case "最新上架":
                assert  explore.newArrivalsDisplayed();
                break;
            case "全部餐廳":
                assert explore.allRestaurantsDisplayed();
                break;
            default:
                break;
        }
    }


    @When("^the user scrolls the 最新上架 on the explore page to show the (.*) restaurant$")
    public void theUserScrollsThe最新上架OnTheExplorePageToShowTheRestaurant(String restaurant) {
        switch (restaurant){
            case "The Wall Street Bar & Lounge":
                explore.wallStreetBarDisplayed();
                break;
            case "PizzaExpress":
                explore.pizzaExpressDisplayed();
                break;
            default:
                break;

        }
    }


    @When("the user scrolls the 全部餐廳 on the explore page to show the {} restaurant")
    public void theUserScrollsThe全部餐廳OnTheExplorePageToShowTheRestaurant(String restaurant) {
        switch (restaurant){
            case "Plato Cafe Bistro":
                explore.platoCafeBistroDisplayed();
                break;
            case "The Farmhouse Deli 餅店":
                explore.farmhouseDeliDisplayed();
                break;
            case "成為會員":
                explore.joinMemberButtonDisplayed();
                break;
            default:
                break;

        }
    }
    @And("^user clicks the (.*) restaurant on the explore page$")
    public void userClicksTheOnTheExplorePage(String restaurants) {
        switch (restaurants){
            case "The Wall Street Bar & Lounge":
                explore.clicksWallStreetBar();
                break;
            case "Plato Cafe Bistro":
                explore.clicksPlatoCafeBistro();
                break;
            case "The Farmhouse Deli 餅店":
                explore.clicksFarmhouseDeli();
            default:
                break;

        }

    }

    @When("user clicks the search result on the explore page")
    public void userClicksTheSearchResultOnTheExplorePage() {
        explore.clicksSearchResult();
    }


    @Then("the user should see the 電郵已發送 prompt box appear")
    public void theUserShouldSeeThe電郵已發送PromptBoxAppear() {
        assert explore.emailSentPromptBoxDisplayed();
    }

    @When("user clicks the 完成 button on the prompt box")
    public void userClicksThe完成ButtonOnThePromptBox() {
        explore.clicksDoneButton();
    }

    @When("user clicks the search box on the explore page")
    public void userClicksTheSearchBoxOnTheExplorePage() {
        explore.clicksSearchBox();
    }

    @And("the update button is disable on the email change page")
    public void theUpdateButtonIsDisableOnTheEmailChangePage() {
        Assert.assertFalse(explore.getUpdateButtonStatus());
    }

    @When("^user enters email (.*) in the email field$")
    public void userEntersEmailTInTheEmailField(String email) {
        explore.typeEmailField(email);
    }

    @Then("the update button is enable on the email change page")
    public void theUpdateButtonIsEnableOnTheEmailChangePage() {
        assert explore.getUpdateButtonStatus();
    }

    @When("user clicks the update button on the email change page")
    public void userClicksTheUpdateButtonOnTheEmailChangePage() {
        explore.clicksUpdateButton();
    }

    @And("user clicks the 成為會員 button the explore page")
    public void userClicksThe成為會員ButtonTheExplorePage() {
        explore.clicksJoinMemberButton();
    }

    @And("^user should see the agree button is (disabled|enabled) on the membership details$")
    public void userShouldSeeTheAgreeButtonIsOnTheMembershipDetails(String status) {
        switch (status){
            case "disabled":
                Assert.assertFalse(explore.getAgreeButton());
                break;
            case "enabled":
                assert explore.getAgreeButton();
                break;
            default:
                break;
        }
    }

    @When("^user clicks the (disagree|agree) button on the membership details$")
    public void userClicksTheDisagreeButtonOnTheMembershipDetails(String buttonName) {
        switch (buttonName){
            case "disagree":
                explore.clicksDisagreeButton();
                break;
            case "agree":
                explore.clicksAgreeButton();
                break;
            default:
                break;
        }
    }

    @Then("^user back to restaurant page and (成為會員|會籍有效期) is displayed$")
    public void userBackToRestaurantPageAndIsDisplayed(String name) {
        switch (name){
            case "成為會員":
                assert explore.restaurantJoinMemberButtonDisplayed();
                break;
            case "會籍有效期":
                assert explore.membershipValidityDisplayed();
                break;
            default:
                break;
        }
    }

    @And("the user scrolls to view the member details until the bottom")
    public void theUserScrollsToViewTheMemberDetailsUntilTheBottom() {
        explore.scrollMemberContent();
    }

}
