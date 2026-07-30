# Java UI Test Automation Framework for the Internet

## Project Purpose
This repository is part of a multi-language UI test automation project built around the same application.

The goal of the repository is to strengthen Java programming skills and gain practical experience automating web applications that contain standard UI elements that are commonly used across most web apps and across different business domains.

The application under test (AUT) is: https://the-internet.herokuapp.com/.

Additionally, this project provides an opportunity to:
- Apply practical experience with Selenium WebDriver, GitHub Actions, and Allure reporting that was gained in previous JavaScript and Python projects.
- Broaden automation quality assurance (AQA) experience out of the [eCommerce](https://github.com/Olexandr29/eCommerce) project and domain in general.
- Expand my AQA tech stack and broaden the range of projects I am qualified to work on.

Working with Java also provides valuable experience with a strongly statically typed language that differs significantly from JavaScript and Python. 

___

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- GitHub Actions
- Allure Report
___

## Project Structure

```text
automation-the-internet-java
├───.github
│   └───workflows
├───src
│   ├───main
│   │   ├───java
│   │   │   └───pages
│   │   └───resources
│   └───test
│       ├───java
│       │   ├───testData
│       │   └───tests
│       └───resources
├───testng
│   ├───smoke.xml
│   ├───regression.xml
│   └─── ...
├───pom.xml
└───README.md
```

___


## Run Tests

### Locally

```bash
mvn clean test
```

#### Generate Allure Report

```bash
allure serve target/allure-results
```

### Remotely via GitHub Actions

Tests are automatically executed through GitHub Actions on every push and also can be triggered manually from the GitHub Actions UI.

#### Generate Allure Report
Allure reporting is integrated into the GitHub Actions workflow.

___

**This repository is continuously improved with new automation scenarios and framework enhancements.**