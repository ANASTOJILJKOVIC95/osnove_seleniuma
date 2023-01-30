package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zatadak7 {public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("https://netoglasi.rs/");

    List< WebElement> items = driver.findElements(By.xpath("//ion-list/app-category-picker-item/ion-item/a"));
    for (int i = 0; i < items.size(); i++) {
        System.out.println(items.get(i).getText());}
}}
