package guru.selenium;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    private ElementsCollection phoneTitles = $$(".product-name a");
    private SelenideElement pageHeader = $("h1");

    public ElementsCollection getPhoneList() {
        return phoneTitles;
    }

    public String getPageTitle() {
        return title();
    }

    public String getPageHeaderMessage() {
        return pageHeader.getText();
    }
}
