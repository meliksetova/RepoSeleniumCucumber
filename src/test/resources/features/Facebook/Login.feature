Feature: Login feature

  Scenario: Verify user get error for invalid credentials
    Given I am on facebook landing page
    When I enter 'test@gmail.com' as username
    And I enter 'abcd@1234' as password
    And I click on login button
    Then I get invalid credentials error message

