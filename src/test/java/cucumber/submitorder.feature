@tag
Feature: purchase the order from ecommerce website
I want to use this template for my feature file
Background:
Given I landed on ecommerce page

@Regression
Scenario Outline: positive test of submitting order
Given logged in username <name> and password <password>
When I add product <productName> to cart
And checkout <productName> and submit the order
Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page
 Examples:
|name                  |password      |productName|
|aswinithumala@gmail.com|Aswini@123    |ZARA COAT 3 |

