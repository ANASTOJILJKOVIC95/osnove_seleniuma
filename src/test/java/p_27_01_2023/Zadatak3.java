package p_27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.html.HTMLBRElement;

import java.time.Duration;

public class Zadatak3 { public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort= ");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.manage().window().maximize();

    driver.findElement(By.className("btn")).click();
    driver.findElements(By.className("SelectMenu-item")).get(1).click();


    Helper helper = new Helper();
    if (helper.elementExist(driver, By.xpath("//a[contains(@class,'issues-reset-query')]"))){
        System.out.println("Postoji");
    } else {
        System.out.println("Ne postoji");}

    driver.findElement(By.xpath("//a[contains(@class,'issues-reset-query ')]")).click();

    Thread.sleep(5000);
    driver.quit();
}
}
