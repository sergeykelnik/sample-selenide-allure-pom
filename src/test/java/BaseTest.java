import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            System.setProperty("wdm.architecture", "X32");
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else throw new NoSuchElementException("Wrong browser parameter");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            /*System.setProperty("wdm.architecture", "X32");
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            //System.setProperty("webdriver.gecko.driver", "D:\\Guru99\\bin\\geckodriver.exe");
            //driver = new FirefoxDriver();
            //System.setProperty("webdriver.chrome.driver", "D:\\Guru99\\bin\\chromedriver.exe");
            //driver = new ChromeDriver();
            //System.setProperty("webdriver.edge.driver", "D:\\Guru99\\bin\\msedgedriver.exe");
            //driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
    }

    /*@Parameters({"Port"})
    @BeforeClass
    public void initiateDriver(String Port) throws MalformedURLException {
        if (Port.equalsIgnoreCase("9002")) {
            driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.chrome());
            driver.manage().window().maximize();
        } else if (Port.equalsIgnoreCase("9003")) {
            driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.firefox());
            driver.manage().window().maximize();
        } else {
            driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.operaBlink());
            driver.manage().window().maximize();
        }
    }*/

    /*@Parameters({"OSAndBrowser"})
    @BeforeClass
    public void setup(String OSAndBrowser) throws MalformedURLException {
        if (OSAndBrowser.equalsIgnoreCase("OSX")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os", "OS X");
            caps.setCapability("os_version", "Catalina");
            caps.setCapability("browser", "Safari");
            caps.setCapability("browser_version", "13");
            caps.setCapability("name", "Safari Test");
            caps.setCapability("browserstack.console", "errors");
            caps.setCapability("browserstack.networkLogs", "true");
            driver = new RemoteWebDriver(new URL(URL), caps);
        } else if (OSAndBrowser.equalsIgnoreCase("WIN10")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("browser", "IE");
            caps.setCapability("browser_version", "11");
            caps.setCapability("name", "IE11 Test");
            caps.setCapability("browserstack.console", "errors");
            caps.setCapability("browserstack.networkLogs", "true");
            driver = new RemoteWebDriver(new URL(URL), caps);
        } else if (OSAndBrowser.equalsIgnoreCase("IPAD")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "iPhone");
            caps.setCapability("device", "iPad 7th");
            caps.setCapability("realMobile", "true");
            caps.setCapability("os_version", "13");
            caps.setCapability("name", "IPAD Test");
            caps.setCapability("browserstack.console", "errors");
            caps.setCapability("browserstack.networkLogs", "true");
            driver = new RemoteWebDriver(new URL(URL), caps);
        } else if (OSAndBrowser.equalsIgnoreCase("CHROME")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "latest");
            caps.setCapability("name", "CHROME Test");
            caps.setCapability("browserstack.console", "errors");
            caps.setCapability("browserstack.networkLogs", "true");
            driver = new RemoteWebDriver(new URL(URL), caps);
        }
    }*/

    /*@Parameters({"OSAndBrowser"})
    @BeforeClass
    public void setup(String OSAndBrowser) throws MalformedURLException {
        if (OSAndBrowser.equalsIgnoreCase("OSX")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "Safari");
            capabilities.setCapability("browserVersion", "13.1");
            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("os", "OS X");
            browserstackOptions.put("osVersion", "Catalina");
            browserstackOptions.put("resolution", "1920x1080");
            browserstackOptions.put("local", "false");
            browserstackOptions.put("networkLogs", "true");
            browserstackOptions.put("seleniumVersion", "4.0.0-alpha-6");
            capabilities.setCapability("bstack:options", browserstackOptions);
            driver = new RemoteWebDriver(new URL(URL), capabilities);
        } else if (OSAndBrowser.equalsIgnoreCase("WIN7IE11")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "IE");
            capabilities.setCapability("browserVersion", "11.0");
            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("os", "Windows");
            browserstackOptions.put("osVersion", "7");
            browserstackOptions.put("resolution", "1920x1080");
            browserstackOptions.put("local", "false");
            browserstackOptions.put("seleniumVersion", "4.0.0-alpha-6");
            capabilities.setCapability("bstack:options", browserstackOptions);
            driver = new RemoteWebDriver(new URL(URL), capabilities);
        } else if (OSAndBrowser.equalsIgnoreCase("IPAD")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("osVersion", "14");
            browserstackOptions.put("deviceName", "iPad Pro 12.9 2020");
            browserstackOptions.put("realMobile", "true");
            browserstackOptions.put("local", "false");
            capabilities.setCapability("bstack:options", browserstackOptions);
            driver = new RemoteWebDriver(new URL(URL), capabilities);
        } else if (OSAndBrowser.equalsIgnoreCase("CHROME")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("browserVersion", "latest-beta");
            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("os", "Windows");
            browserstackOptions.put("osVersion", "10");
            browserstackOptions.put("resolution", "1920x1080");
            browserstackOptions.put("local", "false");
            browserstackOptions.put("networkLogs", "true");
            browserstackOptions.put("seleniumVersion", "4.0.0-alpha-6");
            capabilities.setCapability("bstack:options", browserstackOptions);
            driver = new RemoteWebDriver(new URL(URL), capabilities);
        }
    }*/

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}