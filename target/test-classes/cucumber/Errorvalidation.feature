@tag
Feature: Errorvalidation
I want to use this template for my feature file
Background:
Given I landed on ecommerce page

@Errorvalidation
Scenario Outline: positive test of submitting order
Given I landed on ecommerce page
When logged in username <name> and password <password>

Then "Incorrect email or password." message is displayed 
 Examples:
|name                  |password      |
|aswinithumala@gmail.com|Aswini123    |
