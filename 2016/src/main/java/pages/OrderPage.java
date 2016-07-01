package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By welcomeMessage = By.xpath("//td[text()='Welcome, testuser']");

    // Methods
    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }
}