package com.orangehrm.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for common test utilities
 */
public class TestUtils {
    
    /**
     * Take screenshot and save to file
     */
    public static String takeScreenshot(WebDriver driver, String testName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String screenshotPath = "target/screenshots/" + testName + "_" + timestamp + ".png";
            
            File destinationFile = new File(screenshotPath);
            destinationFile.getParentFile().mkdirs();
            
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destinationFile);
            
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            
            fis.close();
            fos.close();
            
            return screenshotPath;
        } catch (Exception e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Add delay/wait for test execution
     */
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Generate current timestamp
     */
    public static String getCurrentTimestamp() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    
    /**
     * Log message with timestamp
     */
    public static void log(String message) {
        System.out.println("[" + getCurrentTimestamp() + "] " + message);
    }
}
