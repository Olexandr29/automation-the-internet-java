# Architecture

<details><summary><b>Overview</b></summary>

This project is part of the [multi-language UI test automation ecosystem](https://github.com/Olexandr29/automation-the-internet-on-python-java-js/tree/main)
built around the same application under test (AUT): [The Internet](https://the-internet.herokuapp.com/).

This repository contains a Java-based UI test automation framework designed to automate web application scenarios using Selenium WebDriver and TestNG.

The framework uses Maven for project and dependency management, GitHub Actions for CI/CD automation, and Allure Report for test result reporting.

The project follows the Page Object Model (POM) approach to separate test scenarios from page-specific UI interactions.

</details>


<details><summary><b>Repository Structure</b></summary>

The repository is organized as a Maven-based Java UI test automation framework.

```text
automation-the-internet-java> tree
├───.github/
│   └───workflows/          # GitHub Actions workflow
├───docs/                   # Project documentation
├───scripts/                # Project automation scripts
├───src/
│   ├───main/
│   │   ├───java/
│   │   │   └───pages/      # Page Object classes
│   │   └───resources/      # Main project resources
│   └───test/
│       ├───java/
│       │   ├───listeners/  # TestNG listeners
│       │   ├───testData/   # Test data  
│       │   └───tests/      # Test classes
│       └───resources/      # Test resources
├───testng/                 # TestNG suite configurations
├── .gitignore              # Specifies files and directories ignored by Git 
├── pom.xml                 # Maven project configuration
└── README.md               # Project overview and usage instructions

```

Main Directories and Files

| Directory / File              | Responsibility                                                                                                             |
|-------------------------------|----------------------------------------------------------------------------------------------------------------------------|
| `src/main/java/pages/`        | Contains Page Object classes responsible for page-specific UI interactions.                                                |
| `src/test/java/tests/`        | Contains automated test classes that define test scenarios and assertions.                                                 |
| `src/test/java/testData/`     | Contains test data used by automated tests.                                                                                |
| `src/test/java/listeners/`    | Contains TestNG listeners to capture screenshots when a test method fails.                                         |
| `.github/workflows/`          | Contains GitHub Actions workflow definitions for test execution and reporting automation.                                  |
| `testng/`                     | Contains TestNG suite configuration files for different test execution scopes.                                             |
| `scripts/`                    | Contains project automation scripts, including the script for generating an Allure report locally with history and trends. |
| `docs/`                       | Contains project documentation, including architecture documentation.                                                      |
| `pom.xml`                     | Defines Maven project configuration and dependencies.                                                                      |
| `.gitignore`                  | Specifies files and directories that should not be tracked by Git.                                                         |
| `README.md`                   | Contains the project overview, technology stack, structure, and usage instructions.                                        |

</details>


<details><summary><b>Main Components and Responsibilities</b></summary>

The framework follows the Page Object Model (POM) approach. Page-specific UI interactions are encapsulated in dedicated Page Object classes, while shared browser interaction functionality is provided by the abstract `BasePage` class.

1) BasePage

`BasePage` is an abstract base class inherited by the Page Object classes.

It provides shared functionality for:

- WebDriver and explicit wait management;
- Element location and visibility-based synchronization;
- Reusable UI interactions, such as clicking and typing;
- Keyboard and browser navigation operations;
- Logging through SLF4J;
- Allure step integration for test action reporting.

The class reduces duplication across Page Objects by centralizing common browser interaction functionality.

2) Page Object Classes

Each Page Object represents a specific page or functional area of the application under test.

| Component | Responsibility |
|---|---|
| `HomePage` | Provides navigation to the main application sections, including login, dropdown, checkbox, and broken images pages. |
| `LoginPage` | Encapsulates login form interactions, successful and unsuccessful authentication scenarios, and password field verification. |
| `SecurePage` | Represents the authenticated page and provides methods for verifying page content and logging out. |
| `DropdownPage` | Encapsulates dropdown visibility, option selection, keyboard interaction, and focus verification. |
| `CheckboxPage` | Encapsulates checkbox visibility, selection state verification, state changes, and keyboard interactions. |
| `BrokenImagesPage` | Encapsulates broken images page interactions, image count and visibility checks, and image loading verification. |

Page Objects use the shared functionality inherited from `BasePage` while exposing methods specific to their respective pages and UI components.
</details>


<details><summary><b>Test Components(Layers) and Responsibilities</b></summary>

Test classes contain automated test scenarios and verify the expected behavior of the application under test.

The test layer is implemented using **TestNG** and follows the Page Object Model approach. Test classes interact with Page Objects instead of directly locating and manipulating web elements.

| Component        | Responsibility                                                                                                            |
| ---------------- | ------------------------------------------------------------------------------------------------------------------------- |
| `BaseTest`       | Provides common test setup and teardown functionality, WebDriver initialization, and access to the `HomePage`.            |
| `LoginTest`      | Verifies successful and unsuccessful login scenarios, logout behavior, secure area access, and password field handling.   |
| `DropdownTest`   | Verifies dropdown visibility, available options, option selection, keyboard interaction, and browser navigation behavior. |
| `CheckboxTest`    | Verifies checkbox visibility, initial states, state changes, refresh behavior, and keyboard interaction.                  |
| `BrokenImagesTest` | Verifies page content, image visibility, image count, and image loading status.                                           |

Test classes use assertions to validate application behavior and are organized using TestNG groups such as `smoke`, `regression`, `keyboard`, and `navigation`.

Test scenarios can use TestNG data providers to execute the same test logic with different input values. For example, `LoginTest` uses the `invalidLoginData` data provider to validate multiple unsuccessful login scenarios.

1) BaseTest (Test Setup and WebDriver Lifecycle)

`BaseTest` is the common base class for test classes and manages the WebDriver lifecycle.

Its responsibilities include:

* Creating a Chrome WebDriver instance before each test method;
* Configuring browser options;
* Enabling incognito mode;
* Enabling headless execution in GitHub Actions;
* Opening the application home page;
* Initializing the `HomePage` object;
* Closing the browser after each test method.

The `BaseTest.setUp()` method initializes the browser and opens the application home page before each test methods. A test-specific `@BeforeMethod` then opens the required page through the corresponding Page Object. The `@AfterMethod` method closes the WebDriver session after test execution.

The browser configuration changes depending on the execution environment. When the `GITHUB_ACTIONS` environment variable is set to `true`, Chrome runs in headless mode with additional options intended for CI execution.

The `BaseTest` class also provides access to the active WebDriver instance through the `getDriver()` method, which is used by the screenshot listener.

2) Test Data Classes

Test data is stored in dedicated classes under the `testData` package.

These classes centralize URLs, expected messages, input values, and default UI states used by the test scenarios.

| Component          | Responsibility                                                                                            |
| ------------------ | --------------------------------------------------------------------------------------------------------- |
| `LoginData`        | Stores login credentials, expected authentication messages, page URLs, and security-related input values. |
| `DropdownData`     | Stores dropdown page URLs, expected option names, and the expected number of options.                     |
| `CheckboxData`     | Stores checkbox identifiers, the page URL, and expected initial checkbox states.                          |
| `BrokenImagesData` | Stores the page URL, expected page content, link text, and expected image count.                          |

The test data classes expose constants that can be reused by multiple test methods. This reduces duplicated values in test implementations and separates test data from test execution logic.

3) ScreenshotListener

`ScreenshotListener` implements the TestNG `IInvokedMethodListener` interface and captures screenshots when a test method fails.

The listener performs the following operations:

1. Checks whether the invoked method is a test method.
2. Checks whether the test result has a failure status.
3. Retrieves the WebDriver instance from the test class.
4. Captures a screenshot using Selenium's `TakesScreenshot` interface.
5. Attaches the screenshot to the Allure report.

The listener separates failure screenshot handling from individual test classes and Page Objects. This allows screenshots to be captured consistently for failed test methods without adding screenshot logic to each test scenario.

4Allure Reporting

Allure is used to collect test execution results, steps, and failure screenshots.

Allure results are stored in `target/allure-results`, as configured in
`src/test/resources/allure.properties`.

Local reporting is handled by `scripts/generate-allure-report.ps1`,
which runs tests, creates execution metadata, restores report history,
and generates the Allure report.

In GitHub Actions, the workflow generates the Allure report and publishes
the report history to the `gh-pages` branch.

```text
TestNG Test Method
|
v
Test Failure
|
v
ScreenshotListener
|
v
WebDriver Screenshot
|
v
Allure Attachment
```
</details>


<details><summary><b>Test Execution Flow</b></summary>
The Java framework follows a test execution flow in which browser is initialized before each test, the required Page Object is opened, the test scenario is executed, and the browser session is closed afterward. 

Test Layer
```
@BeforeMethod: BaseTest.setUp()
↓
Create ChromeDriver
↓
Open Home Page
↓
Initialize HomePage
↓
@BeforeMethod: openLoginPage() / openDropdownPage() / ...
↓
@Test
↓
@AfterMethod: tearDown()
↓
driver.quit()
```

```
Test Layer 
│ 
▼ 
Page Object Layer 
│
▼ 
Utility / WebDriver Layer 
│ 
▼ 
Browser 
│ 
▼ 
Application Under Test
```

The common architecture separates test scenarios from UI interaction, reusable framework functionality, and test execution infrastructure.

The implementation details of these layers are specific to each framework and are documented in their respective repositories.

</details>


