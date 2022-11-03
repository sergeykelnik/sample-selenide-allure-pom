package guru.selenide;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Configuration.baseUrl;

public class BaseTest {

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(@Optional("chrome") String browser) {
        Configuration.startMaximized = true;
        baseUrl = "http://live.techpanda.org/";
        if (browser.equalsIgnoreCase("Chrome")) {
            Configuration.browser = CHROME;
            //WebDriverManager.chromedriver().setup();
            //WebDriverRunner.setWebDriver(new ChromeDriver());
            //WebDriverRunner.getWebDriver().manage().window().maximize();

        } else if (browser.equalsIgnoreCase("Firefox")) {
            Configuration.browser = FIREFOX;
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