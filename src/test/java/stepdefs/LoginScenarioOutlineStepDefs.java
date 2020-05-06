package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginScenarioOutlineStepDefs {

    private WebDriver driver;
    private By usernameInputField = By.name("username");
    private By passwordInputField = By.name("password");
    private By overviewTitle = By.cssSelector("h1.title");
    private By logOutLink = By.linkText("Log Out");


    @Given("I am in the login page of the Para Bank App")
    public void iAmInTheLoginPageOfParaBank() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter valid {string} and {string}")
    public void iEnterValidUsernameAndPassword(String username, String password) {
        driver.findElement(usernameInputField).sendKeys(username);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(usernameInputField).submit();
    }

    @Then("I should be taken to Overview Page")
    public void iShouldLandOnOverviewPage() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(overviewTitle).isDisplayed();
        driver.findElement(logOutLink).click();
        driver.quit();
    }
}
