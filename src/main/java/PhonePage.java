import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PhonePage {
    WebDriver driver;

    private By phonePrice = By.cssSelector(".price");

    public PhonePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPhonePrice() {
        return driver.findElement(phonePrice).getText();
    }
}
