Feature: OrangeHRM Login Tests
  As a user
  I want to login to OrangeHRM application
  So that I can access the dashboard and other modules

  Background:
    Given User is on the OrangeHRM login page

  @smoke @login_positive
  Scenario: Verify user can login with valid credentials
    When User enters valid username "Admin" and password "admin123"
    And User clicks the login button
    Then User should be redirected to the dashboard
    And Dashboard title should be displayed

  @smoke @login_positive
  Scenario Outline: Verify user can login with different valid credentials
    When User enters valid username "<username>" and password "<password>"
    And User clicks the login button
    Then User should be redirected to the dashboard

    Examples:
      | username | password |
      | Admin    | admin123 |

  @regression @login_negative
  Scenario: Verify login fails with invalid username
    When User enters invalid username "InvalidUser" and password "admin123"
    And User clicks the login button
    Then An error message should be displayed
    And User should remain on the login page

  @regression @login_negative
  Scenario: Verify login fails with invalid password
    When User enters valid username "Admin" and password "InvalidPassword"
    And User clicks the login button
    Then An error message should be displayed
    And User should remain on the login page

  @regression @login_negative
  Scenario: Verify login fails with invalid credentials
    When User enters invalid username "InvalidUser" and password "InvalidPassword"
    And User clicks the login button
    Then An error message should be displayed
    And User should remain on the login page

  @regression @login_validation
  Scenario: Verify login page elements are displayed
    Then Login page should display username and password fields