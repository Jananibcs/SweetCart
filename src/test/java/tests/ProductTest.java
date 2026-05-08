package tests;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
public class ProductTest extends BaseClass {
    @Test(priority = 1)
    public void verifyProductListDisplayed() {
        ProductPage pp = new ProductPage(driver);
        Assert.assertTrue(pp.isProductListDisplayed(), "Products not displayed");
    }
    @Test(priority = 2)
    public void verifyProductDetailPage() {
        ProductPage pp = new ProductPage(driver);
        pp.openFirstProduct();
        Assert.assertNotNull(pp.getProductName(), "Product name missing");
        Assert.assertNotNull(pp.getProductPrice(), "Product price missing");
    }
    @Test(priority = 3)
    public void verifyAddToBasketButton() {
        ProductPage pp = new ProductPage(driver);
        pp.clickFirstProduct();
        Assert.assertTrue(pp.isAddToBasketDisplayed(), "Add to Basket missing");
    }
}