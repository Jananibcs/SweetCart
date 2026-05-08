package tests;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
public class LoginTest extends BaseClass{
    //valid login
    @Test
    public void validLoginTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("oneorder@sweetshop.local","qwerty");
        Assert.assertTrue(lp.isLoginSuccessful());
    }
    //invalid login
    @Test
    public void invalidLoginTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("wrong@gmail.com","123456");
        Assert.assertTrue(lp.getErrorMessage().contains("Use one of the demo"));
    }
    @Test
    public void verifyProtectedPageWithoutLogin() {
        driver.manage().deleteAllCookies();
        LoginPage lp = new LoginPage(driver);
        lp.openProtectedPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("sweetshop.netlify.app"));
    }
}
