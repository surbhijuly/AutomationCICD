import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dynamicDropdown
{
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    // //a[@value="MAA"] - xpath for chennai
        // //a[@value="BLR"] - xpath for bengaluru
//1st dropdown
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(2000);
driver.findElement(By.xpath("//a[@value='BLR']")).click();
//2nd dropdown
// driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
Thread.sleep(2000);
//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        Thread.sleep(2000);
//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();


        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("spclearDate")).getDomAttribute("style"));

        if(driver.findElement(By.id("spclearDate")).getDomAttribute("style").contains("block"))
        {
            Assert.assertTrue(true);
            System.out.println("It's enabled");
        }
else {
            Assert.assertFalse(false);
        }

        driver.quit();
    }

}
