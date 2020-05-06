package stepdefs;

import base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class DependencyInjectionScenarioOutline extends BaseUtil {

    private WebDriver driver;
    private By usernameInputField = By.name("username");
    private By passwordInputField = By.name("password");
    private By overviewTitle = By.cssSelector("h1.title");
    private By logOutLink = By.linkText("Log Out");
    private By userFullNameDisplay = By.className("smallText");

    private BaseUtil baseUtil;

    public DependencyInjectionScenarioOutline(BaseUtil util) {
        this.baseUtil = util;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I am on login page")
    public void inTheLoginPageOfParaBank() {
        driver.get("http://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter {string} and {string} with {string}")
    public void enterValidUsernameAndPassword(String username, String password, String userFullName1) {
        baseUtil.userFullName = userFullName1;

        driver.findElement(usernameInputField).sendKeys(username);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(usernameInputField).submit();
    }

    @Then("I should be reverted to the Overview Page")
    public void landOnOverviewPage() throws InterruptedException {
        Thread.sleep(5000);
        assertTrue(driver.findElement(userFullNameDisplay).getText(), driver.findElement(userFullNameDisplay).getText().contains(baseUtil.userFullName));
        driver.findElement(overviewTitle).isDisplayed();
        driver.findElement(logOutLink).click();
        driver.quit();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
