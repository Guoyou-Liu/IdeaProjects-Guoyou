package gt.org.steps;

import gt.org.page.LoginPage;
import gt.org.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    AppiumDriver driver = DriverManager.getDriver();
    LoginPage login = new LoginPage(driver);



    @When("user clicks the phone number code button on the login page")
    public void userClicksThePhoneNumberCodeButtonOnTheLoginPage() {
        login.clickNumberCodeButton();
    }

    @Then("phone number code selection appears on the login page")
    public void phoneNumberCodeSelectionAppearsOnTheLoginPage() {
        assert login.numberCodeSelectionDisplayed();
    }

    @When("^user select the phone number code (.*) on the phone number code selection$")
    public void userSelectThePhoneNumberCodeOnThePhoneNumberCodeSelection(String arg0) {
        switch (arg0){
            case "852":
                login.selectNumberCode852();
                break;
            case "853":
                login.selectNumberCode853();
                break;
            case "86":
                login.selectNumberCode86();
                break;
            default:
                break;
        }
    }

    @Then("^phone number code button shows (.*) on the login page$")
    public void phoneNumberCodeButtonShowsOnTheLoginPage(String arg0) {

        Assert.assertEquals(login.getNumberCodeButtonContent(),arg0);

    }

    @When("^user input the phone number (.*) and password (.*) on the login page$")
    public void userInputThePhoneNumberAndPasswordInLoginPageOnTheLoginPage(String number, String password) {
        login.enterPhoneNumberAndPassword(number,password);
    }

    @And("user clicks the login button on the login page")
    public void userClicksTheLoginButtonOnTheLoginPage() {
        login.clickLoginButton();
    }

    @Then("app prompts that the phone number or password is incorrect")
    public void appPromptsThatThePhoneNumberOrPasswordIsIncorrect() {
        assert login.errorMessageBoxDisplayed();
    }
    @And("user clicks the confirm error button in the error message prompt box")
    public void userClicksTheConfirmErrorButtonInTheErrorMessagePromptBox() {
        login.clickConfirmErrorButton();
    }

    @Then("user successfully logs in and goes to the My Wallet page")
    public void userSuccessfullyLogsInAndGoesToTheMyMalletPage() {
        assert login.myWalletPageDisplayed();
    }

    @When("user clicks the my account button on the My Wallet page")
    public void userClicksTheMyAccountButtonOnTheMyWalletPage() {
        login.clicksMyAccountButton();
    }

    @Then("account information appear on the My Wallet page")
    public void accountInformationAppearOnTheMyWalletPage() {
        assert login.accountTitleDisplayed();
    }

    @And("account id is displayed on the account information")
    public void accountIdIsDisplayedOnTheAccountInformation() {
        Assert.assertEquals(login.getAccountId(),"190106262");
    }
}
