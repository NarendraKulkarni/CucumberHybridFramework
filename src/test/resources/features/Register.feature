Feature: Registration Functionality

Scenario:  User creates an account only with mandatory fields
Given      User navigates to Register Account page
When       User enters details into below fields
|firstName		|Anoop										 |
|lastName			|Motoori									 |
|telephone		|1234567890								 |
|password 		|12345										 |
And User select Privacy Policy
And USer clicks on Continue button
Then User account should get created successfully

Scenario:  User creates an account only with all fields
Given      User navigates to Register Account page
When       User enters details into below fields
|firstName		|Arun 										 |
|lastName			|Motoori									 |
|telephone		|1234567890								 |
|password 		|12345										 |
And User select Yes for NewsLetter
And User select Privacy Policy
And USer clicks on Continue button
Then User account should get created successfully
	
	
Scenario:  User creates a duplicate account
Given      User navigates to Register Account page
When       User enters details into below fields with duplicate email 
|firstName		|Arun 										 |
|lastName			|Motoori									 |
|email				|amotooricap9@gmail.com|
|telephone		|1234567890								 |
|password 		|12345										 |
And User select Yes for NewsLetter
And User select Privacy Policy
And USer clicks on Continue button
Then User account should get a proper warning about duplicate email address


Scenario: User creates an account without filling any details
Given     User navigates to Register Account page
When 			User dont enter any details into fields
And 			USer clicks on Continue button
Then 			User should get proper warning message
