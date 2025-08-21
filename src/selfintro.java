import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class selfintro
{
public static void main (String[] args)
{
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("http://candidate-uat.hirebright.ai");
driver.findElement(By.id("email")).sendKeys("uatenvcan@inboxbear.com");
driver.findElement(By.id("password")).sendKeys("Password");
driver.findElement(By.xpath("//html/body/div/div/div/div/div/form/div[4]/button[1]/span")).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement toast = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[contains(@class,'ant-message-custom-content')]//span")
            ));
    System.out.println("Toast: " + toast.getText());



//driver.findElement(By.cssSelector("div.ant-message-notice-content span"));
driver.findElement(By.xpath("//button[@class=''ant-btn css-7ev6ie ant-btn-link ant-btn-color-primary ant-btn-variant-link !text-primary]")).click();
driver.quit();
}
}
