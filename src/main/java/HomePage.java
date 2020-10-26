import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    private By mobileLink = By.cssSelector(".nav-1 a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public MobilePage clickMobileLink() {
        driver.findElement(mobileLink).click();
        return new MobilePage(driver);
    }
}