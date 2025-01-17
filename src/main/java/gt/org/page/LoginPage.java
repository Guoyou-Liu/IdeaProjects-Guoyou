package gt.org.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    @AndroidFindBy(id = "com.storellet:id/frag_login_dialog_v4_title_tv")
    WebElement loginPage;
    public boolean loginPageDisplayed(){
        waitElement(loginPage,10);
        return loginPage.isDisplayed();
    }
    @AndroidFindBy(id = "com.storellet:id/frag_login_dialog_v4_country_btn")
    WebElement numberCodeButton;
    public void clickNumberCodeButton(){
        numberCodeButton.click();
    }
    public String getNumberCodeButtonContent(){
        return numberCodeButton.getText();
    }


    @AndroidFindBy(id = "com.storellet:id/dialog_error_dialog_title")
    WebElement numberCodeSelection;
    public boolean numberCodeSelectionDisplayed(){
        return numberCodeSelection.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"852\"]")
    WebElement numberCode852;
    public void selectNumberCode852(){
        numberCode852.click();
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"853\"]")
    WebElement numberCode853;
    public void selectNumberCode853(){
        numberCode853.click();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"86\"]")
    WebElement numberCode86;
    public void selectNumberCode86(){
        numberCode86.click();
    }

    @AndroidFindBy(id = "com.storellet:id/frag_login_dialog_v4_mobile_et")
    WebElement phoneNumberField;
    @AndroidFindBy(id = "com.storellet:id/frag_login_dialog_v4_password_et")
    WebElement passwordField;
    public void enterPhoneNumberAndPassword(String phoneNumber, String password){
        phoneNumberField.clear();
        passwordField.clear();
        phoneNumberField.sendKeys(phoneNumber);
        passwordField.sendKeys(password);
    }
    @AndroidFindBy(id = "com.storellet:id/frag_login_dialog_v4_confirm_btn")
    WebElement loginButton;
    public void clickLoginButton(){
        loginButton.click();
    }

    @AndroidFindBy(id = "com.storellet:id/dialog_error_dialog_content")
    WebElement errorMessageBox;
    public boolean errorMessageBoxDisplayed(){
        return errorMessageBox.isDisplayed();
    }

    @AndroidFindBy(id = "com.storellet:id/dialog_error_dialog_negative_btn")
    WebElement confirmErrorButton;
    public void clickConfirmErrorButton(){
        confirmErrorButton.click();
    }


    @AndroidFindBy(id = "com.storellet:id/fragment_member_card_member_id_tv")
    WebElement accountId;
    public String getAccountId(){
        return accountId.getText();
    }


    public LoginPage(AppiumDriver driver) {
        super(driver);
    }
}
