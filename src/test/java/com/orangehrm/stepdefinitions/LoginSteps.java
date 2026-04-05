package com.orangehrm.stepdefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import com.orangehrm.driver.DriverManager;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.config.Config;

/**
 * Step Definitions for Login scenarios
 */
public class LoginSteps {
    
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private WebDriverWait wait;
    
    /**
     * Background step: Initialize WebDriver
     */
    @Given("User is on the OrangeHRM login page")
    public void userIsOnLoginPage() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage(Config.BASE_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Config.EXPLICIT_WAIT));
        // Wait for login page to be displayed
        wait.until(d -> loginPage.isLoginPageDisplayed());
        Assert.assertTrue("Login page is not displayed", loginPage.isLoginPageDisplayed());
    }
    
    /**
     * Step: Verify login page elements are displayed
     */
    @Then("Login page should display username and password fields")
    public void verifyLoginPageElements() {
        Assert.assertTrue("Username field is not displayed", loginPage.isUsernameFieldDisplayed());
        Assert.assertTrue("Password field is not displayed", loginPage.isPasswordFieldDisplayed());
    }
    
    /**
     * Step: User enters valid credentials
     */
    @When("User enters valid username {string} and password {string}")
    public void userEntersValidCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
    
    /**
     * Step: User enters invalid credentials
     */
    @When("User enters invalid username {string} and password {string}")
    public void userEntersInvalidCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
    
    /**
     * Step: User clicks the login button
     */
    @When("User clicks the login button")
    public void userClicksLoginButton() {
        loginPage.clickLoginButton();
    }
    
    /**
     * Step: User enters only username
     */
    @When("User enters username {string}")
    public void userEntersUsername(String username) {
        loginPage.enterUsername(username);
    }
    
    /**
     * Step: User enters password
     */
    @When("User enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.enterPassword(password);
    }
    
    
    /**
     * Step: Verify user is redirected to dashboard
     */
    @Then("User should be redirected to the dashboard")
    public void verifyUserIsOnDashboard() {
        driver = DriverManager.getDriver();
        dashboardPage = new DashboardPage(driver);
        // Wait for dashboard to be displayed
        wait.until(d -> dashboardPage.isDashboardDisplayed());
        Assert.assertTrue("Dashboard is not displayed", dashboardPage.isDashboardDisplayed());
    }
    
    
    /**
     * Step: Verify specific error message
     */
    @Then("Error message should contain {string}")
    public void verifyErrorMessageContains(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue("Error message does not contain expected text", 
                         actualMessage.contains(expectedMessage));
    }
    
    /**
     * Step: An error message should be displayed
     */
    @Then("An error message should be displayed")
    public void errorMessageDisplayed() {
        Assert.assertTrue("Error message is not displayed", loginPage.isErrorMessageDisplayed());
    }
    
    /**
     * Step: User should remain on the login page
     */
    @Then("User should remain on the login page")
    public void userRemainsOnLoginPage() {
        Assert.assertTrue("User is not on login page", loginPage.isLoginPageDisplayed());
    }
}