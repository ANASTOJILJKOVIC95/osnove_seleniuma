package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("https://cms.demo.katalon.com/");
    WebElement element = driver.findElement(By.className("menu-toggle"));
    boolean isVisible = element.isDisplayed();
    if (isVisible == true){
        System.out.println("Vidi se");
    } else {
        System.out.println("Ne vidi se");}

    Dimension dimension = new Dimension(700, 700);
    driver.manage().window().setSize(dimension);
    boolean vidljiv = element.isDisplayed();
    if (vidljiv == true){
        System.out.println("Vidi se");
    } else {
        System.out.println("Ne vidi se");}

    driver.quit();


}}
