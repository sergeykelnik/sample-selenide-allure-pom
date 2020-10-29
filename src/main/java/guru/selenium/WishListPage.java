package guru.selenium;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WishListPage {
    private SelenideElement shareWishListButton = $(".btn-share");
    private SelenideElement email = $("#email_address");
    private SelenideElement message = $("#message");
    private SelenideElement submit = $("[title='Share Wishlist']");
    private SelenideElement successMessage = $(".success-msg");

    public void clickShareWishList() {
        shareWishListButton.click();
    }

    public void fillOutSubmitWishList(String email, String message) {
        this.email.setValue(email);
        this.message.setValue(message);
        submit.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
