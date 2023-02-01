package p_30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

    driver.findElement(By.id("basic-primary-trigger")).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basic-primary-example")));
    System.out.println("Element se pojavio");
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("basic-primary-example")));
    System.out.println("Element se izgubio");


    driver.findElement(By.id("basic-primary-trigger")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basic-primary-example")));
    System.out.println("Element se pojavio");

    driver.findElement(By.id("basic-primary-example"))
            .findElement(By.className("btn-close"))
            .click();

    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("basic-primary-example")));
    System.out.println("Element se izgubio");

    Thread.sleep(5000);
    driver.quit();
}
}
