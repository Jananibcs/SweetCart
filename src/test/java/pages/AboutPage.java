package pages;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class AboutPage extends BasePage {
    WebDriver driver;
    public AboutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    By sweetsLink = By.xpath("//a[contains(text(),'Sweets')]");
    By aboutLink = By.xpath("//a[contains(text(),'About')]");
    By loginLink = By.xpath("//a[contains(text(),'Login') or contains(text(),'Sign')]");
    By aboutHeading = By.tagName("h1");
    By navLinks = By.cssSelector("a.nav-link");
    By brandText = By.xpath("//a[@class='navbar-brand']");

    public void clickAbout() {
        driver.findElement(aboutLink).click();
    }

    public void clickSweets() {
        driver.findElement(sweetsLink).click();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public boolean isNavLinksDisplayed() {
        return driver.findElements(sweetsLink).size() > 0 &&
                driver.findElements(aboutLink).size() > 0 &&
                driver.findElements(loginLink).size() > 0;
    }

    public boolean isAboutPageHeadingDisplayed() {
        return driver.findElements(aboutHeading).size() > 0;
    }

    public String getAboutHeadingText() {
        return driver.findElement(aboutHeading).getText();
    }

    public boolean isFooterDisplayed() {
        return driver.findElements(navLinks).size() > 0;
    }

    public boolean isFooterLinksPresent() {
        return driver.findElements(navLinks).size() >= 3;
    }

    public boolean isFooterTextPresent() {
        return driver.findElement(brandText).isDisplayed();
    }
}