package guru.selenium;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private SelenideElement createAccountButton = $("[title='Create an Account']");

    public CreateAccountPage clickNewAccountButton() {
        createAccountButton.click();
        return page(CreateAccountPage.class);
    }
}
