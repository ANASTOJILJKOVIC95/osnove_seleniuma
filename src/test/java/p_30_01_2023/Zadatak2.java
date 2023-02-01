package p_30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://youtube.com");

//        //*[@id='search']
        driver
                .findElement(By.xpath("//input[@id='search']"))
                .sendKeys("RHCP");

        driver
                .findElement(By.xpath("//input[@id='search']"))
                .sendKeys(Keys.SPACE);


        wait.until(
                ExpectedConditions
                        .numberOfElementsToBeMoreThan(
                                By.xpath("//li[@role='presentation']"), 3));

        driver.findElement(By.xpath("//li[@role='presentation'][last()]")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
