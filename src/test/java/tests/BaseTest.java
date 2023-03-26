package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.AccountsPage;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    AccountsPage accountsPage;
    public static final String USER = "reiybhujif-lr1u@force.com";
    public static final String PASSWORD = "4da8db88";

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
//            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        testContext.setAttribute("driver", driver);


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        accountsPage = new AccountsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
