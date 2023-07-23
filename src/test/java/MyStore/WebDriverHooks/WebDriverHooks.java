package MyStore.WebDriverHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
* This class was created to prevent triggering multiple @Before and @After Cucumber fixtures,
* which caused the opening of multiple browser windows, even when only one scenario was being executed
 **/

public class WebDriverHooks {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }

    public WebDriver getDriver() {
        return driver;
    }
}
