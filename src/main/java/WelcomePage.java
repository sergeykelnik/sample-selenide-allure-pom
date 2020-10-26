import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class WelcomePage {

    WebDriver driver;

    private By welcomeText = By.cssSelector("marquee.heading3");

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void takePageScreenshot() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
            FileUtils.copyFile(scrFile, new File("target/resources/screenshot_" + timestamp + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getWelcomeText() {
        return driver.findElement(welcomeText).getText();
    }

    public String getPageTitle() {
        driver.findElement(welcomeText);
        return driver.getTitle();
    }
}