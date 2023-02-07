package p_06_02_2023;

import Helper.Helper;
import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class KatalonShopTests extends BaseTest {
    @Test
    public void verifyNavLinks() throws IOException {

        String cartLink = navPage.cartLink().getAttribute("href");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(new Helper().getHTTPResponseStatusCode(cartLink),
                200,
                "Cart link invalid status code.");

        String checkoutLink = navPage.checkoutLink().getAttribute("href");

        softAssert.assertEquals(new Helper().getHTTPResponseStatusCode(checkoutLink),
                200,
                "Checkout link invalid status code.");

        softAssert.assertAll();
    }


    @Test(priority = 10)
    @Description("Test #1:  Adding product with quantity to the cart")
    public void addingProductWithQuantityToTheCart() {
        driver.get(baseUrl + "/product/flying-ninja/");
        productPage.getQuantity().clear();
        productPage.getQuantity().sendKeys("3");
        productPage.getAddToCartButton().click();
        Assert.assertTrue(productPage.getMessage().getText().contains("Flying Ninja"),
                "Wrong message.");
        navPage.cartLink().click();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/cart",
                "Not on cart page.");
        cartPage.waitForNumberOfRowsToBe(1);
    }


    @Test
    @Description("Test #2:  Removing product from cart")
    public void removingProductFromCart() {
        navPage.cartLink().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/cart",
                "Not on cart page.");
        cartPage.waitForNumberOfRowsToBe(1);
        cartPage.getRemoveItemButtonByRow(1).click();
        cartPage.waitForNumberOfRowsToBe(0);
    }
}