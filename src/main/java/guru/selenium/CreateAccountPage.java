package guru.selenium;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CreateAccountPage {

    private SelenideElement fistname = $("#firstname");
    private SelenideElement middlename = $("#middlename");
    private SelenideElement lastname = $("#lastname");
    private SelenideElement email_address = $("#email_address");
    private SelenideElement password = $("#password");
    private SelenideElement password_confirmation = $("#confirmation");
    private SelenideElement subscribe = $("[type='checkbox']");
    private SelenideElement register = $(".buttons-set [title='Register']");

    public MyDashboradPage fillOutRegistrationForm(String firstname, String middlename, String lastname, String email_address, String password, boolean subscribe) {
        this.fistname.setValue(firstname);
        this.middlename.setValue(middlename);
        this.lastname.setValue(lastname);
        this.email_address.setValue(email_address);
        this.password.setValue(password);
        this.password_confirmation.setValue(password);
        this.subscribe.setSelected(subscribe);
        register.click();
        return page(MyDashboradPage.class);
    }
}
