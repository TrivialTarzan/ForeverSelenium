package MyStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private final WebDriver driver;

    @FindBy(xpath = "//span[text()='\n            Addresses\n          ']")
    private WebElement addressTab;


    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToAddressTab() {
        addressTab.click();
    }
}
