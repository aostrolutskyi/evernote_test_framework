# evernote_test_framework
Test Framework for Evernote

## Description
This framework is based on JAVA serenity framework as it has already implemented such patterns as
PageObjects, PageFactory, it also has beautiful reporting, BDD, parallelization runs just out of the box.

* PageObjects are located in package 'pages'
* BDD Steps are located in package 'steps'
* BDD stories are located in 'resources/stories' folder
* Different settings can be found in 'serenity.properties' file which can be configured according to official documentation
* To run the test run maven command:
```
mvn clean verify
```
* Test report will be located in "target/site/serenity" folder.

##Notes: 
Unfortunately I couldn't create api tests because evernote identify api requests from my computer as suspicious activity.
So I have created only one scenario to have an example. Test steps can be found in 'steps.login.api'.