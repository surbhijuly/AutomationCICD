import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;


public class RealTime {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //1. Give me the count of the link of this page

        System.out.println(driver.findElements(By.tagName("a")).size());

        //2. count of the links present in the footer section

        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));  //limiting webdriver scope
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //3. Links count on the footer for 1st section
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        //click on each link and check whether the links are opening

        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
            String clickLinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);

            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickLinkTab);
            Thread.sleep(3000);

        }
        Set<String> abc = driver.getWindowHandles();  //4 windows
        Iterator<String> it = abc.iterator();

        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());

        }
    }


}


