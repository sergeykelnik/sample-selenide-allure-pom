package guru.selenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCart extends BasePage {

    private SelenideElement qtyField = $(".product-cart-actions input");
    private SelenideElement qtyUpdateButton = $(".product-cart-actions button");
    private SelenideElement errorMessageTop = $(".error-msg");
    private SelenideElement errorMessageItem = $(".item-msg.error");
    private SelenideElement emptyCartButton = $("[value='empty_cart']");


    public void updateQtyTo(String qty) {
        qtyField.setValue(qty);
        qtyUpdateButton.click();
    }

    public String getErrorMessageTop() {
        return errorMessageTop.getText();
    }

    public String getErrorMessageItem() {
        return errorMessageItem.getText();
    }

    public void emptyCart() {
        emptyCartButton.click();
    }
}
