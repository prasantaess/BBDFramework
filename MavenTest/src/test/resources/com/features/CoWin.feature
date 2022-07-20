
Feature: Test the Cowin Web Site
  I want to use this to test the Cowin Site

  @CoWin
  Scenario: To Test The Dynamic Web Table
    Given User landed to the Home Page
    When user gets title of the page
    When user select state and district
    And user click on the search button
    Then verify the dynamic WebTable
    
   @CoWinD
  Scenario: To Test The DashBoard page
    Given User landed to the dashboard Page
    When user gets title of the page
    And user print all the corresponding data
    
   @CoWinD1
  Scenario: To Test The DashBoard page
    Given User landed to the dashboard Page
    When user gets title of the page
    And user print all the SVG graph value
    