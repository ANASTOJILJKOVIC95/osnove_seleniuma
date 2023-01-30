package p_27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/modal-dialogs");

        driver.manage().window().maximize();
        Helper helper = new Helper();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("showLargeModal")).click();
        if (helper.elementExist(driver, By.className("modal-content"))){
            System.out.println("Postoji");
        } else{
            System.out.println("Nepostoji");
        }


        Thread.sleep(1000);
        driver.quit();
    }
}
