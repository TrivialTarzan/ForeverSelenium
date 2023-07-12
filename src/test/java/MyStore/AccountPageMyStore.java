package MyStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPageMyStore {

    private final WebDriver driver;

    @FindBy(xpath = "//span[text()='Addresses']")
    private WebElement addressTab;


    public AccountPageMyStore(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyDisplayedFullName(String expectedName) {
        WebElement name = driver.findElement(
                By.xpath("//span[text()='" + expectedName + "']")
        );
        return name.isDisplayed();
    }

    public void goToAddressTab() {
        addressTab.click();
    }
}
