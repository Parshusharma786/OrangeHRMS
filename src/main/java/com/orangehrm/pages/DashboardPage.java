package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Dashboard Page Object class
 * Handles all interactions on the OrangeHRM dashboard page after successful login
 */
public class DashboardPage extends BasePage {
    
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement dashboardTitle;
    
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    private WebElement userDropdown;
    
    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    private WebElement logoutButton;
    
    @FindBy(xpath = "//a[contains(text(), 'Admin')]")
    private WebElement adminMenu;
    
    @FindBy(xpath = "//a[contains(text(), 'PIM')]")
    private WebElement pimMenu;
    
    @FindBy(xpath = "//a[contains(text(), 'Leave')]")
    private WebElement leaveMenu;
    
    @FindBy(xpath = "//a[contains(text(), 'Time')]")
    private WebElement timeMenu;
    
    @FindBy(xpath = "//a[contains(text(), 'Recruitment')]")
    private WebElement recruitmentMenu;
    
    @FindBy(xpath = "//a[contains(text(), 'My Info')]")
    private WebElement myInfoMenu;
    
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
    private WebElement usernameDisplay;
    
    /**
     * Constructor for DashboardPage
     */
    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Check if dashboard is displayed
     */
    public boolean isDashboardDisplayed() {
        try {
            return isElementDisplayed(dashboardTitle);
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Get dashboard title
     */
    public String getDashboardTitle() {
        if (isDashboardDisplayed()) {
            return getText(dashboardTitle);
        }
        return "";
    }
    
    /**
     * Click on user dropdown
     */
    public void clickUserDropdown() {
        clickElement(userDropdown);
    }
    
    /**
     * Logout from the application
     */
    public void logout() {
        clickUserDropdown();
        waitForElementToBeClickable(logoutButton);
        clickElement(logoutButton);
    }
    
    /**
     * Navigate to Admin module
     */
    public void navigateToAdmin() {
        clickElement(adminMenu);
    }
    
    /**
     * Navigate to PIM module
     */
    public void navigateToPIM() {
        clickElement(pimMenu);
    }
    
    /**
     * Navigate to Leave module
     */
    public void navigateToLeave() {
        clickElement(leaveMenu);
    }
    
    /**
     * Navigate to Time module
     */
    public void navigateToTime() {
        clickElement(timeMenu);
    }
    
    /**
     * Navigate to Recruitment module
     */
    public void navigateToRecruitment() {
        clickElement(recruitmentMenu);
    }
    
    /**
     * Navigate to My Info module
     */
    public void navigateToMyInfo() {
        clickElement(myInfoMenu);
    }
    
    /**
     * Get logged-in username
     */
    public String getLoggedInUsername() {
        return getText(usernameDisplay);
    }
}
