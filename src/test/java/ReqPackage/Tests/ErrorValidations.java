package ReqPackage.Tests;

import TestComponent.BaseTest;
import TestComponent.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidations extends BaseTest
{

@Test (groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
public void LoginErrorValidation() throws IOException, InterruptedException {

   // WebDriverManager.chromedriver().setup();
    String nameI = "ZARA COAT 3";
    landingPage.LoginApplication("Surbhidoc11@gmail.com","Automation@2025");
    //surbhidoc11@gmail.com, Automation@2025
Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());


}

}
