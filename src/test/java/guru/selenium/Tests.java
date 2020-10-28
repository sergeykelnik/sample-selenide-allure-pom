package guru.selenium;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Configuration.baseUrl;

public class Tests extends BaseTest {

    private HomePage homePage;
    private MobilePage mobilePage;
    private PhonePage phonePage;
    private ShoppingCart shoppingCart;
    private ComparePopUp comparePopUp;

    @BeforeMethod
    public void beforeMethod() {
        clearBrowserCookies();
        homePage = open(baseUrl, HomePage.class);
    }

    //@Ignore
    @Test(priority = 1)
    public void day1Test() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getPageTitle(), "Home page");
        mobilePage = homePage.clickMobileLink();
        softAssert.assertEquals(mobilePage.getPageTitle(), "Mobile");
        mobilePage.sortByName();
        softAssert.assertEquals(mobilePage.getPhoneList().get(0).getText(), "IPHONE");
        softAssert.assertEquals(mobilePage.getPhoneList().get(1).getText(), "SAMSUNG GALAXY");
        softAssert.assertEquals(mobilePage.getPhoneList().get(2).getText(), "SONY XPERIA");
        softAssert.assertAll();
    }

    //@Ignore
    @Test(priority = 2)
    public void day2Test() {
        mobilePage = homePage.clickMobileLink();
        String priceOnMobilePage = mobilePage.getPhonePrice("iphone");
        phonePage = mobilePage.getPhoneLink("iphone");
        String priceOnPhonePage = phonePage.getPhonePrice();
        Assert.assertEquals(priceOnMobilePage, priceOnPhonePage);
        System.out.println(priceOnMobilePage + " equals to " + priceOnPhonePage);
    }

    //@Ignore
    @Test(priority = 3)
    public void day3Test() {
        mobilePage = homePage.clickMobileLink();
        shoppingCart = mobilePage.clickBuyButton("sony");
        shoppingCart.updateQtyTo("1000");
        SoftAssert softAssert = new SoftAssert();
        String errorMessageTop = shoppingCart.getErrorMessageTop();
        String errorMessageItem = shoppingCart.getErrorMessageItem();
        softAssert.assertEquals(errorMessageTop, "Some of the products cannot be ordered in requested quantity.");
        softAssert.assertEquals(errorMessageItem, "* The maximum quantity allowed for purchase is 500.");
        shoppingCart.emptyCart();
        String pageHeaderMessage = shoppingCart.getPageHeaderMessage();
        softAssert.assertEquals(pageHeaderMessage, "SHOPPING CART IS EMPTY");
        softAssert.assertAll();
    }

    //@Ignore
    @Test(priority = 4)
    public void day4Test() {
        mobilePage = homePage.clickMobileLink();
        comparePopUp = mobilePage.compareTwoPhones("sony", "iphone", "");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(comparePopUp.getPageHeaderMessage(), "COMPARE PRODUCTS");
        softAssert.assertEquals(comparePopUp.getPhoneList().get(0).getText(), "SONY XPERIA");
        softAssert.assertEquals(comparePopUp.getPhoneList().get(1).getText(), "IPHONE~");
        softAssert.assertAll();
    }
}
