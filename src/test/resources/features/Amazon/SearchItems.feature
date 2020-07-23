Feature: Search feature


 Scenario Outline: Verify user selection appears on Search result page
   Given I am on Amazon landing page
    When I type '<item>' on search
   Then I verify search contains '<specific item>'

Examples:
    |item | specific item|
    |watch|Apple Watch  |
   |laptop |Chromebook|