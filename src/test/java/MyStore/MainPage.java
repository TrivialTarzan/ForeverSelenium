package MyStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    private final WebDriver driver;

//    @FindBy(css = "a[title='Log in to your customer account]")
    @FindBy(xpath = "//span[text()='Sign in']")
    private WebElement signInElement;

    @FindBy(className = "cart-count")
    private List<WebElement> checkQuantityTagEnabled;

    @FindBy(xpath = "//input[aria-label='Search']")
    private WebElement searchBar;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyDisplayedFullName(String expectedName) {
        WebElement name = driver.findElement(
                By.xpath("//span[text()='" + expectedName + "']")
        );
        return name.isDisplayed();
    }

    public void clickOnSignInButton() {
        signInElement.click();
    }

    public void findProduct(String productName) {
        searchBar.clear();
        searchBar.sendKeys(productName);
    }
}
