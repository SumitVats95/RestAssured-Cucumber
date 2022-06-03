#Author: Sumitvats2495@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Demo
Feature: Get all list of users

 @GetRequest
  Scenario: I want to get the list of users on the page.
  Given I set base URL of the API.
  And I set headers of the API.
  And I set the query param(s) of the API.
  When I send request to see all users on page
  Then I validate the API response code.
  And I validate the API response body.
  
  @PostRequest
  Scenario: I want to create a new user.
  Given I set base URL of the API.
  And I set headers of the API.
  When I send request with payload
  Then I validate the Post API response code.
  And I validate the  Post API response body.

