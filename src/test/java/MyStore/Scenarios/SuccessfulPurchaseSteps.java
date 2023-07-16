package MyStore.Scenarios;

import MyStore.AccountPage;
import MyStore.LoginPage;
import MyStore.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuccessfulPurchaseSteps {

    private WebDriver driver;

    private final String URL = "https://mystore-testlab.coderslab.pl";

    private AccountPage accountPage;

    private MainPage mainPage;

    @BeforeAll
    public void navigateToMainPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);
    }

    @Given("^I log into my account with email: (.*) and password: (.*)$")
    public void logIntoAccount(String email, String password) {
        mainPage = new MainPage(driver);
        mainPage.clickOnSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email, password);
    }

    @And("^I verify that my name: (.*) is displayed on the screen$")
    public void verifyNameDisplayedOnScreen(String name) {
        mainPage = new MainPage(driver);
        assertTrue(mainPage.verifyDisplayedFullName(name));
    }

    @Then("^I search for the product: (.*)$")
    public void searchForProduct() {
    }
}
