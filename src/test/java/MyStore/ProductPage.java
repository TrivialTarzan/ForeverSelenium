package MyStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private final WebDriver driver;

    @FindBy(className = "discount-percentage")
    private WebElement discountElement;

    @FindBy(className = "form-control-select")
    private WebElement sizeDropdown;

    @FindBy(className = "control-label")
    private WebElement sizeTextElement;

    @FindBy(css = "a[aria-controls='product-details']")
    private WebElement productDetailsElement;

    @FindBy(css = "dd.value")
    private WebElement materialCompositionElement;

    @FindBy(css = "span[data-stock]")
    private WebElement availableStockElement;

    @FindBy(className = "touchspin-up")
    private WebElement increaseQuantityButton;

    @FindBy(className = "touchspin-down")
    private WebElement decreaseQuantityButton;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityInputElement;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyDiscountIsDisplayed() {
        return discountElement.isDisplayed();
    }

    public boolean isDiscountValueCorrect(String discount) {
        return discountElement.getText().contains(discount);
    }

    public void chooseSize(String size) {
        sizeDropdown.click();

        WebElement sizeElement = driver.findElement(By.xpath("//option[@title='" + size + "']"));
        if (sizeElement.isEnabled()) {
            sizeElement.click();
        }
    }

    public boolean isSizeCorrect(String expectedSize) {
        System.out.println(sizeTextElement.getText());
        return sizeTextElement.getText().contains(expectedSize);
    }

    public String getQuantity() {
        return quantityInputElement.getAttribute("value");
    }

    public void adjustQuantity(String quantity) {
        int desiredQuantity = Integer.parseInt(quantity);
        int displayedQuantity = Integer.parseInt(getQuantity());

        if (desiredQuantity > displayedQuantity) {
            for (int i = displayedQuantity; i < desiredQuantity; i++) {
                increaseQuantityButton.click();
            }
        } else if ( displayedQuantity > desiredQuantity) {
            for (int i = displayedQuantity - 1; i > desiredQuantity; i--) {
                decreaseQuantityButton.click();
            }
        }
    }

    public String getMaterialComposition() {
        productDetailsElement.click();
        return materialCompositionElement.getText();
    }

    public int availableStock() {
        String stockText = availableStockElement.getText();
        String extractedStockNumber = stockText.replace("[^0-9]", "");

        return Integer.parseInt(extractedStockNumber);
    }
}
