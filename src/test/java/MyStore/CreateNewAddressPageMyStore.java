package MyStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAddressPageMyStore {

    private final WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(name = "company")
    private WebElement companyInput;

    @FindBy(id = "field-address1")
    private WebElement addressInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(name = "postcode")
    private WebElement zipCodeInput;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;

    @FindBy(className = "form-control-submit")
    private WebElement saveButton;

    public CreateNewAddressPageMyStore(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillOutForm(
            String alias, String company, String address, String city, String zipCode, String phone
    ) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        companyInput.clear();
        companyInput.sendKeys(company);

        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.clear();
        cityInput.sendKeys(city);

        zipCodeInput.clear();
        zipCodeInput.sendKeys(zipCode);

        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void saveChanges() {
        saveButton.click();
    }
}
