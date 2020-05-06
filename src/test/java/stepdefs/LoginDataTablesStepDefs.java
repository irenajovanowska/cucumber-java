package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LoginDataTablesStepDefs {

    private WebDriver driver;
    private By usernameInputField = By.name("username");
    private By passwordInputField = By.name("password");
    private By overviewTitle = By.cssSelector("h1.title");
    private By logOutLink = By.linkText("Log Out");

    @Given("I am in the login page of the App")
    public void iAmInTheLoginPageOfTheApp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter user and pass")
    public void iEnterUserAndPass(DataTable table) {
        List<String> loginForm = table.asList();

        driver.findElement(usernameInputField).sendKeys(loginForm.get(0));
        driver.findElement(passwordInputField).sendKeys(loginForm.get(1));
        driver.findElement(usernameInputField).submit();
    }

    @Then("I should land to Overview Page")
    public void iShouldLandToOverviewPage() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(overviewTitle).isDisplayed();
        driver.findElement(logOutLink).click();
        driver.quit();
    }
}
