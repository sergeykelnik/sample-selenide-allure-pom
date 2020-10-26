import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {

    private WebDriver driver;

    private By mobileLink = By.cssSelector(".nav-1 a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String returnPageTitle() {
        return driver.getTitle();
    }

    public MobilePage clickMobileLink() {
        driver.findElement(mobileLink).click();
        return new MobilePage(driver);
    }
}