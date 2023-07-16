package MyStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {

    private final WebDriver driver;

    @FindBy(className = "product-thumbnail")
    private WebElement productElement;

    @FindBy(className = "product-thumbnail")
    private List<WebElement> listOfProducts;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
        productElement.click();
    }
}
