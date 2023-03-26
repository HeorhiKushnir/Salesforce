package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void login() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        loginPage.userTitleIsDisplayed();
        accountsPage.openAccountsPage();
        accountsPage.createNewAccountButton();
        accountsPage.fillIn("Account Name", "Phone", "Parrent Account", "Fax",
                "Website", "Employees", "Annual Revenue", "Description",
                "Billing Street", "Shipping Street", "Billing City",
                "Billing State Province", "Billing Zip/Postal Code",
                "Billing Country", "Shipping City", "Shipping State Province",
                "Shipping Zip/Postal Code", "Shipping Country", "Аналитик",
                "Одежда");
    }
}
