package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Login Page Object class
 * Handles all interactions on the OrangeHRM login page
 */
public class LoginPage extends BasePage {
    
    @FindBy(name = "username")
    private WebElement usernameField;
    
    @FindBy(name = "password")
    private WebElement passwordField;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    
    @FindBy(xpath = "//div[contains(@class, 'oxd-alert--error')]//p")
    private WebElement errorMessage;
    
    @FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
    private WebElement loginTitle;
    
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
    private WebElement forgotPasswordLink;
    
    /**
     * Constructor for LoginPage
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Navigate to login page
     */
    public void navigateToLoginPage(String url) {
        driver.navigate().to(url);
    }
    
    /**
     * Enter username
     */
    public LoginPage enterUsername(String username) {
        sendKeys(usernameField, username);
        return this;
    }
    
    /**
     * Enter password
     */
    public LoginPage enterPassword(String password) {
        sendKeys(passwordField, password);
        return this;
    }
    
    /**
     * Click login button
     */
    public void clickLoginButton() {
        clickElement(loginButton);
    }
    
    /**
     * Perform login action
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
    
    /**
     * Check if error message is displayed
     */
    public boolean isErrorMessageDisplayed() {
        try {
            return isElementDisplayed(errorMessage);
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Get error message text
     */
    public String getErrorMessage() {
        if (isErrorMessageDisplayed()) {
            return getText(errorMessage);
        }
        return "";
    }
    
    /**
     * Check if login page is displayed
     */
    public boolean isLoginPageDisplayed() {
        return isElementDisplayed(loginTitle);
    }
    
    /**
     * Check if username field is displayed
     */
    public boolean isUsernameFieldDisplayed() {
        return isElementDisplayed(usernameField);
    }
    
    /**
     * Check if password field is displayed
     */
    public boolean isPasswordFieldDisplayed() {
        return isElementDisplayed(passwordField);
    }
}