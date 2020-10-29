package guru.selenium;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.*;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Configuration.baseUrl;

public abstract class BaseTest {

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browser) {
        Configuration.browserSize = "1920x1080";
        baseUrl = "http://live.demoguru99.com/";
        if (browser.equalsIgnoreCase("Chrome")) {
            Configuration.browser = "firefox";
            //WebDriverManager.chromedriver().setup();
            //WebDriverRunner.setWebDriver(new ChromeDriver());
            //WebDriverRunner.getWebDriver().manage().window().maximize();

        } else if (browser.equalsIgnoreCase("Firefox")) {
            Configuration.browser = "firefox";
            //WebDriverManager.firefoxdriver().setup();
            //WebDriverRunner.setWebDriver(new FirefoxDriver());
            //WebDriverRunner.getWebDriver().manage().window().maximize();

        } else if (browser.equalsIgnoreCase("Edge")) {
            //WebDriverManager.edgedriver().setup();
            //WebDriverRunner.setWebDriver(new EdgeDriver());
            //WebDriverRunner.getWebDriver().manage().window().maximize();

        } else if (browser.equalsIgnoreCase("Opera")) {
            //WebDriverManager.operadriver().setup();
            //WebDriverRunner.setWebDriver(new OperaDriver());
            //WebDriverRunner.getWebDriver().manage().window().maximize();

        } else if (browser.equalsIgnoreCase("IE")) {
            //WebDriverManager.iedriver().arch32();
            //WebDriverManager.iedriver().setup();
            //WebDriverRunner.setWebDriver(new InternetExplorerDriver());
            //WebDriverRunner.getWebDriver().manage().window().maximize();
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

    /*@AfterClass
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }*/
}