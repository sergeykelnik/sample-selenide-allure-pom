import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCart extends BasePage {

    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    private By qtyField = By.cssSelector(".product-cart-actions input");
    private By qtyUpdateButton = By.cssSelector(".product-cart-actions button");
    private By errorMessageTop = By.cssSelector(".error-msg");
    private By errorMessageItem = By.cssSelector(".item-msg.error");
    private By emptyCartButton = By.cssSelector("[value='empty_cart']");


    public void updateQtyTo(String qty) {
        driver.findElement(qtyField).sendKeys(qty);
        driver.findElement(qtyUpdateButton).click();
    }

    public String getErrorMessageTop() {
        return driver.findElement(errorMessageTop).getText();
    }

    public String getErrorMessageItem() {
        return driver.findElement(errorMessageItem).getText();
    }

    public void emptyCart() {
        driver.findElement(emptyCartButton).click();
    }
}
