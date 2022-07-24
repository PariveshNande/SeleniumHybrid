package com.movie.hybridframework.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    @Override
    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "Test-Report" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter("src/test-reports/" + reportName);
        try {
            sparkReporter.loadXMLConfig("src/test/resources/extent-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("hostName", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "parivesh");

        sparkReporter.config().setDocumentTitle("E-Movies Test Project");
        sparkReporter.config().setReportName("Functional Test Report");
        sparkReporter.config().setTheme(Theme.DARK);
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        logger = extent.createTest(tr.getName());
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        logger = extent.createTest(tr.getName());
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

        String screenShotPath = "src/test-reports/screenshots" + tr.getName() + ".png";
        File f = new File(screenShotPath);
        if (f.exists()) {
            try {
                logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(screenShotPath));
            } catch (Exception e) {
                System.out.println(String.format("%s", e.getMessage()));
            }
        }

    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        logger = extent.createTest(tr.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
    }

    @Override
    public void onFinish(ITestContext testContext) {
        extent.flush();
    }
}
