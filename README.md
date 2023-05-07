# Demo Camunda Feature

* Below are this project configuration details:
camunda version: 7.19,
Java version: 11,
Spring version: 2.7.12,
Database: h2 file based,
Log: not yet configured


# Below are the details of the demo file with little description:

1. connectorDemo/connector_demo_1.bpmn: This workflow shows two service task where one making Get call and other making POST call utilising connectors (http-connector) and capturing the response.

2. errorhandlingdemo/error_handling_demo_1.bpmn: This workflow shows voting process where error is thrown and handled when the voting age is less than 18 and when the voting details are incorrect. This workflow also shows how can we have a dedicated error catch event and how to create a generic one. This shows the error handling using error subprocess with start and end error event.

3. errorhandlingdemo/error_handling_demo_2.bpmn: This is same as error_handling_demo_1.bpmn except this shows intermediate error event.

4. retrymechanism/retry_mechanism_demo_1.bpmn: This workflow shows the retry mechanism is simplistic process with just one service task configured to have 5 times execution with time interval of 5 minutes.


# Below are some errors i received when i tried to create this project from scretch. I am keeping these is readme as the reader can too be benefited with the roadblock and their solution.

1. Just after I got a basic project from spring initializer. "org.springframework.boot does not exist" does not exist error:
Solution: Just remove the iml files inside your modules
https://stackoverflow.com/questions/53869118/importing-to-intellij-error-package-org-springframework-boot-does-not-exist

2. Spring boot stopped after immediately starting
Solution: I made a silly mistake of not including spring boot start web which get the tomcat server. Hence, I included the dependency and it worked
https://stackoverflow.com/questions/22380119/why-does-my-spring-boot-app-always-shutdown-immediately-after-starting

3. Added camunda dependency without adding database dependency. Hence, got error " 'org.springframework.transaction.PlatformTransactionManager' that could not be found."
Solution: Well, with camunda, if we use file based h2 db then it somehow ignores the url configured in application.properties and as solution we need
to keep start-jdbc in dependency.
https://forum.camunda.io/t/camunda-spring-boot-starter-ignores-spring-datasource-url-pointing-to-h2-file-based/7909?u=ingo_richtsmeier

4. Had issue where using connector gave the issue 
"* One of the attributes 'class', 'delegateExpression', 'type', or 'expression' is mandatory on serviceTask. If you are using a connector, make sure theconnect process engine plugin is registered with the process engine. | resource C:\Users\rishav.mishra\Downloads\demoCamunda\demoCamunda\build\resources\main\conntectordemo\connector_demo_1.bpmn | line 7 | column 70"
Solution: I initially used camunda spring boot starter project. However, that is insufficient to work with Connectors. Also, its recommended to take 
camunda BOM to use which will include everything in one shot.
https://camunda.com/blog/2014/04/use-camunda-bom-for-maven-dependency/






