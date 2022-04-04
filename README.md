# Ira_Bot
Automation Assignment_Avaamo

How to run the automation test suite and check reports, failure screenshots:

Open the project in IntelliJ Idea IDE (preferably) and navigate to Project(Ira_Bot)\src\main\resources and right click, run or (ctrl+shift+F10) testng.xml

Check the test suite automation run report under Project(Ira_Bot)\reports\AutomationReports.html - right click, open in browser (default).

For any test failures, check failure screenshots under Project(Ira_Bot)\screenshots.

--------------------------------------------------------------------------------------------------------------------------------------------------------

To run single test method:

Add the run->edit configuration parameters as below:

Name:              Value:
Test               testscripts#<test method name>        //ex: testscripts#chatWithBot
browsername		   chrome                                //In the above test configuration->parameters 

========================================================================================================================================================

Please use chrome browser verion as below to run this automation. Added few chrome drivers for different OS(s) under Project(Ira_Bot)\browser_drivers folder.

	---------ChromeDriver 100.0.4896.60 (2022-03-30)---------
Supports Chrome version 100

	Name	                    Last modified	    Size

	chromedriver_linux64.zip	2022-03-30 07:06:34	6.66MB		

	chromedriver_mac64.zip	    2022-03-30 07:06:37	8.01MB	

	chromedriver_mac64_m1.zip	2022-03-30 07:06:39	7.31MB	

	chromedriver_win32.zip	    2022-03-30 07:06:41	6.10MB	
	

To modify the script, in order to run the automation on Mac\Linux machines using above chrome drivers respectively, 
Kindly check "testbase" class under test.java
Find line no: 30 as below:

//For Mac\Linux machines to run this automation, kindly comment the above line and uncomment the respective below lines.

========================================================================================================================================================

Thread.sleep is added in some places of the test script to allow the audience to view the automation process by delaying the execution - Not required uasually.
And at few places to enter the test data at proper pace with bot ex: entering test data in Renew motor policy.

========================================================================================================================================================

A video of the automation test run has been attached in the Project(Ira_Bot)\TestRunVideo folder.

========================================================================================================================================================

In Test Bot form, "How often you search for policy related information in website" this dropdown doesn't contain "Select" tag, so couldn't use the select class and 
pick the drop down items (for which I had written a method "selectDropDownItem" in "element_locators" class), instead taken them using their locators.

========================================================================================================================================================

Apart from what is asked to do, I have also written a test for "Renew Motor Policy" -> refer  @Test(priority = 4) in testscripts.

========================================================================================================================================================
