package p_30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {  public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.get("https://s.bootsnipp.com/iframe/klDWV");

    wait.until(ExpectedConditions.textToBe(By.id("precent"), "100%"));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader-wrap")));
//        wait.until(ExpectedConditions.attributeContains(By.className("glow"), "style", "width: 100%"));
    Thread.sleep(5000);
    driver.quit();
}
}

