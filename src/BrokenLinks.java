import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.cssSelector("li[class*='gf-li'] a"));
        SoftAssert a = new SoftAssert();
        for (WebElement link : links) {

            // for mutiple link
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int resp = conn.getResponseCode();
            System.out.println(resp);
            a.assertTrue(resp < 400, "The link with text" + link.getText() + "is broken with code" + resp);
        }
        a.assertAll();

        
    }
}
//broken url
//step to get all the "href" urls
//java method call thr urls and provide you the status
//if status code is greater than 400 then urls are not working
// String url = driver.findElement(By.cssSelector("a[href*='broken']")).getAttribute("href"); // for single link
