package domaci_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak2 {public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    driver.get("https://itbootcamp.rs/");
    driver.manage().window().maximize();


    List<WebElement> padajuciMeni = driver.findElements(By.xpath("//*[contains(@id, 'menu-main-menu')]/li"));

    for (int i = 0; i < padajuciMeni.size(); i++) {
        new Actions(driver).moveToElement(padajuciMeni.get(i)).perform();
        if (padajuciMeni.get(i).getAttribute("class").contains("dropdown-toggle")) {
            wait.until(ExpectedConditions.visibilityOf(padajuciMeni.get(i)));
        }
    }


    Thread.sleep(5000);
    driver.quit();

}



}

