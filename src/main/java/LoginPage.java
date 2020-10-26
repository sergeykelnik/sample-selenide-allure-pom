import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;

    private By login = By.name("uid");
    private By password = By.name("password");
    private By submit = By.name("btnLogin");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WelcomePage LoginAsUser(String uid, String pass) {
        driver.findElement(login).sendKeys(uid);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submit).click();
        return new WelcomePage(driver);
    }
}
