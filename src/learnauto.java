import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class learnauto
{
    public static void main (String[] args)
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("surbhi");
        driver.findElement(By.name("inputPassword")).sendKeys("Password");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//driver.findElement(By.cssSelector("div.ant-message-notice-content span"));
       // driver.findElement(By.xpath("//button[@class=''ant-btn css-7ev6ie ant-btn-link ant-btn-color-primary ant-btn-variant-link !text-primary]")).click();
        driver.findElement(By.linkText("Forgot your password?")).click();

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("surbhi");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("automationtest@tupmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9876543210");
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
        //Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("surbhi");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        //driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();


    }
}
// HTML text- <input type="text" placeholder="Name">

