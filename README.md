# OrangeHRM End-to-End Testing Framework

A comprehensive Selenium BDD testing framework for the OrangeHRM application using Java and Cucumber.

## Project Overview

This framework is designed to test the OrangeHRM application (https://opensource-demo.orangehrmlive.com/) using:
- **Selenium WebDriver** - Browser automation
- **Cucumber/Gherkin** - BDD approach for writing test scenarios
- **Java** - Core programming language
- **Maven** - Build and dependency management
- **JUnit** - Test execution framework

## Project Structure

```
OrangeHRMS/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/orangehrm/
│   │           ├── config/          # Configuration files
│   │           │   └── Config.java
│   │           ├── driver/          # WebDriver management
│   │           │   └── DriverManager.java
│   │           ├── pages/           # Page Object Models
│   │           │   ├── BasePage.java
│   │           │   ├── LoginPage.java
│   │           │   └── DashboardPage.java
│   │           └── utilities/       # Utility classes
│   │               └── TestUtils.java
│   └── test/
│       ├── java/
│       │   └── com/orangehrm/
│       │       ├── stepdefinitions/  # Cucumber step definitions
│       │       │   ├── LoginSteps.java
│       │       │   └── DashboardSteps.java
│       │       ├── hooks/            # Cucumber hooks (setup/teardown)
│       │       │   └── Hooks.java
│       │       └── runners/          # Test runners
│       │           └── TestRunner.java
│       └── resources/
│           └── features/            # Cucumber feature files
│               ├── Login.feature
│               └── Dashboard.feature
├── pom.xml                           # Maven configuration
└── README.md                         # This file
```

## Key Dependencies

- **Selenium**: 4.35.0
- **Cucumber**: 7.28.2
- **WebDriverManager**: 6.2.0
- **JUnit**: 4.13.2
- **Cucumber Reporting**: 5.10.1

## Features Covered

### Login Feature (`src/test/resources/features/Login.feature`)
- ✅ Valid login with correct credentials
- ✅ Invalid login scenarios (wrong username, wrong password)
- ✅ Empty fields validation
- ✅ Error message display verification

### Dashboard Feature (`src/test/resources/features/Dashboard.feature`)
- ✅ Dashboard access after successful login
- ✅ Navigation to different modules (Admin, PIM, Leave, My Info)
- ✅ Logout functionality

## Setup Instructions

### Prerequisites
- Java 11 or higher
- Maven 3.6.0 or higher
- Chrome/Firefox/Edge browser

### Installation

1. Clone the repository
   ```bash
   git clone <repository-url>
   cd OrangeHRMS
   ```

2. Install dependencies
   ```bash
   mvn clean install
   ```

## Running Tests

### Run all tests
```bash
mvn test
```

### Run tests by tag
```bash
# Run only smoke tests
mvn test -Dcucumber.filter.tags="@smoke"

# Run only login tests
mvn test -Dcucumber.filter.tags="@login_positive"

# Run all but skip tests with @skip tag
mvn test -Dcucumber.filter.tags="not @skip"
```

### Run specific feature file
```bash
mvn test -Drunner=TestRunner
```

### Run with specific browser
```bash
mvn test -Dbrowser=firefox
```

Supported browsers: `chrome`, `firefox`, `edge`

## Page Object Model (POM)

The framework uses the Page Object Model pattern:

### BasePage
Base class containing common methods:
- Element interactions (click, send keys, get text)
- Explicit waits
- Error handling

### LoginPage
Handles login page interactions:
- Username and password entry
- Login button click
- Error message verification
- Login page validation

### DashboardPage
Handles dashboard interactions after login:
- Module navigation (Admin, PIM, Leave, My Info)
- Logout functionality
- Dashboard title verification

## Step Definitions

### LoginSteps
Implements all steps related to login scenarios:
- User navigates to login page
- User enters credentials
- User verifies error messages
- User verifies successful login

### DashboardSteps
Implements all steps related to dashboard scenarios:
- User navigates between modules
- User performs logout
- User verifies page contents

## Configuration

Edit `src/main/java/com/orangehrm/config/Config.java` to modify:
- Base URL
- Browser type
- Timeout values
- Test credentials

## Test Data

Valid credentials (from config):
- **Username**: Admin
- **Password**: admin123

## Test Report

After running tests, the report is generated at:
```
target/cucumber-reports/index.html
```

Open this file in a browser to view the detailed test report.

## Best Practices Implemented

1. ✅ Page Object Model (POM) for maintainability
2. ✅ BDD approach with Gherkin language
3. ✅ Explicit waits for element visibility
4. ✅ ThreadLocal for WebDriver instance management
5. ✅ Cucumber hooks for setup and teardown
6. ✅ Comprehensive logging
7. ✅ Modular code structure
8. ✅ DRY principle (Don't Repeat Yourself)
9. ✅ Proper exception handling
10. ✅ Maven for dependency and build management

## Tagging Strategy

Tests are tagged for easy filtering:
- `@smoke` - Quick smoke tests
- `@regression` - Full regression tests
- `@login_positive` - Positive login test cases
- `@login_negative` - Negative login test cases
- `@login_validation` - Input validation tests
- `@dashboard` - Dashboard functionality tests
- `@logout` - Logout tests
- `@navigation` - Module navigation tests

## Troubleshooting

### WebDriver Issues
If you encounter WebDriver issues:
1. Ensure your browser is up-to-date
2. WebDriverManager automatically downloads the correct driver
3. If issues persist, manually set browser path in Config.java

### Element Not Found
1. Check if the element locators are correct
2. Add explicit waits if elements load dynamically
3. Use developer tools to inspect the element

### Test Failures
1. Check if the OrangeHRM website is accessible
2. Verify test credentials
3. Review test logs for detailed error messages

## Future Enhancements

- [ ] Add screenshot capture on test failure
- [ ] Implement API testing for backend validation
- [ ] Add performance testing
- [ ] Implement data-driven testing with Excel/JSON
- [ ] Add Allure reporting
- [ ] Integrate with CI/CD pipeline (Jenkins)
- [ ] Add test parallelization
- [ ] Implement custom wait conditions

## Contributing

1. Create a new branch for each feature
2. Follow existing code conventions
3. Add tests for new features
4. Update documentation as needed

## License

This project is licensed under the MIT License - see LICENSE file for details.

## Support

For issues or questions, please create an issue in the repository.

---

**Framework Version**: 1.0.0  
**Last Updated**: 2026-04-03  
**Author**: Senior QA Automation Engineer
