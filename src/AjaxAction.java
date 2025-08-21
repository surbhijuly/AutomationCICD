import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class AjaxAction {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        //driver.findElement(By.xpath("button[@type='submit']")).click();
        Actions a = new Actions(driver);

        WebElement move = driver.findElement(By.cssSelector("div[id='nav-link-accountList']"));

        a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        //moves/hover on to specific element
        a.moveToElement(driver.findElement(By.cssSelector("div[id='nav-link-accountList']"))).build().perform();
        a.moveToElement(move).contextClick().build().perform();

    }

}
