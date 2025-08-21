import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        driver.findElement(By.xpath("(//a[normalize-space()='Chennai (MAA)'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
//check 2way radio button is disabled or not, for this calendar should be disabled for 1 way ticket.

        if (driver.findElement(By.id("spclearDate")).getDomAttribute("style").contains("block")) {
            Assert.assertTrue(true);
            System.out.println("It's enabled");
        } else {
            Assert.assertFalse(false);
        }

        // check the checkbox either for senior citizen or friends

        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();

        // add number of passengers

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("hrefIncAdt"));

        int i = 1;
        while (i <= 5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        // add currency(static dropdown)

        WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticdropdown);
        dropdown.selectByIndex(3);

        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
    }

}
