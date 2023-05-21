# REST API Testing using RESTAssured

This project demonstrates how to automate REST API testing using the RESTAssured library. It provides an example of how to write and execute tests for RESTful APIs.

## Prerequisites

To run the tests, ensure that you have the following installed:

- Java Development Kit (JDK) 1.8 or later
- Apache Maven

## Libraries

The project uses the following libraries:

- [RESTAssured](https://rest-assured.io/): A Java library for testing RESTful APIs
- [TestNG](https://testng.org/): A testing framework for Java

## Running the Tests

To execute the tests, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/REST-API-testing-using-RESTAssured.git`
2. Navigate to the project directory: `cd REST-API-testing-using-RESTAssured`
3. Run the tests using Maven: `mvn test`

The test results will be displayed in the console, and any failures or errors will be reported.

## Test Suite Configuration

The project uses TestNG to define and execute test suites. The test suite configuration is specified in the `testSuites.xml` file located in the `src/test/resources` directory. You can modify this file to include or exclude specific test classes or methods in your test runs.

## Notes

- Ensure that the API endpoints or URLs used in the tests are valid and accessible.
- You can add more test classes and methods to the `src/test/java` directory to expand the test coverage.

Feel free to customize and extend the project based on your specific requirements.

Enjoy testing your RESTful APIs with RESTAssured!

If you have any questions or need further assistance, please feel free to reach out.
