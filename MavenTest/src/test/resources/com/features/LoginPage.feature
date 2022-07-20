Feature: Login Test Functionality
Scenario: Page Validation
Given user is navigate to the login Page
When user gets title of the page
And user print url of the page
Then User verify the page name "IRCTC Next Generation eTicketing System"
