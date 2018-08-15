# Project Title
Product Search in Amazon.in
## Description
This project will search for any product based on the category we filter and search result we apply, and get the required information from the particular product(Title, Publised date, Publisher, Book copy and Price).
### Pre-requisites
- Before getting into the Project, We need to setup the Environment ready.
- Eclipse: Install the Eclipse IDE for Java to implement the project. [from here](https://www.eclipse.org/downloads/)
- Java JDK: Install Java Development Kit for configuring jar files and accessing version - jdk1.8.0_161
- Maven: Install the Maven from Eclipse Marketplace, Maven is usefull for integrating with CI and maintaining the Project directory and Dependencies.
  - Dependencies:
    - TestNG : TestNG with version 6.8 dependency need to be added in POM.xml file
    - Selenium Jar files: Selenium version 2.45.0 dependency need to be added in POM.xml file
    - ReportNG: Google Guice(version 3.0), Reporting(version 1.1.4) and Velocity-dep(version 1.4) need to be added in POM.xml file
    - Apache POI: POI version 3.17 need to be added in POM.xml file
    - Log4j:Log.xml version 1.2.17 need to be added in POM.xml file
    - Plugins: Maven-complier plugin and Maven-surefire plugin need to be added for compiling and executing as Maven Build.
## Running the tests
  After successful environment build, Run the Test by Right click on POM.xml file and choose Maven Test or we can run the test using Command Prompt as "mvn test". 
### Code Break down
  - Code structure:
      - Framework used : TestNG
        - For Generating the logs helps viewer to under the Report easily
        - For getting inputs from Excel using DataProvider made easy and understable.
        - For Identifying which method is executing using Annotations.
      - Approach Followed : PageFactory
        - Optimize the Object definition and easy to re-use
  - Design decisions
      - Break down the requirement into two methods as follows:
        - Search input
          - AmazonHome.java file has the Methods for Filtering and Searching for input
        - get Output
          - AmazonResult.java file has the Methods for getting the required product information from the list displayed
      - Configuration File
        - Used config.properties file for storing the file_path and file_name to access inside the methods using Properties class.
  - Choice of locators
      - Locator choosed as xPath:
        - The xpath is very helpful for accessing dynamic webelements.
        - Used following-siblings::tagname, parent::tagname and getting any attribute values.
        - Used @data-attribute as "Book type name" followed by its corresponding price, which is dynamically assigned and easy to reuse.
  - Assertion types
      - Assert equals method:
        - Used Assertion type as assertEquals with two parameters in boolean(actual and expected).
          - If the Actual and expected met, (i.e: object present and assign to webelement) try block will execute
          - Else the actual and expected not met, (i.e: object is not present in webpage) catch block will execute
  - Resource used
      - Chromedriver
        - Used Chromedriver to the test the application using Chrome Browser
      - Excel file
        - Used Excel file as an output parameter, which will store all the product information as an Output.
        - For accessing the Excel file, we used Excel packages using Apache POI jars for reading and writing the excel cells.
### Purpose of test
  The purpose of the test is to search for "Data Catalog" input from the search engine also filtering the category as "Books" get the required information about the particular product, here we can easily access for all kind of product as the code is reusable much.
  Just changing the input parameter as Category name, Search Input and changing only the List tag in Page factory.
## Build With
  The Project is build with Maven Tool,
  Why Maven?
      Easy maintainence of Project directory
      Easy maintainence of Dependency files
      Easy access to build by Maven Build Life Cycle and Build Goals,(Ex : Clean, Install, Test, Compile, Clean-install)
## Reporting
  The Main category in every project is Reporting the Execution Result, here we used the Reporting plugin as ReportNG, Since we have default Reporting in TestNG that is not much readable and interactive.
  ReportNG will generate the Report in more readable format than TestNG reports
  Samples
  
    ![Suite Result overview](https://github.com/vm599414/Assignment/tree/master/target/Sample%20Report/Test%20Result.PNG)
    ![Test Result overview](https://github.com/vm599414/Assignment/blob/master/target/Sample%20Report/Detailed%20result.PNG)
    
## Author
  - Vinodhini M - [Profile](https://github.com/vm599414)
