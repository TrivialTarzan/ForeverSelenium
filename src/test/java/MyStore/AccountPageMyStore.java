package MyStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPageMyStore {

    private final WebDriver driver;

    @FindBy(xpath = "//span[text()='Add first address']")
    private WebElement addAddressButton;

    public AccountPageMyStore(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyDisplayedFullName(String expectedName) {
        WebElement getName = driver.findElement(By.xpath("//span[text()='" + expectedName + "']"));

        return getName.isDisplayed();
    }

    public void addNewAddress() {

    }
}
