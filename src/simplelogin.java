import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;


public class simplelogin
{
    public static void main (String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com"); //open the URL
        WebElement search = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        search.sendKeys("Automation testing");
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"));
        button.click();
        System.out.println("Test successfully run");
    }
}
