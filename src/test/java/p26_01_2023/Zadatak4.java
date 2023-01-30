package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("http://cms.demo.katalon.com/my-account/");
    Thread.sleep(2000);

    driver.findElement(By.xpath("//input[@name='rememberme']")).click();

    if (driver.findElement(By.id("rememberme")).isSelected()){
        System.out.println("Remember me button is checked");
    }else {
        System.out.println("Remember me button is not checked");
        driver.close();
    }
}
}
