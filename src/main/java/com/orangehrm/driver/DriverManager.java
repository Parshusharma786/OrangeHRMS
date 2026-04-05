package com.orangehrm.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.orangehrm.config.Config;

/**
 * WebDriver Manager class for initializing and managing WebDriver instances
 */
public class DriverManager {
    
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    /**
     * Initialize WebDriver based on browser configuration
     */
    public static void initDriver() {
        String browser = Config.BROWSER.toLowerCase();
        WebDriver webDriver = null;
        
        try {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Browser: " + browser + " not supported");
            }
            
            // Set timeouts
            webDriver.manage().timeouts()
                    .pageLoadTimeout(java.time.Duration.ofSeconds(Config.PAGE_LOAD_TIMEOUT));
            
            // Maximize window
            webDriver.manage().window().maximize();
            
            driver.set(webDriver);
            
        } catch (Exception e) {
            System.out.println("Failed to initialize WebDriver: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Get current WebDriver instance
     */
    public static WebDriver getDriver() {
        return driver.get();
    }
    
    /**
     * Close WebDriver instance
     */
    public static void quitDriver() {
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            webDriver.quit();
            driver.remove();
        }
    }
}