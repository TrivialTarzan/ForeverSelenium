package MyStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPageMyStore {

    private final WebDriver driver;

//    @FindBy(css = "a[title='Log in to your customer account]")
    @FindBy(xpath = "//span[text()='Sign in']")
    private WebElement signInElement;

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
        PageFactory.initElements(driver, this);
    }


    public void clickOnSignInButton() {
        signInElement.click();
    }

}
