Feature: Search feature


Scenario: Verify user selection from autosuggestion appears on Search result page
Given I am on hotels landing page
When I enter 'york' in search
And I select 'Lake George, New York, United States of America' from autosuggestion
And I click on Search button
Then I verify search result header is same as text selected from auto suggestion
And I verify text under 'Destination, property, or landmark' is same as text selected from auto suggestion



  Scenario: Verify the cheapest available hotel is less than $100
    Given I am on hotels landing page
    When I enter 'york' in search
    And I select 'Lake George, New York, United States of America' from autosuggestion
    And I select '2' in children dropdown
    And I enter Child 1 age as '4'
    And I enter Child 2 age as '<1'
    And I click on Search button
    And I sort the result 'Price (low to high)'
    Then I print the lowest hotel price and hotel name in console
    And I verify the lowest price is less than '$100'