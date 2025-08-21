import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


public class MultiWindow {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
//1st course name displayed on another url, paste the name in 1st url input box
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> win = driver.getWindowHandles();
        Iterator<String> it = win.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.get("http://www.rahulshettyacademy.com/");
        String text = driver.findElements(By.cssSelector("[href*='https://courses.rahulshettyacademy.com/p/get-access']"))
            .get(1).getText();
        driver.switchTo().window(parentWindow);
        WebElement nameTwo = driver.findElement(By.name("name"));
        nameTwo.sendKeys(text);

        //Screenshot
        File file = nameTwo.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("/Users/surbhi/Desktop/ss/ss1.jpg"));

        //get height and width
        System.out.println(nameTwo.getRect().getDimension().getHeight());
        System.out.println(nameTwo.getRect().getDimension().getWidth());
    }
}