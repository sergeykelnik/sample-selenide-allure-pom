package guru.selenium;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.*;

public class MobilePage extends BasePage {

    private ElementsCollection sortByButtons = $$(".sort-by select");
    private SelenideElement compareAllButton = $("button[title='Compare']");

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

    public void sortByName() {
        sortByButtons.first().selectOptionContainingText("Name");
    }

    public String getPhonePrice(String name) throws NoSuchElementException {
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

    public PhonePage getPhoneLink(String name) {
        if (name.equalsIgnoreCase("sony")) {
            sonyLink.click();
            return page(PhonePage.class);
        } else if (name.equalsIgnoreCase("iphone")) {
            iphoneLink.click();
            return page(PhonePage.class);
        } else if (name.equalsIgnoreCase("galaxy")) {
            galaxyLink.click();
            return page(PhonePage.class);
        } else {
            throw new NoSuchElementException("Wrong phone name");
        }
    }

    public ShoppingCart clickBuyButton(String name) {
        if (name.equalsIgnoreCase("sony")) {
            sonyBuyButton.click();
            return page(ShoppingCart.class);
        } else if (name.equalsIgnoreCase("iphone")) {
            iphoneBuyButton.click();
            return page(ShoppingCart.class);
        } else if (name.equalsIgnoreCase("galaxy")) {
            galaxyBuyButton.click();
            return page(ShoppingCart.class);
        } else {
            throw new NoSuchElementException("Wrong phone name");
        }
    }

    public ComparePopUp compareTwoPhones(String name1, String name2, String name3) {
        addPhoneToCompare(name1);
        addPhoneToCompare(name2);
        addPhoneToCompare(name3);
        compareAllButton.click();
        switchTo().window("Products Comparison List - Magento Commerce");
        return page(ComparePopUp.class);
    }

    private void addPhoneToCompare(String name) {
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