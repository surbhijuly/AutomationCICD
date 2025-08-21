import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FunctionalTesting {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //declaring implicit wait globally
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        String[] vegges = {"Cucumber", "Brocolli", "Tomato"}; //Array takes less memory and array list takes high memory
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        //Thread.sleep(2000);
        AddItems(driver, vegges);

        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter promo code']")));

        driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoBtn")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));


        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }


    public static void AddItems(WebDriver driver, String[] vegges) {
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i <= products.size(); i++) {
            String[] name = products.get(i).getText().split("-");  // splitting the string
            String formattedname = name[0].trim();   //triming the name
            //check whether name you extracted is present in this array or not
            //convert array into array list for easy search
            List veggesList = Arrays.asList(vegges);

            if (veggesList.contains(formattedname)) {
                j++;

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == vegges.length)
                    break;
            }

        }

    }
}
