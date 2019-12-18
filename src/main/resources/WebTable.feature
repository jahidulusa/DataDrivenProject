 @TS_1023
Feature: Web application login function and web table data Validation

Description: 
User able to login with valid credentials
User able to get data from web application table 
User also get test data from excel
Validate excel data with web table

Background:
Given User able to open any browser 
And  Put URL and go to home apge

@smoke
Scenario Outline: Login function validation

When I enter Username as "<username>" and Password as "<password>"
Then login should be successful


Examples:
| username  				| password  | 
| studentttech@gmail.com 	| student1234 | 

@regression
Scenario: Successfully validate web table
	Then Validate home page
	And take screen shot of the web table
	When User able to get web table data
	Then Find out club name chelse
	And Find out chelse club rank
	When User able to read excel data
	Then User able to validate match club name
	And User able to validate not match club name
	And user able to count not match club number
	When close the browser

	# created a feature file but not develop stepdef yet= dry run
	
	