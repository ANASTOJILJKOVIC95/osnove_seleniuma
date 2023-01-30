package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak5 {public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("https://www.ebay.com/");
    WebElement selectElement = driver.findElement(By.id("gh-cat"));
    Select select = new Select(selectElement);
    select.selectByVisibleText("Crafts");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@type-'submit']")).click();

    driver.quit();


} }
