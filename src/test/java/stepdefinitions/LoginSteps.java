package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

public class LoginSteps {
    private WebDriver driver = Hooks.driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // adjust URL if needed
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get("https://opensource-demo.orangehrmlive.com/");
    	System.out.println("Page loaded successfully!");
    }

    
    @When("the user enters valid username {string} and password {string}")
    public void the_user_enters_valid_username_and_password(String username, String password) {
        //driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        //driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }


    @When("the user enters invalid username {string} and password {string}")
    public void the_user_enters_invalid_username_and_password(String username, String password) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }

    @When("the user leaves the username field empty and enters password {string}")
    public void the_user_leaves_username_empty(String password) {
        driver.findElement(By.xpath("//input[@name='username']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }

    @When("the user enters username {string} and leaves the password field empty")
    public void the_user_leaves_password_empty(String username) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).clear();
    }

    @And("clicks the login button")
    public void clicks_login_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

   @Then("the user should be redirected to the dashboard page")
    public void the_user_should_be_redirected_to_the_dashboard_page() {
        // check welcome element is displayed on successful login
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        System.out.println("Actual URL: " + actualUrl);
        System.out.println("Expected URL: " + expectedUrl);
        assertEquals(expectedUrl, actualUrl);
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String message) {
        String actualMessage = driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
        assertEquals(message, actualMessage);
    }
}

