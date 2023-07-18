package MyStore.Scenarios;

import MyStore.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuccessfulPurchaseSteps {

    private WebDriver driver;
    private final String URL = "https://mystore-testlab.coderslab.pl";
    private AccountPage accountPage;
    private MainPage mainPage;
    private SearchResultPage searchResultPage;
    private ProductPage productPage;

    @Given("I am on the main page")
    public void navigateToMainPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Then("^I log into my account with email: (.*) and password: (.*)$")
    public void logIntoAccount(String email, String password) {
        mainPage = new MainPage(driver);
        mainPage.clickOnSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email, password);
    }

    @And("^I search for the product: (.*)$")
    public void searchForProduct(String productName) {
        mainPage.findProduct(productName);
    }

    @And("^I verify the product: (.*) is displayed on the screen$")
    public void verifyProductIsDisplayed(String productName) {
        searchResultPage = new SearchResultPage(driver);
        assertTrue(searchResultPage.verifyProductIsDisplayed(productName));
    }

    @Then("^I navigate to the product page, check if the discount is displayed and equals: (.*)$")
    public void navigateToProductPageAndCheckDiscount(String discount) {
        searchResultPage.selectProduct();

        productPage = new ProductPage(driver);
        assertTrue(productPage.verifyDiscountIsDisplayed());
        assertTrue(productPage.isDiscountValueCorrect(discount));
    }

    @Then("^I choose the desired size: (.*) and quantity: (.*)$")
    public void chooseSize(String size, String quantity) {
        productPage.chooseSize(size);
        assertTrue(productPage.isSizeCorrect(size));

        productPage.adjustQuantity(quantity);
        assertEquals(quantity, productPage.getQuantity());
    }

    @Then("^I check if the material composition of the product is: (.*)$")
    public void checkMaterialCompositionOfProduct(String expectedMaterial) {
        assertEquals(expectedMaterial, productPage.getMaterialComposition(), expectedMaterial + " " + productPage.getMaterialComposition());
    }

    @And("^I verify that there are more than (.*) items available in stock$")
    public void verifyAvailableStockGreaterThan(int minimalStock) {
        assertTrue(productPage.availableStock() > minimalStock);
    }
}
