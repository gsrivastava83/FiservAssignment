1. Implemented the testcase that was mentioned on the TestNG framework and POM design pattern and using scripting language JAVA.
2. GoogleSearch test class - This carries actual code. It will call the methods in the Page Object classes for execution and test validations through the objects of Page Object classes.
   This is inheriting the BaseTest class.
3. Base test class - This is BaseTest for testcases or test class. It contains code for setting up the browser, launching the application, Global Properties,
   closing driver, getScreenshot, getJsonData, etc which will be needed by all tests for their execution.
4. Created Page Object class, LandingPage - All actions will be carried out in Page Object Class. This inherits the Abstract Component class.
5. AbstractComponent class - This contains re-usable code file and is inheritted by all Page Object classes.
6. Listeners are implemented to keep track of test results.
7. ExtentReports are generated using TestNG Listeners.
8. Locators are getting retreived through Json file.
9. TestNG @DataProvider concept is implemented to retreive data from Json file.
10. ThreadLocal - This concept which is threadsafe is implemented to resolve the problem of concurrency.
11. Retry - This is also implemented which is useful when a test is flaky and fails intermittently.
12. TestNG xml file to run the test
13. Maven Integration.
14. Added Profiles in POM.xml to run different testNG.xml files available.



