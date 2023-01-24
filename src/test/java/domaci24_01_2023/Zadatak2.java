package domaci24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    ArrayList<String> toDo = new ArrayList<>();

    toDo.add("Visit Paris");
    toDo.add("Visit London");
    toDo.add("Visit New York");
    toDo.add("Visit Belgrade");
    toDo.add("Visit Prague");

    driver.manage().window().maximize();

    driver.get("https://example.cypress.io/todo");
        for (int i = 0; i < toDo.size(); i++) {
            driver.findElement(By.className("new-todo")).sendKeys(toDo.get(i));
            driver.findElement(By.className("new-todo")).sendKeys(Keys.ENTER);
        }

        Thread.sleep(5000);
        driver.quit();

    }
}
