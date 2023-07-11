package MyStore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class CreatingNewAddressSteps {

    private WebDriver driver;
    

    private final String URL = "https://mystore-testlab.coderslab.pl";

    @Given("I'm on the main page")
    public void navigateToMainPage() {
        driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);
    }

    @And("^I'm logged into my account with email: (.*) and password: (.*)$")
    public void logIntoAccount(String email, String password) {
        MainPageMyStore mainPage = new MainPageMyStore(driver);
        mainPage.clickOnSignInButton();

        LoginPageMyStore loginPage = new LoginPageMyStore(driver);
        loginPage.loginAs(email, password);
    }

    @Then("^Then I verify that the name (.*) is displayed on the screen$")
    public void thenIVerifyThatTheNameFullNameIsDisplayedOnTheScreen() {
    }
}
