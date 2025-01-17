package gt.org.steps;

import gt.org.page.SettingsPage;
import gt.org.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SettingsSteps {
    AppiumDriver driver = DriverManager.getDriver();
    SettingsPage settings = new SettingsPage(driver);

    @Then("account information appear on the home page")
    public void accountInformationAppearOnTheHomePage() {
        settings.accountTitleDisplayed();
    }

    @And("setting button is displayed on the account information")
    public void settingButtonIsDisplayedOnTheAccountInformation() {
        assert settings.settingsButtonDisplayed();
    }


    @When("user clicks the setting button on the account information")
    public void userClicksTheSettingButtonOnTheAccountInformation() {
        settings.clicksSettingsButton();
    }


    @And("^(.*) are displayed on the settings page$")
    public void AreDisplayedOnTheSettingsPage(String arg0) {
        switch (arg0){
            case "push notification":
                assert settings.notificationsDisplayed();
                break;
            case "account management entry":
                assert settings.accountManagementDisplayed();
                break;
            case "update information entry":
                assert settings.updatedInfoDisplayed();
                break;
            case "change password entry":
                assert settings.changePasswordButtonDisplayed();
                break;
            case "logout button":
                assert settings.logoutButtonDisplayed();
                break;
            case "language setting entry":
                assert settings.languageSettingButtonDisplayed();
                break;
            case "contact us entry":
                assert settings.contactUsButtonDisplayed();
                break;
            case "re-enable guide button":
                assert settings.reEnableGuideButtonDisplayed();
                break;
            case "about button":
                assert settings.aboutButtonDisplayed();
            default:
                break;

        }
    }

    @And("^push notification checkbox is (.*) on the settings page$")
    public void pushNotificationCheckboxIsOnTheSettingsPage(String arg0) {
        switch (arg0){
            case "not checked":
                Assert.assertEquals(settings.getNotificationCheckboxStatus(),"false","Push notification checkbox is checked state");
                break;
            case "checked":
                Assert.assertEquals(settings.getNotificationCheckboxStatus(),"true","Push notification checkbox is not checked state");
                break;
            default:
                break;
        }
    }


    @And("^language setting entry displayed is (.*) on the settings page$")
    public void languageSettingEntryDisplayedIsOnTheSettingsPage(String arg0) {
        switch (arg0){
            case "traditional chinese":
                Assert.assertEquals(settings.getLanguageSettingText(),"繁體中文 (香港)","Language is english");
                break;
            case "english":
                Assert.assertEquals(settings.getLanguageSettingText(),"English","Language is traditional chinese");
        }

    }

    @When("^user clicks the (.*) on the settings page$")
    public void userClicksTheOnTheSettingsPage(String arg0) {
        switch (arg0){
            case "push notification checkbox":
                settings.clickNotificationCheckbox();
                break;
            case "language setting button":
                settings.clicksLanguageSettingButton();
                break;
            case "logout button":
                settings.clicksLogoutButton();
                break;
            default:
                break;
        }
    }


    @Then("language selections appears on the settings page")
    public void languageSelectionsAppearsOnTheSettingsPage() {
        assert settings.languageSelectionsDisplayed();
    }

    @And("^(.*) option is displayed on the language selections$")
    public void optionIsDisplayedOnTheLanguageSelections(String arg0) {
        switch (arg0){
            case "traditional chinese":
                assert settings.traditionalChineseOptionDisplayed();
                break;
            case "english":
                assert settings.englishOptionDisplayed();
                break;
            default:
                break;
        }
    }

    @And("^(.*) option is selected on the language selections$")
    public void optionIsSelectedOnTheLanguageSelections(String arg0) {
        switch (arg0){
            case "traditional chinese":
                Assert.assertEquals(settings.getTraditionalChineseCheckBoxStatus(),"true","Traditional chinese option is not selected");
                break;
            case "english":
                Assert.assertEquals(settings.getEnglishCheckBoxStatus(),"true","English option is not selected");
                break;
            default:
                break;
        }
    }

    @And("^(.*) option is not selected on the language selections$")
    public void OptionIsNotSelectedOnTheLanguageSelections(String arg0) {
        switch (arg0) {
            case "traditional chinese":
                Assert.assertEquals(settings.getTraditionalChineseCheckBoxStatus(), "false", "Traditional chinese option is selected");
                break;
            case "english":
                Assert.assertEquals(settings.getEnglishCheckBoxStatus(), "false", "English option is selected");
                break;
            default:
                break;
        }
    }

    @When("^user clicks the (.*) on the language selections$")
    public void userClicksTheOnTheLanguageSelections(String arg0) {
        switch (arg0){
            case "cancel button":
                settings.clicksLanguageCancelButton();
                break;
            case "confirm button":
                settings.clicksLanguageConfirmButton();
                break;
            default:
                break;
        }
    }

    @And("^user select the (.*) option on the language selections$")
    public void userSelectTheOptionOnTheLanguageSelections(String arg0) {
        switch (arg0){
            case "traditional chinese":
                settings.clicksTraditionalChinese();
                break;
            case "english":
                settings.clicksEnglish();
                break;
            default:
                break;
        }
    }



    @And("^app is displayed (.*) language$")
    public void appIsDisplayedLanguage(String arg0) {
        switch (arg0){
            case "english":
                Assert.assertEquals(settings.getRedeemText(),"Redeem");
                break;
            case "traditional chinese":
                Assert.assertEquals(settings.getRedeemText(),"兌換中心");
                break;
            default:
                break;
        }
    }

    @Then("user should see the logout prompt box displayed on the settings page")
    public void userShouldSeeTheLogoutPromptBoxDisplayedOnTheSettingsPage() {
        assert settings.logoutPromptBoxDisplayed();
    }

    @When("^user clicks the (cancel|logout) button on the logout prompt box$")
    public void userClicksTheButtonOnTheLogoutPromptBox(String buttonName) {
        switch (buttonName){
            case "cancel":
                settings.clicksPromptBoxCancelButton();
                break;
            case "logout":
                settings.clicksPromptBoxLogoutButton();
            default:
                break;
        }
    }

}
