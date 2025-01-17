package gt.org.utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;


public class DriverManager {
    private static AppiumDriver driver;
    private static AndroidDriver androidDriver;
    private static IOSDriver iosDriver;
    public static void getAndroidDriver(){
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:noReset", false);
            caps.setCapability("appium:automationName","UiAutomator2");
            caps.setCapability("appium:platformName","Android");
            caps.setCapability("appium:platformVersion","13.0");
            caps.setCapability("appium:avd","Pixel_7_API_33");
            caps.setCapability("appium:app","/Users/liuguoyou/Downloads/Storellet_4023303.apk");
            caps.setCapability("appium:appPackage","com.storellet");
            caps.setCapability("appium:appActivity","com.storellet.v3.basement.activity.SplashActivity");
            caps.setCapability("appium:autoGrantPermissions",true);
            caps.setCapability("appium:fullReset",false);
            try {
                androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
                androidDriver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 500);
                driver = androidDriver;
            } catch (MalformedURLException e){
                e.printStackTrace();
            }
    }

    public static void getIOSDriver(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:noReset", false);
        caps.setCapability("appium:automationName","XCUITest");
        caps.setCapability("appium:platformName","iOS");
        caps.setCapability("appium:platformVersion","17.0");
        caps.setCapability("appium:deviceName","iPhone 15 Pro Max");
        caps.setCapability("appium:app","/Users/liuguoyou/Downloads/HKMovie_2_7_9.app");
        caps.setCapability("appium:appPackage","com.hkmovie6.eigaland");
        caps.setCapability("appium:autoAcceptAlerts",true);
        caps.setCapability("appium:fullReset",false);
        try {
            iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
            iosDriver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 500);
            driver = iosDriver;
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
    }
    public static AppiumDriver getDriver(){
        if (driver == null){
            if (Objects.equals(System.getProperty("platform"), "Android")){
                DriverManager.getAndroidDriver();
            }if (Objects.equals(System.getProperty("platform"), "iOS")) {
                    DriverManager.getIOSDriver();
            }
        }
        return driver;
    }

    public static void restartApp(){
        if (driver != null){
            if (Objects.equals(System.getProperty("platform"), "Android")){
                androidDriver.terminateApp(driver.getCapabilities().getCapability("appium:appPackage").toString());
                androidDriver.activateApp(driver.getCapabilities().getCapability("appium:appPackage").toString());
            }if (Objects.equals(System.getProperty("platform"), "iOS")){
                iosDriver.terminateApp(driver.getCapabilities().getCapability("appium:appPackage").toString());
                iosDriver.activateApp(driver.getCapabilities().getCapability("appium:appPackage").toString());
            }
        }
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}
