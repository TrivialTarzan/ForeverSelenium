package MyStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage {

    private final WebDriver driver;

    @FindBy(xpath = "//span[@class='product-price']")
    private WebElement totalPriceElement;

    @FindBy(className = "current-price")
    private WebElement discountPriceElement;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyPriceCorrect(String price, String quantity) {
        double multipliedDiscountPrice = Double.parseDouble(price) * Integer.parseInt(quantity);
        String expectedPrice = String.valueOf(multipliedDiscountPrice);

        return getTotalPrice().contains(expectedPrice);
    }


    public String getTotalPrice() {
        return totalPriceElement.getText();
    }
}
