package p_06_02_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.NavPage;
import pages.ProductPage;

import java.time.Duration;

public abstract class BaseTest {
   protected WebDriver driver;
   protected WebDriverWait wait;
   protected NavPage navPage;
   protected CartPage cartPage;
   protected ProductPage productPage;
   protected Actions actions;

    protected String baseUrl ="https://cms.demo.katalon.com";

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.navPage = new NavPage(driver,wait);
        this.cartPage = new CartPage(driver, wait);
        this.productPage = new ProductPage(driver, wait);
        this.actions = new Actions(driver);


    }

    @BeforeMethod
    public void beforeMethod (){
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    public void afterMethod (){
        System.out.println("After");
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
