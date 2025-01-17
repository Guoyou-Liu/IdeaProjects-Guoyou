package gt.org.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SettingsPage extends BasePage{
    @AndroidFindBy(id = "com.storellet:id/fragment_member_card_setting_iv")
    WebElement settingsButton;
    public boolean settingsButtonDisplayed(){
        return settingsButton.isDisplayed();
    }
    public void clicksSettingsButton(){
        settingsButton.click();
    }
    @AndroidFindBy(id = "com.storellet:id/fragment_setting_main_back_iv")
    WebElement settingsBackButton;
    public boolean settingsPageDisplayed(){
        waitElement(settingsBackButton,5);
        return settingsBackButton.isDisplayed();
    }
    public void clicksSettingsBackButton(){
        settingsBackButton.click();
    }

    @AndroidFindBy(id = "com.storellet:id/fragment_setting_main_notice")
    WebElement notifications;
    public boolean notificationsDisplayed(){
        return notifications.isDisplayed();
    }
    @AndroidFindBy(id = "com.storellet:id/view_setting_item_extra_tick_v")
    WebElement notificationCheckbox;
    public String getNotificationCheckboxStatus(){
        return notificationCheckbox.getDomAttribute("checked");
    }
    public void clickNotificationCheckbox(){
        notificationCheckbox.click();
    }

    @AndroidFindBy(id = "com.storellet:id/fragment_setting_main_account_manage")
    WebElement accountManagementButton;
    public boolean accountManagementDisplayed(){
        return accountManagementButton.isDisplayed();
    }
    public void clicksAccountManagementButton(){
        accountManagementButton.click();
    }

    @AndroidFindBy(id = "com.storellet:id/fragment_setting_main_update_info")
    WebElement updateInfoButton;
    public boolean updatedInfoDisplayed(){
        return updateInfoButton.isDisplayed();
    }
    public void clicksUpdateInfoButton(){
        updateInfoButton.click();
    }

    @AndroidFindBy(id = "com.storellet:id/fragment_setting_main_change_password")
    WebElement changePasswordButton;
    public boolean changePasswordButtonDisplayed(){
        return changePasswordButton.isDisplayed();
    }
    public void clicksChangePasswordButton(){
        changePasswordButton.click();
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/fragment_setting_main_logout_tv"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/fragment_setting_main_logout_tv\"]")
    })
    WebElement logoutButton;
    public boolean logoutButtonDisplayed(){
        return logoutButton.isDisplayed();
    }
    public void clicksLogoutButton(){
        logoutButton.click();
    }

    @AndroidFindBy(id = "com.storellet:id/fragment_setting_main_lang")
    WebElement languageSettingButton;
    public boolean languageSettingButtonDisplayed(){
        return languageSettingButton.isDisplayed();
    }
    public void clicksLanguageSettingButton(){
        languageSettingButton.click();
    }
    @AndroidFindBy(id = "com.storellet:id/view_setting_item_extra_selection_tv")
    WebElement languageSettingText;
    public String getLanguageSettingText(){
        return languageSettingText.getText();
    }

    @AndroidFindBy(id = "com.storellet:id/fragment_setting_contact_us")
    WebElement contactUsButton;
    public boolean contactUsButtonDisplayed(){
        return contactUsButton.isDisplayed();
    }
    public void clicksContactUsButton(){
        contactUsButton.click();
    }

    @AndroidFindBy(id = "com.storellet:id/fragment_setting_main_about_storellet")
    WebElement aboutButton;
    public boolean aboutButtonDisplayed(){
        return aboutButton.isDisplayed();
    }
    public void clickAboutButton(){
        aboutButton.click();
    }

    @AndroidFindBy(id = "com.storellet:id/fragment_setting_main_reset_tutor")
    WebElement reEnableGuideButton;
    public boolean reEnableGuideButtonDisplayed(){
        return reEnableGuideButton.isDisplayed();
    }
    public void clickReEnableGuideButton(){
        reEnableGuideButton.click();
    }

    @AndroidFindBy(id = "com.storellet:id/parentPanel")
    WebElement languageSelections;
    public boolean languageSelectionsDisplayed(){
        return languageSelections.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"繁體中文 (香港)\"]")
    WebElement traditionalChinese;
    public boolean traditionalChineseOptionDisplayed(){
        return traditionalChinese.isDisplayed();
    }
    public String getTraditionalChineseCheckBoxStatus(){
        return traditionalChinese.getDomAttribute("checked");
    }
    public void clicksTraditionalChinese(){
        traditionalChinese.click();
    }

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"English\"]")
    WebElement english;
    public boolean englishOptionDisplayed(){
        return english.isDisplayed();
    }
    public String getEnglishCheckBoxStatus(){
        return english.getDomAttribute("checked");
    }
    public void clicksEnglish(){
        english.click();
    }

    @AndroidFindBy(id = "android:id/button2")
    WebElement languageCancelButton;
    public void clicksLanguageCancelButton(){
        languageCancelButton.click();
    }

    @AndroidFindBy(id = "android:id/button1")
    WebElement languageConfirmButton;
    public void clicksLanguageConfirmButton(){
        languageConfirmButton.click();
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/dialog_error_dialog_content"),
            @AndroidBy(className = "android.widget.TextView"),
            @AndroidBy(xpath = "//android.widget.TextView[@resource-id=\"com.storellet:id/dialog_error_dialog_content\"]")
    })
    WebElement logoutPromptBox;
    public boolean logoutPromptBoxDisplayed(){
        return logoutPromptBox.isDisplayed();
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/dialog_error_dialog_negative_btn"),
            @AndroidBy(xpath = "//android.widget.Button[@resource-id=\"com.storellet:id/dialog_error_dialog_negative_btn\"]")
    })
    WebElement promptBoxCancelButton;
    public void clicksPromptBoxCancelButton(){
        promptBoxCancelButton.click();
    }

    @AndroidFindAll({
            @AndroidBy(id = "com.storellet:id/dialog_error_dialog_positive_btn"),
            @AndroidBy(xpath = "//android.widget.Button[@resource-id=\"com.storellet:id/dialog_error_dialog_positive_btn\"]")
    })
    WebElement promptBoxLogoutButton;
    public void clicksPromptBoxLogoutButton(){
        promptBoxLogoutButton.click();
    }


    public SettingsPage(AppiumDriver driver) {
        super(driver);
    }
}
