package ReqPackage.Tests;

import E2ETesting.pageobjects.LandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandaloneTest
{

public static void main(String[] args)
{
//adding for cicd test2

   // WebDriverManager.chromedriver().setup();
    String nameI = "ZARA COAT 3";
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://rahulshettyacademy.com/client/#/auth/login");

    LandingPage landingPage = new LandingPage(driver);

    //surbhidoc11@gmail.com, Automation@2025
driver.findElement(By.id("userEmail")).sendKeys("surbhidoc11@gmail.com");
driver.findElement(By.id("userPassword")).sendKeys("Automation@2025");
driver.findElement(By.id("login")).click();
List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
WebElement prod = products.stream().filter(item->item.findElement(By.cssSelector("b")).getText().equals(nameI)).findFirst().orElse(null);
prod.findElement(By.xpath("//button/parent::div/button[2]")).click();

    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
    //.toast-bottom-right
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".toast-bottom-right")));
    driver.findElement(By.xpath("//html/body/app-root/app-dashboard/app-sidebar/nav/ul/li[4]/button")).click();
List<WebElement> cartitem = driver.findElements(By.cssSelector(".cart ul li div div h3"));
    boolean match = cartitem.stream().anyMatch(item -> item.getText().equalsIgnoreCase(nameI));
    Assert.assertTrue(match);
    driver.findElement(By.cssSelector(".subtotal ul li button")).click();

    Actions a = new Actions(driver);
    a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
a.moveToElement(driver.findElement(By.cssSelector(".ta-results button:nth-of-type(2)"))).click().perform();
driver.findElement(By.cssSelector(".action__submit")).click();
String textTwo = driver.findElement(By.tagName("h1")).getText();
Assert.assertTrue(textTwo.equalsIgnoreCase("Thankyou for the order."));
driver.quit();

}

}
