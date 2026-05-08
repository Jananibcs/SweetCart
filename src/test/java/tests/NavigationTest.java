package tests;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutPage;
public class NavigationTest extends BaseClass {
    AboutPage ap;
    @Test(priority = 1)
    public void verifyTopNavigationLinks() {
        ap = new AboutPage(driver);
        Assert.assertTrue(ap.isNavLinksDisplayed(), "Navigation links missing");
    }

    @Test(priority = 2)
    public void verifyAboutPageHeading() {
        ap = new AboutPage(driver);
        ap.clickAbout();
        String heading = ap.getAboutHeadingText();
        Assert.assertTrue(heading.contains("Sweet Shop"));
    }

    @Test(priority = 3)
    public void verifyFooterContent() {
        ap = new AboutPage(driver);
        Assert.assertTrue(ap.isFooterDisplayed(), "Footer not displayed");
        Assert.assertTrue(ap.isFooterLinksPresent(), "Footer links missing");
        Assert.assertTrue(ap.isFooterTextPresent(), "Footer text missing");
    }
}