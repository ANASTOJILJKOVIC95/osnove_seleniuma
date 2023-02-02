package domaci_31_01_2023;

import Helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class Zadatak4 {public static void main(String[] args) throws InterruptedException, IOException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    driver.get("https://blueimp.github.io/jQuery-File-Upload/");
    driver.manage().window().maximize();

    Helper helper = new Helper();

    ArrayList<String> putanjeDoSlika = new ArrayList<>();
    putanjeDoSlika.add(helper.apsolutPath("test_data/front.jpg"));
    putanjeDoSlika.add(helper.apsolutPath("test_data/right.jpg"));
    putanjeDoSlika.add(helper.apsolutPath("test_data/left.jpg"));
    putanjeDoSlika.add(helper.apsolutPath("test_data/back.jpg"));

    for (int i = 0; i < putanjeDoSlika.size(); i++) {
        driver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys(putanjeDoSlika.get(i));
    }
    wait.until(ExpectedConditions
            .numberOfElementsToBe(By.className("template-upload"), 4));

   driver.findElement(By.xpath("//button[@type='submit']")).click();

    wait.until(ExpectedConditions
            .numberOfElementsToBe(By.xpath("//button[@data-type='DELETE']"), 4));

    driver.quit();


}}
