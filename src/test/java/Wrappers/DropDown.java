package Wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropDown {
    String label;
    WebDriver driver;
    String inputLocator = "//span[text()='%s']/ancestor::div[contains(@class,'uiInputSelect')]//a";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String text) {
        driver.findElement(By.xpath(String.format(inputLocator, label))).click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@class='select-options']//li"));
        for (WebElement option : options) {
            if (option.getText().equals(text)) {
                option.click();
                break;
            }
        }
    }
}
