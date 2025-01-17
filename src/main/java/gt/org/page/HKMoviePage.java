package gt.org.page;

import gt.org.utils.GeneralMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class HKMoviePage extends BasePage{

    //启动页跳过按钮
    @iOSXCUITFindAll({
            @iOSXCUITBy(className = "XCUIElementTypeStaticText"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeStaticText[@name=\"スキップ\"]")
    })
    WebElement skip;

    // 位置确认完成按钮
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"完了\"]")
    WebElement completed;

    // 广告弹窗关闭按钮
    @iOSXCUITFindAll({
            @iOSXCUITBy(accessibility = "\uF129"),
            @iOSXCUITBy(xpath = "(xpath = \"//XCUIElementTypeButton[@name=\\\"\\uF129\\\"]\")")
    })
    WebElement tipBoxCloseButton;

    //标题
    @iOSXCUITFindAll({
            @iOSXCUITBy(className = "XCUIElementTypeNavigationBar"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeNavigationBar")
    })
    WebElement title;

    //搜索按钮
    @iOSXCUITFindAll({
            @iOSXCUITBy(accessibility = "検索"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeButton[@name=\"検索\"]")
    })
    WebElement homeSearchButton;

    //我的页面按钮
    @iOSXCUITFindAll({
            @iOSXCUITBy(accessibility = "マイページ"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeButton[@name=\"マイページ\"]")
    })
    WebElement myPageButton;

    //我的页面标题
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"マイページ\"]")
    WebElement myPageTitle;

    // 注册和登陆按钮
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"新規登録・ログイン\"]")
    WebElement newRegisterAndLoginButton;

    // 登陆页面标题
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"ログイン\"])[1]")
    WebElement loginPage;


    //登陆的email field
    @iOSXCUITFindAll({
            @iOSXCUITBy(className = "XCUIElementTypeTextField"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeTextField[@value=\"email@example.com\"]")
    })
    WebElement loginEmailField;

    //登陆的password field
    @iOSXCUITFindAll({
            @iOSXCUITBy(className = "XCUIElementTypeSecureTextField"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeSecureTextField[@value=\"必須\"]")
    })
    WebElement loginPasswordField;

    //粘贴按钮
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ペースト\"]")
    WebElement pasteButton;

    //登陆按钮
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ログイン\"]")
    WebElement loginButton;

    //登陆成功后的用户ID
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, \"ID: \")]")
    WebElement userId;


    public void skipDisplayed(){
        skip.isDisplayed();
    }

    public void clicksSkipButton(){
        skip.click();
    }

    public boolean locationTipsDisplayed(){
        waitElement(completed,3);
        return completed.isDisplayed();
    }

    public void clicksCompleted(){
        completed.click();
    }

    public void clicksTipBoxCloseButton(){
        try {
            tipBoxCloseButton.click();
        }catch (Exception e){
            System.out.println("WebElement does not exist");
        }

    }

    public String getTitleText(){
        return title.getDomAttribute("name");
    }

    public void homeSearchButtonDisplayed(){
        homeSearchButton.isDisplayed();
    }

    public void clicksMyPageButton(){
        myPageButton.click();
    }

    public boolean newRegisterAndLoginButtonDisplayed(){
        return newRegisterAndLoginButton.isDisplayed();
    }

    public void clicksNewRegisterAndLoginButton(){
        newRegisterAndLoginButton.click();
    }

    public boolean loginPageDisplayed(){
        return loginPage.isDisplayed();
    }

    public void typeLoginEmailField(String email){
        loginEmailField.clear();
        loginEmailField.sendKeys(email);
    }

    public void typeLoginPasswordField(String password){
        loginPasswordField.click();
        loginPasswordField.clear();
        ((IOSDriver) driver).setClipboardText(password);
        GeneralMethods.longPress(driver,loginPasswordField,2);
        pasteButton.click();

    }

    public void clicksLoginButton(){
        loginButton.click();
    }

    public String getUserId(){
        return userId.getText();
    }

    public HKMoviePage(AppiumDriver driver) {
        super(driver);
    }
}
