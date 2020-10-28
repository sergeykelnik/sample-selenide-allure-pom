package guru.selenium.utils;

import guru.selenium.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestListener extends BaseTest implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(getTestMethodName(iTestResult) + " started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(getTestMethodName(iTestResult) + " succeed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //takeScreenshot();
        System.out.println(getTestMethodName(iTestResult) + " failed");
    }
}