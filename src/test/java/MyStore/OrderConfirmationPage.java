package MyStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class OrderConfirmationPage {

    private final WebDriver driver;

    @FindBy(name = "confirm-addresses")
    private WebElement confirmAddressButton;

    @FindBy(xpath = "//button[contains(text(), 'Continue')]")
    private WebElement confirmPersonalInfoButton;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmDeliveryOptionButton;

    @FindBy(id = "delivery_option_8")
    private WebElement selfPickUpCheckbox;

    @FindBy(id = "delivery_option_6")
    private WebElement myCarrierCheckbox;

    @FindBy(name = "delivery_message")
    private WebElement deliveryMessageInput;

    @FindBy(id = "payment-option-1")
    private WebElement payByCheckCheckbox;

    @FindBy(id = "payment-option-2")
    private WebElement payByBankWireCheckbox;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement termsOfServiceChceckbox;

    @FindBy(xpath = "//button[contains(text(), 'Place order')]")
    private WebElement submitButton;

    @FindBy(xpath = "//dd[contains(text(), '€')]")
    private WebElement orderAmountText;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void confirmPersonalInformation() {
        if (confirmPersonalInfoButton.isDisplayed()) {
            confirmPersonalInfoButton.click();
        }
    }

    public void confirmAddress() {
        if (confirmAddressButton.isDisplayed()) {
            confirmAddressButton.click();
        }
    }

    public void confirmShippingMethod() {
        if (confirmDeliveryOptionButton.isDisplayed()) {
            confirmDeliveryOptionButton.click();
        }
    }

    public void selectPaymentMethod(String paymentMethod) {
        if (Objects.equals(paymentMethod, "Pay by Check")) {
            payByCheckCheckbox.click();
        } else if (Objects.equals(paymentMethod, "Pay by bank wire")) {
            payByBankWireCheckbox.click();
        }
    }

    public void agreeToTermsOfService() {
        termsOfServiceChceckbox.click();
    }

    public String getOrderAmount() {
        return orderAmountText.getText();
    }

    public void placeOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).perform();
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }

}
