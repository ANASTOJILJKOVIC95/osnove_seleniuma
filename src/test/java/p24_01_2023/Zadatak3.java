package p24_01_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    ArrayList<String> stranice = new ArrayList<>();
    stranice.add("https://google.com/");
    stranice.add("https://youtube.com/");
    stranice.add("https://ebay.com/");
    stranice.add("https://www.kupujemprodajem.com/");

    for (int i = 0; i < stranice.size(); i++) {
        driver.get(stranice.get(i));
        System.out.println(driver.getTitle());
    }

    driver.quit();
    }
}