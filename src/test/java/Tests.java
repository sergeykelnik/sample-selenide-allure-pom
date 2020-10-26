import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tests extends BaseTest {

    HomePage homePage;
    MobilePage mobilePage;
    PhonePage phonePage;

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://live.demoguru99.com/index.php/");
    }

    @Test(priority = 0)
    public void day1Test() {
        homePage = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.returnPageTitle(), "Home page");
        mobilePage = homePage.clickMobileLink();
        softAssert.assertEquals(mobilePage.getPageTitle(), "Mobile");
        mobilePage.sortByName();
        softAssert.assertEquals(mobilePage.getPhoneList().get(0).getText(), "IPHONE");
        softAssert.assertEquals(mobilePage.getPhoneList().get(1).getText(), "SAMSUNG GALAXY");
        softAssert.assertEquals(mobilePage.getPhoneList().get(2).getText(), "SONY XPERIA");
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void day2Test() {
        homePage = new HomePage(driver);
        mobilePage = homePage.clickMobileLink();
        String priceOnMobilePage = mobilePage.getPhonePrice("iphone");
        phonePage = mobilePage.getPhoneLink("iphone");
        String priceOnPhonePage = phonePage.getPhonePrice();
        Assert.assertEquals(priceOnMobilePage, priceOnPhonePage);
        System.out.println(priceOnMobilePage + " equals to " + priceOnPhonePage);
    }
}
