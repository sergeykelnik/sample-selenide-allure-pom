import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    WelcomePage welcomePage;

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://www.demo.guru99.com/V4/");
        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "LoginCredentialsAndResults")
    public Object[][] getDataFromDataprovider() {
        return new Object[][]
                {
                        {"invalid", "hYpEzAd"},
                        {"mngr291903", "invalid"},
                };

    }

    @Test(dataProvider = "LoginCredentialsAndResults")
    private void LoginNegative(String user, String password) {
        welcomePage = loginPage.LoginAsUser(user, password);
        Assert.assertEquals(welcomePage.getAlertMessage(), "User or Password is not valid");
        welcomePage.acceptAlert();
    }

    @Test
    private void LoginPositive() {
        welcomePage = loginPage.LoginAsUser("mngr291903", "Egahyru");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(welcomePage.getWelcomeText(), "Welcome To Manager's Page of Guru99 Bank");
        welcomePage.takePageScreenshot();
        softAssert.assertEquals(welcomePage.getPageTitle(), "Guru99 Bank Manager HomePage");
        softAssert.assertAll();
    }
}
