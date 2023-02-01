package p_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tus.io/demo.html");
        driver.manage().window().maximize();

       new Actions(driver)
               .scrollToElement(driver.findElement(By.id("js-upload-container")))
               .perform();

       driver.findElement(By.id("js-file-input")).
               sendKeys(new File("test_data/slikaa.png").getAbsolutePath());

        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id='js-upload-container']/a[1]")));

        Thread.sleep(3000);
        driver.quit();
    }
}
