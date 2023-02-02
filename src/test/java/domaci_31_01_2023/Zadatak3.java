package domaci_31_01_2023;

import Helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak3 {public static void main(String[] args) throws InterruptedException, IOException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    driver.get("https://itbootcamp.rs/");
    driver.manage().window().maximize();

    WebElement scroll = driver.findElement(By.xpath("//div[@class='vc_row wpb_row vc_row-fluid slider_bkgd']"));
    new Actions(driver).scrollToElement(scroll)
            .perform();

    List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='carousel-item']/img"));

    Helper helper = new Helper();

    for (int i = 0; i < elementList.size(); i++) {
        String url = elementList.get(i).getAttribute("src");
       if (helper.getHTTPResponseStatusCode(url) >= 200 && helper.getHTTPResponseStatusCode(url)<300){
           helper.downloadUsingStream(url, "downloads/ITB"+i+".jpg");
       }
    }
    driver.quit();
}
}
