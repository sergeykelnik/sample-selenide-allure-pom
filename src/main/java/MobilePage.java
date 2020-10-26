import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MobilePage {

    WebDriver driver;

    private By sortByButtons = By.cssSelector(".sort-by select");
    private By phoneTitles = By.cssSelector(".product-name a");
    private By sonyPrice = By.cssSelector("#product-price-1");
    private By iphonePrice = By.cssSelector("#product-price-2");
    private By galaxyPrice = By.cssSelector("#product-price-3");
    private By sonyLink = By.cssSelector(".product-name a[title='Sony Xperia']");
    private By iphoneLink = By.cssSelector(".product-name a[title='IPhone']");
    private By galaxyLink = By.cssSelector(".product-name a[title='Samsung Galaxy']");

    public MobilePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void sortByName() {
        WebElement sortableElement = driver.findElements(sortByButtons).get(0);
        Select select = new Select(sortableElement);
        select.selectByVisibleText("Name");
    }

    public List<WebElement> getPhoneList() {
        List<WebElement> webElements = driver.findElements(phoneTitles);
        return webElements;
    }

    public String getPhonePrice(String name) throws NoSuchElementException {
        if (name.equalsIgnoreCase("sony")) {
            return driver.findElement(sonyPrice).getText();
        } else if (name.equalsIgnoreCase("iphone")) {
            return driver.findElement(iphonePrice).getText();
        } else if (name.equalsIgnoreCase("galaxy")) {
            return driver.findElement(galaxyPrice).getText();
        } else {
            throw new NoSuchElementException("Wrong phone name");
        }
    }

    public PhonePage getPhoneLink(String name) {
        if (name.equalsIgnoreCase("sony")) {
            driver.findElement(sonyLink).click();
            return new PhonePage(driver);
        } else if (name.equalsIgnoreCase("iphone")) {
            driver.findElement(iphoneLink).click();
            return new PhonePage(driver);
        } else if (name.equalsIgnoreCase("galaxy")) {
            driver.findElement(galaxyLink).click();
            return new PhonePage(driver);
        } else {
            throw new NoSuchElementException("Wrong phone name");
        }
    }
}
