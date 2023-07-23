package MyStore.WebDriverHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.picocontainer.PicoFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

import java.time.Duration;

public class WebDriverHooks {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        MutablePicoContainer pico = new DefaultPicoContainer();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        pico.addComponent(WebDriver.class, driver);
    }

    @After(order = 0)
    public void tearDown() {
        driver.quit();
    }
}
