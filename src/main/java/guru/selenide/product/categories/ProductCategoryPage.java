package guru.selenide.product.categories;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import guru.selenide.BasePage;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.*;

public class ProductCategoryPage extends BasePage {

    private ElementsCollection sortByButtons = $$(".sort-by select");
    private SelenideElement compareAllButton = $("button[title='Compare']");

    public void sortBy(String type) {
        if (type.equalsIgnoreCase("Name")) {
            sortByButtons.first().selectOptionContainingText("Name");
        } else if (type.equalsIgnoreCase("Position")) {
            sortByButtons.first().selectOptionContainingText("Position");
        } else if (type.equalsIgnoreCase("Price")) {
            sortByButtons.first().selectOptionContainingText("Price");
        } else {
            throw new NoSuchElementException("Wrong sorting type");
        }
    }

    public void compareAll() {
        compareAllButton.click();
    }
}