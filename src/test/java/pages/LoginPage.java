package pages;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage extends BasePage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    By loginMenu = By.linkText("Login");
    By emailField = By.id("exampleInputEmail");
    By passwordField = By.id("exampleInputPassword");
    By loginButton = By.xpath("//button[text()='Login']");
    By loginText = By.linkText("Login");
    By accountMenu = By.xpath("//a[contains(text(),'Account')]");
    By errorMessage = By.xpath("//*[contains(text(),'Use one of the demo')]");
    public void openLoginPage() {
        clickElement(loginMenu);
    }
    public void login(String email, String password) {
        openLoginPage();
        enterText(emailField,email);
        enterText(passwordField,password);
        clickElement(loginButton);
    }
    public boolean isLoginDisplayed() {
        return driver.findElement(loginText).isDisplayed();
    }
    public boolean isLoginSuccessful() {
        return !driver.getCurrentUrl().contains("login");
    }
    public void openAccountPage() {
        clickElement(accountMenu);
    }
    public String getErrorMessage() {
        return getText(errorMessage);
    }
    public void openProtectedPage() {
        driver.get("https://sweetshop.netlify.app/00efc23d-b605-4f31-b97b-6bb276de447e.html");
    }
}