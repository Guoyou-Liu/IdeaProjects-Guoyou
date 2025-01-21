package gt.org.runner;
import gt.org.reports.ReportGenerator;
import gt.org.utils.AppiumServer;
import gt.org.utils.AppiumServerGui;
import gt.org.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.Getter;
import lombok.Setter;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Setter
@Getter
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"gt.org.steps","gt.org.hook"},
        plugin = {"pretty",
                "html:target/reports/index.html",
                "json:target/reports/cucumber-report.json",
                "junit:target/cucumber-reports/cucumber.xml"
        }
        ,tags = "@HKMovie"
)

public class TestRunner extends AbstractTestNGCucumberTests {
        private AppiumServer appiumServer = new AppiumServer();

        public static byte @NotNull [] takeScreenshot(AppiumDriver driver) {
                return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }

        public static void saveScreenshotToFile(byte[] screenshot, String filePath) {
                File file = new File(filePath);
                file.getParentFile().mkdirs();
                try (FileOutputStream outputFile = new FileOutputStream(file)) {
                        outputFile.write(screenshot);
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        @BeforeSuite
        public void startAppiumServer() {

                if (appiumServer.isAppiumServicePortOccupancy(4723)){
                        System.out.println("Appium Server Port occupied, Close port...");
                        appiumServer.stopAppiumService();
                }
                System.out.println("Appium Server Port start ...");
                appiumServer.startAppiumService(4723);

                DriverManager.getDriver();
        }
        @AfterSuite
        public void generateReportAndTearDown() {
                ReportGenerator reportGenerator = new ReportGenerator();
                reportGenerator.generateReport();
                System.out.println("All Scenario execution completed, quit the app...\n");
                DriverManager.quitDriver();

                if (appiumServer.isAppiumServicePortOccupancy(4723)){
                        System.out.println("Appium Server stopping...");
                        appiumServer.stopAppiumService();
                }
        }


}
