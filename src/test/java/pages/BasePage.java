package pages;

import org.openqa.selenium.WebDriver;

abstract class BasePage {

    WebDriver driver;
    public static final String BASE_URL = "https://login.salesforce.com/";

    BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
