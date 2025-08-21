import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//2nd Assignment
public class chkboxAssignment
{
public static void main (String[] args) throws InterruptedException {
    WebDriver driver= new ChromeDriver();


driver.get("https://rahulshettyacademy.com/angularpractice/");
driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys("Surbhi");
driver.findElement(By.xpath("//input[@name='email']")).sendKeys("surbhidoc11@gmail.com");
driver.findElement(By.id("exampleInputPassword1")).sendKeys("Password1");
driver.findElement(By.id("exampleCheck1")).click();
WebElement sdropdown = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
    Select dropdown = new Select(sdropdown);
    dropdown.selectByIndex(1);
    System.out.println(dropdown);
    driver.findElement(By.id("inlineRadio1")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("bday")).sendKeys("11/07/1993");
    driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
    System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());

}

}







 /* First assignment

 import org.testng.Assert;

import java.util.List;
    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
    Assert.assertTrue(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
    driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
    Assert.assertFalse(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());

    int options = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
    System.out.println("No. of Checkboxes are : " + options);
*/