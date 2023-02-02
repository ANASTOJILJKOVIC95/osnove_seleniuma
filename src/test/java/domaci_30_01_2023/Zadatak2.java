package domaci_30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");
        new Select(driver.
                findElement(By.xpath("//*[@id='delay-select']")))
                .selectByVisibleText("2000ms");
        Actions actions = new Actions(driver);
        int broj = 5;

        for (int i = 0; i < 5; i++) {
            actions.scrollToElement(driver.findElement(By.id("infinite-scroll-button")))
                    .perform();

            actions.scrollToElement(driver.findElement(By.xpath("//*[@id='infinite-scroll-container']/div["+broj+"]")))
                    .perform();

            Thread.sleep(2000);
            actions.scrollToElement(driver.findElement(By.id("infinite-scroll-button")))
                    .perform();

            wait.until
                    (ExpectedConditions.elementToBeClickable(By.id("infinite-scroll-button"))).click();

            broj += 3;
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
