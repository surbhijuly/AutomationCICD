import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//TestNG is one of the testing framework
public class staticDropdown

{
public static void main (String[] args) throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
    driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
    System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

    //count the checkboxes
System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
Thread.sleep(1000);
    WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
    Select dropdown = new Select(staticdropdown);
    dropdown.selectByIndex(3);
    System.out.println(dropdown.getFirstSelectedOption().getText());

    driver.findElement(By.id("divpaxinfo")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("hrefIncAdt"));

    int i=1 ;
    while (i<=5)
    {
        driver.findElement(By.id("hrefIncAdt")).click();
        i++;
    }
    driver.findElement(By.id("btnclosepaxoption")).click();
}




}
