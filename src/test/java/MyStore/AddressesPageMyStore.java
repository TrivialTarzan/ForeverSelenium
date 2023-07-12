package MyStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddressesPageMyStore {

    private final WebDriver driver;

    @FindBy(xpath = "//span[text()='Create new address']")
    private WebElement addressButton;

    @FindBy(className = "address-body")
    private List<WebElement> listOfAddedAddresses;

    public AddressesPageMyStore(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyIfAddressAdded(
            String alias, String company, String address, String city, String zipCode, String phone) {
        for (WebElement addedAddress : listOfAddedAddresses) {
            String currentAddress = addedAddress.getText();
            if (currentAddress.contains(alias)
                    && currentAddress.contains(company)
                    && currentAddress.contains(address)
                    && currentAddress.contains(city)
                    && currentAddress.contains(zipCode)
                    && currentAddress.contains(phone)) {
                return true;
            }
        }
        return false;
    }

    public void navigateToCreateNewAddressPage() {
        addressButton.click();
    }
}
