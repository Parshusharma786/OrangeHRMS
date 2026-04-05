package com.orangehrm.config;

/**
 * Configuration class for managing test environment settings
 */
public class Config {
    
    public static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public static final String BROWSER = System.getProperty("browser", "chrome");
    public static final int IMPLICIT_WAIT = 10;
    public static final int EXPLICIT_WAIT = 15;
    public static final int PAGE_LOAD_TIMEOUT = 30;
    
    // Test data
    public static final String VALID_USERNAME = "Admin";
    public static final String VALID_PASSWORD = "admin123";
    public static final String INVALID_USERNAME = "InvalidUser";
    public static final String INVALID_PASSWORD = "InvalidPass123";
}
