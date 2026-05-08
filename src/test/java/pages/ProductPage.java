package pages;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class ProductPage extends BasePage {
    WebDriver driver;
    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    By productCards = By.cssSelector(".product, .card, .item");
    By firstProduct = By.cssSelector(".product, .card, .item");
    By productName = By.cssSelector(".product-name, h1, .name");
    By productPrice = By.cssSelector(".price, [class*='text-muted']");
    By addToBasketBtn = By.cssSelector("a.addItem, .addItem");
    public boolean isProductListDisplayed() {
        return driver.findElements(productCards).size() > 0;
    }
    public void openFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(firstProduct));
        list.get(0).click();
    }
    public void clickFirstProduct() {
        List<WebElement> list = driver.findElements(productCards);
        if (list.size() == 0) {
            throw new RuntimeException("No products found in list");
        }
        list.get(0).click();
    }
    public String getProductName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        return nameElement.getText();
    }
    public String getProductPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        return priceElement.getText();
    }
    public boolean isAddToBasketDisplayed() {
        return driver.findElements(addToBasketBtn).size() > 0;
    }
}