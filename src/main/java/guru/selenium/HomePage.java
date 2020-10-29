package guru.selenium;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import guru.selenium.product.categories.PhoneCategoryPage;
import guru.selenium.product.categories.ProductCategoryPage;
import guru.selenium.product.categories.TVCategoryPage;

import static com.codeborne.selenide.Selenide.*;


public class HomePage extends BasePage {

    private SelenideElement mobileLink = $(".nav-1 a");
    private SelenideElement tvLink = $(".nav-2 a");
    private SelenideElement accountLink = $(".skip-account");
    private ElementsCollection accountLinks = $$("#header-account a");

    public PhoneCategoryPage clickMobileLink() {
        mobileLink.click();
        return page(PhoneCategoryPage.class);
    }

    public TVCategoryPage clickTVLink() {
        tvLink.click();
        return page(TVCategoryPage.class);
    }

    public LoginPage goToMyAccount() {
        accountLink.click();
        accountLinks.findBy(Condition.text("My Account")).click();
        return page(LoginPage.class);
    }
}