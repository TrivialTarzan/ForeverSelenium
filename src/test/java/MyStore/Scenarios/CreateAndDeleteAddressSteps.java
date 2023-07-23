package MyStore.Scenarios;

import MyStore.*;
import MyStore.WebDriverHooks.WebDriverHooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class CreateAndDeleteAddressSteps {

    private final WebDriver driver;
    private final String URL = "https://mystore-testlab.coderslab.pl";
    private MainPage mainPage;
    private CreateNewAddressPage createNewAddressPage;
    private AddressesPage addressesPage;


    public CreateAndDeleteAddressSteps(WebDriverHooks hooks) {
        this.driver = hooks.getDriver();
    }

    @Given("I'm on the main page")
    public void navigateToMainPage() {
        driver.get(URL);
        mainPage = new MainPage(driver);
    }

    @And("^I'm logged into my account with email: (.*) and password: (.*)$")
    public void logIntoAccount(String email, String password) {
        mainPage.clickOnSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email, password);
    }

    @Then("^I verify that the name: (.*) is displayed on the screen$")
    public void verifyNameDisplayedOnScreen(String name) {
        assertTrue(mainPage.verifyDisplayedFullName(name));
    }


    @And("I navigate to 'Address' tab and click on 'Create new address' button")
    public void navigateToAddressTab() {
        AccountPage accountPage = new AccountPage(driver);
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

    @Then("I verify if the added address contains the correct " +
            "credentials: (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void verifyIfCredentialsAreCorrect(
            String alias, String company, String address, String city, String zipCode, String phone) {
        assertTrue(addressesPage.verifyIfAddressAdded(alias, company, address, city, zipCode, phone));
    }

    @Then("I delete the address and verify it was successfully deleted")
    public void deleteAddressAndVerifyItWasDeleted() {
        addressesPage.deleteAddresses();
        assertEquals(1, addressesPage.checkNumberOfAddresses());
    }

}
