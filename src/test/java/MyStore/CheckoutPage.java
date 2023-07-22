package MyStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckoutPage {

    private final WebDriver driver;

    @FindBy(className = "current-price")
    private WebElement discountPriceElement;

    @FindBy(className = "product-price")
    private WebElement totalPriceElement;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyIfPriceIsCorrect(String quantity) {
        double priceForOneProduct = Double.parseDouble(getDiscountedPrice());
        double totalPrice = Double.parseDouble(getTotalPrice());
        int quantityInt = Integer.parseInt(quantity);

        System.out.println("Total price: " + totalPrice);
        System.out.println("Price for one product: " + priceForOneProduct);

        return totalPrice == (priceForOneProduct * quantityInt);
    }

    public String getDiscountedPrice() {
        Pattern pattern = Pattern.compile("\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(discountPriceElement.getText());

        return matcher.group();
    }

    public String getTotalPrice() {
        Pattern pattern = Pattern.compile("\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(totalPriceElement.getText());

        return matcher.group();
    }
}
