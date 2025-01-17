package gt.org.steps;
import gt.org.page.SplashPage;
import gt.org.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SplashSteps {
    SplashPage splash = new SplashPage(DriverManager.getDriver());

    @And("user scrolls the Storellet introduction page and clicks the close button on the last page")
    public void userScrollsTheStorelletIntroductionPageAndClicksTheCloseButtonOnTheLastPage() {
        splash.clickIntroductionPageCloseButton();
    }

    @Then("user navigates to the home page and guide appears")
    public void userNavigatesToTheHomePageAndGuideAppears() {
            assert splash.homeGuideDisplayed();
    }

    @When("^user skips the (.*) guide on the home page$")
    public void userSkipsTheGuideOnTheHomePage(String arg0) {
        switch (arg0) {
            case "home":
                splash.clickHomeGuide();
                break;
            case "explore":
                splash.clickexploreGuide();
                break;
            case "wallet":
                splash.clickWalletGuide();
                break;
            case "account":
                splash.clickAccountGuide();
                break;
            case "scanner":
                splash.clickScannerGuide();
                break;
            case "notice":
                splash.clickNoticeGuide();
                break;
            default:
                break;
        }
    }

    @Then("^(.*) guide appears on the home page")
    public void guideAppearsOnTheHomePage(String arg0) {
            switch (arg0){
                case "explore":
                    assert splash.exploreGuideDisplayed();
                    break;
                case "wallet":
                    assert splash.walletGuideDisplayed();
                    break;
                case "account":
                    assert splash.accountGuideDisplayed();
                    break;
                case "scanner":
                    assert splash.scannerGuideDisplayed();
                    break;
                case "notice":
                    assert splash.noticeGuideDisplayed();
                    break;
                default:
                    break;
            }
    }

    @Then("show home page content")
    public void showHomePageContent() {
        assert splash.homeLogoDisplayed();

    }
}
