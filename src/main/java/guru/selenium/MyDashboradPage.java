package guru.selenium;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MyDashboradPage extends BasePage {

    private SelenideElement successMessage = $(".success-msg");

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
