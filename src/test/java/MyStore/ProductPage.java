package MyStore;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(className = "add-to-cart")
    private WebElement addToCartButton;

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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    private void waitForElement(long miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isDiscountDisplayed() {
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
        WebElement expectedElement = driver.findElement(
                By.xpath("//span[contains(text(), '" + expectedSize + "')]"));

        wait.until(ExpectedConditions.visibilityOf(expectedElement));

        return sizeTextElement.getText().contains(expectedSize);
    }

    public String getQuantity() {
        return quantityInputElement.getAttribute("value");
    }

    public void adjustQuantity(String quantity) {
        int desiredQuantity = Integer.parseInt(quantity);
        int displayedQuantity = Integer.parseInt(getQuantity());

        if (desiredQuantity > displayedQuantity) {
            for (int i = displayedQuantity; i <= desiredQuantity; i++) {
                increaseQuantityButton.click();
                waitForElement(200);
            }
        } else if ( displayedQuantity > desiredQuantity) {
            for (int i = displayedQuantity - 1; i >= desiredQuantity; i--) {
                decreaseQuantityButton.click();
                waitForElement(200);
            }
        }
    }

    public void changeQuantity(String quantity) {
        quantityInputElement.clear();
        quantityInputElement.sendKeys(quantity);
    }

    public void selectProductDetails() {
        productDetailsElement.click();
    }

    public String getMaterialComposition() {
        return materialCompositionElement.getAttribute("innerText");
    }

    public int getAvailableStock() {
        return Integer.parseInt(availableStockElement.getAttribute("data-stock"));
    }

    public void addToCart() {
        try {
            addToCartButton.click();
        } catch (StaleElementReferenceException e) {
            addToCartButton = driver.findElement(By.className("add-to-cart"));
            addToCartButton.click();
        }
    }

}
