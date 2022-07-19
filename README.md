1) This is a small collection of automated tests written in Java (IntelliJ IDEA) and based on the Selenium WebDriver framework. I used:

- OS Windows 10
- Browsers: Chrome, Firefox  
- Build tool: Maven
- Testing framework: TestNG
- Design pattern for UI tests: Page Object Model
- Library for API tests: REST Assured
- Test reporting tool: Allure

2) This combination of tools and frameworks is a widely used stack that helps create structured, readable, and maintainable automated tests.

3) Tests can be run by running the testng.xml file in the IDE or by using the following command line in CMD after cloning the project (and also in the IDE terminal):
mvn clean test -Dfile=testng

4) If the framework was bigger, we could add more enhancements like a flaky tests analyzer and logs for all steps (e.g. Log4j) 