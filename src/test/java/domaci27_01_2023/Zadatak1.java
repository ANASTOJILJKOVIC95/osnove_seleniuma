package domaci27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        List<WebElement> buttonList = driver.findElements(By.xpath("//*[@id='section-basic-example']/section[1]/div/section/div/button"));
        List<WebElement> toastList = driver.findElements(By.xpath("//div[contains(@id,'basic')]"));

        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).click();

            wait.until(ExpectedConditions.visibilityOf(toastList.get(i)));

            if(toastList.get(i).isDisplayed()){
                System.out.println("Poruka za je vidljiva.");
                System.out.println("<-------->");
            } else{
                System.out.println("Poruka za nije vidljiva.");
                System.out.println("<-------->");
            }
        }
        driver.quit();
    }
}

