import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class learn {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("automation");
        Thread.sleep(2000);
        driver.findElement(By.name("btnK")).click();
    }

}
