Feature: Amazon Cart feature


  Scenario: Verify user is able to add most expensive watch in the cart
    Given I am on Amazon
    When I search 'watch'
    And I sort results using 'Price: High to Low'
    Then The first item should be mose expensive
    And I add the item in cart
    And I verify the item got added in the cart
