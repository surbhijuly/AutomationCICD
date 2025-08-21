package E2ETesting.pageobjects;

import E2ETesting.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //page factory
//driver.findElement(By.id("userEmail")).sendKeys("surbhidoc11@gmail.com");
    @FindBy(id = "userEmail")
    WebElement userEmail;
    //driver.findElement(By.id("userPassword")).sendKeys("Automation@2025");
    @FindBy(id = "userPassword")
    WebElement password;
    //driver.findElement(By.id("login")).click();
    @FindBy(id = "login")
    WebElement submit;

    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;
    public ProductCatalog LoginApplication(String email, String pass)
    {
        userEmail.sendKeys(email);
        password.sendKeys(pass);
        submit.click();

        return new ProductCatalog(driver);
    }

    public String getErrorMessage() {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
    }


}
