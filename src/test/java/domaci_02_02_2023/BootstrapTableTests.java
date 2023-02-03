package domaci_02_02_2023;

import Helper.Helper;
import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BootstrapTableTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl ="https://s.bootsnipp.com";

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
        driver.get(baseUrl + "/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Not on edit and update data from the table page");

    }

    @Test (priority = 1)
    @Description("Test #1: Edit and Update Table Data")
    public void editRow (){
        String firstName = "Maja";
        String lastName = "Kostic";
        String middleName = "Dragan";
        driver.findElement(By.xpath("//*[@id='d1']//*[@data-target='#edit']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("modal-content")));

        WebElement fn = driver.findElement(By.id("fn"));
        fn.clear();
        fn.sendKeys(firstName);

        WebElement ln = driver.findElement(By.id("ln"));
        ln.clear();
        ln.sendKeys(lastName);

        WebElement mn = driver.findElement(By.id("mn"));
        mn.clear();
        mn.sendKeys(middleName);

        driver.findElement(By.id("up")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-content")));

        Assert.assertEquals(driver.findElement(By.id("f1")).getText(),
                firstName,
                "Inserted wrong first name.");


        Assert.assertEquals(driver.findElement(By.id("l1")).getText(),
                lastName,
                "Inserted wrong last name.");

        Assert.assertEquals(driver.findElement(By.id("m1")).getText(),
                middleName,
                "Inserted wrong last name.");
    }

    @Test(priority = 2)
    @Description("Test #2: Delete Row")
    public void deleteRow(){
        int numberOfRows = driver.findElements(By.xpath("//tbody/tr")).size();

        driver.findElement(By.xpath("//*[@id='d1']//*[@data-target='#delete']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("modal-content")));

        driver.findElement(By.id("del")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-content")));

        Assert.assertEquals(driver.findElements(By.xpath("//tbody/tr")).size(),
                numberOfRows - 1,
                "Number of rows after deletion is not as it is expected");

        //Izbacuje da je test fejlovao, ali to je zato sto prvi tr ostaje u html-u,
        // i ako nema nijedan td. Test bi u tom slucaju trebao da se radi tako sto proverava td u prvom tr-u
    }

    @Test (priority = 3)
    @Description("Take a Screenshot")
    public void screenshot() throws IOException {
        new Helper().takeScreenshot(driver, "screenshots/bootstrapTest.png");

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
