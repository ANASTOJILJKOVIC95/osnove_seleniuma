package p24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/login");
        driver.findElement(By.id("userName")).sendKeys("itbootcamp");

        driver.findElement(By.xpath("//input[@placeholder='Password']"))
                .sendKeys("ITBootcamp2021!");

        driver.findElement(By.xpath("//form/div[contains(@class,'mt-2')]/div/button")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[contains(text(), 'Log out')]")).click();


        driver.quit();

    }
}
