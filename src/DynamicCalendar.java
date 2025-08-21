import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DynamicCalendar {
    public static void main(String[] args) throws InterruptedException {

        String monthNum = "6";
        String date = "15";
        String year = "2027";
        String[] expectedList = {monthNum, date, year};
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/a[2]")).click();
        //Thread.sleep(2000);
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        driver.findElement(By.cssSelector(".react-date-picker__calendar-button")).click();
        //Thread.sleep(3000);
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNum) - 1).click();
        //driver.findElement(By.cssSelector(""))
        driver.findElement(By.xpath("//abbr[.='" + date + "']")).click();
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText();
        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

        for (int i = 0; i < actualList.size(); i++) {
            System.out.println(actualList.get(i).getDomAttribute("value"));
            Assert.assertEquals(actualList.get(i).getDomAttribute("value"), expectedList[i]);
        }
        driver.close();

    }


}
