package p_31_01_2023;

import Helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak5 {public static void main(String[] args) throws InterruptedException, IOException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.get("https://cms.demo.katalon.com/");
    driver.manage().window().maximize();

    List <WebElement> linkovi =
            driver.findElements(By.xpath("//*[@id='primary-menu']/ul/li/a"));

    for (int i = 0; i < linkovi.size(); i++) {
        String url = linkovi.get(i).getAttribute("href");
        try { int statusCode = new Helper().getHTTPResponseStatusCode(url);
            if (statusCode >= 200 && statusCode < 400) {
                System.out.println("Link: " + url + " is available.");
            } else {
                System.out.println("Link: " + url + " is not available.");

            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}}
