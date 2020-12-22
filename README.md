# API Automation Test BDD framework
API Automation Test is RestAssured based BDD framework to perform API testing. This project is useful as an example of API Testing with RestAssured and Java playing nicely together.

## Getting Started
```
1. git clone https://github.com/sadabnepal/APITesting_RestAssured_BDD.git"
2. Navigate to APITesting_RestAssured_BDD
```

## Run project and Generate Report
**In terminal from root project folder (APITesting_RestAssured_BDD), run below commands as required**
- To run all features `mvn clean test verify`
- To pass environment variable from command line `mvn clean test verify -DargLine=-DWSNSHELL_HOME=RSURI`
  *RSRUI* is environment passed in `src-> test-> java-> base-> BaseBuilder.java` and defined in *config.properties*
- To view Cucumber HTML Report open file in any browse. Restule file path: `{project_root_folder_paths}/APIAutomationFramework/target/cucumber-html-reports/overview-features.html`
- To view Spark Report open file in any browse. Restule file path: `{project_root_folder_paths}/APIAutomationFramework/test-output/Pdf/ExtentPdf.pdf`
- To view Cucumber PDF Report open file in any browse. Restule file path: `{project_root_folder_paths}/APIAutomationFramework/test-output/Spark/ExtentSpark.html`

### Reports used
- `Spark HTML Report`
- `Cucumber PDF Report`
- `Cucumber HTML Report`

### Key Features
	- Runtime environment set
	- Hashmap to simplify serialization of payload
	- Tag based execution
	- Detailed Cucumber Report
	- Header builder simplified
	- Reusable methods to perform GET, POST operations

## Sample Report
![Report](https://user-images.githubusercontent.com/65847528/102914715-b95be780-44a6-11eb-8022-79b9149c5fad.gif)
