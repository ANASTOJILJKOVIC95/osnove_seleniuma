package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("https://s.bootsnipp.com/iframe/z80en");
    WebElement table =
            driver.findElement(By.xpath("//*[@id='lorem']/table"));

    List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));

    for (int i = 0; i < rows.size(); i++) {
        List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
        for (int j = 0; j < columns.size(); j++) {
            System.out.print(columns.get(j).getText() + " " );
        }
        System.out.println();

    }


    Thread.sleep(5000);
    driver.quit();
    }
}

