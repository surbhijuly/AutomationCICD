import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.Select;

public class PracticeAssignmentSix {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // 1. check anyone select box.
        // 2. print the text for the selected checkbox
//3. in the select field, select the text same as selected in checkbox. drive it dynamically from step 2.
        //4. Enter the step 2 grabbed label text in editbox
// 5. Click Alert and verify if text grabbed in step 2 is present in the alert popup or not.

        driver.findElement(By.id("checkBoxOption1")).click();
        String name = driver.findElement(By.cssSelector("label[for*='bmw']")).getText();
        System.out.println(name);  //Grabbed text
        driver.findElement(By.id("dropdown-class-example")).click();
        WebElement sdropdown = driver.findElement(By.id("dropdown-class-example"));
        Select a = new Select(sdropdown);
        a.selectByVisibleText(name);
        //System.out.println(a);
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("alertbtn")).click();
        System.out.print(driver.switchTo().alert().getText());
        String nameTwo = driver.switchTo().alert().getText();
        System.out.println("\n");
        if (nameTwo.contains(name)) {
            System.out.println("Text is present in the Alert Popup");
        } else {
            System.out.println("Code is not working");
        }
        driver.switchTo().alert().accept();
    }
}
