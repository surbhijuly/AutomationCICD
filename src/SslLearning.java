/*import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SslLearning {
    public static void main(String[] args) {
        SafariOptions option = new SafariOptions(); //for safari
        option.setAcceptInsecureCerts(true);

        ChromeOptions option = new ChromeOptions();
        option.setAcceptInsecureCerts(true);
        // option.addExtensions("");
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("");
        option.setCapability("Proxy", proxy);

        WebDriver driver = new SafariDriver(option);
        driver.get("https://expired.badssl.com/");

    }
}
*/