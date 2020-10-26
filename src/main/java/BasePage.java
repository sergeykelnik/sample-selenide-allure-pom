import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private By phoneTitles = By.cssSelector(".product-name a");
    private By pageHeader = By.cssSelector("h1");

    public List<WebElement> getPhoneList() {
        List<WebElement> webElements = driver.findElements(phoneTitles);
        return webElements;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageHeaderMessage() {
        return driver.findElement(pageHeader).getText();
    }
}
