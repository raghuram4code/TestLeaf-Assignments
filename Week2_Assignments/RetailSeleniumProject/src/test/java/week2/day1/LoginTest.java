package week2.day1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Page Object class representing the Login page of the Retail customer
 * application.
 */
class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='new-login-button']")
    private WebElement btnForIndividualStandards;

    @FindBy(xpath = "//div[@id='sw-redirect-button']")
    private WebElement btnForCustomSubscriptions;

    @FindBy(xpath = "//div[@id='create-acount-link']")
    private WebElement linkCreateAccount;

    public void clickForIndividualStandards() {
        btnForIndividualStandards.click();
    }

    public void clickForCustomSubscriptions() {
        btnForCustomSubscriptions.click();
    }

    public void clickCreateAccountLink() {
        linkCreateAccount.click();
    }
}

/**
 * Test class to validate the Login page functionality.
 */
public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://store.standards.org.au");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testClickForIndividualStandards() {
        loginPage.clickForIndividualStandards();
    }

    @Test
    public void testClickForCustomSubscriptions() {
        loginPage.clickForCustomSubscriptions();
    }

    @Test
    public void testClickCreateAccountLink() {
        loginPage.clickCreateAccountLink();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}