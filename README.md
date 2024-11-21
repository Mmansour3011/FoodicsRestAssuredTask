# Foodics Rest Assured Login Tests

**Project Overview**

This project contains automated tests for the login functionality of a Foodics API endpoint. These tests are written in Java using the Rest Assured library and the TestNG testing framework.

**Project Structure**

* **package tests:** This package contains the test cases for login functionality.
    * `LoginTests.java`: This class defines three test cases:
        * `testLoginSuccess`: Tests successful login with valid credentials.
        * `testWhoamiWithValidToken`: Tests the `/cp_internal/whoami` endpoint with a valid token.
        * `testLoginFailureWithInvalidCredentials`: Tests login failure with invalid credentials.
* **package base:** This package contains the base setup for the tests.
    * `BaseTest.java`: This class sets the base URI for Rest Assured requests using `@BeforeClass` annotation.
* **pom.xml:** This file defines the project dependencies and configurations for building the project with Maven.

**Dependencies**

* Rest Assured (v5.3.0)
* TestNG (v7.8.0)
* Jackson Databind (v2.15.0)

**Running the Tests**

1. Ensure you have Maven installed.
2. Clone or download the project.
3. Open a terminal and navigate to the project directory.
4. Run `mvn test` to execute the tests.
