package pages;

import Wrappers.DropDown;
import Wrappers.Input;
import Wrappers.TextArea;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage extends BasePage {

    public static final String ACCOUNTS_PAGE_URL = "https://teachmeskillsheorhi.lightning.force.com/lightning/o/Account/list";
    public static final String USER_TITLE = "[title=New]";

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Filling all fields")
    public void fillIn(String accountName, String phone, String parentAccount, String fax, String website,
                       String employees, String annualRevenue, String description, String billingStreet,
                       String shippingStreet, String billingCity, String billingStateProvince, String billingZipPostalCode,
                       String billingCountry, String shippingCity, String shippingStateProvince, String shippingZipPostalCode,
                       String shippingCountry, String type, String industry) {
        new Input(driver, "Account Name").write(accountName);
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Parent Account").write(parentAccount);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Website").write(website);
        new DropDown(driver, "Type").select(type);
        new DropDown(driver, "Industry").select(industry);
        new Input(driver, "Employees").write(employees);
        new Input(driver, "Annual Revenue").write(annualRevenue);
        new TextArea(driver, "Description").write(description);
        new TextArea(driver, "Billing Street").write(billingStreet);
        new TextArea(driver, "Shipping Street").write(shippingStreet);
        new Input(driver, "Billing City").write(billingCity);
        new Input(driver, "Billing State/Province").write(billingStateProvince);
        new Input(driver, "Billing Zip/Postal Code").write(billingZipPostalCode);
        new Input(driver, "Billing Country").write(billingCountry);
        new Input(driver, "Shipping City").write(shippingCity);
        new Input(driver, "Shipping State/Province").write(shippingStateProvince);
        new Input(driver, "Shipping Zip/Postal Code").write(shippingZipPostalCode);
        new Input(driver, "Shipping Country").write(shippingCountry);
    }

    @Step("Opening accounts page")
    public void openAccountsPage() {
        driver.get(ACCOUNTS_PAGE_URL);
    }

    @Step("Click on button to create new account")
    public void createNewAccountButton() {
        driver.findElement(By.cssSelector(USER_TITLE)).click();
    }
}
