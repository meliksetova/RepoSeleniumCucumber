Feature: Temp Summary

  Scenario: Verify the temp values on timeLine is same as its detail section
    Given I am on darksky landing page
    Then I scroll to Today timeline
    When I verify the temp values on timeline is same as detail section