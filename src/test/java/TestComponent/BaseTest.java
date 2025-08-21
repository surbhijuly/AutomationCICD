package TestComponent;

import E2ETesting.pageobjects.LandingPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

public WebDriver driver;
public LandingPage landingPage;
  public WebDriver initialiseDriver() throws IOException {
      Properties pro = new Properties();
      FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//E2ETesting//resources/GlobalData.properties");
      pro.load(fis);

      String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : pro.getProperty("browser");

      browserName = pro.getProperty("browser");
      System.out.println("Launching browser:"+browserName);

      if (browserName.equalsIgnoreCase("chrome")) {
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();

      }//initialise driver

      else if (browserName.equalsIgnoreCase("safari"))
      {
          WebDriverManager.safaridriver().setup();
      driver = new SafariDriver();

      }
      else {
          throw new RuntimeException("Unsupported browser:"+browserName);
      }
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      return driver;
  }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        // read json to string
        String jsonContent =  FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

        //String to Hashmap - use Jackson Databind dependency-add it in POM.xml
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> testdata = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {}
        );
        return testdata;
    }


    public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir")+"//src//main//java//Reports" +testcaseName+".png");
        FileUtils.copyFile(source, destination);
        return System.getProperty("user.dir")+"//src//main//java//Reports" +testcaseName+".png";
    }

@BeforeMethod(alwaysRun = true)
  public LandingPage launchApplication() throws IOException {
      driver = initialiseDriver();
      landingPage = new LandingPage(driver);
      landingPage.goTo();
      return landingPage;
  }

  @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        driver.quit();
    }

}
