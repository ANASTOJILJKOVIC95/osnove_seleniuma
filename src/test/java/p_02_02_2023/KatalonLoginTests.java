package p_02_02_2023;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class KatalonLoginTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl ="https://cms.demo.katalon.com";

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod (){
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

   @Test
   @Description("Visit login page from Nav bar")
    public void  loginPage(){
        driver.findElement(By.linkText("MY ACCOUNT")).click();
       Assert.assertEquals(driver.getTitle(),
               "My account – Katalon Shop", "Not on my account page");
       Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "Not on my account page");
    }

    @Test
    public void CheckInputTypes(){
        driver.findElement(By.linkText("MY ACCOUNT")).click();

        WebElement email =  driver.findElement(By.id("username"));
      Assert.assertEquals(email.getAttribute(
              "type"),
              "text",
              "Invalid username input type");

      WebElement password=  driver.findElement(By.id("password"));
      Assert.assertEquals(password.getAttribute(
              "type"),
              "password",
              "Invalid password input type");

      WebElement checkbox=  driver.findElement(By.id("rememberme"));

      Assert.assertEquals(checkbox.getAttribute(
              "type"),
              "checkbox",
              "Invalid checkbox input type");

      Assert.assertTrue(!checkbox.isSelected(), "Checkbox is clicked");
    }

    @Test
    public void DisplayErrorWhenCredentialAreWrong(){
        driver.findElement(By.linkText("MY ACCOUNT")).click();

        driver.findElement(By.id("username")).sendKeys("invalidemail@gmail.com");
        driver.findElement(By.id("password")).sendKeys(" invalid123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        WebElement greska =driver.findElement(By.className("woocommerce-error"));

        Assert.assertTrue(greska.isDisplayed(), "Doesn't show error message");
        Assert.assertEquals(greska.getText(), "ERROR: Invalid email address");
        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "Url does not contain '/my-account'");
    }
    @AfterMethod
    public void afterMethod (){
        System.out.println("After");
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
