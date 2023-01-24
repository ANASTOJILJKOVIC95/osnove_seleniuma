package domaci24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/" +
                "table-with-add-and-delete-row-feature.php");

        driver.manage().window().maximize();

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath("//button[@type='button']")).click();
            driver.findElement(By.name("name")).sendKeys("Ime i prezime");
            driver.findElement(By.name("department")).sendKeys("department");
            driver.findElement(By.name("phone")).sendKeys("broj telefona");
            driver.findElement(By.xpath("//tbody/tr[last()]/td[last()]/a[@class='add']")).click();
            Thread.sleep(500);
        }






    }
}
