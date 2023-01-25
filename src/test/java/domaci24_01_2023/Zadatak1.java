package domaci24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    Thread.sleep(3000);
    driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).sendKeys("admin123");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(5000);

    driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys("Me");
    driver.findElement(By.className("oxd-main-menu-item")).click();

    Thread.sleep(3000);

    driver.findElement(By.className("oxd-userdropdown-name")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("Logout")).click();

    Thread.sleep(5000);
    driver.quit();



    }
}
