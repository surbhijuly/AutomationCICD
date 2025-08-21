package E2ETesting.pageobjects;

import E2ETesting.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponent
{
    WebDriver driver;

@FindBy(css=".totalRow button")
    WebElement checkoutEle;

@FindBy(css="tr td:nth-child(3)")
    private List<WebElement> productNames;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public Boolean VerifyOrderDisplay(String productName)
    {
        Boolean match = productNames.stream().anyMatch(item -> item.getText().equalsIgnoreCase(productName));
    return match;
    }

}
