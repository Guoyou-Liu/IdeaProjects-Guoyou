package gt.org.page;

import gt.org.utils.GeneralMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SplashPage extends BasePage{
    @AndroidFindBy(xpath = "//*[@text='Close Message']")
    WebElement upgradeTipsCloseButton;
    public void clickUpgradeTipsCloseButton(){
        try {
            waitElement(upgradeTipsCloseButton,10);
            if (upgradeTipsCloseButton.isDisplayed()){
                upgradeTipsCloseButton.click();
            }
        }catch (Exception e){
            System.out.println("WebElement does not exist");
        }
    }

    @AndroidFindBy(id = "com.storellet:id/intro_1_iv")
    WebElement introductionPage;
    public boolean introductionPageDisplayed(){
        waitElement(introductionPage,20);
        return introductionPage.isDisplayed();
    }


    @AndroidFindBy(id = "com.storellet:id/item_introduction_5_close")
    WebElement introductionPageCloseButton;
    public void clickIntroductionPageCloseButton(){
            while (true) {
                try {
                    introductionPageCloseButton.click();
                    break;
                } catch (Exception e) {
                    GeneralMethods.scrolling("left", 200);
                }
            }
    }

    @AndroidFindBy(id = "com.storellet:id/view_navigation_tutor_explore_bubble")
    WebElement homeGuide;
    public boolean homeGuideDisplayed(){
        return homeGuide.isDisplayed();
    }
    public void clickHomeGuide(){
        homeGuide.click();
    }

    @AndroidFindBy(id = "com.storellet:id/view_navigation_tutor_membership_bubble")
    WebElement exploreGuide;
    public boolean exploreGuideDisplayed(){
        return exploreGuide.isDisplayed();
    }
    public void clickexploreGuide(){
        exploreGuide.click();
    }

    @AndroidFindBy(id = "com.storellet:id/view_navigation_tutor_wallet_bubble")
    WebElement walletGuide;
    public boolean walletGuideDisplayed(){
        return walletGuide.isDisplayed();
    }
    public void clickWalletGuide(){
        walletGuide.click();
    }

    @AndroidFindBy(id = "com.storellet:id/view_navigation_tutor_me_bubble")
    WebElement accountGuide;
    public boolean accountGuideDisplayed(){
        return accountGuide.isDisplayed();
    }
    public void clickAccountGuide(){
        accountGuide.click();
    }

    @AndroidFindBy(id = "com.storellet:id/view_navigation_tutor_scanner_bubble")
    WebElement scannerGuide;
    public boolean scannerGuideDisplayed(){
        return scannerGuide.isDisplayed();
    }
    public void clickScannerGuide(){
        scannerGuide.click();
    }

    @AndroidFindBy(id = "com.storellet:id/view_navigation_tutor_notice_bubble")
    WebElement noticeGuide;
    public boolean noticeGuideDisplayed(){
        return noticeGuide.isDisplayed();
    }
    public void clickNoticeGuide(){
        noticeGuide.click();
    }

    @AndroidFindBy(id = "com.storellet:id/fragment_child_discover_feature_toolbar_logo_iv")
    WebElement homeLogo;
    public boolean homeLogoDisplayed(){
        return homeLogo.isDisplayed();
    }

    public SplashPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

}
