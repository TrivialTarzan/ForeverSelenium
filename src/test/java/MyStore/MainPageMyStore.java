package MyStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPageMyStore {

    private final WebDriver driver;

    @FindBy(css = "a[title='Log in to your customer account]")
    private WebElement signInButton;

    @FindBy(className = "cart-count")
    private List<WebElement> checkQuantityTagEnabled;

    @FindBy(className = "empty-cart")
    private List<WebElement> isCartEmpty;

    @FindBy(className = "cart-icon")
    private WebElement cartIcon;

    @FindBy(css = "input[type='search'].search-keyword")
    private WebElement searchBar;

    public MainPageMyStore(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnSignInButton() {
        signInButton.click();
    }

}
