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
- To view HTML report open file in any browse. Restule file path: `{project_root_folder_paths}/APIAutomationFramework/target/cucumber-html-reports/overview-features.html`

### Reports used
- `Cucumber Report`

### Key Features
	- Runtime environment set
	- Hashmap to simplify serialization of payload
	- Tag based execution
	- Detailed Cucumber Report
	- Header builder simplified
	- Reusable methods to perform GET, POST operations

## Sample Report
![image](https://user-images.githubusercontent.com/65847528/97099111-258abc80-16ab-11eb-813d-267afa9e4535.png)
