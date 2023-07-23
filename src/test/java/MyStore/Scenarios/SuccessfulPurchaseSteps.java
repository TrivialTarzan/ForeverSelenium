package MyStore.Scenarios;

import MyStore.*;
import MyStore.WebDriverHooks.WebDriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuccessfulPurchaseSteps {

    private final WebDriver driver;
    private final String URL = "https://mystore-testlab.coderslab.pl";
    private AccountPage accountPage;
    private MainPage mainPage;
    private SearchResultPage searchResultPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;


    public SuccessfulPurchaseSteps(WebDriverHooks hooks) {
        this.driver = hooks.getDriver();
    }

    @Given("I am on the main page")
    public void navigateToMainPage() {
        driver.get(URL);
        mainPage = new MainPage(driver);
    }

    @Then("^I log into my account with email: (.*) and password: (.*)$")
    public void logIntoAccount(String email, String password) {
        mainPage.clickOnSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email, password);
    }

    @When("^I search for the product: (.*)$")
    public void searchForProduct(String productName) {
        mainPage.findProduct(productName);
    }

    @And("^I verify the product: (.*) is displayed on the screen$")
    public void verifyProductIsDisplayed(String productName) {
        searchResultPage = new SearchResultPage(driver);
        assertTrue(searchResultPage.isProductDisplayed(productName));
    }

    @Then("^I navigate to the product page, check if the discount is displayed and equals: (.*)$")
    public void navigateToProductPageAndCheckDiscount(String discount) {
        searchResultPage.selectProduct();

        productPage = new ProductPage(driver);
        assertTrue(productPage.isDiscountDisplayed());
        assertTrue(productPage.isDiscountValueCorrect(discount));
    }

    @Then("^I choose the desired size: (.*) and quantity: (.*)$")
    public void chooseSize(String size, String quantity) {
        productPage.chooseSize(size);
        productPage.adjustQuantity(quantity);

        assertEquals(quantity, productPage.getQuantity());
        assertTrue(productPage.isSizeCorrect(size), "Incorrect size");
    }

    @Then("^I verify the material composition of the product: (.*)$")
    public void checkMaterialCompositionOfProduct(String expectedMaterial) {
        productPage.selectProductDetails();
        assertEquals(expectedMaterial, productPage.getMaterialComposition(), expectedMaterial + " " + productPage.getMaterialComposition());
    }

    @And("^I verify that there are more than (.*) items available in stock$")
    public void verifyAvailableStockGreaterThan(int minimalStock) {
        assertTrue(productPage.getAvailableStock() > minimalStock);
    }

    @Then("I add the product to the cart")
    public void addProductToCart() {
        productPage.addToCart();
    }

    @Then("I proceed to checkout")
    public void iProceedToCheckout() {
        CheckoutPopup checkoutPopup = new CheckoutPopup(driver);
        checkoutPopup.proceedToCheckout();
    }

    @And("^verify the price (.*) for the (.*) products matches the total price$")
    public void verifyPriceForProductsMatchesTotalPrice(String price, String quantity) {
        checkoutPage = new CheckoutPage(driver);
        assertTrue(checkoutPage.verifyPriceCorrect(price, quantity));
    }
}
