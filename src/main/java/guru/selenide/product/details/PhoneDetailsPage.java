package guru.selenide.product.details;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PhoneDetailsPage {

    private SelenideElement phonePrice = $(".price");

    public String getPhonePrice() {
        return phonePrice.getText();
    }
}
