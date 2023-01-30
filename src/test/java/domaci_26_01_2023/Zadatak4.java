package domaci_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak4 {public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("https://geodata.solutions/");
    Select select = new Select(driver.findElement(By.xpath("//select[@name='country']")));
    select.selectByVisibleText("Serbia");select = new Select(driver.findElement(By.xpath("//select[@name='state']")));
    Thread.sleep(3000);
    select.selectByVisibleText("Central Serbia");
    select = new Select(driver.findElement(By.xpath("//select[@name='city']")));
     Thread.sleep(3000);
    select.selectByVisibleText("Nis");
    Thread.sleep(3000);
    driver.quit();
}}