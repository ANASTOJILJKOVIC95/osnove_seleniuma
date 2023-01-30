package domaci_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.get("https://s.bootsnipp.com/iframe/Dq2X");
    driver.manage().window().maximize();

    List < WebElement> x =
            driver.findElements(By.xpath("//button[contains(@class,'close')]"));

    for (int i = x.size()-1; i >=0 ; i--) {
        x.get(i).click();
        for (int j = x.size()-1; j >0 ; j--) {
            if (x.get(i).equals(x.get(j))){
          System.out.println("Element je obrisan");}
        }
    }

    Thread.sleep(5000);
    driver.quit();
}}
