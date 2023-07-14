package MyStore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class CreatingNewAddressSteps {

    private WebDriver driver;

    private final String URL = "https://mystore-testlab.coderslab.pl";

    private AccountPage accountPage;

    private CreateNewAddressPage createNewAddressPage;

    private AddressesPage addressesPage;

    @Given("I'm on the main page")
    public void navigateToMainPage() {
        driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);
    }

    @And("^I'm logged into my account with email: (.*) and password: (.*)$")
    public void logIntoAccount(String email, String password) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email, password);
    }

    @Then("^I verify that the name: (.*) is displayed on the screen$")
    public void verifyNameDisplayedOnScreen(String name) {
        accountPage = new AccountPage(driver);
        assertTrue(accountPage.verifyDisplayedFullName(name));
    }


    @And("I navigate to 'Address' tab and click on 'Create new address' button")
    public void navigateToAddressTab() {
        accountPage.goToAddressTab();

        addressesPage = new AddressesPage(driver);
        addressesPage.navigateToCreateNewAddressPage();
    }

    @When("^I fill out the form with following credentials: (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void fillTheForm(
            String alias, String company, String address, String city, String zipCode, String phone) {
        createNewAddressPage = new CreateNewAddressPage(driver);
        createNewAddressPage.fillOutForm(alias, company, address, city, zipCode, phone);
    }

    @And("save the changes")
    public void saveTheChanges() {
        createNewAddressPage.saveChanges();
    }

    @Then("I verify if the added address contains the correct credentials")
    public void verifyIfCredentialsAreCorrect(
            String alias, String company, String address, String city, String zipCode, String phone) {
        assertTrue(addressesPage.verifyIfAddressAdded(alias, company, address, city, zipCode, phone));
    }

}
