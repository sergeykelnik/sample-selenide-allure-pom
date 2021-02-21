package guru.selenide;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.selenide.product.categories.PhoneCategoryPage;
import guru.selenide.product.categories.TVCategoryPage;
import guru.selenide.product.details.PhoneDetailsPage;
import guru.selenide.product.details.TVDetailsPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class Tests extends BaseTest {

    private HomePage homePage;
    private PhoneCategoryPage phoneCategoryPage;
    private TVCategoryPage tvCategoryPage;
    private PhoneDetailsPage phoneDetailsPage;
    private TVDetailsPage tvDetailsPage;
    private ShoppingCart shoppingCart;
    private ComparePopUp comparePopUp;
    private LoginPage loginPage;
    private CreateAccountPage createAccountPage;
    private MyDashboradPage myDashboradPage;
    private WishListPage wishListPage;

    Random random = new Random();
    int number = random.nextInt(100000);
    String randoms = String.format("%03d", number);

    @BeforeTest
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

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
        phoneCategoryPage = homePage.clickMobileLink();
        softAssert.assertEquals(phoneCategoryPage.getPageTitle(), "Mobile");
        phoneCategoryPage.sortBy("Name");
        sleep(1000);
        softAssert.assertEquals(phoneCategoryPage.getPhoneList().get(0).getText(), "IPHONE");
        softAssert.assertEquals(phoneCategoryPage.getPhoneList().get(1).getText(), "SAMSUNG GALAXY");
        softAssert.assertEquals(phoneCategoryPage.getPhoneList().get(2).getText(), "SONY XPERIA");
        softAssert.assertAll();
    }

    //@Ignore
    @Test(priority = 2)
    public void day2Test() {
        phoneCategoryPage = homePage.clickMobileLink();
        String priceOnMobilePage = phoneCategoryPage.getPrice("iphone");
        phoneDetailsPage = phoneCategoryPage.getLink("iphone");
        String priceOnPhonePage = phoneDetailsPage.getPhonePrice();
        Assert.assertEquals(priceOnMobilePage, priceOnPhonePage);
        System.out.println(priceOnMobilePage + " equals to " + priceOnPhonePage);
    }

    //@Ignore
    @Test(priority = 3)
    public void day3Test() {
        phoneCategoryPage = homePage.clickMobileLink();
        shoppingCart = phoneCategoryPage.clickBuyButton("sony");
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
        phoneCategoryPage = homePage.clickMobileLink();
        comparePopUp = phoneCategoryPage.compareTwoItems("sony", "iphone", "");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(comparePopUp.getPageHeaderMessage(), "COMPARE PRODUCTS");
        softAssert.assertEquals(comparePopUp.getPhoneList().get(0).getText(), "SONY XPERIA");
        softAssert.assertEquals(comparePopUp.getPhoneList().get(1).getText(), "IPHONE");
        switchTo().window("Mobile");
        softAssert.assertAll();
    }

    //@Ignore
    @Test(priority = 5)
    public void day5Test() {
        loginPage = homePage.goToMyAccount();
        createAccountPage = loginPage.clickNewAccountButton();
        myDashboradPage = createAccountPage.fillOutRegistrationForm(
                "Name",
                "Middlename",
                "Surname",
                "mail" + randoms + "@mail.ee",
                "123456",
                true);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(myDashboradPage.getSuccessMessage(), "Thank you for registering with Main Website Store.");
        tvCategoryPage = homePage.clickTVLink();
        wishListPage = tvCategoryPage.addItemToWishList("lg");
        wishListPage.clickShareWishList();
        wishListPage.fillOutSubmitWishList("galowor896@wpfoo.com", "Share message!");
        softAssert.assertEquals(wishListPage.getSuccessMessage(), "Your Wishlist has been shared.");
    }
}
