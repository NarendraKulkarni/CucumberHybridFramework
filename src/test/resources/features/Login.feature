Feature: Login Functionality

Scenario Outline:  Login with valid credentials
Given User navigates to login page
When  User enters valid email address <username>
And   User has entered valid password <password>
And   User clicks on Login button 
Then  User should get successfully logged in
Examples:
|username							 | password |
|amotooricap1@gmail.com|  12345   |
|amotooricap2@gmail.com|  12345   |
|amotooricap3@gmail.com|  12345   |

Scenario:  Login with invalid credentials
Given User navigates to login page
When  User enters invalid email address "amotoori24122022@gmail.com" in email field
And   User enters invalid password "1234567890" in password field
And   User clicks on Login button
Then  User should get a proper warning message about credentials match

Scenario:  Login with valid email and invalid password
Given User navigates to login page
When  User enters valid email address "amotooricap9@gmail.com"
And   User enters invalid password "1234567890" in password field
And   User clicks on Login button 
Then  User should get a proper warning message about credentials match

Scenario: Login with invalid email and valid password 
Given User navigates to login page
When  User enters invalid email address "amotoori24122022@gmail.com" in email field
And   User has entered valid password "12345"
And   User clicks on Login button
Then  User should get a proper warning message about credentials match

Scenario: Login without providing any credentials
Given User navigates to login page
When  User dont enters any email address into email field
And 	User dont enters any password into password field
And   User clicks on Login button
Then  User should get a proper warning message about credentials match