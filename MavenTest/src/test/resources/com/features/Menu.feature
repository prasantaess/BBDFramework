Feature: Verify The Menu 

Scenario: Page Validation
Given user is navigate to the login Page
When user gets title of the page
And user print url of the page
Then User verify the page name "IRCTC Next Generation eTicketing System"
When User gets The Menu Sections
|BUSES|
|TRAINS|

@Flipkart
Scenario: Search the Highest price and click the button add to cart
Given User landed on the "https://www.saucedemo.com/v1/inventory.html"
When User click the height value 