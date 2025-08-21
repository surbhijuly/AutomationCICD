import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollAssignment {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//1. No. of rows of table =11
        // No. of columns of table =3
        // print data present in 2nd row

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        int rowsN = driver.findElements(By.cssSelector(".table-display tr")).size();
        System.out.println("No. of rows in the given table are " + rowsN + ".");  //1. No. of rows of table =11
        int columnN = driver.findElements(By.cssSelector(".table-display th")).size();
        System.out.println("No. of columns in the given table are " + columnN + "."); // No. of columns of table =3

        String text = driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText();
        System.out.println(text);

    }

}
