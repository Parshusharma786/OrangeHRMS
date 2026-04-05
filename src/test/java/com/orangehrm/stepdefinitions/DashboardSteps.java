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
 * Step Definitions for Dashboard scenarios
 */
public class DashboardSteps {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    
    /**
     * Step: User is logged in
     */
    @Given("User is logged in to OrangeHRM application")
    public void userIsLoggedIn() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(Config.EXPLICIT_WAIT));
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage(Config.BASE_URL);
        loginPage.login(Config.VALID_USERNAME, Config.VALID_PASSWORD);
        dashboardPage = new DashboardPage(driver);
        // Wait for dashboard to be displayed
        wait.until(d -> dashboardPage.isDashboardDisplayed());
    }
    
    /**
     * Step: Verify dashboard title
     */
    @Then("Dashboard title should be displayed")
    public void verifyDashboardTitle() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(driver);
        }
        String title = dashboardPage.getDashboardTitle();
        Assert.assertFalse("Dashboard title is empty", title.isEmpty());
    }
    
    /**
     * Step: User navigates to Admin module
     */
    @When("User navigates to Admin module")
    public void userNavigatesToAdminModule() {
        dashboardPage.navigateToAdmin();
        // Wait for URL to contain 'admin'
        wait.until(ExpectedConditions.urlContains("admin"));
    }
    
    /**
     * Step: User navigates to PIM module
     */
    @When("User navigates to PIM module")
    public void userNavigatesToPIMModule() {
        dashboardPage.navigateToPIM();
        // Wait for URL to contain 'pim'
        wait.until(ExpectedConditions.urlContains("pim"));
    }
    
    /**
     * Step: User navigates to Leave module
     */
    @When("User navigates to Leave module")
    public void userNavigatesToLeaveModule() {
        dashboardPage.navigateToLeave();
        // Wait for URL to contain 'leave'
        wait.until(ExpectedConditions.urlContains("leave"));
    }
    
    /**
     * Step: User navigates to My Info module
     */
    @When("User navigates to My Info module")
    public void userNavigatesToMyInfoModule() {
        dashboardPage.navigateToMyInfo();
        // Wait for URL to contain 'myinfo'
        wait.until(ExpectedConditions.urlContains("myinfo"));
    }
    
    /**
     * Step: User logs out
     */
    @When("User clicks on user dropdown and logout")
    public void userLogsOut() {
        dashboardPage.logout();
        // Wait for login page to be displayed
        loginPage = new LoginPage(driver);
        wait.until(d -> loginPage.isLoginPageDisplayed());
    }
    
    /**
     * Step: Verify user is logged out
     */
    @Then("User should be logged out and redirected to login page")
    public void verifyUserIsLoggedOut() {
        loginPage = new LoginPage(driver);
        Assert.assertTrue("User is not on login page after logout", loginPage.isLoginPageDisplayed());
    }
    
    /**
     * Step: Verify page URL contains Admin
     */
    @Then("User should be on Admin page")
    public void verifyUserIsOnAdminPage() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue("User is not on Admin page", currentURL.contains("admin"));
    }
    
    /**
     * Step: Verify page URL contains PIM
     */
    @Then("User should be on PIM page")
    public void verifyUserIsOnPIMPage() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue("User is not on PIM page", currentURL.contains("pim"));
    }
    
    /**
     * Step: Verify page URL contains Leave
     */
    @Then("User should be on Leave page")
    public void verifyUserIsOnLeavePage() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue("User is not on Leave page", currentURL.contains("leave"));
    }
    
    /**
     * Step: Verify page URL contains My Info
     */
    @Then("User should be on My Info page")
    public void verifyUserIsOnMyInfoPage() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue("User is not on My Info page", currentURL.contains("myinfo"));
    }
}