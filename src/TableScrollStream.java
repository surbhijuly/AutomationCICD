import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class TableScrollStream {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

//click on the column for sorting.
        driver.findElement(By.cssSelector("th[aria-label*='Veg/fruit name'] ")).click();
        //capture all webelements into list
        List<WebElement> elelist = driver.findElements(By.xpath("//tr/td[1]"));
        //capture text of all webelement into new(original) list
        List<String> originallist = elelist.stream().map(s -> s.getText()).collect(Collectors.toList());
        //apply sort on that list= sorted listed
        List<String> sortedList = originallist.stream().sorted().collect(Collectors.toList());
        //compare orginal with sorted list
        Assert.assertTrue(originallist.equals(sortedList));
//price of each vegitable

        List<String> price;
        //scan the name column and get the text -> Rice, print it's price
        do {

            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getveggieprice(s)).collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));
            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        } while (price.size() < 1);
    }


    private static String getveggieprice(WebElement s) {
        String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return pricevalue;
    }
}
