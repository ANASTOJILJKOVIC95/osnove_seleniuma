package domaci_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Zadatak1 { public static void main(String[] args) throws InterruptedException {
//Niztodo-a (niz stringova) koje treba da uneti. Niz je:
//Visit Paris
//Visit Prague
//Visit London
//Visit New York
//Visit Belgrade
//Maksimizirati prozor
//Ucitati stranicu https://example.cypress.io/to do
//Program petljom prolazi kroz niz to do i svaki unosi na stranicu
//Nakon svakog unosa todoa, unosi se enter
//Validira da li je novi to do dodat na stranici
//Na kraju programa proci petljom i izbrisati svaki to do sa stranice (klikom na x dugme svakog to do-a)
//Validirati da je na kraju programa broj to do-a na stranici 0.
//Cekanje od 5s
//Zatvorite pretrazivac


    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    ArrayList<String> toDo = new ArrayList<>();

    toDo.add("Visit Paris");
    toDo.add("Visit London");
    toDo.add("Visit New York");
    toDo.add("Visit Belgrade");
    toDo.add("Visit Prague");

    driver.manage().window().maximize();

    driver.get("https://example.cypress.io/todo");

    for (int i = 0; i < toDo.size(); i++) {
        driver.findElement(By.className("new-todo")).sendKeys(toDo.get(i));
        driver.findElement(By.className("new-todo")).sendKeys(Keys.ENTER);
        List <WebElement> toDoUnet =
                driver.findElements(By.xpath("//ul/li/div"));
        Thread.sleep(1000);
        for (int j = 0; j < toDoUnet.size(); j++) {
            if ( toDoUnet.get(j).getText().equals(toDo.get(i))){
               System.out.println("Uneli ste na to do listu " + toDo.get(i));}
        }
    }
    List <WebElement> toDoUnet =
            driver.findElements(By.xpath("//ul/li/div"));
    Thread.sleep(3000);
    Actions actions = new Actions(driver);
    List<WebElement> x =
            driver.findElements((By.xpath("//button[contains(@class,'destroy')]")));
    for (int i = toDoUnet.size()-1; i >=0 ; i--) {
        actions.moveToElement(toDoUnet.get(i));
        actions.clickAndHold();

        actions.moveToElement(x.get(i));
        actions.release().perform();
        actions.click(x.get(i));
    }
    Thread.sleep(5000);
    driver.quit();

    if (toDoUnet.size() == 0){
        System.out.println("Obrisali ste sve iz to do liste");}
}
}
