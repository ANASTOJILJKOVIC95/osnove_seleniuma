package p_27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Predavanja {public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("file:///C:/Users/Korisnik/Downloads/Zadatak4.html");

    boolean elementExist = true;

    try{WebElement div = driver.findElement(By.id("id-0"));
        } catch (NoSuchElementException error){
        elementExist = false;
    }
    if (elementExist){
    System.out.println("Element postoji");}
    else {
        System.out.println("Element ne postoji");}
}}

      //  List<WebElement> elementExist =}
