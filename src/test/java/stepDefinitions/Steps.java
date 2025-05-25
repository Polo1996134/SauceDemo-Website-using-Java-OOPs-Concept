package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.time.Duration;

public class Steps {
    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    LogoutPage logoutPage;

    @Given("User is on login page")
    public void openLoginPage() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
    }

    @When("User logs in with valid credentials")
    public void login() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("User should be redirected to products page")
    public void verifyProductsPage() {
        productPage = new ProductPage(driver);
        assert productPage.isOnProductsPage();
    }

    @When("User adds a product to the cart")
    public void addToCart() {
        productPage.addProductToCart();
        productPage.goToCart();
        cartPage = new CartPage(driver);
    }

    @Then("Product should be visible in cart")
    public void verifyCart() {
        assert cartPage.isProductInCart();
    }

	/*
	 * @When("User logs out") public void logout() { logoutPage = new
	 * LogoutPage(driver); logoutPage.logout(); }
	 * 
	 * @Then("User should be back on login page") public void backToLogin() { assert
	 * driver.getCurrentUrl().contains("saucedemo.com"); driver.quit(); }
	 */
}