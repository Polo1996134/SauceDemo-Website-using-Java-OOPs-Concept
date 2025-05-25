package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "title") WebElement title;
    @FindBy(id = "add-to-cart-sauce-labs-backpack") WebElement addToCart;
    @FindBy(className = "shopping_cart_link") WebElement cartIcon;

    public boolean isOnProductsPage() {
        return title.getText().equals("Products");
    }

    public void addProductToCart() {
        addToCart.click();
    }

    public void goToCart() {
        cartIcon.click();
    }
}