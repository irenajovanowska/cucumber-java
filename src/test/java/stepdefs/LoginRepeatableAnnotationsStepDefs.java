package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginRepeatableAnnotationsStepDefs {

    private WebDriver driver;
    private By usernameInputField = By.name("username");
    private By passwordInputField = By.name("password");
    private By overviewTitle = By.cssSelector("h1.title");
    private By logOutLink = By.linkText("Log Out");


    @Given("I am in the login page")
    @Given("I am in the login page of Para Bank Application")
    public void iAmInTheLoginPageOfParaBankApplication() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter valid username and password")
    public void iEnterValidUserAndPass() {
        String username = "tautester";
        String password = "password";

        driver.findElement(usernameInputField).sendKeys(username);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(usernameInputField).submit();
    }

    @Then("I should land on the Overview Page")
    public void iShouldLandOnTheOverviewPage() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(overviewTitle).isDisplayed();
        driver.findElement(logOutLink).click();
        driver.quit();
    }
}
