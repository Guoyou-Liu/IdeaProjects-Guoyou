package gt.org.steps;

import gt.org.page.HKMoviePage;
import gt.org.utils.DriverManager;
import gt.org.utils.GeneralMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HKMovieSteps {
    HKMoviePage hkMovie = new HKMoviePage(DriverManager.getDriver());
    @Given("^user on HKMovie (.*) page$")
    public void userOnHKMovieStartupPage(String pageName) {
        switch (pageName){
            case "startup":
                hkMovie.skipDisplayed();
                break;
            case "上映回数順 ▾":
                hkMovie.homeSearchButtonDisplayed();
                break;
            default:
                System.out.println("No matching pages found");
        }
    }

    @When("the user clicks the Skip button on the HKMovie startup page")
    public void theUserClicksTheSkipButtonOnTheHKMovieStartupPage() {
        hkMovie.clicksSkipButton();
    }

    @Then("the user should navigate to the select location selection")
    public void theUserShouldNavigateToTheSelectLocationSelection() {
        assert hkMovie.locationTipsDisplayed();
    }

    @When("the user clicks the Completed button on the select location selection")
    public void theUserClicksTheCompletedButtonOnTheSelectLocationSelection() {
        hkMovie.clicksCompleted();
    }

    @And("the user clicks the close button in the prompt box if it exists")
    public void theUserClicksTheCloseButtonInThePromptBoxIfItExists() {
        hkMovie.clicksTipBoxCloseButton();
    }

    @Then("^the user should navigate to the HKMovie (.*) page$")
    public void theUserShouldNavigateToTheHKMovieHomePage(String pageName) {
        Assert.assertEquals(hkMovie.getTitleText(),pageName);
    }

    @When("user clicks the my page button")
    public void userClicksTheMyPageButton() {
        hkMovie.clicksMyPageButton();
    }


    @And("User should see the New Register and Login button displayed on HKMovie my page")
    public void userShouldSeeTheNewRegisterAndLoginButtonDisplayedOnHKMovieMyPage() {
        assert hkMovie.newRegisterAndLoginButtonDisplayed();
    }

    @When("the user clicks the New Register and Login button on the HKMovie my page")
    public void theUserClicksTheNewRegisterAndLoginButtonOnTheHKMovieMyPage() {
        hkMovie.clicksNewRegisterAndLoginButton();
    }

    @Then("the user should navigate to the login page")
    public void theUserShouldNavigateToTheLoginPage() {
        assert hkMovie.loginPageDisplayed();
    }

    @When("^the user enters the (.*) and (.*) on the HKMovie login page$")
    public void theUserEntersTheAndOnTheHKMovieLoginPage(String email, String password) {
        hkMovie.typeLoginEmailField(email);
        hkMovie.typeLoginPasswordField(password);
    }

    @And("user clicks the login button on the HKMovie login page")
    public void userClicksTheLoginButtonOnTheHKMovieLoginPage() {
        hkMovie.clicksLoginButton();
    }

    @Then("^the user logs in successfully and should see user id (.*) on the HKMovie my page$")
    public void theUserLogsInSuccessfullyAndShouldSeeUserIdOnTheHKMovieMyPage(String id) {
        Assert.assertEquals(GeneralMethods.regexMethod(hkMovie.getUserId(),"ID:\\s*(\\d+)",1),id);
    }
}
