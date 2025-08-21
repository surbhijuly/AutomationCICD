import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AssignmentWindowSwitch {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.cssSelector("a[href*='/windows/new']")).click();
        Set<String> window = driver.getWindowHandles();  //parent child
        Iterator<String> a = window.iterator();
        String parendId = a.next();
        String childId = a.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".example")).getText());
        driver.switchTo().window(parendId);
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());

    }

}
