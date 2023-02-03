package p_02_02_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Testng {
    private WebDriver driver;
    private WebDriverWait wait;

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
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
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

    @Test
    public void googleTitle(){
        Assert.assertEquals(driver.getTitle() , "google", "Title stranice");
        }

        @Test
    public void googleUrl() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
    }
}

