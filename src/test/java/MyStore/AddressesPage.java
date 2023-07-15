package MyStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddressesPage {

    private final WebDriver driver;

    @FindBy(xpath = "//span[text()='Create new address']")
    private WebElement addressButton;

    @FindBy(className = "address-body")
    private List<WebElement> listOfAddedAddresses;

    @FindBy(xpath = "//span[text()='Delete']")
    private List<WebElement> deleteButtons;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyIfAddressAdded(
            String alias, String company, String address, String city, String zipCode, String phone) {
        for (WebElement addedAddress : listOfAddedAddresses) {
            String currentAddress = addedAddress.getText();
            // System.out.println(currentAddress);
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

    public int checkNumberOfAddresses() {
        return listOfAddedAddresses.toArray().length;
    }

    // This method deletes all addresses except the FIRST ADDED address
    public void deleteAddresses() {
        for (int i = 1; i < deleteButtons.size(); i++) {
            WebElement deleteButton = deleteButtons.get(i);
            if (deleteButtons.size() > 1) {
                deleteButton.click();
            }
        }
    }

    public void navigateToCreateNewAddressPage() {
        addressButton.click();
    }
}
