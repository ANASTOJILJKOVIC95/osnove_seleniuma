package domaci24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");



    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://artplayer.org/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
        driver.findElement(By.xpath("//*[@aria-label='Mute']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@class, 'screenshot')]")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'art-icon-pip')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@class, 'art-icon-pip')]")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'icon-fullscreenWebOn')]")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'icon-fullscreenWebOff')]")).click();
        Thread.sleep(5000);

        driver.quit();
}
}
