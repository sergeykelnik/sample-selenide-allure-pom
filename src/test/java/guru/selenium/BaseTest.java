package guru.selenium;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

import static com.codeborne.selenide.Browsers.*;
import static com.codeborne.selenide.Configuration.baseUrl;

public class BaseTest {

    @Parameters({"browser"})
    @BeforeSuite
    public void initiateDriver(@Optional("Chrome") String browser) {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.reportsFolder = "target/surefire-reports/screenshots";
        Configuration.savePageSource = false;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
        baseUrl = "http://live.demoguru99.com/index.php/";
        if (browser.equalsIgnoreCase("Chrome")) {
            Configuration.browser = CHROME;
            //Configuration.remote = "http:localhost:4444/wd/hub";
        } else if (browser.equalsIgnoreCase("Firefox")) {
            Configuration.browser = FIREFOX;
            //Configuration.remote = "http:localhost:4444/wd/hub";
        } else if (browser.equalsIgnoreCase("Opera")) {
            Configuration.browser = OPERA;
            //Configuration.remote = "http:localhost:4444/wd/hub";
        } else if (browser.equalsIgnoreCase("Edge")) {
            Configuration.browser = EDGE;
        } else if (browser.equalsIgnoreCase("IE")) {
            System.setProperty("wdm.architecture", "X32");
            Configuration.browser = IE;
        }
    }

    /*String USERNAME = "pecebbevse1";
    String AUTOMATE_KEY = "RCm2s4XXRqLTEsCdbfMh";
    String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Parameters({"browser"})
    @BeforeClass
    public void setup(String OSAndBrowser) throws MalformedURLException {
        if (OSAndBrowser.equalsIgnoreCase("Chrome")) {
            DesiredCapabilities caps = new DesiredCapabilities();

            driver = new RemoteWebDriver(new URL(URL), caps);
        } else if (OSAndBrowser.equalsIgnoreCase("Safari")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            driver = new RemoteWebDriver(new URL(URL), capabilities);
        } else if (OSAndBrowser.equalsIgnoreCase("Firefox")) {
            DesiredCapabilities caps = new DesiredCapabilities();

            driver = new RemoteWebDriver(new URL(URL), caps);
        } else if (OSAndBrowser.equalsIgnoreCase("IE11")) {
            DesiredCapabilities caps = new DesiredCapabilities();

            driver = new RemoteWebDriver(new URL(URL), caps);
        }
    }*/
}