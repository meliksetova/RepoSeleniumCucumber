Feature: Temp Summary

  Scenario: Verify the temp value changes as per temp unit selected by user
    Given I am on darksky landing page
    Then I verify feelsLike, low and high temp values are displayed
    When I select "ËšC, mph" from temp unit dropdown
    Then I verify feelsLike, low and high temp values changed as per unit selected