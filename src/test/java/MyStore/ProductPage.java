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

    @FindBy(css = "a[aria-controls='product-details']")
    private WebElement productDetailsElement;

    @FindBy(css = "dd.value")
    private WebElement materialCompositionElement;

    @FindBy(css = "span[data-stock]")
    private WebElement availableStockElement;

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

        WebElement sizeElement = driver.findElement(By.xpath("//option[title='" + size + "']"));
        if (sizeElement.isEnabled()) {
            sizeElement.click();
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
