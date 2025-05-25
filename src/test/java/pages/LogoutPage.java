package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogoutPage {

    WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        driver.findElement(By.id("react-burger-menu-btn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for logout link to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));

        WebElement logout = driver.findElement(By.id("logout_sidebar_link"));

        // Scroll logout into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logout);

        // Wait until clickable
        wait.until(ExpectedConditions.elementToBeClickable(logout));

        // Click logout using JavaScript to avoid interaction errors
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);
    }
}
