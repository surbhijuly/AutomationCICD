package E2ETesting.pageobjects;

import E2ETesting.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent
{
    WebDriver driver;

@FindBy(css=".totalRow button")
    WebElement checkoutEle;

@FindBy(css=".cartSection H3")
    private List<WebElement> cartProducts;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifyProductDisplay(String productName)
    {
        boolean match = cartProducts.stream().map(item -> item.getText().trim()).anyMatch(item -> item.equalsIgnoreCase(productName.trim()));
    return match;
    }

    public CheckoutPage goToCheckout()

    {
        checkoutEle.click();
        return new CheckoutPage(driver);
    }
}
