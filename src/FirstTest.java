import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();  // Auto setup
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("The Biryani Life Restaurant Ghaziabad");
driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();

        driver.quit();
    }
}
