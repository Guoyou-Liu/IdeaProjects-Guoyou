package gt.org.runner;
import gt.org.reports.ReportGenerator;
import gt.org.utils.AppiumServerGui;
import gt.org.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"gt.org.steps","gt.org.hooks"},
        plugin = {"pretty",
                "html:target/reports/index.html",
                "json:target/reports/cucumber-report.json",
                "junit:target/cucumber-reports/cucumber.xml"
        }
        ,tags = "@HKMovie"
)

public class TestRunner extends AbstractTestNGCucumberTests {

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
        public void setUp() throws IOException, InterruptedException {
                if (AppiumServerGui.isAppiumServicePortOccupied("4723")){
                        AppiumServerGui.closeAppiumService("4723");
                }
                AppiumServerGui.startAppiumService("4723");
                DriverManager.getDriver();
        }
        @AfterSuite
        public void tearDown() throws IOException, InterruptedException {
                ReportGenerator reportGenerator = new ReportGenerator();
                reportGenerator.generateReport();
                DriverManager.quitDriver();
                if (AppiumServerGui.isAppiumServicePortOccupied("4723")){
                        AppiumServerGui.closeAppiumService("4723");
                        AppiumServerGui.closeTerminalWindows();
                }
        }


}
