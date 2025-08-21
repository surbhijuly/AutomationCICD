package ReqPackage.Tests;

import E2ETesting.pageobjects.*;
import TestComponent.BaseTest;
// removed unused imports
// removed unused imports
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// removed unused imports
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


/**
 * End-to-end tests for submitting an order.
 *
 * Flow:
 * 1) (Optional) Register user
 * 2) Login
 * 3) Add product to cart
 * 4) Verify cart contents
 * 5) Checkout and place order
 * 6) Verify confirmation and (in dependent test) order history
 */
public class SubmitOrderTest extends BaseTest
{
    public String productName;
    public String loginEmail;
    public String loginPassword;
    /**
     * Places an order for the given input data.
     *
     * Expected keys in input: "email", "password", "productName".
     */
@Test (dataProvider = "getData", groups={"Purchase"})
public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
    productName = input.get("productName");
    loginEmail = input.get("email");
    loginPassword = input.get("password");
   // WebDriverManager.chromedriver().setup();
   // Optional precondition: register user with provided credentials
   RegistrationPage registrationPage = new RegistrationPage(driver);
   registrationPage.goTo();
   landingPage = registrationPage.registerNewUser(
       "Jane", "Doe",
       input.get("email"),
       "9999999999",
       "Engineer",
       "Female",
       input.get("password"),
       input.get("password"),
       true
   );
   // Navigate to login page to proceed with authentication
   new LandingPage(driver).goTo();
    // Login using supplied credentials
    ProductCatalog productCatalog = landingPage.LoginApplication(loginEmail, loginPassword);
    //surbhidoc11@gmail.com, Automation@2025

    // Fetch product list and add the requested product to cart
    productCatalog.getProductList();
    productCatalog.addProductToCart(input.get("productName"));
    // Open cart and verify product is present
    CartPage cartPage = productCatalog.goToCartPage();

    boolean match = cartPage.verifyProductDisplay(input.get("productName"));
    Assert.assertTrue(match);

    // Proceed to checkout and place the order
    CheckoutPage checkoutPage = cartPage.goToCheckout();
    checkoutPage.selectCountry("India");
    ConfirmationPage confirmationPage = checkoutPage.submitOrder();

// Validate confirmation message
String confirmMessage = confirmationPage.getConfirmationMessage();
Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


}

    /**
     * Confirms that the purchased product appears in order history.
     */
@Test (dependsOnMethods = {"SubmitOrder"})
    public void OrderHistoryTest()
{
    ProductCatalog productCatalog = landingPage.LoginApplication(loginEmail, loginPassword);
    OrderPage orderPage = productCatalog.goToOrdersPage();

    Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
}



    /**
     * Provides test data from the JSON file as an array of maps.
     */
@DataProvider
    public Object[][] getData() throws IOException {
 /*   HashMap<String,String> map = new HashMap<String, String>();
    map.put("email", "surbhidoc11@gmail.com");
    map.put("password", "Automation@2025");
    map.put("productName", "ZARA COAT 3");

    HashMap<String,String> map1 = new HashMap<String, String>();
    map1.put("email", "test@dropjar.com");
    map1.put("password", "Test@123");
    map1.put("productName", "ADIDAS ORIGINAL");

  */
    List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//E2ETesting//data//PurchaseOrder.json");
return  new Object[][] {{data.get(0)},{data.get(1)}};


   // return new Object[][] {{"surbhidoc11@gmail.com", "Automation@2025", "ZARA COAT 3"},{"test@dropjar.com","Test@123","ADIDAS ORIGINAL"}};
}

}
