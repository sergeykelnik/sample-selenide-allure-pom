package guru.selenium.product.categories;

import com.codeborne.selenide.SelenideElement;
import guru.selenium.WishListPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class TVCategoryPage extends ProductCategoryPage {

    private SelenideElement lgWishListButton = $("a[title='LG LCD']+div .actions [type='button']+.add-to-links .link-wishlist");
    private SelenideElement samsungWishListButton = $("a[title='Samsung LCD']+div .actions [type='button']+.add-to-links .link-wishlist");

    public WishListPage addItemToWishList(String name) {
        if (name.equalsIgnoreCase("lg")) {
            lgWishListButton.click();
        } else if (name.equalsIgnoreCase("samsung")) {
            samsungWishListButton.click();
        }
        return page(WishListPage.class);
    }

}
