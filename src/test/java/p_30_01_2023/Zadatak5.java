package p_30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak5 {  public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

    driver.findElement(By.id("basic-primary-trigger")).click();
    driver.findElement(By.id("basic-secondary-trigger")).click();
    driver.findElement(By.id("basic-success-trigger")).click();
    driver.findElement(By.id("basic-danger-trigger")).click();


    wait.until(ExpectedConditions
            .numberOfElementsToBe(
                    By.xpath("//div[contains(@class, 'toast-fixed')][contains(@class, 'show')]"), 4));

    Thread.sleep(5000);
    driver.quit();
}
}
