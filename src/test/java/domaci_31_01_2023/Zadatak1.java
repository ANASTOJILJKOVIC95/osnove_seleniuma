package domaci_31_01_2023;

import Helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
        driver.manage().window().maximize();
        Helper helper = new Helper();


        ArrayList <String> putanjeDoSlika = new ArrayList<>();
        putanjeDoSlika.add(helper.apsolutPath("test_data/front.jpg"));
        putanjeDoSlika.add(helper.apsolutPath("test_data/right.jpg"));
        putanjeDoSlika.add(helper.apsolutPath("test_data/left.jpg"));
        putanjeDoSlika.add(helper.apsolutPath("test_data/back.jpg"));

        driver.findElement(By.className("edit-image")).click();
        wait.until
                (ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@id='image-option-remove']"))).click(); //brisanje



        for (int i = 0; i < putanjeDoSlika.size(); i++) {//ubacivanje slike
            driver.findElement(By.className("edit-image")).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement
                    (By.xpath("//*[contains(@class, 'sc-eGugkK')]"))));

            driver.findElement(By.id("imageUpload"))
                    .sendKeys(putanjeDoSlika.get(i));

            wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//*[contains(@class, 'sc-dIfARi')]/div["+(i+1)+"]")));

            driver.findElement(By.xpath("//*[contains(@class, 'sc-dIfARi')]/div[1]/div/img")).click();

            wait.until(ExpectedConditions.visibilityOf
                    (driver.findElement(By.xpath("//*[contains(@data-testid, 'container')]"))));

            driver.findElement(By.xpath("//*[contains(@type, 'submit')]")).click(); //klik na submit

            Thread.sleep(2000);
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.id("next-button"))).click();
        driver.findElement(By.id("textareaID")).sendKeys("Ovo je neki text");
        driver.findElement(By.id("text-editor-done")).click();
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
