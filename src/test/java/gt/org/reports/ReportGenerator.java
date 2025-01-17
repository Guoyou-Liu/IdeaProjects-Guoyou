package gt.org.reports;

import gt.org.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReportGenerator{
    private final AppiumDriver driver;

    public ReportGenerator() {
        this.driver = DriverManager.getDriver();
    }
    public void generateReport(){
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/reports/cucumber-report.json");
        String buildNumber = "V1.0";
        String projectName="Guoyou Automation Reports";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);
        String platform = driver.getCapabilities().getCapability("platformName").toString();
        String version = driver.getCapabilities().getCapability("platformVersion").toString();
        String device = "";
        if (Objects.equals(System.getProperty("platform"), "Android")){
            device = driver.getCapabilities().getCapability("avd").toString();
        }if (Objects.equals(System.getProperty("platform"), "iOS")){
            device = driver.getCapabilities().getCapability("deviceName").toString();
        }
        configuration.addClassifications("Platform",platform);
        configuration.addClassifications("Version",version);
        configuration.addClassifications("deviceName",device);
        configuration.setSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles,configuration);
        reportBuilder.generateReports();
    }
}
