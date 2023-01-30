package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("https://s.bootsnipp.com/iframe/z80en");
    List <WebElement> kolone = driver.findElements(By.xpath("//div[@id='lorem']//td[1]"));
    for (int i = 0; i < kolone.size(); i++) {
        System.out.println(kolone.get(i).getText());
    }



   driver.quit();
}
}
