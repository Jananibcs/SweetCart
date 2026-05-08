package base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import java.time.Duration;
public class BaseClass {
    public static WebDriver driver;
    @BeforeMethod
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("baseUrl");
        String timeout = ConfigReader.getProperty("timeout");
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(timeout)));
        driver.get(url);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
