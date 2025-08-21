package E2ETesting.pageobjects;

import E2ETesting.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalog extends AbstractComponent {
    WebDriver driver;

    public ProductCatalog(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //page factory
//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css=".ng-animating")
         WebElement spinner;

    By productsBy= By.cssSelector(".mb-3");
    By addToCart= By.xpath("//button/parent::div/button[2]");
    By toastMessage = By.cssSelector("#toast-container");
public List<WebElement> getProductList()
{
    waitForElementToAppear(productsBy);
    return products;

}

public WebElement getProductByName(String productName)
{

    WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findAny().orElse(null);
return prod;
}

public void addProductToCart(String productName) throws InterruptedException {
    WebElement prod = getProductByName(productName);
    System.out.println("Adding to cart: " + productName);
    if (prod == null) {
        throw new RuntimeException("Product not found: " + productName);
    }
    prod.findElement(addToCart).click();
    waitForElementToAppear(toastMessage);
    waitForElementToDisappear(spinner);
}

}
