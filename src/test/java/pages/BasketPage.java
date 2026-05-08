package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class BasketPage extends BasePage {

    WebDriver driver;

    public BasketPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // 🔹 Locators
    By basketIcon = By.id("basketIcon"); // update based on your app
    By basketCount = By.id("basketCount");

    By productNames = By.xpath("//div[@class='basket-item-name']");
    By productPrices = By.xpath("//div[@class='basket-item-price']");
    By removeButtons = By.xpath("//button[contains(text(),'Remove')]");

    By emptyMessage = By.xpath("//*[contains(text(),'Basket is empty')]");

    // 🔹 Actions

    public void clickBasket() {
        driver.findElement(basketIcon).click();
    }

    public String getBasketCount() {
        return driver.findElement(basketCount).getText();
    }

    public List<String> getProductNames() {
        return driver.findElements(productNames)
                .stream()
                .map(e -> e.getText())
                .toList();
    }

    public List<String> getProductPrices() {
        return driver.findElements(productPrices)
                .stream()
                .map(e -> e.getText())
                .toList();
    }

    public void removeFirstProduct() {
        driver.findElements(removeButtons).get(0).click();
    }

    public boolean isBasketEmpty() {
        return driver.findElements(emptyMessage).size() > 0;
    }
}