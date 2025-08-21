package E2ETesting.pageobjects;

import E2ETesting.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends AbstractComponent {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page factory
    @FindBy(id = "firstName")
    WebElement firstNameInput;

    @FindBy(id = "lastName")
    WebElement lastNameInput;

    @FindBy(id = "userEmail")
    WebElement emailInput;

    @FindBy(id = "userMobile")
    WebElement mobileInput;

    @FindBy(css = "select[formcontrolname='occupation']")
    WebElement occupationSelect;

    @FindBy(css = "input[formcontrolname='gender'][value='Male']")
    WebElement genderMaleRadio;

    @FindBy(css = "input[formcontrolname='gender'][value='Female']")
    WebElement genderFemaleRadio;

    @FindBy(id = "userPassword")
    WebElement passwordInput;

    @FindBy(id = "confirmPassword")
    WebElement confirmPasswordInput;

    @FindBy(css = "input[formcontrolname='required']")
    WebElement termsCheckbox;

    @FindBy(id = "login")
    WebElement registerButton;

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client/#/auth/register");
    }

    public LandingPage registerNewUser(String firstName, String lastName, String email, String mobile, String occupation, String gender, String password, String confirmPassword, boolean acceptTerms) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        mobileInput.sendKeys(mobile);

        Select occupationDropdown = new Select(occupationSelect);
        occupationDropdown.selectByVisibleText(occupation);

        if (gender != null) {
            if (gender.equalsIgnoreCase("Male")) {
                genderMaleRadio.click();
            } else if (gender.equalsIgnoreCase("Female")) {
                genderFemaleRadio.click();
            }
        }

        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);

        if (acceptTerms) {
            termsCheckbox.click();
        }

        registerButton.click();
        return new LandingPage(driver);
    }
}


