package guru.selenium.product.categories;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import guru.selenium.ComparePopUp;
import guru.selenium.ShoppingCart;
import guru.selenium.product.details.PhoneDetailsPage;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.*;

public class PhoneCategoryPage extends ProductCategoryPage {

    private SelenideElement sonyPrice = $("#product-price-1");
    private SelenideElement iphonePrice = $("#product-price-2");
    private SelenideElement galaxyPrice = $("#product-price-3");

    private SelenideElement sonyLink = $(".product-name a[title='Sony Xperia']");
    private SelenideElement iphoneLink = $(".product-name a[title='IPhone']");
    private SelenideElement galaxyLink = $(".product-name a[title='Samsung Galaxy']");

    private SelenideElement sonyBuyButton = $("a[title='Xperia']+div .actions [type='button']");
    private SelenideElement iphoneBuyButton = $("a[title='IPhone']+div .actions [type='button']");
    private SelenideElement galaxyBuyButton = $("a[title='Samsung Galaxy']+div .actions [type='button']");

    private SelenideElement sonyCompareButton = $("a[title='Xperia']+div .actions [type='button']+.add-to-links .link-compare");
    private SelenideElement iphoneCompareButton = $("a[title='IPhone']+div .actions [type='button']+.add-to-links .link-compare");
    private SelenideElement galaxyCompareButton = $("a[title='Samsung Galaxy']+div .actions [type='button']+.add-to-links .link-compare");

    @Override
    public void sortBy(String type) {
        super.sortBy(type);
    }

    public String getPrice(String name) throws NoSuchElementException {
        if (name.equalsIgnoreCase("sony")) {
            return sonyPrice.getText();
        } else if (name.equalsIgnoreCase("iphone")) {
            return iphonePrice.getText();
        } else if (name.equalsIgnoreCase("galaxy")) {
            return galaxyPrice.getText();
        } else {
            throw new NoSuchElementException("Wrong phone name");
        }
    }

    public PhoneDetailsPage getLink(String name) {
        if (name.equalsIgnoreCase("sony")) {
            sonyLink.click();
        } else if (name.equalsIgnoreCase("iphone")) {
            iphoneLink.click();
        } else if (name.equalsIgnoreCase("galaxy")) {
            galaxyLink.click();
        } else {
            throw new NoSuchElementException("Wrong phone name");
        }
        return page(PhoneDetailsPage.class);
    }

    public ShoppingCart clickBuyButton(String name) {
        if (name.equalsIgnoreCase("sony")) {
            sonyBuyButton.click();
        } else if (name.equalsIgnoreCase("iphone")) {
            iphoneBuyButton.click();
        } else if (name.equalsIgnoreCase("galaxy")) {
            galaxyBuyButton.click();
        } else {
            throw new NoSuchElementException("Wrong phone name");
        }
        return page(ShoppingCart.class);
    }

    public ComparePopUp compareTwoItems(String name1, String name2, String name3) {
        addItemToCompare(name1);
        addItemToCompare(name2);
        addItemToCompare(name3);
        compareAll();
        switchTo().window("Products Comparison List - Magento Commerce");
        return page(ComparePopUp.class);
    }

    public void addItemToCompare(String name) {
        if (name.equalsIgnoreCase("sony")) {
            sonyCompareButton.click();
        } else if (name.equalsIgnoreCase("iphone")) {
            iphoneCompareButton.click();
        } else if (name.equalsIgnoreCase("galaxy")) {
            galaxyCompareButton.click();
        } else {
            if (!name.isEmpty()) {
                throw new NoSuchElementException("Wrong phone name");
            }
        }
    }
}
