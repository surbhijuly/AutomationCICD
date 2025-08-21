import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AssignmentSync {
    public static void main(String[] args) throws InterruptedException {

        // ✅ Step 1: Set Chrome options to disable password breach popup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-features=PasswordCheck,PasswordManagerEnabled,AutofillServerCommunication");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--incognito"); // optional: clean session

        // ✅ Step 2: Pass options to ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        // ✅ Step 3: Proceed with test as before
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");

        driver.findElement(By.xpath("//label[2]//span[2]")).click();

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(text(),'You will be limited to only fewer functionalities ')]")
        ));

        driver.findElement(By.id("okayBtn")).click();

        WebElement sdropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select drop = new Select(sdropdown);
        drop.selectByIndex(2);

        driver.findElement(By.xpath("//*[@id='terms']")).click();
        driver.findElement(By.id("signInBtn")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));

        List<WebElement> product = driver.findElements(By.cssSelector(".card-footer .btn-info"));
        for (int i = 0; i < product.size(); i++) {
            product.get(i).click();
        }

        driver.findElement(By.partialLinkText("Checkout")).click();
    }
}
