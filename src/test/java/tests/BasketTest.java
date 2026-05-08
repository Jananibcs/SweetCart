package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.ProductPage;

import java.util.List;

public class BasketTest extends BaseClass {

    @Test(priority = 1)
    public void verifyAddProductToBasket() {

        ProductPage productPage = new ProductPage(driver);
        BasketPage basketPage = new BasketPage(driver);

        // Add product
        productPage.addFirstProductToBasket();

        // Verify basket count
        String count = basketPage.getBasketCount();
        Assert.assertEquals(count, "1", "Basket count mismatch");
    }

    @Test(priority = 2)
    public void verifyProductInBasket() {

        BasketPage basketPage = new BasketPage(driver);

        basketPage.clickBasket();

        List<String> names = basketPage.getProductNames();
        List<String> prices = basketPage.getProductPrices();

        Assert.assertTrue(names.size() > 0, "No products in basket");
        Assert.assertTrue(prices.size() > 0, "No prices shown");
    }

    @Test(priority = 3)
    public void verifyRemoveProductFromBasket() {

        BasketPage basketPage = new BasketPage(driver);

        basketPage.clickBasket();
        basketPage.removeFirstProduct();

        Assert.assertTrue(basketPage.isBasketEmpty(), "Basket is not empty");
    }

    @Test(priority = 4)
    public void verifyMultipleProductsInBasket() {

        ProductPage productPage = new ProductPage(driver);
        BasketPage basketPage = new BasketPage(driver);

        // Add multiple products
        productPage.addFirstProductToBasket();
        productPage.addSecondProductToBasket();

        basketPage.clickBasket();

        List<String> names = basketPage.getProductNames();

        Assert.assertEquals(names.size(), 2, "Products count mismatch");
    }
}