package guru.selenium;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class HomePage extends BasePage {

    private SelenideElement mobileLink = $(".nav-1 a");

    public MobilePage clickMobileLink() {
        mobileLink.click();
        return page(MobilePage.class);
    }
}