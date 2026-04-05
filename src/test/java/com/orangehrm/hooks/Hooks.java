package com.orangehrm.hooks;

// Removed TestNG imports
import io.cucumber.java.Before;
import io.cucumber.java.After;
import com.orangehrm.driver.DriverManager;
import org.openqa.selenium.WebDriver;

/**
 * Cucumber Hooks for setup and teardown
 */
public class Hooks {
    
    /**
     * Before hook - Runs before each scenario (Cucumber)
     */
    @Before
    public void setUp() {
        System.out.println("======== Starting Test Scenario ========");
        DriverManager.initDriver();
        System.out.println("Browser initialized successfully");
    }
    
    /**
     * After hook - Runs after each scenario (Cucumber)
     */
    @After
    public void tearDown() {
        System.out.println("======== Ending Test Scenario ========");
        DriverManager.quitDriver();
        System.out.println("Browser closed successfully");
    }
}
