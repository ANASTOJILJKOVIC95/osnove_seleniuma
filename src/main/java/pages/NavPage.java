package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage{


    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement cartLink (){
        return driver.findElement(By.linkText("CART"));
    }

    public WebElement checkoutLink(){
        return driver.findElement(By.linkText("CHECKOUT"));
    }
    public WebElement myAccountLink(){
        return driver.findElement(By.linkText("MY ACCOUNT"));
    }
    public WebElement samplePageLink(){
        return driver.findElement(By.linkText("SAMPLE PAGE"));
    }

    public WebElement shopLink(){
        return driver.findElement(By.linkText("SHOP"));
    }
}
