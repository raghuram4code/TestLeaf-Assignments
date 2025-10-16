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
 * Page Object class representing the Login page of the Retail customer application.
 * Contains locators and actions for login-related elements.
 */
class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor to initialize the LoginPage with WebDriver and WebDriverWait.
     *
     * @param driver the WebDriver instance
     */
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

    /**
     * Clicks the 'For Individual Standards and Curated Sets' button.
     */
    public void clickForIndividualStandards() {
        btnForIndividualStandards.click();
    }

    /**
     * Clicks the 'For Custom Subscriptions' button.
     */
    public void clickForCustomSubscriptions() {
        btnForCustomSubscriptions.click();
    }

    /**
     * Clicks the 'Create an account on Store' link.
     */
    public void clickCreateAccountLink() {
        linkCreateAccount.click();
    }
}

/**
 * Test class to validate the Login page functionality using Page Object Model.
 */
public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    /**
     * Sets up the ChromeDriver, navigates to the login page, and initializes the LoginPage object.
     */
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://store.standards.org.au");
        loginPage = new LoginPage(driver);
    }

    /**
     * Validates clicking the 'For Individual Standards and Curated Sets' button.
     */
    @Test
    public void testClickForIndividualStandards() {
        loginPage.clickForIndividualStandards();
    }

    /**
     * Validates clicking the 'For Custom Subscriptions' button.
     */
    @Test
    public void testClickForCustomSubscriptions() {
        loginPage.clickForCustomSubscriptions();
    }

    /**
     * Validates clicking the 'Create an account on Store' link.
     */
    @Test
    public void testClickCreateAccountLink() {
        loginPage.clickCreateAccountLink();
    }

    /**
     * Closes the browser after each test.
     */
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
