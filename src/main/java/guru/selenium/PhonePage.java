package guru.selenium;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PhonePage {

    private SelenideElement phonePrice = $(".price");

    public String getPhonePrice() {
        return phonePrice.getText();
    }
}
