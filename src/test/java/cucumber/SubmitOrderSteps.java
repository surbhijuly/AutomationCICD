package cucumber;

import E2ETesting.pageobjects.*;
import TestComponent.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SubmitOrderSteps {
    private final BaseTest baseTest = new BaseTest();
    private WebDriver driver;
    private LandingPage landingPage;
    private ProductCatalog productCatalog;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ConfirmationPage confirmationPage;
    private OrderPage orderPage;
    private String currentProductName;

    @Given("I launch the application")
    public void i_launch_the_application() throws Exception {
        driver = baseTest.initialiseDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
    }

    @When("I register a user with email {string} and password {string}")
    public void i_register_a_user_with_email_and_password(String email, String password) {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        landingPage = registrationPage.registerNewUser(
                "Jane", "Doe",
                email,
                "9999999999",
                "Engineer",
                "Female",
                password,
                password,
                true
        );
        new LandingPage(driver).goTo();
    }

    @When("I login with email {string} and password {string}")
    public void i_login_with_email_and_password(String email, String password) {
        productCatalog = landingPage.LoginApplication(email, password);
    }

    @When("I add product {string} to the cart")
    public void i_add_product_to_the_cart(String productName) throws InterruptedException {
        currentProductName = productName;
        productCatalog.getProductList();
        productCatalog.addProductToCart(productName);
    }

    @When("I checkout and select country {string}")
    public void i_checkout_and_select_country(String country) {
        cartPage = productCatalog.goToCartPage();
        Assert.assertTrue(cartPage.verifyProductDisplay(currentProductName));
        checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry(country);
    }

    @When("I submit the order")
    public void i_submit_the_order() {
        confirmationPage = checkoutPage.submitOrder();
    }

    @Then("I should see the confirmation message {string}")
    public void i_should_see_the_confirmation_message(String expectedMessage) {
        String actual = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(actual.equalsIgnoreCase(expectedMessage));
    }

    @Then("The product {string} should be present in Order History")
    public void the_product_should_be_present_in_order_history(String productName) {
        orderPage = productCatalog.goToOrdersPage();
        Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


