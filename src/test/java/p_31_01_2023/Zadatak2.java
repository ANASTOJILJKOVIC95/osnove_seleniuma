package p_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys(new File("test_data/slikaa.png").getAbsolutePath());


        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.className("template-upload"), 1));

        driver.findElement(By.className("template-upload"))
                .findElement(By.className("start"))
                .click();

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(@class, 'template-download')]//*[contains(@class, 'delete')]")));

        driver.findElement(
                        By.xpath("//*[contains(@class, 'template-download')]//*[contains(@class, 'delete')]"))
                .click();

        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.className("template-download"), 0));

        Thread.sleep(5000);
        driver.quit();
    }
}