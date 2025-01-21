package gt.org.hook;

import gt.org.runner.TestRunner;
import gt.org.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {
    private final AppiumDriver driver;

    public Hooks() {
        this.driver = DriverManager.getDriver();
    }

    @AfterStep
    public void ScreenshotOnScenarioFailed(@NotNull Scenario scenario)  {
        if (scenario.isFailed()) {
            byte[] screenshot = TestRunner.takeScreenshot(driver);

            scenario.attach(screenshot, "image/png", "Failed Screenshot");

            TestRunner.saveScreenshotToFile(screenshot, "target/screenshots/failed/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"))  + "-" + scenario.getName() + ".png");
        }
    }

    @After
    public void restartAppOnScenarioFailed(@NotNull Scenario scenario){
        if (scenario.isFailed()){
            System.out.println("Scenario failed, restarting the app...\n");
            DriverManager.restartApp();
        }
    }
}