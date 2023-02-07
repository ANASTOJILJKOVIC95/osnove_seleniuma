package p_03_02_2023;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class KatalonShopTests extends BaseTest {
    @Test(priority = 10)
    @Description(" Adding product with quantity to the cart")
    public void addingProduct() {
        driver.get(baseUrl + "/product/flying-ninja/");

        WebElement kolicina = driver.findElement(By.xpath("//input[@type='number']"));
        new Actions(driver).scrollToElement(kolicina);
        kolicina.clear();
        kolicina.sendKeys("3");

        driver.findElement(By.xpath("//*[@name='add-to-cart']")).click();

        Assert.assertTrue(driver.findElement(
                                By.xpath("//*[contains(@class, 'product_title')]")).getText().
                        contains("Flying Ninja"),
                "Text doesnt conatin Flaying ninja");

        driver.findElement(By.linkText("CART")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), "Not on cart page");

        Assert.assertEquals(driver.findElements(
                        By.xpath("//tbody/tr[@class='woocommerce-cart-form__cart-item cart_item']")).size(),
                1,
                "Cart contains more then one item");
    }

    @Test(priority = 20)
    @Description("Removing product from cart")
    public void removingFromCart() throws InterruptedException {
        driver.get(baseUrl + "/product/flying-ninja/");

        driver.findElement(By.linkText("CART")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"));

        Assert.assertEquals(driver.findElements(
                        By.xpath("//tbody/tr[@class='woocommerce-cart-form__cart-item cart_item']")).size(),
                1,
                "Cart contains more then one item");

        driver.findElement(By.className("remove")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElements(
                        By.xpath("//tbody/tr[@class='woocommerce-cart-form__cart-item cart_item']")).size(),
                0,
                "Cart contains item/s");
    }

    @Test(priority = 30)
    @Description("Test#3: Verify error is displayed when username is missing")
    public void ErrorIsDisplayedWhenUsernameIsMising() {
        driver.findElement(By.linkText("MY ACCOUNT")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.className("woocommerce-error")).getText(),
                "Error: Username is required.",
                "Error message is not as expected");
    }

    @Test(priority = 40)
    @Description("Test #4: Verify error is displayed when password is missing")
    public void ErrorIsDisplayedWhenPasswordIsMissing() throws InterruptedException {
        driver.findElement(By.linkText("MY ACCOUNT")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("cutomer");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(5000);

        Assert.assertEquals(driver.findElement(By.className("woocommerce-error")).getText(),
                "ERROR: The password field is empty.",
                "Error message is not as expected");

    }

    @Test(priority = 50)
    @Description("Test #5: Verify error is displayed when password is wrong")
    public void ErrorIsDisplayedWhenPasswordIsWrong() throws InterruptedException {
        driver.findElement(By.linkText("MY ACCOUNT")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("cutomer");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("invalidpassword");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(5000);

        Assert.assertEquals(driver.findElement(By.className("woocommerce-error")).getText(),
                "ERROR: The password you entered for the username customer is incorrect. Lost your password?",
                "Error message is not as expected");
    }

    @Test(priority = 60)
    @Description(" Test #6:  Verify error is displayed when user does not exist")
    public void ErrorIsDisplayedWhenUserDoesNotExist() throws InterruptedException {
        driver.findElement(By.linkText("MY ACCOUNT")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("invaliduser");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pass1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(5000);

        Assert.assertEquals(driver.findElement(By.className("woocommerce-error")).getText(),
                "ERROR: The password you entered for the username customer is incorrect. Lost your password?",
                "Error message is not as expected");
    }

    @Test(priority = 70)
    @Description("Test #7:  Verify successful login")
    public void verifySuccessfulLofin() throws InterruptedException {
        driver.findElement(By.linkText("MY ACCOUNT")).click();

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("customer");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("crz7mrb.KNG3yxv1fbn");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.xpath("//div/div/p")).getText(),
                "Hello Katalon Parlitul_Changed (not Katalon Parlitul_Changed? Log out)",
                "Login is not successful or text isnt as expeced");
    }
}
