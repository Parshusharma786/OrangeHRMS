Feature: OrangeHRM Dashboard Tests
  As a logged-in user
  I want to navigate to different modules from the dashboard
  So that I can access various features of the application

  @smoke @dashboard
  Scenario: Verify user can access dashboard after login
    Given User is logged in to OrangeHRM application
    Then Dashboard title should be displayed

  @regression @dashboard @navigation
  Scenario: Verify user can navigate to Admin module
    Given User is logged in to OrangeHRM application
    When User navigates to Admin module
    Then User should be on Admin page

  @regression @dashboard @navigation
  Scenario: Verify user can navigate to PIM module
    Given User is logged in to OrangeHRM application
    When User navigates to PIM module
    Then User should be on PIM page

  @regression @dashboard @navigation
  Scenario: Verify user can navigate to Leave module
    Given User is logged in to OrangeHRM application
    When User navigates to Leave module
    Then User should be on Leave page

  @regression @dashboard @navigation
  Scenario: Verify user can navigate to My Info module
    Given User is logged in to OrangeHRM application
    When User navigates to My Info module
    Then User should be on My Info page

  @smoke @logout
  Scenario: Verify user can logout from the application
    Given User is logged in to OrangeHRM application
    When User clicks on user dropdown and logout
    Then User should be logged out and redirected to login page