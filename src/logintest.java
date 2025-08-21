import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class logintest {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://candidate-uat.hirebright.ai");

        // Locate email and password fields
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));

        // Locate Sign in button
        WebElement signInButton = driver.findElement(By.xpath("//button[.//span[text()='Sign in']]"));

        // Enter credentials and login
        emailField.sendKeys("uatenvcan@inboxbear.com");
        passwordField.sendKeys("Password1");
        signInButton.click();
        // Add import if needed:

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement dashboardHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/div/div[2]/div[1]/div[2]/h1")
            ));

            String headingText = dashboardHeading.getText();

            if (headingText.equalsIgnoreCase("Dashboard")) {
                System.out.println("Login Successful - Dashboard page loaded.");

                // Click the notification button now
                WebElement profile = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[2]/div/button/div/img"));
                profile.click();
            } else {
                System.out.println("Login may not be successful - Unexpected heading: " + headingText);
            }

        } catch (TimeoutException e) {
            System.out.println("Login is not successful - Dashboard heading not found.");
        }


    }
    }

