package domaci_31_01_2023;

import Helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Zadatak6_za_vezbanje_sa_casa {
    //Po tekstu zadataka 4, kreirajte screenshot i
    // sacuvajte ga u folderu screenshots po imenom
    // screenshot-[dan]-[mesec]-[godina] [sat]-[minut]-[sekund].jpg
    //Koristan link https://www.javatpoint.com/java-date-to-string
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);

       driver.get("https://cms.demo.katalon.com/");
       driver.manage().window().maximize();

    try {new Helper().takeScreenshot(driver, "screenshots/screenshot-"+strDate+".jpg");
        }catch (IOException e){
        e.printStackTrace();
        }
        Thread.sleep(5000);
        driver.quit();
}}
